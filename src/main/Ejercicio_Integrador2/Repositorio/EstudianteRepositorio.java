package main.Ejercicio_Integrador2.Repositorio;

import main.Ejercicio_Integrador2.DTO.EstudianteDTO;
import main.Ejercicio_Integrador2.Modelo.Estudiante;

import java.util.List;

public interface EstudianteRepositorio {

    public void darDeAltaEstudiante(Estudiante e);

    public void matricularEstudianteACarrera(int estudianteId, int carreraId);

    public List<EstudianteDTO> getEstudiantesDTOOrdenados();

    public EstudianteDTO getEstudianteDTOByNumeroDeLibreta(int libreta);

    public List<EstudianteDTO>getEstudiantesPorGenero(char genero);

    public List<EstudianteDTO>getEstudiantesPorCarreraPorCiudad(int id_carrera ,String ciudad);
}
