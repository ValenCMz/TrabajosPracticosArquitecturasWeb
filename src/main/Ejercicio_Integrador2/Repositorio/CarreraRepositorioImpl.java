package main.Ejercicio_Integrador2.Repositorio;

import main.Ejercicio_Integrador2.DTO.CarreraDTO;
import main.Ejercicio_Integrador2.DTO.CarreraReporteDTO;
import main.Ejercicio_Integrador2.DTO.EstudianteDTO;
import main.Ejercicio_Integrador2.Modelo.Carrera;
import main.Ejercicio_Integrador2.Modelo.Estudiante;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarreraRepositorioImpl implements CarreraRepositorio{

    private EntityManager em;

    public CarreraRepositorioImpl(EntityManager em){
        this.em = em;
    }

    @Override
    @Transactional
    public void addCarrera(Carrera c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }

    @Override
    public List<CarreraDTO> getCarrerasConInscriptos() {
         return  em.createQuery("SELECT NEW main.Ejercicio_Integrador2.DTO.CarreraDTO(c.id, c.nombre, COUNT(e)) FROM Carrera  c JOIN c.estudiantes e GROUP BY c.id,c.nombre ORDER BY COUNT(e) ",CarreraDTO.class).getResultList();
    }

    @Override
    public List<CarreraReporteDTO> getCarrerasReporte() {
        return em.createQuery("SELECT new main.Ejercicio_Integrador2.DTO.CarreraReporteDTO(c.nombre, e.inscripcion, COUNT(e.inscripcion), COUNT(e.graduacion) ) FROM Carrera c JOIN c.estudiantes e GROUP BY e.inscripcion, c.nombre ORDER BY c.nombre,e.inscripcion", CarreraReporteDTO.class).getResultList();
    }
}
