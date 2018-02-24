package pe.edu.utp.stylistsdelivery.beans;

import pe.edu.utp.stylistsdelivery.models.Province;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
//Districts Beans
public class DistrictsBean implements Serializable {
    private int id;
    private String description;
    private Province province;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }


}
