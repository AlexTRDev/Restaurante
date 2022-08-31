package modelo.Entidades;

/**
 *
 * @author ALEX
 */
public class Venta {

    private Integer codigo;
    private String fecha;
    private Double subTotal;
    private Double descuento;
    private Double montoFinal;
    private Caja oCaja;

    public Venta() {
    }

    public Venta(Integer codigo) {
        this.codigo = codigo;
    }

    public Venta(Integer codigo, String fecha, Double subTotal, Double descuento, Double montoFinal, Caja oCaja) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.subTotal = subTotal;
        this.descuento = descuento;
        this.montoFinal = montoFinal;
        this.oCaja = oCaja;
    }

    public Caja getoCaja() {
        return oCaja;
    }

    public void setoCaja(Caja oCaja) {
        this.oCaja = oCaja;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(Double montoFinal) {
        this.montoFinal = montoFinal;
    }

    @Override
    public String toString() {
        return "Venta{" + "codigo=" + codigo + ", fecha=" + fecha + ", subTotal=" + subTotal + ", descuento=" + descuento + ", montoFinal=" + montoFinal + ", oCaja=" + oCaja + '}';
    }
    
}
