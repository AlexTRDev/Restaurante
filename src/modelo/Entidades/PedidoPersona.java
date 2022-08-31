
package modelo.Entidades;

/**
 *
 * @author ALEX
 */
public class PedidoPersona {

    private Pedido oPedido;
    private Persona oPersona;

    public PedidoPersona() {
    }

    public PedidoPersona(Pedido oPedido, Persona oPersona) {
        this.oPedido = oPedido;
        this.oPersona = oPersona;
    }

    public Pedido getoPedido() {
        return oPedido;
    }

    public void setoPedido(Pedido oPedido) {
        this.oPedido = oPedido;
    }

    public Persona getoPersona() {
        return oPersona;
    }

    public void setoPersona(Persona oPersona) {
        this.oPersona = oPersona;
    }

    @Override
    public String toString() {
        return "PedidoPersona{" + "oPedido=" + oPedido + ", oPersona=" + oPersona + '}';
    }

}
