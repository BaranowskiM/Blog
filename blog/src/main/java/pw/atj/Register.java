package pw.atj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Register {

    private int count = 0;
    private String redirectURL;
    private String data = null;
    private ArrayList<Users> usersList = new ArrayList<>();
    private Gson gson = new Gson();
    private Scanner myReader = null;
    private String json;
    private FileWriter myWriter = null;
   
    public String register(String userName, File file, String writtenPassword, String writtenPassword2){


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
        
        usersList = gson.fromJson(data, new TypeToken<ArrayList<Users>>(){}.getType());

        if(userName.length() > 0){
            for(Users name: usersList){
                if(userName.equals(name.getLogin())){
                count++;
                } 
            }
            if(count == 0 && (writtenPassword != null && writtenPassword.equals(writtenPassword2))){
                System.out.println("Rejestracja poprawna");
                //Zapis loginu i hasła w pliku
                redirectURL = "/login.jsp";
                usersList.add(new Users(userName, writtenPassword));

                try{
                    myWriter = new FileWriter(file);
                    json = gson.toJson(usersList);
                    myWriter.write(json);
                    myWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            } else {
                    System.out.println("Podana nazwa użytkownika jest już zajęta!");
                    //Przeniesienie do strony ponownego rejestrowania
                    redirectURL = "/register.jsp";
                }
               
            }
            return redirectURL;
        }


    }
 

//