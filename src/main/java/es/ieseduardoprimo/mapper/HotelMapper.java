package es.ieseduardoprimo.mapper;

import es.ieseduardoprimo.dto.HotelDTO;
import es.ieseduardoprimo.model.Hotel;

public class HotelMapper extends BaseMapper<Hotel, HotelDTO> {

    @Override
    public Hotel fromDTO(HotelDTO item) {
        return new Hotel(item.getId(), item.getNombre(), item.getTelefono());
    }

    @Override
    public HotelDTO toDTO(Hotel item) {
        return new HotelDTO(item.getId(), item.getNombre(), item.getTelefono());
    }

}