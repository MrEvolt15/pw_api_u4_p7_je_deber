package uce.edu.ec.service;

import uce.edu.ec.service.to.EstudianteTo;

public interface IEstudianteService {
    public void guardar(EstudianteTo estudiante);

    public EstudianteTo buscarPorId(Integer id);

    public void actualizar(EstudianteTo estudiante);

    public void eliminar(Integer id);
}
