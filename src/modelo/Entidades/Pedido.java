package modelo.Entidades;

/**
 *
 * @author ALEX
 */
public class Pedido {
    private Integer codigo;
    private String fechaHora;
    private String detalle;
    private String tipoPedido;
    private String direccionDelivery;
    public enum tipo{MOSTRADOR, MESA, DELIVERY}

    public Pedido() {
    }
    
    public Pedido(Integer codigo) {
        this.codigo = codigo;
    }

    public Pedido(Integer codigo, String fechaHora, String detalle, String tipoPedido, String direccionDelivery) {
        this.codigo = codigo;
        this.fechaHora = fechaHora;
        this.detalle = detalle;
        this.tipoPedido = tipoPedido;
        this.direccionDelivery = direccionDelivery;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fechaHora;
    }

    public void setFecha(String fecha) {
        this.fechaHora = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }
    
    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getDireccionDelivery() {
        return direccionDelivery;
    }

    public void setDireccionDelivery(String direccionDelivery) {
        this.direccionDelivery = direccionDelivery;
    }

    @Override
    public String toString() {
        return "Pedido{" + "codigo=" + codigo + ", fechaHora=" + fechaHora + ", detalle=" + detalle + ", tipoPedido=" + tipoPedido + ", direccionDelivery=" + direccionDelivery + '}';
    }

}
