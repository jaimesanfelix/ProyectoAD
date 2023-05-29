package es.ieseduardoprimo.repository.hotel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Document;

import org.w3c.dom.NodeList;

import es.ieseduardoprimo.model.Hotel;

public class InMemoryHotelRepository implements HotelRepository{

    private Document data;

    @Override
    public List<Hotel> findAll() {
        List<Hotel> listHotel = new ArrayList<Hotel>();
        NodeList nodeList = this.data.getElementsByTagName("Hotel");
        for (int i = 0; i < nodeList.getLength(); i++) {
            listHotel.add(nodeList.item(i));
        }
        return listHotel;
    }

    @Override
    public Hotel findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean create(Hotel entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public boolean update(Hotel entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }


}
