package uce.edu.ec.service;

import java.util.function.Function;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.repository.IEstudianteRepository;
import uce.edu.ec.repository.modelo.Estudiante;
import uce.edu.ec.service.to.EstudianteTo;

@ApplicationScoped
public class EstudianteServiceImpl implements IEstudianteService {

    @Inject
    private IEstudianteRepository estudianteRepository;

    @Override
    public void guardar(EstudianteTo estudiante) {
        estudianteRepository.insertar(this.mapEstudiante.apply(estudiante));
    }

    @Override
    public EstudianteTo buscarPorId(Integer id) {
        Estudiante estu = estudianteRepository.seleccionar(id);
        return this.mapTo.apply(estu);
    }

    @Override
    public void actualizar(EstudianteTo estudiante) {
        estudianteRepository.actualizar(this.mapEstudiante.apply(estudiante));
    }

    @Override
    public void eliminar(Integer id) {
        estudianteRepository.eliminar(id);
    }

    private Function<Estudiante, EstudianteTo> mapTo = (p) -> {
        return new EstudianteTo(p.getId(), p.getNombre(), p.getApellido(),p.getCedula(), p.getCorreo());
    };
    private Function<EstudianteTo, Estudiante> mapEstudiante = (p) -> {
        Estudiante persona = new Estudiante();
        persona.setId(p.getId());
        persona.setNombre(p.getNombre());
        persona.setApellido(p.getApellido());
        persona.setCorreo(p.getCorreo());
        return persona;
    };
}
