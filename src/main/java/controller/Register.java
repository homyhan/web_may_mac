package controller;

import javax.servlet.*;
import javax.servlet.http.*;

import com.fasterxml.jackson.core.io.JsonStringEncoder;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.*;
import helper.Contants;
import model.RSAAlgo;
import model.User;
import service.UserService;
import javax.servlet.annotation.*;
import java.io.*;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

import static org.apache.poi.poifs.macros.Module.ModuleType.Document;

@WebServlet(name = "Register ", value = "/register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setCharacterEncoding("utf8");// lấy dữ liệu ép kiểu về tiếng việt
		response.setCharacterEncoding("utf8");
		response.setContentType("text/html; charset=UTF-8");

        String lastname = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String phone = request.getParameter("phone");
        String publicKey = request.getParameter("publicKey");
        String privateKey = request.getParameter("privateKeyReq");

        if (!password.equals(repassword)) {
        	request.setAttribute("error", "Mật khẩu không giống nhau. Vui lòng thử lại");
            request.getRequestDispatcher("/template/dang-ky.jsp").forward(request, response);
            return;
        } else {
            if (UserService.checkUserNameExist(userName)) {
                request.setAttribute("error", "Bạn đã có tài khoản. Vui lòng đăng nhập");
                request.getRequestDispatcher("/template/dang-ky.jsp").forward(request, response);
                return;
            }
            
            //Nếu là admin
            int role = Contants.ROLE_CUSTOMER;
    		String[] selected = request.getParameterValues("isdefault");
    		System.out.println(selected);
    		if (selected != null) {
    			role = Integer.parseInt(selected[0]);//nếu có tham số này thì là insert từ trang quản trị là Admin
    		}
    		System.out.println(role);

            try{
                PublicKey pbKey = convertStringToPublicKey(publicKey);
                PrivateKey privateKey1 = convertStringToPrivateKey(privateKey);
                if(!checkKeyPair(pbKey, privateKey1)){
                    System.out.println("Khong phai la 1 cap key");
                }else {
                    System.out.println("La mot cap key");
//                    savePrivateKeyToFile(privateKey);
                   }
            } catch (Exception e) {
                System.out.println("Không cùng 1 cặp key");
                request.getRequestDispatcher("/template/dang-ky.jsp").forward(request, response);
                return;
            }

            User user = new User(lastname, firstName, email, userName, phone, password, 1, role, publicKey);
            int isInsert = UserService.addRegister(user);
            if (isInsert <= 0) {
                request.setAttribute("error", "Đăng ký bị lỗi. Vui lòng thử lại.");
                request.getRequestDispatcher("/template/dang-ky.jsp").forward(request, response);
                return;
            } else {
                savePrivateKeyToFile(privateKey);
                createPDFWithPrivateKey(privateKey);
                response.sendRedirect("/sign-in");
                System.out.println("Đăng ký thành công");
            }
            System.out.println(isInsert);
        }
        response.sendRedirect("/sign-in");
        return;
    }

    private boolean checkKeyPair(PublicKey pbKey, PrivateKey privateKey1) {
        try {
            // Tạo một đối tượng Signature với thuật toán SHA256withRSA
            Signature signature = Signature.getInstance("SHA256withRSA");

            // Ký một mảng byte bằng private key
            signature.initSign(privateKey1);
            byte[] message = "Hello, World!".getBytes();
            signature.update(message);
            byte[] signedData = signature.sign();

            // Xác minh chữ ký bằng public key
            signature.initVerify(pbKey);
            signature.update(message);

            // Nếu xác minh thành công, chứng tỏ public key và private key là một cặp hợp lệ
            return signature.verify(signedData);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void savePrivateKeyToFile(String privateKey) {
        String directoryPath = "D:\\HAN\\AT";
        String fileName = "privatekey2.txt";

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs(); // Tạo thư mục nếu nó chưa tồn tại
        }

        File file = new File(directory, fileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(privateKey);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createPDFWithPrivateKey(String privateKey) throws IOException {
        String pdfFilePath = "/Users/tlinhn/Documents/HKI_2023_2024/ATBMHTTT/web_may_mac";
        FileWriter writer = new FileWriter(pdfFilePath);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write(privateKey);
        bufferedWriter.close();
        System.out.println("Tạo tệp PDF thành công: " + pdfFilePath);

        //PdfDocument pdfDoc = null;
        //Document document = new Document(new PdfDocument(pdfDoc.getReader()));
        // = new PdfDocument(new PdfWriter(pdfFilePath));
//        try {
//            fos.;
//            pdfDoc.getIn.getHighPrecision();;
//            document.open();
//            document.add(new Paragraph(privateKey));
//            document.close();
//            System.out.println("Tạo tệp PDF thành công: " + pdfFilePath);
//

//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
    }

    private PrivateKey convertStringToPrivateKey(String privateKey) throws Exception {
        RSAAlgo rsa = new RSAAlgo();
        PrivateKey privateKey1 = rsa.getPrivateKeyFromString(privateKey);
        return privateKey1;
    }

    private PublicKey convertStringToPublicKey(String publicKey) throws Exception {
        RSAAlgo rsa = new RSAAlgo();
        PublicKey pbKey = rsa.getPublicKeyFromString(publicKey);
        return pbKey;
    }
}
