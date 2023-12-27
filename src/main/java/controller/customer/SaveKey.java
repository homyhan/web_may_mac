package controller.customer;

import model.RSA;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/template/savePrivateKey")

public class SaveKey extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String privateKey = request.getParameter("privateKeyReq");

        // Thực hiện lưu private key vào file trên server
        savePrivateKeyToFileOnServer(privateKey);

        // Trả về thông báo thành công hoặc lỗi (tùy thuộc vào kết quả lưu file)
        response.getWriter().write("Private key saved successfully");
    }
    private void savePrivateKeyToFileOnServer(String privateKey) {
        try {
            // Đặt đường dẫn đến thư mục lưu trữ private key trên server
            String directoryPath = getServletContext().getRealPath("/") + "privatekeys";

            // Tạo thư mục nếu nó không tồn tại
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Tạo tên file dựa trên thời gian hiện tại
            String fileName = "privatekey_" + System.currentTimeMillis() + ".txt";
            String filePath = directoryPath + File.separator + fileName;

            // Tạo và ghi private key vào file
            try (PrintWriter writer = new PrintWriter(filePath)) {
                writer.write(privateKey);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
