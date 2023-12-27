package model;

public class Key {
    private String publicKey; // Thêm thuộc tính public key
    private String privateKey; // Thêm thuộc tính private key

    public Key() {
        super();
    }

    public Key(String publicKey, String privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

}
