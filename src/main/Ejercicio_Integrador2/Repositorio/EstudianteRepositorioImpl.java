package main.Ejercicio_Integrador2.Repositorio;

import main.Ejercicio_Integrador2.Modelo.Carrera;
import main.Ejercicio_Integrador2.Modelo.Estudiante;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

@Repository
public class EstudianteRepositorioImpl implements EstudianteRepositorio{

    private EntityManager em;

    public EstudianteRepositorioImpl(EntityManager em){
       this.em = em;
    }

    @Override
    @Transactional
    public void darDeAltaEstudiante(Estudiante e) {
        em.getTransaction().begin();

        em.persist(e);

        em.getTransaction().commit();
    }

    private Estudiante getEstudianteById(int id){
        return em.find(Estudiante.class,id);
    }

    @Override
    @Transactional
    public void matricularEstudianteACarrera(int estudianteId, int carreraId) {
        Estudiante estudiante = this.getEstudianteById(estudianteId);
        Carrera carrera = em.find(Carrera.class, carreraId);

        if(estudiante!=null && carrera!=null){
            estudiante.getCarreras().add(carrera);
            carrera.getEstudiantes().add(estudiante);
            em.getTransaction().begin();
            em.persist(estudiante);
            em.persist(carrera);
            em.getTransaction().commit();
        }
    }
}
