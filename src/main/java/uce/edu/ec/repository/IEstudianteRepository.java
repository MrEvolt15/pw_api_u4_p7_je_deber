package uce.edu.ec.repository;

import uce.edu.ec.repository.modelo.Estudiante;

public interface IEstudianteRepository {
    public void insertar(Estudiante estudiante);

    public Estudiante seleccionar(Integer id);

    public void actualizar(Estudiante estudiante);

    public void eliminar(Integer id);

}
