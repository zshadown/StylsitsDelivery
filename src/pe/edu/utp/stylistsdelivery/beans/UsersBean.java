package pe.edu.utp.stylistsdelivery.beans;

import pe.edu.utp.stylistsdelivery.models.SdService;
import pe.edu.utp.stylistsdelivery.models.User;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class UsersBean implements Serializable{
    private SdService sdService;
    private User user;

    public UsersBean() {
        sdService = new SdService();
    }

    /*public List<User> getUsers(){
        return sdService.findAllUsers();
    }*/

    public User getUser(){
        return user;
    }


}
