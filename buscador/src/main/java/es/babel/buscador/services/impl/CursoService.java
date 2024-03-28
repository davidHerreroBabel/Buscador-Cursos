package es.babel.buscador.services.impl;

import es.babel.buscador.model.Alumno;
import es.babel.buscador.model.Curso;
import es.babel.buscador.model.DTO.CursoObjetoEntrada;
import es.babel.buscador.model.DTO.CursoObjetoRespuesta;
import es.babel.buscador.repositories.CursoRepository;
import es.babel.buscador.repositories.ICursoRepository;
import es.babel.buscador.services.ICursoService;

import java.util.List;

public class CursoService implements ICursoService {

    private final ICursoRepository cursoRepository = new CursoRepository();

    @Override
    public List<CursoObjetoRespuesta> getListadoCursos(CursoObjetoEntrada cursoObjetoEntrada) {
        return cursoRepository.getListadoCursosRespuesta(cursoObjetoEntrada);
    }

    @Override
    public Curso getCurso(String idCurso) {
        return cursoRepository.getCursoDetalle(idCurso);
    }

    @Override
    public void matricularAlumno(String idCurso, Alumno alumno) {
        cursoRepository.matricularAlumnoCurso(idCurso, alumno);
    }

    @Override
    public void anadirCurso(Curso curso) {
        cursoRepository.anadirCurso(curso);
    }

    @Override
    public List<Alumno> getAlumnosCurso(String idCurso) {
        return cursoRepository.getAlumnosCurso(idCurso);
    }

}
