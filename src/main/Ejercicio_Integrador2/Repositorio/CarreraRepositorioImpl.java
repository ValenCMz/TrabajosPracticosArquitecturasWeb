package main.Ejercicio_Integrador2.Repositorio;

import main.Ejercicio_Integrador2.Modelo.Carrera;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

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
}
