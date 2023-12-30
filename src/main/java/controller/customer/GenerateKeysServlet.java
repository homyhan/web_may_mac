package controller.customer;

import model.RSA;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/template/generateKeys")

public class GenerateKeysServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Servlet invoked");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        RSA rsa = new RSA();
        try {
            rsa.genKey();
            String publicKey = Base64.getEncoder().encodeToString(rsa.getPublicKey().getEncoded());
            String privateKey = Base64.getEncoder().encodeToString(rsa.getPrivateKey().getEncoded());

            // You may want to send only the Base64 encoded key strings instead of toString().

            // Create a JSON response
            String jsonResponse = "{\"publicKey\":\"" + publicKey + "\", \"privateKey\":\"" + privateKey + "\"}";

            PrintWriter out = response.getWriter();
            out.print(jsonResponse);
            System.out.println(jsonResponse);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

}
