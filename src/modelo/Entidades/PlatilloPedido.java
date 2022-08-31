/*
PLATILLOS_codigo int(11) PK 
PEDIDOS_codigo int(11) PK 
cantidad int(11) 
importe decimal(9,2)
 */
package modelo.Entidades;

/**
 *
 * @author ALEX
 */
public class PlatilloPedido {
    private Platillo oPlatillo;
    private Pedido oPedido;
    private Integer cantidad;
    private Double importe;

    public PlatilloPedido() {
    }

    public PlatilloPedido(Platillo oPlatillo, Pedido oPedido) {
        this.oPlatillo = oPlatillo;
        this.oPedido = oPedido;
    }

    public Platillo getoPlatillo() {
        return oPlatillo;
    }

    public void setoPlatillo(Platillo oPlatillo) {
        this.oPlatillo = oPlatillo;
    }

    public Pedido getoPedido() {
        return oPedido;
    }

    public void setoPedido(Pedido oPedido) {
        this.oPedido = oPedido;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }
     
    @Override
    public String toString() {
        return "PlatilloPedido{" + "oPlatillo=" + oPlatillo + ", oPedido=" + oPedido + ", codigo=" + cantidad + ", importe=" + importe + '}';
    }
    
}
