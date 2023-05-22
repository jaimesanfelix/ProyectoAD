package es.ieseduardoprimo.repository;

import es.ieseduardoprimo.repository.sala.InMemorySalaRepository;
import es.ieseduardoprimo.repository.sala.SalaRepository;

public class InMemoryRepositoryManager implements RepositoryManager{
    
    private SalaRepository salaRepository;


    public SalaRepository getSalaRepository() {
        if (salaRepository == null) {
            salaRepository = new InMemorySalaRepository();
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
