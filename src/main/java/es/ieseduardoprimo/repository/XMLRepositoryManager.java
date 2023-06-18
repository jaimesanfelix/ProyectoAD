package es.ieseduardoprimo.repository;

import es.ieseduardoprimo.mapper.SalaMapper;
import es.ieseduardoprimo.repository.hotel.HotelRepository;
import es.ieseduardoprimo.repository.media.MediaRepository;
import es.ieseduardoprimo.repository.sala.SalaRepository;
import es.ieseduardoprimo.rest.APIRestConfig;

public class XMLRepositoryManager implements RepositoryManager {

    private SalaRepository salaRepository;


    @Override
    public SalaRepository getSalaRepository() {
        if (salaRepository == null) {
            salaRepository = new RestSalaRepository(
                APIRestConfig.getService(SalasRest.class),
                new SalaMapper()
            );
        }

        return salaRepository;
    }


    @Override
    public HotelRepository getHotelRepository() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHotelRepository'");
    }

    @Override
    public MediaRepository getMediaRepository() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMediaRepository'");
    }
}
