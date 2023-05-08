package es.ieseduardoprimo.stream;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.ieseduardoprimo.model.Hotel;


public class ConsultasHotel {
    
    public ArrayList<Hotel> getListaHotels(ResultSet listaHoteles) throws SQLException{
        ArrayList<Hotel> hoteles = new ArrayList<>();

        while (listaHoteles.next()) {
            Hotel hotel = new Hotel(listaHoteles.getLong(1), listaHoteles.getString(2), listaHoteles.getInt(3));
            hoteles.add(hotel);
        }
        return hoteles;
    }

}
