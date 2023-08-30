package main.Ejercicio_Integrador1.Main;

import main.Ejercicio_Integrador1.DAO.DAOFactory;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.FileReader;
import java.io.IOException;

public class main {
    public static void main(String[]args)
    {
        DAOFactory df = DAOFactory.getDAOManagerMYSQL();
        df.getClienteDAO().crearTabla();
        df.getProductoDAO().crearTabla();
        df.getFacturaDAO().crearTabla();
        df.getFacturaProductoDAO().crearTabla();


        CSVParser parser = null;
        try {
            parser = CSVFormat.DEFAULT.withHeader().parse(new
                    FileReader("src/main/Integrador/productos.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*
        for(CSVRecord row: parser) {
            df.getProductoDAO().insert(new Producto(Integer.valueOf(row.get("idProducto")),row.get("nombre"),Float.valueOf(row.get("valor"))));
        }*/
    }
}
