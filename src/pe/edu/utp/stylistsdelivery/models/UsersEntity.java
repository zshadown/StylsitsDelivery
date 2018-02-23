package pe.edu.utp.stylistsdelivery.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersEntity extends BaseEntity {
    private static String DEFAULT_SQL = "SELECT * FROM users";
    private List<User> findByCriteria(String sql, UsersTypeEntity usersTypeEntity, DistrictsEntity districtsEntity){
        List<User> users = new ArrayList<>();
        if (getConnection() != null){
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()){
                    /*
                    User user = new User((
                            resultSet.getInt("id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getDate("birthday"),
                            resultSet.getString("email"),
                            resultSet.getInt("dni"),
                            resultSet.getString("password"),
                            usersTypeEntity.findById(resultSet.getInt("id")),
                            DistrictsEntity.findById(resultSet.getInt("id"))
                    );
                    users.add(user);*/
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        return null;
    }

    public List<User> findAll(UsersTypeEntity usersTypeEntity, DistrictsEntity districtsEntity){
        return findByCriteria(DEFAULT_SQL, usersTypeEntity, districtsEntity);
    }

    public User findById(int id){
        List<User> users = findByCriteria(DEFAULT_SQL +
        " WHERE id = "+ String.valueOf(id), null, null);
        return (users != null ? users.get(0) : null);
    }

    private  int updateByCriteria(String sql){
        if (getConnection() != null){
            try {
                return getConnection()
                        .createStatement()
                        .executeUpdate(sql);
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return 0;
    }

    private boolean delete(int id){
        return updateByCriteria("DELETE FROM users WHERE id = "+String.valueOf(id)) > 0;
    }
}
