package pw.atj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet{

    private String userName;
    private File file;
    private String writtenPassword;
    private String address;

    private File fileWithPosts;
    private String data = null;
    private Gson gson = new Gson();
    private Scanner myReader = null;
    private ArrayList<Post> postList = new ArrayList<Post>();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Login login = new Login();

        if(request.getParameter("logbut") != null) {
            userName = request.getParameter("username");
            writtenPassword = request.getParameter("password");

        //  file = new File("D:/JAVA-Studia/semestr 2/1. ATJ/Projekty/blog/src/main/webapp/data/users.json"); // dla Laptopa
            file = new File("E:/JAVA-Studia/semestr 2/1. ATJ/Projekty/blog/src/main/webapp/data/users.json"); // dla PC

            fileWithPosts = new File("E:/JAVA-Studia/semestr 2/1. ATJ/Projekty/blog/src/main/webapp/data/posts.json"); // dla PC
            // fileWithPosts = new File("D:/JAVA-Studia/semestr 2/1. ATJ/Projekty/blog/src/main/webapp/data/posts.json"); // dla Laptopa

            address = login.login(userName, file, writtenPassword);

            if(address.equals("/blog.jsp")){
                HttpSession session = request.getSession();
                session.setAttribute("userID", userName);
            try{
                myReader = new Scanner(fileWithPosts);
                while( myReader.hasNextLine()){
                    data = myReader.nextLine();
                }
                myReader.close();
            } catch(FileNotFoundException e){
                System.out.println("No file!");
                e.printStackTrace();
            }
    
            postList = gson.fromJson(data, new TypeToken<ArrayList<Post>>(){}.getType());
            
            request.setAttribute("postList", postList);
            request.getRequestDispatcher(address).forward(request, response);


            }
        }
    }
   
    public String getUserName() {
        return userName;
    }
    
}
