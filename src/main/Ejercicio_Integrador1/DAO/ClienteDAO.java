package main.Ejercicio_Integrador1.DAO;

import main.Ejercicio_Integrador1.DTO.ClienteDTO;
import main.Ejercicio_Integrador1.Modelo.Cliente;

import java.util.List;

public interface ClienteDAO extends DAO<Cliente> {
    public List<ClienteDTO> getClientes();
}
