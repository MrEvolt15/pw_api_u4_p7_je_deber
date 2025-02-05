package uce.edu.ec.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import uce.edu.ec.repository.modelo.Estudiante;

@Transactional
@ApplicationScoped
public class EstudianteRepositoryImpl implements IEstudianteRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public void insertar(Estudiante estudiante) {
        this.entityManager.persist(estudiante);
    }

    @Override
    public Estudiante seleccionar(Integer id) {
        return this.entityManager.find(Estudiante.class, id);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
       this.entityManager.merge(estudiante);
    }

    @Override
    public void eliminar(Integer id) {
        this.entityManager.remove(this.seleccionar(id));
    }

}
