package modelo.Entidades;

/**
 *
 * @author ALEX
 */
public class TipoPago {
    private Integer codigo;
    private String nombre;
    private String descripcion;

    public TipoPago() {
    }

    public TipoPago(Integer codigo) {
        this.codigo = codigo;
    }

    public TipoPago(Integer codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "TipoPagos{" + "codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
}
