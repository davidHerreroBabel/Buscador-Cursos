package es.babel.buscador.model.DTO;

import es.babel.buscador.enums.Modalidad;
import lombok.Data;

@Data
public class CursoObjetoEntrada {
    private String area;
    private String numHoras;
    private Modalidad modalidad;
}
