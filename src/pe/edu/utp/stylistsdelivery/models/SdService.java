package pe.edu.utp.stylistsdelivery.models;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class SdService {
    private Connection connection;
    private ProvincesEntity provincesEntity;
    private DistrictsEntity districtsEntity;
    private ServicesEntity servicesEntity;
    private UsersEntity usersEntity;
    private UsersTypeEntity usersTypeEntity;

    /* Conecctioin con la BD MYSQLDataSource*/
    private Connection getConnection() {
        if(connection ==null){
            try {
                connection = ((DataSource) InitialContext.doLookup("jdbc/MySQLDataSource1"))
                        .getConnection();
            } catch (NamingException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /* Metodo get Entity Provinces*/
    protected ProvincesEntity getProvincesEntity() {
        if(getConnection() != null) {
            if(provincesEntity == null) {
                provincesEntity = new ProvincesEntity();
                provincesEntity.setConnection(getConnection());
            }
        }
        return provincesEntity;
    }

    /* Metodo get Entity Districts*/
    protected DistrictsEntity getDistrictsEntity(){
        if(getConnection() != null) {
            if(districtsEntity == null) {
               districtsEntity = new DistrictsEntity();
               districtsEntity.setConnection(getConnection());
            }
        }
        return districtsEntity;
    }

    /* /* Metodo get Entity Services*/
    protected ServicesEntity getServicesEntity(){
        if(getConnection() != null) {
            if(servicesEntity == null) {
                servicesEntity = new ServicesEntity();
                servicesEntity.setConnection(getConnection());
            }
        }
        return servicesEntity;
    }

    /* Metodo get Entity Users*/
    protected UsersEntity getUsersEntity(){
        if(getConnection() != null) {
            if(usersEntity== null) {
                usersEntity = new UsersEntity();
                usersEntity.setConnection(getConnection());
            }
        }
        return usersEntity;
    }


    /* Metodo get Entity UsersType*/
    protected UsersTypeEntity getUsersType(){
        if(getConnection() != null) {
            if(usersTypeEntity == null) {
                usersTypeEntity = new UsersTypeEntity();
                usersTypeEntity.setConnection(getConnection());
            }
        }
        return usersTypeEntity;
    }






    /*metodos de update, delete, create, find de User*/

     /*public boolean updateUser(User user){
        return getUsersEntity() != null ?
                getUsersEntity().update(user) : false;
    }*/

    /*metodos de update, delete, create, find de Province*/

    /*metodos de update, delete, create, find de Distric*/

    /*metodos de update, delete, create, find de Service*/

    /*metodos de update, delete, create, find de UserType*/
}
