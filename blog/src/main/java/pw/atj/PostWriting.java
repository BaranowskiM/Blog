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

public class PostWriting {

    private ArrayList<Post> postList = new ArrayList<Post>();
    private FileWriter myWriter = null;
    private Gson gson = new Gson();
    private String json;
    private Scanner myReader = null;
    private String data = null;
    private int ID = 0;
    private Post newPost;
    // private boolean isDeleted;
    // private JButton button;


    public ArrayList<Post> getPostList() {
        return postList;
    }

    public void post(String userName, String actualDate, String writtenMessage, File file){
    // public void post(String userName, String actualDate, String writtenMessage, File file, boolean isDeleted, JButton button){

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

        newPost = new Post(userName, actualDate, writtenMessage, ID);

        System.out.println("ID posta na miejscu 0 to: " + postList.get(0).getID());
        System.out.println("ID nowego posta to: " + newPost.getID());
        // System.out.println(postList.get(0));

        // if(postList.get(0).getID() == newPost.getID()){
        //     System.out.println("wartości są równe");
        // }

       
        if(postList.get(0).getID() >= newPost.getID()){
             while(postList.get(0).getID() >= newPost.getID()) {
                ID++;
                System.out.println("ID posta to: " + ID);
                newPost.setID(ID);
             }
            postList.add(0, newPost);
            System.out.println("ID posta PO PĘTLI to: " + newPost.getID());
        } else {
            postList.add(0, newPost);
            System.out.println("ID posta BEZ PĘTLI to: " + ID);
        }

        

        // postList.add(0, new Post(userName, actualDate, writtenMessage, isDeleted, button));
        

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
