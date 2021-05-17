package Data;

import java.io.Serializable;

public class LogInClass implements Serializable {

    public String user;
    public String pass;

    public LogInClass(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public LogInClass(){

    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
