package uce.edu.ec.controller;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import uce.edu.ec.service.IEstudianteService;
import uce.edu.ec.service.to.EstudianteTo;

@Path("/estudiantes")
public class EstudianteController {
    @Inject
    private IEstudianteService estudianteService;

    @GET
    @Path("/{id}")
    public EstudianteTo buscarPorId(@PathParam("id") Integer id) {
        return this.estudianteService.buscarPorId(id);
    }

    @POST
    @Path("")
    public void guardar(EstudianteTo estudiante) {

        this.estudianteService.guardar(estudiante);

    }

    @PUT
    @Path("/{id}")
    public void actualizar(@PathParam("id") Integer id, EstudianteTo estudiante) {
        estudiante.setId(id);
        this.estudianteService.actualizar(estudiante);
    }

    @PATCH
    @Path("/{id}/nuevo/{cedula}")
    public void actualizarParcial(EstudianteTo estudiante, @PathParam("id") Integer id,
            @PathParam("cedula") String cedula) {
        EstudianteTo tmp = this.estudianteService.buscarPorId(id);
        tmp.setNombre(estudiante.getNombre());
        this.estudianteService.actualizar(tmp);

    }

    @DELETE
    @Path("/{id}")
    public void borrar(@PathParam("id") Integer id) {
        this.estudianteService.eliminar(id);
    }

    @GET
    @Path("")
    public List<EstudianteTo> listaTodos() {
        return this.estudianteService.listaTodos();
    }

    @GET
    @Path("/porNombre")
    public List<EstudianteTo> listaPorNombre(@QueryParam("nombre") String nombre) {
        return this.estudianteService.listaPorNombre(nombre);
    }

    @GET
    @Path("/porNombreApellido")
    public List<EstudianteTo> listaPorNombreApellido(@QueryParam("nombre") String nombre,
            @QueryParam("apellido") String apellido) {
        return this.estudianteService.listaPorNombreApellido(nombre, apellido);
    }
    
}
