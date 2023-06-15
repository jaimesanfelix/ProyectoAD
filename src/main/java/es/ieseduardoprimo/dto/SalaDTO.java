package es.ieseduardoprimo.dto;

import es.ieseduardoprimo.model.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaDTO {
    private String id;
    private Hotel hotel_id;
}
