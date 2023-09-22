package main.Ejercicio_Integrador2.Repositorio;

import main.Ejercicio_Integrador2.DTO.EstudianteDTO;
import main.Ejercicio_Integrador2.DTO.EstudiantePorCarreraDTO;
import main.Ejercicio_Integrador2.Modelo.Estudiante;

import java.util.List;

public interface EstudianteRepositorio {

    public void darDeAltaEstudiante(Estudiante e);

    public List<EstudianteDTO> getEstudiantesDTOOrdenadosPorApellido();

    public EstudianteDTO getEstudianteDTOByNumeroDeLibreta(int libreta);

    public List<EstudianteDTO>getEstudiantesPorGenero(String genero);

    public List<EstudiantePorCarreraDTO>getEstudiantesPorCarreraPorCiudad(int id_carrera , String ciudad);
}
