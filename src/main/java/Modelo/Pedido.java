

package Modelo;


public class Pedido {
    int idpedido;
    int idproducto;
    String fechapedido;
    String fechaentrega;
    int cantidad;
    String estado;

    public Pedido() {
    }

    public Pedido(int idpedido, int idproducto, String fechapedido, String fechaentrega, int cantidad, String estado) {
        this.idpedido = idpedido;
        this.idproducto = idproducto;
        this.fechapedido = fechapedido;
        this.fechaentrega = fechaentrega;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getFechapedido() {
        return fechapedido;
    }

    public void setFechapedido(String fechapedido) {
        this.fechapedido = fechapedido;
    }

    public String getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(String fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
