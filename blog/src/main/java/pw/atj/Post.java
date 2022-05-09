package pw.atj;

// import javax.swing.JButton;

public class Post {

    private String userName;
    private String actualDate;
    private String writtenMesage;

    private int ID;
    // private boolean isDeleted;
    // private JButton button;

    
    public Post(String userName, String actualDate, String writtenMessage, int ID){
        this.userName = userName;
        this.actualDate = actualDate;
        this.writtenMesage = writtenMessage;
        this.ID = ID;
        
    }
    
    /*
    public Post(String userName, String actualDate, String writtenMesage, boolean isDeleted, JButton button) {
        this.userName = userName;
        this.actualDate = actualDate;
        this.writtenMesage = writtenMesage;
        this.isDeleted = isDeleted;
        this.button = button;
    }
*/
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getActualDate() {
        return actualDate;
    }

    public void setActualDate(String actualDate) {
        this.actualDate = actualDate;
    }

    public String getWrittenMesage() {
        return writtenMesage;
    }

    public void setWrittenMesage(String writtenMesage) {
        this.writtenMesage = writtenMesage;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}
