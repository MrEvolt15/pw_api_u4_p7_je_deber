package uce.edu.ec.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

     @Override
    public List<Estudiante> listaTodos() {
        TypedQuery<Estudiante> mQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
        return mQuery.getResultList();
        }

    @Override
    public List<Estudiante> listaPorNombre(String nombre) {
        TypedQuery<Estudiante> mQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.nombre = :Nombre", Estudiante.class);
        mQuery.setParameter("Nombre", nombre);
        return mQuery.getResultList();
        }

    @Override
    public List<Estudiante> listaPorNombreApellido(String nombre, String apellido) {
        TypedQuery<Estudiante> mQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.nombre = :Nombre AND e.apellido = :Apellido", Estudiante.class);
        mQuery.setParameter("Nombre", nombre);
        mQuery.setParameter("Apellido", apellido);
        return mQuery.getResultList();
    }

}
