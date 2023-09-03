package main.Ejercicio_Integrador1.DTO;

public class ClienteDTO {

    private int idCliente;
    private String nombre;
    private String email;
    private int montoFacturado;

    public ClienteDTO(int id, String nombre, String email, int monto){
        this.idCliente = id;
        this.nombre = nombre;
        this.email = email;
        this.montoFacturado = monto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMontoFacturado() {
        return montoFacturado;
    }
    public void setMontoFacturado(int montoFacturado) {
        this.montoFacturado = montoFacturado;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", montoFacturado=" + montoFacturado +
                '}' + '\n';
    }
}
