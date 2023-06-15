package es.ieseduardoprimo.mapper;

import es.ieseduardoprimo.dto.SalaDTO;
import es.ieseduardoprimo.model.Sala;

public class SalaMapper extends BaseMapper<Sala, SalaDTO> {

    @Override
    public Sala fromDTO(SalaDTO item) {
        return new Sala(item.getId(), item.getHotel_id());
    }

    @Override
    public SalaDTO toDTO(Sala item) {
        return new SalaDTO(item.getId(), item.getHotel_id());
    }

}