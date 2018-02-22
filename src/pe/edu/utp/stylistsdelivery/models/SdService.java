package pe.edu.utp.stylistsdelivery.models;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class SdService {
    private Connection connection;


    private Connection getConnection(){
        if (connection == null){
            try {
                connection = ((DataSource) InitialContext
                .doLookup("jdbc/MySQLDataSource"))
                        .getConnection();
            } catch (SQLException | NamingException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
