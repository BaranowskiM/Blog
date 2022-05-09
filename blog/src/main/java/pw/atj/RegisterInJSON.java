package pw.atj;


/*
import java.io.File;
// import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
// import java.util.Scanner;

import com.google.gson.Gson;
// import com.google.gson.reflect.TypeToken;



public class RegisterInJSON {



    
    
public static void main(String args[]){
    // String data = null;
    ArrayList<Post> users = new ArrayList<>();
    // ArrayList<Post> users2 = null;
    FileWriter myWriter;
    File file;

    Gson gson = new Gson();
    Post post1 = new Post("Administrator", "2022/05/03", "Witaj na forum drogi użytkowniku!");
    // Post post2 = new Post("AAA", "2022/05/03", "Witaj Świecie!");
    // Post post3 = new Post("BBB", "2022/05/03", "Witaj AAA!");
    


    users.add(post1);
    // users.add(post2);
    // users.add(post3);
    //System.out.println(users.toString());

    String json = gson.toJson(users);
    // users.add(post1);
   // json = gson.toJson(users);


    file = new File("E:/JAVA-Studia/semestr 2/1. ATJ/Projekty/blog/src/main/webapp/data/posts.json");

    try{
        myWriter = new FileWriter(file);
        json = gson.toJson(users);
        myWriter.write(json);
        myWriter.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    System.out.println("Wpisane z klasy: " + json);

  /*
   String json2 = "[{\"userName\":\"Administrator\",\"actualDate\":\"2022/05/03\",\"writtenMesage\":\"Witaj na forum drogi użytkowniku!\"}]";
   
   // ArrayList<Users>  users2 = gson.fromJson(json2, ArrayList.class);
   users2 = gson.fromJson(json2, new TypeToken<ArrayList<Post>>(){}.getType());
    System.out.println("Login to: " + users2.get(0).getUserName() + ", a data: " + 
                        users2.get(0).getActualDate() + " treść wiadomości to: " + users2.get(0).getWrittenMesage() );

*/

/*
try{
    File file = new File("src/main/webapp/data/posts.json");
    Scanner myReader = new Scanner(file);
    while( myReader.hasNextLine()){
        data = myReader.nextLine();
        System.out.println("Wypisane z pliku JSON: " + data);
    }
    myReader.close();
} catch(FileNotFoundException e){
    System.out.println("No file!");
    e.printStackTrace();
}
// String json2 = data;
users2 = gson.fromJson(json2, new TypeToken<ArrayList<Users>>(){}.getType());


System.out.println("Login to: " + users2.get(0).getUserName() + ", a treść: " + users2.get(0).getWrittenMesage() );


 


}
*/