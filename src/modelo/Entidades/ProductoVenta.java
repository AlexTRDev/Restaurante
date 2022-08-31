package modelo.Entidades;

/**
 *
 * @author ALEX
 */
public class ProductoVenta {

    private Producto oProducto;
    private Venta oVenta;
    private Double cantidad;
    private Double importe;

    public ProductoVenta() {
    }

    public ProductoVenta(Producto oProducto, Venta oVenta) {
        this.oProducto = oProducto;
        this.oVenta = oVenta;
    }

    public ProductoVenta(Producto oProducto, Venta oVenta, Double cantidad, Double importe) {
        this.oProducto = oProducto;
        this.oVenta = oVenta;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Producto getoProducto() {
        return oProducto;
    }

    public void setoProducto(Producto oProducto) {
        this.oProducto = oProducto;
    }

    public Venta getoVenta() {
        return oVenta;
    }

    public void setoVenta(Venta oVenta) {
        this.oVenta = oVenta;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ProductoVenta{" + "oProducto=" + oProducto + ", oVenta=" + oVenta + ", cantidad=" + cantidad + ", importe=" + importe + '}';
    }
    
}
