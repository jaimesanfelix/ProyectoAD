package es.ieseduardoprimo.repository;

import es.ieseduardoprimo.repository.hotel.HotelRepository;
import es.ieseduardoprimo.repository.hotel.InMemoryHotelRepository;
import es.ieseduardoprimo.repository.media.InMemoryMediaRepository;
import es.ieseduardoprimo.repository.sala.InMemorySalaRepository;
import es.ieseduardoprimo.repository.sala.SalaRepository;

public class InMemoryRepositoryManager implements RepositoryManager{

    private InMemorySalaRepository salaRepository;
    private InMemoryHotelRepository hotelRepository;
    private InMemoryMediaRepository mediaRepository;

    public SalaRepository getSalaRepository() {
        if (salaRepository == null) {
            salaRepository = new InMemorySalaRepository();
        }

        return salaRepository;
    }


    @Override
    public HotelRepository getHotelRepository() {
        if (hotelRepository == null) {
            hotelRepository = new InMemoryHotelRepository();
        }
        return hotelRepository;
    }

    @Override
    public InMemoryMediaRepository getMediaRepository() {
        if (mediaRepository == null) {
            mediaRepository = new InMemoryMediaRepository();
        }
        return mediaRepository;
    }


}
