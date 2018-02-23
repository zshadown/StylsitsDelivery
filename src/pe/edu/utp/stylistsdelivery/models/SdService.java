package pe.edu.utp.stylistsdelivery.models;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class SdService {
    private Connection connection;
    private ProvincesEntity provincesEntity;

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

    protected ProvincesEntity getProvincesEntity() {
        if(getConnection() != null) {
            if(provincesEntity == null) {
                provincesEntity = new ProvincesEntity();
                provincesEntity.setConnection(getConnection());
            }
        }
        return provincesEntity;
    }
}
