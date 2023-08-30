package main.Ejercicio_Integrador1.MySQL_DAO;

import main.Ejercicio_Integrador1.DAO.ProductoDAO;
import main.Ejercicio_Integrador1.Modelo.Producto;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    @Override
    public void generarDatos(String path) {
        CSVParser parser = null;
        try {
            parser = CSVFormat.DEFAULT.withHeader().parse(new
                    FileReader(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Agrego los datos
        for(CSVRecord row: parser) {
            insert(new Producto(Integer.valueOf(row.get("idProducto")),row.get("nombre"),Float.valueOf(row.get("valor"))));
        }
    }


    /*Escriba un programa JDBC que retorne el producto que más recaudó. Se define
    “recaudación” como cantidad de productos vendidos multiplicado por su valor*/
    @Override
    public Producto getProductoMasRecaudo() {
      Producto toReturn  = null;
        try {
            String query = "SELECT p.*, SUM(fp.cantidad * p.valor) AS sumatoria FROM producto p JOIN factura_producto fp ON p.idProducto = fp.idProducto GROUP BY p.idProducto ORDER BY sumatoria DESC LIMIT 1";
            PreparedStatement ps = conn.prepareStatement(query);
            //Resultado de ejecutar la query, a esto puedo acceder para imprimir los dato
            ResultSet rs = ps.executeQuery();

            //Imprimo los datos de la consulta
            while(rs.next()) {
                toReturn = new Producto(rs.getInt(1),rs.getString(2),rs.getInt(3));
            }
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
      return toReturn;
    }
}
