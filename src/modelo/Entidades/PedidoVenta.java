package modelo.Entidades;

/**
 *
 * @author ALEX
 */
public class PedidoVenta {

    private Pedido oPedido;
    private Venta oVenta;
    private String detalle;
    private Double importe;

    public PedidoVenta() {
    }

    public PedidoVenta(Pedido oPedido, Venta oVenta) {
        this.oPedido = oPedido;
        this.oVenta = oVenta;
    }

    public PedidoVenta(Pedido oPedido, Venta oVenta, String detalle, Double importe) {
        this.oPedido = oPedido;
        this.oVenta = oVenta;
        this.detalle = detalle;
        this.importe = importe;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Pedido getoPedido() {
        return oPedido;
    }

    public void setoPedido(Pedido oPedido) {
        this.oPedido = oPedido;
    }

    public Venta getoVenta() {
        return oVenta;
    }

    public void setoVenta(Venta oVenta) {
        this.oVenta = oVenta;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "PedidoVenta{" + "oPedido=" + oPedido + ", oVenta=" + oVenta + ", detalle=" + detalle + ", importe=" + importe + '}';
    }
    
}
