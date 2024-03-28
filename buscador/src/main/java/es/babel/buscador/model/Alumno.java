package es.babel.buscador.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Alumno extends Persona {
    private String dni;
}
