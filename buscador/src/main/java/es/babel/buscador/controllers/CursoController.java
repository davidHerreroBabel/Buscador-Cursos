package es.babel.buscador.controllers;

import es.babel.buscador.model.Alumno;
import es.babel.buscador.model.Curso;
import es.babel.buscador.model.DTO.AlumnoIdCurso;
import es.babel.buscador.model.DTO.CursoObjetoEntrada;
import es.babel.buscador.model.DTO.CursoObjetoRespuesta;
import es.babel.buscador.services.ICursoService;
import es.babel.buscador.services.impl.CursoService;
import es.babel.buscador.utils.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/curso")
public class CursoController {

    private final ICursoService cursoService = new CursoService();

    @PostMapping(value = "")
    public ResponseEntity<Object> crearCurso(@RequestBody Curso curso) {
        cursoService.anadirCurso(curso);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/all/filter")
    public ResponseEntity<List<CursoObjetoRespuesta>> getListadoCursos
            (@RequestBody CursoObjetoEntrada cursoObjetoEntrada) {
        Long startTime = System.nanoTime();
        List<CursoObjetoRespuesta> listadoCursos = cursoService.getListadoCursos(cursoObjetoEntrada);
        Long endTime = System.nanoTime();
        long duracion = endTime - startTime;
        Log.trace("Duración de la consulta: " + duracion);
        return new ResponseEntity<>(listadoCursos, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/id/detalle")
    public ResponseEntity<Curso> getCurso
            (@RequestParam String id) {
        Long startTime = System.nanoTime();
        Curso curso = cursoService.getCurso(id);
        Long endTime = System.nanoTime();
        long duracion = endTime - startTime;
        Log.trace("Duración de la consulta: " + duracion);
        if (curso == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(curso, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/id/matriculados")
    public ResponseEntity<List<Alumno>> getAlumnosCurso(@RequestParam String id) {
        return new ResponseEntity<>(cursoService.getAlumnosCurso(id), HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/matricular")
    public ResponseEntity<Integer> matricularAlumno(@RequestBody AlumnoIdCurso alumnoIdCurso) {
        cursoService.matricularAlumno(alumnoIdCurso.getIdCurso(), alumnoIdCurso.getAlumno());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
