package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class RSA {

    KeyPair keyPair;
    PublicKey publicKey;
    PrivateKey privateKey;

    public void genKey() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("RSA");
        keyGenerator.initialize(2048);
        keyPair = keyGenerator.generateKeyPair();
        publicKey = keyPair.getPublic();
        privateKey = keyPair.getPrivate();

    }

    public String encrypt(String data, PublicKey publicKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(cipher.ENCRYPT_MODE, publicKey);
        byte[] output = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(output);

    }

    public String decrypt(String data, PrivateKey privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] output = cipher.doFinal(Base64.getDecoder().decode(data));
        return new String(output, StandardCharsets.UTF_8);
    }

    public void fileEncrypt(String inputPath, String outputPath, PublicKey publicKey) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        byte[] iv = new byte[16];
        IvParameterSpec spec = new IvParameterSpec(iv);
        SecretKey secretKey = keyGen.generateKey();
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, spec);

        CipherInputStream inputStream = new CipherInputStream(new BufferedInputStream(new FileInputStream(inputPath)), cipher);
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(outputPath)));

        String keyString = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        dataOutputStream.writeUTF(encrypt(keyString, publicKey));
        dataOutputStream.writeLong(new File(inputPath).length());
        dataOutputStream.writeUTF(Base64.getEncoder().encodeToString(iv));

        byte[] buff = new byte[1024];
        int i;
        while ((i = inputStream.read(buff)) != -1) {
            dataOutputStream.write(buff, 0, i);
        }
        inputStream.close();
        dataOutputStream.flush();
        dataOutputStream.close();
    }

    public void fileDecrypt(String inputPath, String outputPath, PrivateKey privateKey) throws IOException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(inputPath)));
        String keyString = dis.readUTF();
        long size = dis.readLong();
        byte[] iv = Base64.getDecoder().decode(dis.readUTF());

        SecretKey secretKey = new SecretKeySpec(Base64.getDecoder().decode(decrypt(keyString, privateKey)), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));
        CipherInputStream cis = new CipherInputStream(dis, cipher);
        BufferedOutputStream bof = new BufferedOutputStream(new FileOutputStream(outputPath));

        byte[] buff = new byte[1024];
        int i;
        while ((i = cis.read(buff)) != -1) {
            bof.write(buff, 0, i);
        }
        cis.close();
        bof.close();
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }
    public  PrivateKey getPrivateKeyFromString(String key) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(key);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }

    public  PublicKey getPublicKeyFromString(String key) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(key);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }
}


