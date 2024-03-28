package es.babel.buscador.services;

import es.babel.buscador.model.Alumno;
import es.babel.buscador.model.Curso;
import es.babel.buscador.model.DTO.CursoObjetoEntrada;
import es.babel.buscador.model.DTO.CursoObjetoRespuesta;

import java.util.List;

public interface ICursoService {

    List<CursoObjetoRespuesta> getListadoCursos(CursoObjetoEntrada cursoObjetoEntrada);

    Curso getCurso(String idCurso) ;

    void matricularAlumno(String idCurso, Alumno alumno);

    void anadirCurso(Curso curso);

    List<Alumno> getAlumnosCurso(String idCurso);
}
