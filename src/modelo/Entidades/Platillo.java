package modelo.Entidades;

/**
 *
 * @author ALEX
 */
public class Platillo {
    private Integer codigo;
    private String nombre;
    private Double precio;
    private String detalle;
    private String foto;

    public Platillo() {
    }

    public Platillo(Integer codigo) {
        this.codigo = codigo;
    }

    public Platillo(Integer codigo, String nombre, Double precio, String detalle, String foto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.detalle = detalle;
        this.foto = foto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Platillo{" + "codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", detalle=" + detalle + ", foto=" + foto + '}';
    }
    
}
