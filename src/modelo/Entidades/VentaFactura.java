package modelo.Entidades;

/**
 *
 * @author ALEX
 */
public class VentaFactura {

    private Venta oVenta;
    private Factura oFactura;
    private String detalle;
    private Double importe;

    public VentaFactura() {
    }

    public VentaFactura(Venta oVenta, Factura oFactura) {
        this.oVenta = oVenta;
        this.oFactura = oFactura;
    }

    public VentaFactura(Venta oVenta, Factura oFactura, String detalle, Double importe) {
        this.oVenta = oVenta;
        this.oFactura = oFactura;
        this.detalle = detalle;
        this.importe = importe;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Venta getoVenta() {
        return oVenta;
    }

    public void setoVenta(Venta oVenta) {
        this.oVenta = oVenta;
    }

    public Factura getoFactura() {
        return oFactura;
    }

    public void setoFactura(Factura oFactura) {
        this.oFactura = oFactura;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "VentaFactura{" + "oVenta=" + oVenta + ", oFactura=" + oFactura + ", detalle=" + detalle + ", importe=" + importe + '}';
    }
    
}
