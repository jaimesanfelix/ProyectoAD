package es.ieseduardoprimo.repository.sala;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import es.ieseduardoprimo.model.Sala;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class XmlSalaRepository implements SalaRepository {

    @NonNull
    private Connection con;
    PreparedStatement sentencia = null;
    Resultset resultado = null;

    @Override
    public List<Sala> findAll() {

        ArrayList<Sala> listaSalas = new ArrayList<>();
        String sentenciaSql = "SELECT * FROM rooms";
        
        try {
            sentencia = con.prepareStatement(sentenciaSql);
            listaSalas = (ArrayList<Sala>) sentencia.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return listaSalas;

    }

    @Override
    public Sala findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean create(Sala entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public boolean update(Sala entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
