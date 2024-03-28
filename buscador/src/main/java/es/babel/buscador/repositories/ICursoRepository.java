package es.babel.buscador.repositories;

import es.babel.buscador.model.Alumno;
import es.babel.buscador.model.Curso;
import es.babel.buscador.model.DTO.CursoObjetoEntrada;
import es.babel.buscador.model.DTO.CursoObjetoRespuesta;

import java.util.List;

public interface ICursoRepository {

    List<CursoObjetoRespuesta> getListadoCursosRespuesta(CursoObjetoEntrada datosCursoEntrada);

    Curso getCursoDetalle(String idCurso);

    void matricularAlumnoCurso(String idCurso, Alumno alumno);

    void anadirCurso(Curso curso);

    List<Alumno> getAlumnosCurso(String idCurso);
}
