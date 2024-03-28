package es.babel.buscador.model;

import es.babel.buscador.enums.Modalidad;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Curso {
    private String id;
    private String area;
    private String numHoras;
    private Modalidad modalidad;
    private String precio;
    private String periodoMatriculacion;
    private Boolean tieneCertificacionAsociada;
    private String localidad;
    private String direccion;
    private List<Formador> formadores;
    private Date fechaInicio;
    private Date fechaFinal;
}
