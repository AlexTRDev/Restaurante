
package modelo.Entidades;

/**
 *
 * @author ALEX
 */
public class ProveedorCelular {
     
    private Integer codigo;
    private Proveedor oProveedor;
    private String celular;

    public ProveedorCelular() {
    }

    public ProveedorCelular(Integer codigo) {
        this.codigo = codigo;
    }

    public ProveedorCelular(Integer codigo, Proveedor oProveedor, String celular) {
        this.codigo = codigo;
        this.oProveedor = oProveedor;
        this.celular = celular;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Proveedor getoProveedor() {
        return oProveedor;
    }

    public void setoProveedor(Proveedor oProveedor) {
        this.oProveedor = oProveedor;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "ProveedorCelular{" + "codigo=" + codigo + ", oProveedor=" + oProveedor + ", celular=" + celular + '}';
    }
    
}
