package main.Ejercicio_Integrador1.Main;

import main.Ejercicio_Integrador1.DAO.DAOFactory;
import main.Ejercicio_Integrador1.Helper.CreadorHelper;
import main.Ejercicio_Integrador1.MySQL_DAO.MySQLManagerDAO;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;


import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[]args)
    {
        DAOFactory df = DAOFactory.getDAOManagerMYSQL();
        CreadorHelper hp = new CreadorHelper(df.getConexion());
        hp.crearTabla();

       df.getProductoDAO().generarDatos("src/main/Ejercicio_Integrador1/productos.csv");
       df.getClienteDAO().generarDatos("src/main/Ejercicio_Integrador1/clientes.csv");
       df.getFacturaDAO().generarDatos("src/main/Ejercicio_Integrador1/facturas.csv");
       df.getFacturaProductoDAO().generarDatos("src/main/Ejercicio_Integrador1/facturas-productos.csv");

        System.out.println(df.getProductoDAO().getProductoMasRecaudo());
        System.out.println(df.getClienteDAO().getClientes());

    }
}
