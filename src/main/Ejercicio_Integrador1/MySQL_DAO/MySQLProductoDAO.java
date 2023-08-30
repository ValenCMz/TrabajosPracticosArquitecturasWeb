package main.Ejercicio_Integrador1.MySQL_DAO;

import main.Ejercicio_Integrador1.DAO.ProductoDAO;
import main.Ejercicio_Integrador1.Modelo.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLProductoDAO implements ProductoDAO {
    private Connection conn;

    public MySQLProductoDAO(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void insert(Producto d) {
        String sentence = "INSERT INTO producto (idProducto,nombre,valor) VALUES(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sentence);
            ps.setInt(1,d.getIdProducto());
            ps.setString(2,d.getNombre());
            ps.setFloat(3,d.getValor());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Producto d) {

    }

    @Override
    public void delete(Producto d) {

    }

    @Override
    public ArrayList getAll() {
        return null;
    }

    @Override
    public void crearTabla() {

        String create = "CREATE TABLE IF NOT EXISTS producto("+ "idProducto INT,"
                + "nombre VARCHAR(45),"+ "valor float," +
                "PRIMARY KEY(idProducto))";
        try {
            conn.setAutoCommit(false);
            conn.prepareStatement(create).execute();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
