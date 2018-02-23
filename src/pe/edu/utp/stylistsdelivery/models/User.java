package pe.edu.utp.stylistsdelivery.models;


import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named (value = "login")
public class User implements Serializable{
    private String userNamed;
    private String password;

    public String getUserNamed() {
        return userNamed;
    }

    public void setUserNamed(String userNamed) {
        this.userNamed = userNamed;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
