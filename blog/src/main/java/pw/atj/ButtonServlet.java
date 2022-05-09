// package pw.atj;

// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.Scanner;

// // import javax.swing.JButton;

// import com.google.gson.Gson;
// import com.google.gson.reflect.TypeToken;

// import jakarta.servlet.ServletException;
// import jakarta.servlet.annotation.WebServlet;
// import jakarta.servlet.http.HttpServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// @WebServlet("/buttonservlet")
// public class ButtonServlet extends HttpServlet{

//     // private JButton deleteButton;
//     private File file;
//     private ArrayList<Post> postList = new ArrayList<Post>();
//     private Gson gson = new Gson();
//     private Scanner myReader = null;
//     private String data = null;


//     @Override
//     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//         Button deleteButton = new Button();

//         if((request.getParameter("deletebutton") != null)) {


//             file = new File("E:/JAVA-Studia/semestr 2/1. ATJ/Projekty/blog/src/main/webapp/data/posts.json"); // dla PC
//             // private File file = new File("D:/JAVA-Studia/semestr 2/1. ATJ/Projekty/blog/src/main/webapp/data/posts.json"); // dla Laptopa

//             deleteButton.deletedButton(file);

//             try{
//                 myReader = new Scanner(file);
//                 while( myReader.hasNextLine()){
//                     data = myReader.nextLine();
//                 }
//                 myReader.close();
//             } catch(FileNotFoundException e){
//                 System.out.println("No file!");
//                 e.printStackTrace();
//             }
    
//             postList = gson.fromJson(data, new TypeToken<ArrayList<Post>>(){}.getType());
            
//             request.setAttribute("postList", postList);

//             request.getRequestDispatcher("/blog.jsp").forward(request, response);

//         }

//     }
    
// }
