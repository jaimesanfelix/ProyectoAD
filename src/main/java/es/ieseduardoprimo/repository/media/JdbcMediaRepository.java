package es.ieseduardoprimo.repository.media;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.ieseduardoprimo.model.Hotel;
import es.ieseduardoprimo.model.Media;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JdbcMediaRepository implements MediaRepository {

    private final String getAll = "SELECT * FROM `rooms`";
    private final String getOne = "SELECT * FROM `rooms` WHERE `id` = ?";
    private final String insert = "INSERT INTO `rooms` (id, hotel_id) VALUES (?, ?)";
    private final String update = "UPDATE `rooms` SET `id` = ? WHERE `hotel_id`= ?";
    private final String delete = "DELETE FROM `rooms` WHERE `id`= ?";

    @NonNull
    private Connection con;
    private Hotel hotel;
    
    @Override
    public List<Media> findAll() {
        PreparedStatement ps = null;
        List<Media> result = new ArrayList<>();
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(getAll);
            rs = ps.executeQuery();
            
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

        return (List<Media>) rs;
    }

    @Override
    public Media findById(Integer id) {
        PreparedStatement ps = null;
        Media result = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(getOne);
            ps.setInt(1, id);
            rs = ps.executeQuery();
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

        return (Media) rs;
    }

    @Override
    public boolean create(Media entity) {
        PreparedStatement ps = null;
        boolean created = false;

        try {
            ps = con.prepareStatement(insert);
            ps.setInt(1, entity.getId());
            ps.setInt(2, hotel.getId());

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
    public boolean update(Media entity) {
        PreparedStatement ps = null;
        boolean updated = false;

        try {
            ps = con.prepareStatement(update);
            ps.setInt(1, entity.getId());
            ps.setInt(2, hotel.getId());

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
    
}



