package modelo.Entidades;

/**
 *
 * @author ALEX
 */
public class ProveedorDireccion {
    
    private Proveedor oProveedor;
    private String calle;
    private String numero;
    private String ciudad;
    private String departamento;
    private String pais;

    public ProveedorDireccion() {
    }

    public ProveedorDireccion(Proveedor oProveedor) {
        this.oProveedor = oProveedor;
    }

    public ProveedorDireccion(Proveedor oProveedor, String calle, String numero, String ciudad, String departamento, String pais) {
        this.oProveedor = oProveedor;
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.pais = pais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Proveedor getoProveedor() {
        return oProveedor;
    }

    public void setoProveedor(Proveedor oProveedor) {
        this.oProveedor = oProveedor;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "ProveedorDireccion{" + "oProveedor=" + oProveedor + ", calle=" + calle + ", numero=" + numero + ", ciudad=" + ciudad + ", departamento=" + departamento + ", pais=" + pais + '}';
    }
    
}
