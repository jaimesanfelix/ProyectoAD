package es.ieseduardoprimo.mapper;

import es.ieseduardoprimo.dto.MediaDTO;
import es.ieseduardoprimo.model.Media;

public class MediaMapper extends BaseMapper<Media, MediaDTO> {

    @Override
    public Media fromDTO(MediaDTO item) {
        return new Media(item.getId(), item.getNombre());
    }

    @Override
    public MediaDTO toDTO(Media item) {
        return new MediaDTO(item.getId(), item.getNombre());
    }

}