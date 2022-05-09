package pw.atj;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regservlet")
public class RegisterServlet extends HttpServlet {

    private String userName;
    private File file;
    private String writtenPassword;
    private String writtenPassword2;
    private String address;
 
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Register register = new Register();

        if(request.getParameter("regbut") != null) {
            userName = request.getParameter("username");
            writtenPassword = request.getParameter("password");
            writtenPassword2 = request.getParameter("password2");

            // file = new File("D:/JAVA-Studia/semestr 2/1. ATJ/Projekty/blog/src/main/webapp/data/users.json"); // dla Laptopa
            file = new File("E:/JAVA-Studia/semestr 2/1. ATJ/Projekty/blog/src/main/webapp/data/users.json"); // dla PC
           
            address = register.register(userName, file, writtenPassword, writtenPassword2);
            request.getRequestDispatcher(address).forward(request, response);
        
        }
    }
}
