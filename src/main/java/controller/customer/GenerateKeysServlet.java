package controller.customer;

import model.RSAAlgo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;

@WebServlet("/template/generateKeys")

public class GenerateKeysServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Servlet invoked");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        RSAAlgo rsa = new RSAAlgo();
        try {
            rsa.genKey();
            String publicKey = Base64.getEncoder().encodeToString(rsa.getPublicKey().getEncoded());
            String privateKey = Base64.getEncoder().encodeToString(rsa.getPrivateKey().getEncoded());

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
