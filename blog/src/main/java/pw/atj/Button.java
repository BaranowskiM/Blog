package pw.atj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// import javax.swing.JButton;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Button {

    private ArrayList<Post> postList = new ArrayList<Post>();
    private FileWriter myWriter = null;
    private Gson gson = new Gson();
    private String json;
    private Scanner myReader = null;
    private String data = null;
    

    // public void deletedButton(File file, JButton button){
        public void deletedButton(File file, int ID){
        
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

        postList.remove(ID);

        try{
            myWriter = new FileWriter(file);
            json = gson.toJson(postList);
            myWriter.write(json);
            myWriter.close();
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        } 

    }
}
