package modelo.Entidades;

/**
 *
 * @author ALEX
 */
public class ProveedorProducto {

    private Proveedor oProveedor;
    private Producto oProducto;
    private String fecha;
    private String detalle;

    public ProveedorProducto() {
    }

    public ProveedorProducto(Proveedor oProveedor, Producto oProducto) {
        this.oProveedor = oProveedor;
        this.oProducto = oProducto;
    }

    public ProveedorProducto(Proveedor oProveedor, Producto oProducto, String fecha, String detalle) {
        this.oProveedor = oProveedor;
        this.oProducto = oProducto;
        this.fecha = fecha;
        this.detalle = detalle;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Proveedor getoProveedor() {
        return oProveedor;
    }

    public void setoProveedor(Proveedor oProveedor) {
        this.oProveedor = oProveedor;
    }

    public Producto getoProducto() {
        return oProducto;
    }

    public void setoProducto(Producto oProducto) {
        this.oProducto = oProducto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "ProveedorProducto{" + "oProveedor=" + oProveedor + ", oProducto=" + oProducto + ", fecha=" + fecha + ", detalle=" + detalle + '}';
    }
    
}
