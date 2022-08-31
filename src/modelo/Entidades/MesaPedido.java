package modelo.Entidades;

/**
 *
 * @author ALEX
 */
public class MesaPedido {
    private Mesa oMesa;
    private Pedido oPedido;

    public MesaPedido() {
    }

    public MesaPedido(Mesa oMesa, Pedido oPedido) {
        this.oMesa = oMesa;
        this.oPedido = oPedido;
    }

    public Pedido getoPedido() {
        return oPedido;
    }

    public void setoPedido(Pedido oPedido) {
        this.oPedido = oPedido;
    }

    public Mesa getoMesa() {
        return oMesa;
    }

    public void setoMesa(Mesa oMesa) {
        this.oMesa = oMesa;
    }

    @Override
    public String toString() {
        return "Mesa_Pedido{" + "oMesa=" + oMesa + ", oPedido=" + oPedido + '}';
    }

}
