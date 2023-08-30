package main.Ejercicio_Integrador1.MySQL_DAO;

import main.Ejercicio_Integrador1.DAO.ClienteDAO;
import main.Ejercicio_Integrador1.Modelo.Cliente;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLClienteDAO implements ClienteDAO {

    private Connection conn;

    public MySQLClienteDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Cliente d) {

    }

    @Override
    public void update(Cliente d) {

    }

    @Override
    public void delete(Cliente d) {

    }

    @Override
    public ArrayList getAll() {
        return null;
    }


    @Override
    public void crearTabla() {

        String create = "CREATE TABLE IF NOT EXISTS cliente("+ "idCliente INT,"
                + "nombre VARCHAR(500),"+ "email VARCHAR(150)," +
                "PRIMARY KEY(idCliente))";
        try {
            conn.setAutoCommit(false);
            conn.prepareStatement(create).execute();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
