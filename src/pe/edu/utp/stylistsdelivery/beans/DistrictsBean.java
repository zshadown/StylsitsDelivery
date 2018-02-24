package pe.edu.utp.stylistsdelivery.beans;

import pe.edu.utp.stylistsdelivery.models.District;
import pe.edu.utp.stylistsdelivery.models.Province;
import pe.edu.utp.stylistsdelivery.models.ProvincesEntity;
import pe.edu.utp.stylistsdelivery.models.SdService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
//Districts Beans
public class DistrictsBean implements Serializable {
    private SdService sdService;
    private District district;
    private ProvincesEntity provincesEntity;

    public DistrictsBean(){
        sdService = new SdService();
    }

    public List<District> getDistricts(ProvincesEntity provincesEntity){
        return sdService.findAllDistricts(provincesEntity);
    }

}
