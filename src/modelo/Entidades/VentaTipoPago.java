package modelo.Entidades;

/**
 *
 * @author ALEX
 */
public class VentaTipoPago {
    
    private Venta oVenta;
    private TipoPago oTipoPago;

    public VentaTipoPago() {
    }

    public VentaTipoPago(Venta oVenta, TipoPago oTipoPago) {
        this.oVenta = oVenta;
        this.oTipoPago = oTipoPago;
    }

    public TipoPago getoTipoPago() {
        return oTipoPago;
    }

    public void setoTipoPago(TipoPago oTipoPago) {
        this.oTipoPago = oTipoPago;
    }

    public Venta getoVenta() {
        return oVenta;
    }

    public void setoVenta(Venta oVenta) {
        this.oVenta = oVenta;
    }

    @Override
    public String toString() {
        return "VentaTipoPago{" + "oVenta=" + oVenta + ", oTipoPago=" + oTipoPago + '}';
    }
    
}
