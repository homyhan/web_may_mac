package controller;

import javax.servlet.*;
import javax.servlet.http.*;

import com.google.gson.JsonObject;
import helper.Contants;
import model.User;
import service.UserService;

import javax.servlet.annotation.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

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

            int role = Contants.ROLE_CUSTOMER;
            String[] selected = request.getParameterValues("isdefault");

            if (selected != null) {
                role = Integer.parseInt(selected[0]);
            }

            User user = new User(lastName, firstName, email, userName, phone, password, 1, role, publicKey, privateKey);

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
                response.sendRedirect("/sign-in");

                // Các đoạn mã in log hoặc thông báo thành công có thể thêm ở đây
                System.out.println("Đăng ký thành công");
            }
        }
    }

    private void savePrivateKeyToFile(String privateKey) throws IOException {
        // Thực hiện lưu file vào thư mục hoặc nơi khác
        // Ví dụ: Lưu file vào thư mục "private_keys"
        String directoryPath = "D:\\HAN\\AT";
        String fileName = "privatekey.txt";

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


}
