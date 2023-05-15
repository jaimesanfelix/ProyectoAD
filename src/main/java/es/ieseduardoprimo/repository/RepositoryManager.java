package es.ieseduardoprimo.repository;

import es.ieseduardoprimo.repository.hotel.HotelRepository;
import es.ieseduardoprimo.repository.media.MediaRepository;
import es.ieseduardoprimo.repository.sala.SalaRepository;

public interface RepositoryManager {
    HotelRepository getHotelRepository();
    MediaRepository getMediaRepository();
    SalaRepository  getSalaRepository();
}
//Falta crear la clase XMLRepositoryManager