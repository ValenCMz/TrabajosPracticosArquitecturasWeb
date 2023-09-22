package main.Ejercicio_Integrador2.Repositorio;

import main.Ejercicio_Integrador2.DTO.EstudianteDTO;
import main.Ejercicio_Integrador2.DTO.EstudiantePorCarreraDTO;
import main.Ejercicio_Integrador2.Modelo.Estudiante;
import main.Ejercicio_Integrador2.Modelo.EstudianteCarrera;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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
    public List<EstudianteDTO> getEstudiantesDTOOrdenadosPorApellido() {
        return em.createQuery("SELECT NEW main.Ejercicio_Integrador2.DTO.EstudianteDTO(e.numeroDeDocumento, concat(e.nombre,' ', e.apellido) , e.numeroDeLibretaUniversitaria,e.genero) FROM Estudiante e ORDER BY e.apellido",EstudianteDTO.class).getResultList();
    }

    @Override
    public EstudianteDTO getEstudianteDTOByNumeroDeLibreta(int libreta) {
        return em.createQuery("SELECT NEW main.Ejercicio_Integrador2.DTO.EstudianteDTO(e.numeroDeDocumento, concat(e.nombre,' ', e.apellido) , e.numeroDeLibretaUniversitaria,e.genero) FROM Estudiante e WHERE e.numeroDeLibretaUniversitaria = :nroLu",EstudianteDTO.class).setParameter("nroLu",libreta).getSingleResult();
    }

    @Override
    public List<EstudianteDTO> getEstudiantesPorGenero(String genero) {
        return em.createQuery("SELECT NEW main.Ejercicio_Integrador2.DTO.EstudianteDTO(e.numeroDeDocumento, concat(e.nombre,' ', e.apellido) , e.numeroDeLibretaUniversitaria,e.genero) FROM Estudiante e WHERE e.genero LIKE :genero",EstudianteDTO.class).setParameter("genero",genero).getResultList();
    }

    @Override
    public List<EstudiantePorCarreraDTO> getEstudiantesPorCarreraPorCiudad(int id_carrera, String ciudad) {

        return em.createQuery("SELECT NEW main.Ejercicio_Integrador2.DTO.EstudiantePorCarreraDTO(e.id, concat(e.nombre, ' ',e.apellido), e2.carrera.nombre, e.ciudadDeResidencia) FROM Estudiante e JOIN e.carreras e2 WHERE e.ciudadDeResidencia LIKE :ciudad AND e2.carrera.id = :id_carrera", EstudiantePorCarreraDTO.class).setParameter("ciudad",ciudad).setParameter("id_carrera",id_carrera).getResultList();
    }


}
