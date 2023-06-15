package es.ieseduardoprimo.repository.hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.ieseduardoprimo.model.Hotel;
import es.ieseduardoprimo.model.Hotel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JdbcHotelRepository implements HotelRepository {

    private final String getAll = "SELECT * FROM `hotels`";
    private final String getOne = "SELECT * FROM `hotels` WHERE `id` = ?";
    private final String insert = "INSERT INTO `hotels` (name, id, telephone) VALUES (?, ?, ?)";
    private final String update = "UPDATE `hotels` SET `name` = ?, `telephone` = ? WHERE `id`= ?";
    private final String delete = "DELETE FROM `hotels` WHERE `id`= ?";

    @NonNull
    private Connection con;
    
    @Override
    public List<Hotel> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Hotel> result = new ArrayList<Hotel>();

        try {
            ps = con.prepareStatement(getAll);
            rs = ps.executeQuery();
            result = fromResultSet(rs);
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }



    @Override
    public Hotel findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Hotel result = null;

        try {
            ps = con.prepareStatement(getOne);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            result = fromResultSet(rs).get(0);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    @Override
    public boolean create(Hotel entity) {
        PreparedStatement ps = null;
        boolean created = false;

        try {
            ps = con.prepareStatement(insert);
            ps.setString(1, entity.getNombre());
            ps.setInt(2, entity.getId());
            ps.setString(3, entity.getTelefono());

            if (ps.executeUpdate() == 1) {
                created = true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return created;
    }

    @Override
    public boolean update(Hotel entity) {
        PreparedStatement ps = null;
        boolean updated = false;

        try {
            ps = con.prepareStatement(update);
            ps.setString(1, entity.getNombre());
            ps.setString(2, entity.getTelefono());
            ps.setInt(3, entity.getId());

            if (ps.executeUpdate() == 1) {
                updated = true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return updated;
    }

    @Override
    public boolean delete(Integer id) {
        PreparedStatement ps = null;
        boolean deleted = false;

        try {
            ps = con.prepareStatement(delete);
            ps.setInt(1, id);

            if (ps.executeUpdate() == 1) {
                deleted = true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return deleted;
    }
 
    private List<Hotel> fromResultSet(ResultSet rs) throws SQLException {
        List<Hotel> result = new ArrayList<>();

        while (rs.next()) {
            result.add(new Hotel(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("telephone")
            ));
        }

        return result;
    }


}



