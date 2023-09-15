package main.Ejercicio_Integrador2.Repositorio;

import main.Ejercicio_Integrador2.Modelo.Ciudad;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CiudadRepositorioImpl implements CiudadRepositorio{

    private EntityManager em;

    public CiudadRepositorioImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public void addCiudad(Ciudad c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }
}
