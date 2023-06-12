package es.ieseduardoprimo.repository.media;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import es.ieseduardoprimo.model.Media;

public class InMemoryMediaRepository implements MediaRepository{

private Document data;
    @Override
    public List<Media> findAll() {
        List<Media> listaMedias = new ArrayList<Media>();
        NodeList nodeList = this.data.getElementsByTagName("media");
        for (int i = 0; i < nodeList.getLength(); i++) {
            listaMedias.add(i, null);
        }
        return listaMedias;
    }

    @Override
    public Media findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean create(Media entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public boolean update(Media entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
