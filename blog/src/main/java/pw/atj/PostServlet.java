package pw.atj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Path.Node;

@WebServlet("/postservlet")
public class PostServlet  extends HttpServlet{

    private String writtenMessage;
    private Date actualDate = new Date();
    private File file;
    private String data = null;
    private Gson gson = new Gson();
    private Scanner myReader = null;
    private ArrayList<Post> postList = new ArrayList<Post>();
    private Integer ID;
    private Integer postID;
    // private boolean isDeleted = false;
    // private JButton button;
    
 
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //postList= (ArrayList<String>) request.getAttribute("postList");
        PostWriting post = new PostWriting();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        if((request.getParameter("sendbut") != null)) {

            writtenMessage = request.getParameter("text");
            
            file = new File("E:/JAVA-Studia/semestr 2/1. ATJ/Projekty/blog/src/main/webapp/data/posts.json"); // dla PC
            // private File file = new File("D:/JAVA-Studia/semestr 2/1. ATJ/Projekty/blog/src/main/webapp/data/posts.json"); // dla Laptopa

            HttpSession session = request.getSession();
            String userID = (String)session.getAttribute("userID");

            // post.post(userID, formatter.format(actualDate), writtenMessage, file, isDeleted, button);
            post.post(userID, formatter.format(actualDate), writtenMessage, file);

            try{
                myReader = new Scanner(file);
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

            request.getRequestDispatcher("/blog.jsp").forward(request, response);
        }



        Button deleteButton = new Button();

        if((request.getParameter("deletebutton") != null)) {

            request.setAttribute("var1", ID);
            file = new File("E:/JAVA-Studia/semestr 2/1. ATJ/Projekty/blog/src/main/webapp/data/posts.json"); // dla PC
            // private File file = new File("D:/JAVA-Studia/semestr 2/1. ATJ/Projekty/blog/src/main/webapp/data/posts.json"); // dla Laptopa
            

            // ID = (Integer)request.getAttribute("var1");

            ID = Integer.valueOf(request.getParameter("deletebutton"));
            

            System.out.println("Nadane ID to: " + ID);
            postID = ID;
            
            deleteButton.deletedButton(file, postID);



            try{
                myReader = new Scanner(file);
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

            request.getRequestDispatcher("/blog.jsp").forward(request, response);

        }


        
    }
    
}
