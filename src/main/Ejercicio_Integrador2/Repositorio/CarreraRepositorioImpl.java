package main.Ejercicio_Integrador2.Repositorio;

import main.Ejercicio_Integrador2.DTO.CarreraDTO;
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
    public List<CarreraDTO> getCarrerasConEstudiantesOrdenadosPorCantidadDeInscriptos() {
        List<Carrera>carreras = em.createQuery("SELECT c FROM Carrera c WHERE c.estudiantes.size != 0 ORDER BY c.estudiantes.size").getResultList();
        List<CarreraDTO>toReturn = new ArrayList<>();
        List<EstudianteDTO>estudianteDTOS = new ArrayList<>();
        for(Carrera c : carreras){
            for(Estudiante e : c.getEstudiantes()){
                estudianteDTOS.add(new EstudianteDTO(e.getNumeroDeLibretaUniversitaria(),e.getNombre(),e.getEdad()));
            }
        }

        for(Carrera c : carreras){
            toReturn.add(new CarreraDTO(c.getId(),c.getNombre(),estudianteDTOS));
        }

        return toReturn;
    }
}
