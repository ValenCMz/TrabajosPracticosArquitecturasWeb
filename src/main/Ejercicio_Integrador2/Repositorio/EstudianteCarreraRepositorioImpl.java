package main.Ejercicio_Integrador2.Repositorio;

import main.Ejercicio_Integrador2.Modelo.Carrera;
import main.Ejercicio_Integrador2.Modelo.CarreraEstudianteKey;
import main.Ejercicio_Integrador2.Modelo.Estudiante;
import main.Ejercicio_Integrador2.Modelo.EstudianteCarrera;

import javax.persistence.EntityManager;

public class EstudianteCarreraRepositorioImpl implements EstudianteCarreraRepositorio{

    private EntityManager em;

    public EstudianteCarreraRepositorioImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public void addEstudianteCarrera(int idEstudiante, int idCarrera,int inscripcion,int graduacion,int antiguedad) {
        em.getTransaction().begin();
        Estudiante e = em.find(Estudiante.class,idEstudiante);
        Carrera c = em.find(Carrera.class,idCarrera);
        if (c != null && e != null){
            CarreraEstudianteKey eck = new CarreraEstudianteKey(e.getNumeroDeDocumento(),c.getId());
            EstudianteCarrera ec = new EstudianteCarrera(c,e,eck,inscripcion,graduacion,antiguedad);
            e.addCarrera(ec);
            c.addCarrera(ec);
            em.persist(ec);
            em.getTransaction().commit();
        }
    }
}
