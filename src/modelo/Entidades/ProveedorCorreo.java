package modelo.Entidades;

/**
 *
 * @author ALEX
 */
public class ProveedorCorreo {
    
    private Integer codigo;
    private Proveedor oProveedor;
    private String correo;

    public ProveedorCorreo() {
    }

    public ProveedorCorreo(Integer codigo) {
        this.codigo = codigo;
    }

    public ProveedorCorreo(Integer codigo, Proveedor oProveedor, String correo) {
        this.codigo = codigo;
        this.oProveedor = oProveedor;
        this.correo = correo;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "ProveedorCorreo{" + "codigo=" + codigo + ", oProveedor=" + oProveedor + ", correo=" + correo + '}';
    }
  
}
