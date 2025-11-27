package com.demo.api_estudiantes.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.demo.api_estudiantes.model.Estudiante;
import com.demo.api_estudiantes.repository.EstudianteRepository;

@Service
public class EstudianteService {

    private final EstudianteRepository repo;

    public EstudianteService(EstudianteRepository repo) {
        this.repo = repo;
    }

    public List<Estudiante> listar() {
        return repo.findAll();
    }

    public Estudiante crear(Estudiante e) {
        return repo.save(e);
    }

    public Estudiante actualizar(Integer id, Estudiante nuevo) {
        Estudiante e = repo.findById(id).orElseThrow();
        e.setNombre(nuevo.getNombre());
        e.setEdad(nuevo.getEdad());
        return repo.save(e);
    }

    public void eliminar(Integer id) {
        repo.deleteById(id);
    }

}
