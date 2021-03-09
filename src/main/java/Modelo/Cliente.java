
package Modelo;


public class Cliente {
    int id;
    String nombre;
    int nit;
    String correo;
    int celular;
    String patente;
    int suscripcion;
    String rango;
    float descuento;

    public Cliente() {
    }

    public Cliente(int id, String nombre, int nit, String correo, int celular, String patente, int suscripcion, String rango, float descuento) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
        this.correo = correo;
        this.celular = celular;
        this.patente = patente;
        this.suscripcion = suscripcion;
        this.rango = rango;
        this.descuento=descuento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(int suscripcion) {
        this.suscripcion = suscripcion;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }
    
    
    
}
