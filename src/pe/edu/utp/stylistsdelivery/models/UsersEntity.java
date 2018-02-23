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

    private  List<User> findByCriteria1(String sql){
        List<User> users;
        if (getConnection() != null){
            users = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()){
                    User user = new User()
                    .setId(resultSet.getInt("id"))
                            .setFirstName(resultSet.getString("first_name"))
                            .setLastName(resultSet.getString("last_name"))
                            .setBirthday(resultSet.getDate("birthday"))
                            .setEmail(resultSet.getString("email"))
                            .setDni(resultSet.getInt("dni"))
                            .setPassword(resultSet.getString("password"));
                            /*.setUserType(resultSet.getString())
                            .setDistrict(resultSet)*/
                            users.add(user);
                }
                return users;
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

    public User findByEmail(String email){
        List<User> users = findByCriteria1(DEFAULT_SQL +
        " WHERE email = '" + email + "'");
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

    private int getMaxId(){
        String sql = "SELECT MAX(id) AS max_id FROM users";
        if (getConnection()!=null){
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                return resultSet.next() ?
                        resultSet.getInt("max_id") : 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public User create(User user){
        if (findByEmail(user.getEmail()) == null){
            if (getConnection() != null){
                String sql = "INSERT INTO users(id, first_name, last_name," +
                        "birthday, email, dni, password, user_type_id, district_id) VALUES(" +
                        String.valueOf(getMaxId()+1) + ", '" + user.getFirstName()+"', '" +
                        user.getLastName() + "', " + user.getBirthday() + ", '" +
                        user.getEmail() + "', " + String.valueOf(user.getDni()) + ", '" +
                        user.getPassword() + "', " +
                        String.valueOf(user.getUserType().getId()) + ", " +
                        String.valueOf(user.getDistrict().getId()) + ")";
                int results = updateByCriteria(sql);
                if (results>0){
                    User user1 = new User();
                    return user1;
                }
            }
        }
        return  null;
    }
}
