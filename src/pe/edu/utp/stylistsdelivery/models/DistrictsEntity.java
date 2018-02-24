package pe.edu.utp.stylistsdelivery.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DistrictsEntity extends BaseEntity {
    private static String DEFAULT_SQL = "SELECT * FROM districts";
    
    private List<District> findByCriteria(String sql, ProvincesEntity provincesEntity){
        List<District> districts = new ArrayList<>();
        if (getConnection()!=null){
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()){
                    District district = new District(
                            resultSet.getInt("id"),
                            resultSet.getString("description"),
                            null
                    );
                    districts.add(district);
                }
                return districts;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
