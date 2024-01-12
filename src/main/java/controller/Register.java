package controller;

import javax.servlet.*;
import javax.servlet.http.*;

import com.google.gson.JsonObject;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import helper.Contants;
import model.RSA;
import model.User;
import service.UserService;

import javax.servlet.annotation.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "Register ", value = "/register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        request.setCharacterEncoding("utf8");// lấy dữ liệu ép kiểu về tiếng việt
//        response.setCharacterEncoding("utf8");
//        response.setContentType("text/html; charset=UTF-8");
//        String lastname = request.getParameter("lastName");
//        String firstName = request.getParameter("firstName");
//        String userName = request.getParameter("userName");
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//        String repassword = request.getParameter("repassword");
//        String phone = request.getParameter("phone");
//
//        String publicKey = request.getParameter("publicKeyReq");
//        String privateKey = request.getParameter("privateKeyReq");
//
//        if (!password.equals(repassword)) {
//            request.setAttribute("error", "Mật khẩu không giống nhau. Vui lòng thử lại");
//            request.getRequestDispatcher("/template/dang-ky.jsp").forward(request, response);
//            return;
//        } else {
//            if (UserService.checkUserNameExist(userName)) {
//                request.setAttribute("error", "Bạn đã có tài khoản. Vui lòng đăng nhập");
//                request.getRequestDispatcher("/template/dang-ky.jsp").forward(request, response);
//                return;
//            }
//
//            //Nếu là admin
//            int role = Contants.ROLE_CUSTOMER;
//            String[] selected = request.getParameterValues("isdefault");
//            System.out.println(selected);
//            if (selected != null) {
//                role = Integer.parseInt(selected[0]);//nếu có tham số này thì là insert từ trang quản trị là Admin
//            }
//            System.out.println(role);
//
//            User user = new User(lastname, firstName, email, userName, phone, password, 1, role, publicKey, privateKey);
//            System.out.println(publicKey);
//            System.out.println(privateKey);
//            int isInsert = UserService.addRegister(user);
////            if (isInsert <= 0) {
////                request.setAttribute("error", "Đăng ký bị lỗi. Vui lòng thử lại.");
////                request.getRequestDispatcher("/template/dang-ky.jsp").forward(request, response);
////                return;
////            }else{
//////                response.setContentType("application/json");
//////                response.setCharacterEncoding("UTF-8");
//////
//////                JsonObject jsonResponse = new JsonObject();
//////                jsonResponse.addProperty("privateKey", privateKey);
//////
//////                response.getWriter().write(jsonResponse.toString());
////                savePrivateKeyToFile(privateKey);
////
////            }
//            if (isInsert <= 0) {
//                request.setAttribute("error", "Đăng ký bị lỗi. Vui lòng thử lại.");
//                request.getRequestDispatcher("/template/dang-ky.jsp").forward(request, response);
//                return;
//            }
//            else {
//                // Bước 2: Chuyển hướng sau khi cả dữ liệu đã được lưu thành công
////                savePrivateKeyToFile(privateKey);
////                                savePrivateKeyToFile2(privateKey);
//
//                response.sendRedirect("/sign-in");
//
//                // Các đoạn mã in log hoặc thông báo thành công có thể thêm ở đây
//                System.out.println("Dang ki thanh cong");
//            }
//
//
//        }
//
////        response.sendRedirect("/sign-in");
//
//        return;
//    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        response.setContentType("text/html; charset=UTF-8");

        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String phone = request.getParameter("phone");

        String publicKey = request.getParameter("publicKeyReq");
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
            if (!isStrongPassword(password)) {
                request.setAttribute("error", "Mật khẩu phải có ít nhất 8 ký tự gồm chữ hoa, chữ thường, số và ký tự đặc biệt");
                request.getRequestDispatcher("/template/dang-ky.jsp").forward(request, response);
                return;
            }
            if(UserService.checkKeyExist(publicKey)){
                request.setAttribute("error", "Key đã tồn tại. Vui lòng nhập key khác");
                request.getRequestDispatcher("/template/dang-ky.jsp").forward(request, response);
                return;
            }
            if(publicKey.trim().length()==0 || publicKey.length()==0 ||privateKey.trim().length()==0||privateKey.length()==0){
                request.setAttribute("error", "Vui lòng nhập đầy đủ thông tin");
                request.getRequestDispatcher("/template/dang-ky.jsp").forward(request, response);
                return;
            }

            int role = Contants.ROLE_CUSTOMER;
            String[] selected = request.getParameterValues("isdefault");

            if (selected != null) {
                role = Integer.parseInt(selected[0]);
            }

            try {
                PublicKey pbKey = convertStringToPublicKey(publicKey);
                PrivateKey prKey = convertStringToPrivateKey(privateKey);
                if(!checkKeyPair(pbKey, prKey)){
                    System.out.println("Khong phai la 1 cap key");
                    request.getRequestDispatcher("/template/dang-ky.jsp").forward(request, response);
                }else {
                    System.out.println("La mot cap key");
//                    savePrivateKeyToFile(privateKey);
                }
//                System.out.println(publicKey);
//                System.out.println(privateKey);
            } catch (Exception e) {
//                throw new RuntimeException(e);
                System.out.println("Khong phai la cap key");
                request.getRequestDispatcher("/template/dang-ky.jsp").forward(request, response);
                return;
            }



            User user = new User(lastName, firstName, email, userName, phone, password, 1, role, publicKey);

            int isInsert = UserService.addRegister(user);

//            int isInsert = 1;
            if (isInsert <= 0) {
                request.setAttribute("error", "Đăng ký bị lỗi. Vui lòng thử lại.");
                request.getRequestDispatcher("/template/dang-ky.jsp").forward(request, response);
                return;
            } else {
                // Lấy đường dẫn thư mục đã chọn từ yêu cầu
//                String selectedFolderPath = request.getParameter("selectedFolderPath");
////                String absoluteFolderPath = getServletContext().getRealPath(selectedFolderPath);
//
//                System.out.println("----------in duong dan--------------");
//                System.out.println(selectedFolderPath);
                // Lưu khóa riêng tư vào tệp văn bản trong thư mục đã chọn
//                savePrivateKeyToFile(privateKey, selectedFolderPath);
                savePrivateKeyToFile(privateKey);
                createPDFWithPrivateKey(privateKey);
                response.sendRedirect("/sign-in");

                // Các đoạn mã in log hoặc thông báo thành công có thể thêm ở đây
                System.out.println("Đăng ký thành công");
            }
        }
    }

    private void savePrivateKeyToFile(String privateKey) throws IOException {
        // Lấy ngày và giờ hiện tại
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Định dạng chuỗi
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
        String formattedDateTime = currentDateTime.format(formatter);

        // Thực hiện lưu file vào thư mục hoặc nơi khác
        // Ví dụ: Lưu file vào thư mục "private_keys"
        String fileName = formattedDateTime+"_privatekey.txt";
        String directoryPath = "D:\\HAN\\AT";

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs(); // Tạo thư mục nếu nó chưa tồn tại
        }

        File file = new File(directory, fileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(privateKey);
        }
    }

    private void savePrivateKeyToFile2(String privateKey, String folderPath) {
        try {
            String fileName = "private_key.txt";
            String filePath = folderPath + File.separator + fileName;

            FileWriter fileWriter = new FileWriter(filePath, StandardCharsets.UTF_8);
            fileWriter.write(privateKey);
            fileWriter.close();

            System.out.println("Khóa riêng tư đã được lưu vào: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createPDFWithPrivateKey(String privateKey) throws IOException {
        // Lấy ngày và giờ hiện tại
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Định dạng chuỗi
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
        String formattedDateTime = currentDateTime.format(formatter);

        // Đường dẫn và tên tệp PDF
        String pdfFilePath = "D:\\HAN\\AT\\"+formattedDateTime+"_privatekey.pdf";

        // Tạo một đối tượng Document
        Document document = new Document();

        try {
            // Tạo đối tượng PdfWriter để ghi vào tệp PDF
            PdfWriter.getInstance(document, new FileOutputStream(new File(pdfFilePath)));

            // Mở document để bắt đầu ghi
            document.open();

            // Chèn thông tin private key vào document
            document.add(new Paragraph(privateKey));

            // Đóng document
            document.close();

            System.out.println("Tạo tệp PDF thành công: " + pdfFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean checkKeyPair(PublicKey publicKey, PrivateKey privateKey) {
        try {
            // Tạo một đối tượng Signature với thuật toán SHA256withRSA
            Signature signature = Signature.getInstance("SHA256withRSA");

            // Ký một mảng byte bằng private key
            signature.initSign(privateKey);
            byte[] message = "Hello, World!".getBytes();
            signature.update(message);
            byte[] signedData = signature.sign();

            // Xác minh chữ ký bằng public key
            signature.initVerify(publicKey);
            signature.update(message);

            // Nếu xác minh thành công, chứng tỏ public key và private key là một cặp hợp lệ
            return signature.verify(signedData);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static PublicKey convertStringToPublicKey(String str) throws Exception {
        RSA rsa = new RSA();
        PublicKey pbKey = rsa.getPublicKeyFromString(str);
        return pbKey;
    }
    private static PrivateKey convertStringToPrivateKey(String str) throws Exception {
        RSA rsa = new RSA();
        PrivateKey privateKey = rsa.getPrivateKeyFromString(str);
        return privateKey;
    }

    private static boolean isStrongPassword(String password) {
        // Biểu thức chính quy để kiểm tra
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=.*[a-zA-Z0-9@#$%^&+=!]).{8,}$";

        // Tạo Pattern và Matcher
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        // Kiểm tra xem chuỗi có khớp với biểu thức chính quy hay không
        return matcher.matches();
    }
}
