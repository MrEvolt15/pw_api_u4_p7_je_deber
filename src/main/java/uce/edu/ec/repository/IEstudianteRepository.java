package uce.edu.ec.repository;

import java.util.List;

import uce.edu.ec.repository.modelo.Estudiante;

public interface IEstudianteRepository {
    public void insertar(Estudiante estudiante);

    public Estudiante seleccionar(Integer id);

    public void actualizar(Estudiante estudiante);

    public void eliminar(Integer id);
    
    public List<Estudiante> listaTodos();
    public List<Estudiante> listaPorNombre(String nombre);
    public List<Estudiante> listaPorNombreApellido(String nombre,String apellido);

}
