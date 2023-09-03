package main.Ejercicio_Integrador1.MySQL_DAO;

import main.Ejercicio_Integrador1.DAO.FacturaProductoDAO;
import main.Ejercicio_Integrador1.Modelo.Factura;
import main.Ejercicio_Integrador1.Modelo.Factura_Producto;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLFacturaProductoDAO implements FacturaProductoDAO {

    private Connection conn;

    public MySQLFacturaProductoDAO(Connection conn) {
        this.conn = conn;
    }



    @Override
    public void insert(Factura_Producto d) {
        String sentence = "INSERT INTO factura_producto (idFactura,idProducto,cantidad) VALUES(?,?,?)";
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sentence);
            ps.setInt(1,d.getIdFactura());
            ps.setInt(2,d.getIdProducto());
            ps.setInt(3,d.getCantidad());
            ps.executeUpdate();
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
            insert(new Factura_Producto(Integer.valueOf(row.get("idFactura")), Integer.valueOf(row.get("idProducto")),Integer.valueOf(row.get("cantidad"))));
        }
    }
}
