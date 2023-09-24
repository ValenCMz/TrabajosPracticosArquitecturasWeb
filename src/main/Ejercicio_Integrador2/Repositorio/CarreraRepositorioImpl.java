package main.Ejercicio_Integrador2.Repositorio;

import main.Ejercicio_Integrador2.DTO.CarreraDTO;
import main.Ejercicio_Integrador2.DTO.CarreraReporteDTO;

import main.Ejercicio_Integrador2.Modelo.Carrera;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import javax.transaction.Transactional;

import java.util.List;

@Repository
public class CarreraRepositorioImpl implements CarreraRepositorio {

    private EntityManager em;

    public CarreraRepositorioImpl(EntityManager em) {
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
        return em.createQuery("SELECT NEW main.Ejercicio_Integrador2.DTO.CarreraDTO(c.id, c.nombre, COUNT(e)) FROM Carrera  c JOIN c.estudiantes e GROUP BY c.id,c.nombre ORDER BY COUNT(e) ", CarreraDTO.class).getResultList();
    }

    @Override
    public List<CarreraReporteDTO> getCarrerasReporte() {
        return em.createQuery("SELECT new main.Ejercicio_Integrador2.DTO.CarreraReporteDTO(c.nombre,ec.inscripcion,count(ec),SUM(CASE WHEN ec.graduacion > 0 THEN 1 ELSE 0 END)) FROM Carrera c JOIN c.estudiantes ec GROUP BY c.nombre,ec.inscripcion ORDER BY c.nombre,ec.inscripcion",CarreraReporteDTO.class).getResultList();
    }
}