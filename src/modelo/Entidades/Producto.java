package modelo.Entidades;

/**
 *
 * @author ALEX
 */
public class Producto {
    
    private Integer codigoProducto;
    private String nombreProducto;
    private Double stockProducto;
    private String unidadMedidaProducto;
    private String contenidoProducto;
    private String monedaProducto;
    private Double precioUnitario;
    private Double precioMedida;
    private Double stockMinimo;
    private Double precioCompraProducto;
    private byte [] fotoProducto;
    private Categoria oCategoria;
//    private String tamañoProducto;
//    private String marcaProducto;
//    private String colorProducto;
//    private String pesoProducto;
//    private String cantidadProducto;
//    private String vencimientoProducto;
//    private String proveedorProducto;
    public enum medida{//1           2       3       4      5     6       7
        KILOGRAMOS, LITROS, GRAMOS, UNIDAD, CAJA, SOBRE, PAQUETE
    }
    public enum moneda{//1       2       3
        SOLES, DOLARES, EUROS
    }

    public Producto() {
    }

    public Producto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Producto(Categoria oCategoria) {
        this.oCategoria = oCategoria;
    }

    public Producto(Integer codigoProducto, String nombreProducto, Double stockProducto, String unidadMedidaProducto, String contenidoProducto, String monedaProducto, Double precioUnitario, Double precioMedida, Double precioVentaProducto, Double precioCompraProducto, byte[] fotoProducto, Categoria oCategoria) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.stockProducto = stockProducto;
        this.unidadMedidaProducto = unidadMedidaProducto;
        this.contenidoProducto = contenidoProducto;
        this.monedaProducto = monedaProducto;
        this.precioUnitario = precioUnitario;
        this.precioMedida = precioMedida;
        this.stockMinimo = precioVentaProducto;
        this.precioCompraProducto = precioCompraProducto;
        this.fotoProducto = fotoProducto;
        this.oCategoria = oCategoria;
    }
    
    public Double getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(Double stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public Integer getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(Double stockProducto) {
        this.stockProducto = stockProducto;
    }

    public String getUnidadMedidaProducto() {
        return unidadMedidaProducto;
    }

    public void setUnidadMedidaProducto(String unidadMedidaProducto) {
        this.unidadMedidaProducto = unidadMedidaProducto;
    }

    public String getContenidoProducto() {
        return contenidoProducto;
    }

    public void setContenidoProducto(String contenidoProducto) {
        this.contenidoProducto = contenidoProducto;
    }

    public String getMonedaProducto() {
        return monedaProducto;
    }

    public void setMonedaProducto(String monedaProducto) {
        this.monedaProducto = monedaProducto;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getPrecioMedida() {
        return precioMedida;
    }

    public void setPrecioMedida(Double precioMedida) {
        this.precioMedida = precioMedida;
    }

    public Double getPrecioCompraProducto() {
        return precioCompraProducto;
    }

    public void setPrecioCompraProducto(Double precioCompraProducto) {
        this.precioCompraProducto = precioCompraProducto;
    }

    public byte[] getFotoProducto() {
        return fotoProducto;
    }

    public void setFotoProducto(byte[] fotoProducto) {
        this.fotoProducto = fotoProducto;
    }

    public Categoria getoCategoria() {
        return oCategoria;
    }

    public void setoCategoria(Categoria oCategoria) {
        this.oCategoria = oCategoria;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigoProducto=" + codigoProducto + ", nombreProducto=" + nombreProducto + ", oCategoria=" + oCategoria + '}';
    }
}