package es.ieseduardoprimo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO {
    private int id;
    private String nombre;
    private String telefono;
}
