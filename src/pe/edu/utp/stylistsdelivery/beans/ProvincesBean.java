package pe.edu.utp.stylistsdelivery.beans;

import pe.edu.utp.stylistsdelivery.models.Province;
import pe.edu.utp.stylistsdelivery.models.SdService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ProvincesBean implements Serializable {
    private SdService service;
    private Province province;

    public ProvincesBean() { service = new SdService();}

    public List<Province> getProvinces() { return service.fin}




}
