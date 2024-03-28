package es.babel.buscador.model.DTO;

import es.babel.buscador.enums.Modalidad;
import lombok.Data;

@Data
public class CursoObjetoRespuesta {
    private String id;
    private String area;
    private String numHoras;
    private Modalidad modalidad;
    private String precio;
}
