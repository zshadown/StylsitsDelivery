package pe.edu.utp.stylistsdelivery.models;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class SdService {
    private Connection connection;

    private Connection getConnection() {return connection;}

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


}
