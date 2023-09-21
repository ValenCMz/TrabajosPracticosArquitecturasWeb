package main.Ejercicio_Integrador2.Repositorio;

import main.Ejercicio_Integrador2.DTO.EstudianteDTO;
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

    /*@Override
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
    }*/


    @Override
    public List<EstudianteDTO> getEstudiantesDTOOrdenados() {
        //"SELECT NEW com.example.dto.EstudianteDTO(e.id, e.nombre, NEW com.example.dto.CarreraDTO(c.id, c.nombre)) FROM Estudiante e JOIN e.estudianteCarreras ec JOIN ec.carrera c"
        List<EstudianteDTO> estudiantes = em.createQuery("SELECT EstudianteDTO(e.numeroDeDocumento,e.nombre,e.edad) FROM Estudiante e",EstudianteDTO.class).getResultList();
        return estudiantes;
    }

    @Override
    public EstudianteDTO getEstudianteDTOByNumeroDeLibreta(int libreta) {
        Estudiante estudiante = em.find(Estudiante.class,libreta);
        List<String>carreras = new ArrayList<>();
        //for(Carrera c : estudiante.getCarreras()){
          //  carreras.add(c.getNombre());
        //}

        return new EstudianteDTO(estudiante.getNumeroDeLibretaUniversitaria(),estudiante.getNombre() + " " +estudiante.getApellido(), estudiante.getEdad());
    }

    @Override
    public List<EstudianteDTO> getEstudiantesPorGenero(char genero) {
        List<Estudiante> estudiantes = em.createQuery("SELECT e FROM Estudiante e WHERE e.genero = :genero",Estudiante.class).setParameter("genero",genero).getResultList();
        List<EstudianteDTO>toReturn = new ArrayList<>();
        List<String>carreras = new ArrayList<>();
        for(Estudiante e :estudiantes){
            //for(Carrera c : e.getCarreras()){
              //  carreras.add(c.getNombre());
            //}
        }

        for(Estudiante e : estudiantes) {
            toReturn.add(new EstudianteDTO(e.getNumeroDeLibretaUniversitaria(),e.getNombre() + e.getApellido(),e.getEdad()));
        }

        return toReturn;
    }

    @Override
    public List<EstudianteDTO> getEstudiantesPorCarreraPorCiudad(int id_carrera, String ciudad) {
        //List<Estudiante> estudiantes = em.createQuery("SELECT e FROM Estudiante e JOIN e.carreras e2 WHERE e.ciudadDeResidencia.nombre = :ciudad AND e2.id = :id_carrera",Estudiante.class).setParameter("ciudad",ciudad).setParameter("id_carrera",id_carrera).getResultList();
        List<EstudianteDTO>toReturn = new ArrayList<>();
        List<String>carreras = new ArrayList<>();
        //for(Estudiante e :estudiantes){
            //for(Carrera c : e.getCarreras()){
              //  carreras.add(c.getNombre());
            //}
       // }

        //for(Estudiante e : estudiantes) {
          //  toReturn.add(new EstudianteDTO(e.getNumeroDeLibretaUniversitaria(),e.getNombre() + e.getApellido(),e.getEdad(),carreras));
        //}

        return toReturn;

    }


}
