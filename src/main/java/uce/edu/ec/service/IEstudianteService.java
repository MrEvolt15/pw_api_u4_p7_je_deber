package uce.edu.ec.service;

import java.util.List;

import uce.edu.ec.service.to.EstudianteTo;

public interface IEstudianteService {
    public void guardar(EstudianteTo estudiante);

    public EstudianteTo buscarPorId(Integer id);

    public void actualizar(EstudianteTo estudiante);

    public void eliminar(Integer id);

    public List<EstudianteTo> listaTodos();
    public List<EstudianteTo> listaPorNombre(String nombre);
    public List<EstudianteTo> listaPorNombreApellido(String nombre,String apellido);
    
}
