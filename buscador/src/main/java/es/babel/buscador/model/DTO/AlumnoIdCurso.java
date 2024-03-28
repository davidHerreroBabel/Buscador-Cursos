package es.babel.buscador.model.DTO;

import es.babel.buscador.model.Alumno;
import lombok.Data;

@Data
public class AlumnoIdCurso {
    private String idCurso;
    private Alumno alumno;
}
