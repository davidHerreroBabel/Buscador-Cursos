package es.babel.buscador.repositories;

import es.babel.buscador.model.Alumno;
import es.babel.buscador.model.Curso;
import es.babel.buscador.model.DTO.CursoObjetoEntrada;
import es.babel.buscador.model.DTO.CursoObjetoRespuesta;
import es.babel.buscador.utils.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CursoRepository implements ICursoRepository {
    private final Map<String, List<Alumno>> alumnosMatriculadoCursos = new HashMap<>();
    private final Map<String, Curso> listadoCursos = new HashMap<>();
    private final List<CursoObjetoRespuesta> listadoCursosRespuesta = new ArrayList<>();

    @Override
    public List<CursoObjetoRespuesta> getListadoCursosRespuesta(CursoObjetoEntrada datosCursoEntrada) {
        List<CursoObjetoRespuesta> listadoCursosFiltro = new ArrayList<>();
        for (CursoObjetoRespuesta curso : listadoCursosRespuesta) {
            if (filtroSeCumple(datosCursoEntrada, curso)) {
                listadoCursosFiltro.add(curso);
            }
        }
        Log.info("Consulta filtro curso con area: " + datosCursoEntrada.getArea() +
                ", con numero de horas: " + datosCursoEntrada.getNumHoras() +
                ", con modalidad: " + datosCursoEntrada.getModalidad() + ".");
        return listadoCursosFiltro;
    }

    @Override
    public Curso getCursoDetalle(String idCurso) {
        Log.info("Consulta detalle curso con id: " + idCurso + ".");
        return listadoCursos.get(idCurso);
    }

    @Override
    public void matricularAlumnoCurso(String idCurso, Alumno alumno) {
        this.alumnosMatriculadoCursos.get(idCurso).add(alumno);
    }

    @Override
    public void anadirCurso(Curso curso) {
        this.listadoCursos.put(curso.getId(), curso);
        this.alumnosMatriculadoCursos.put(curso.getId(), new ArrayList<>());
        CursoObjetoRespuesta cursoRespuesta = crearObjetoRespuesta(curso);
        this.listadoCursosRespuesta.add(cursoRespuesta);
    }

    @Override
    public List<Alumno> getAlumnosCurso(String idCurso) {
        return this.alumnosMatriculadoCursos.get(idCurso);
    }

    private static boolean filtroSeCumple(CursoObjetoEntrada cursoObjetoEntrada,
                                          CursoObjetoRespuesta cursoObjetoRespuesta) {
        if (cursoObjetoEntrada.getArea() != null &&
                (!cursoObjetoEntrada.getArea().equals(cursoObjetoRespuesta.getArea()))) {
            return false;
        }
        if (cursoObjetoEntrada.getModalidad() != null &&
                (!cursoObjetoEntrada.getModalidad().equals(cursoObjetoRespuesta.getModalidad()))) {
            return false;
        }
        return cursoObjetoEntrada.getNumHoras() == null ||
                (cursoObjetoEntrada.getNumHoras().equals(cursoObjetoRespuesta.getNumHoras()));
    }

    private static CursoObjetoRespuesta crearObjetoRespuesta(Curso curso) {
        CursoObjetoRespuesta cursoRespuesta = new CursoObjetoRespuesta();
        cursoRespuesta.setId(curso.getId());
        cursoRespuesta.setArea(curso.getArea());
        cursoRespuesta.setModalidad(curso.getModalidad());
        cursoRespuesta.setNumHoras(curso.getNumHoras());
        cursoRespuesta.setPrecio(curso.getPrecio());
        return cursoRespuesta;
    }

}
