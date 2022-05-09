package pw.atj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Login {
    
    private String redirectURL;
    private String data = null;
    private ArrayList<Users> usersList = new ArrayList<>();
    private Gson gson = new Gson();
    private Scanner myReader = null;

    public String login(String userName, File file, String writtenPassword){

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
        

        if((userName.length() > 0) && (writtenPassword.length() > 0)){
            for(Users name: usersList){
                if(userName.equals(name.getLogin()) && writtenPassword.equals(name.getPassword())){
                    System.out.println("Logowanie poprawne");
                    //Zalogowanie
                    redirectURL = "/blog.jsp";
                    return redirectURL;
                } else {
                    System.out.println("Podana nazwa użytkownika lub hasło nie są poprawne!");
                    //Przeniesienie do strony ponownego logowania
                    redirectURL = "/login.jsp";
                }
            }
        } else {
            System.out.println("Podany login lub hasło są zbyt krótkie");
        }
        return redirectURL;
    }
    
}
