package modelo.LogicaNegocio;

//import controlador.util.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Date;
import modelo.Entidades.*;

/**
 *
 * @author ALEX
 */
public class TestLN {

    public static void main(String[] args) {
//        CajaLN oCajaLN = new CajaLN();
//        CategoriaLN oCategoriaLN = new CategoriaLN();
//        FacturaLN oFacturaLN = new FacturaLN();
//        MesaLN oMesaLN = new MesaLN();
//        MesaPedidoLN oMesaPedidoLN = new MesaPedidoLN();
//        PedidoLN oPedidoLN = new PedidoLN();
//        PedidoPersonaLN oPedidoPersonaLN = new PedidoPersonaLN();
//        PedidoVentaLN oPedidoVentaLN = new PedidoVentaLN();
//        PersonaCelularLN oPersonaCelularLN = new PersonaCelularLN();
//        PersonaCorreoLN oPersonaCorreoLN = new PersonaCorreoLN();
//        PersonaDireccionLN oPersonaDireccionLN = new PersonaDireccionLN();
//        PersonaLN oPersonaLN = new PersonaLN();
//        PersonaReservacionLN oPersonaReservacionLN = new PersonaReservacionLN();
//        PlatilloLN oPlatilloLN = new PlatilloLN();
//        PlatilloPedidoLN oPlatilloPedidoLN = new PlatilloPedidoLN();
        ProductoLN oProductoLN = new ProductoLN();
//        ProductoVentaLN oProductoVentaLN = new ProductoVentaLN();
//        ProveedorCelularLN oProveedorCelularLN = new ProveedorCelularLN();
//        ProveedorCorreoLN oProveedorCorreoLN = new ProveedorCorreoLN();
//        ProveedorDireccionLN oProveedorDireccionLN = new ProveedorDireccionLN();
//        Proveedor oProveedor = new Proveedor();
//        ProveedorProductoLN oProveedorProductoLN = new ProveedorProductoLN();
//        TipoPagoLN oTipoPagoLN = new TipoPagoLN();
//        TipoUsuarioLN oTipoUsuarioLN = new TipoUsuarioLN();
//        UsuarioLN oUsuarioLN = new UsuarioLN();
//        VentaLN oVentaLN = new VentaLN();
//        VentaFacturaLN oVentaFacturaLN = new VentaFacturaLN();
//        VentaTipoPagoLN oVentaTipoPagoLN = new VentaTipoPagoLN();
        

// TIPO PAGO
//        oTipoPagoLN.eliminar(new TipoPago(5));
//        oTipoPagoLN.insertar(new TipoPago(0, "TARJETA DE CREDITO", "BCP - BBVA - INTERBANK"));
//        oTipoPagoLN.insertar(new TipoPago(0, "TARJETA DE DEBITO", "BCP - BBVA - INTERBANK - BANCO DE LA NACION"));
//        oTipoPagoLN.actualizar(new TipoPago(4, "TRANSFERENCIA", "PLIN - YAPE - LUKITA - TRANSFERENCIA BN"));
//        System.out.println(oTipoPagoLN.listar());
//        System.out.println(oTipoPagoLN.getObjeto(new TipoPago(4)));
//        
        
//        CAJA
//        Usuario oUsuario = new Usuario(new Persona("47065040"), new TipoUsuario(2));

//        oCajaLN.insertar(new Caja(0, 350.50, 0.00, Boolean.TRUE, "2022-02-09 18:11:30", "2022-02-09 18:11:30", oUsuario.getoPersona().getDni() + ", " +oUsuario.getoTipoUsuarios().getCodigo(), oUsuario));
//        oCajaLN.actualizar(new Caja(1, 350.50, 850.90, Boolean.FALSE, "2022-02-08 18:11:30", "2022-02-08 22:01:23", oUsuario.getoPersona().getDni() + ", " +oUsuario.getoTipoUsuarios().getCodigo(), oUsuario));
//        oCajaLN.actualizar(new Caja(1, 350.50, 850.90, Boolean.FALSE, "2022-02-08 18:11:30", "2022-02-08 22:01:23", oUsuario.getoPersona().getDni() + ", " +oUsuario.getoTipoUsuarios().getCodigo(), oUsuario));
//        System.out.println(oCajaLN.listar());
//        System.out.println(oCajaLN.getObjeto(new Caja(2)));

//Categoria
//        oCategoriaLN.insertar(new Categoria(0, "GOLOSINAS", "GALLETAS, CARAMELOS, CHUPETINES, ETC"));
//        oCategoriaLN.actualizar(new Categoria(3, "JUGOS", "PIÑA, DURAZNO, FRESA, ETC"));
//        oCategoriaLN.eliminar(new Categoria(4));
//        System.out.println(oCategoriaLN.listar());
//        System.out.println(oCategoriaLN.getObjeto(new Categoria(2)));

//FACTURA
//        oFacturaLN.insertar(new Factura(0, "NULL", "002", 0.00, "22-02-07 14:12:56", Factura.tipoFactura.BOLETA.toString()));
//        oFacturaLN.eliminar(new Factura(3, "002", "NULL", 0.18, "22-02-09 13:12:56", Factura.tipoFactura.BOLETA.toString()));
//        System.out.println(oFacturaLN.listar());
//        System.out.println(oFacturaLN.getObjeto(new Factura(3)));

//MESA
//        oMesaLN.eliminar(new Mesa(3));
//        System.out.println(oMesaLN.listar());
//        System.out.println(oMesaLN.getObjeto(new Mesa(2)));

// PEDIDO
//        System.out.println(oPedidoLN.listar());
//        System.out.println(oPedidoLN.getObjeto(new Pedido(2)));
//        oPedidoLN.eliminar(new Pedido(6, "22-02-09 13:12:56", "platillo 5,platillo 2", Pedido.tipo.DELIVERY.toString(), "GARCILAZO DE LA VEGA #664"));    
//MESA_PEDIDO
//        oMesaPedidoLN.actualizar(new MesaPedido(new Mesa(2), new Pedido(5)));
//        oMesaPedidoLN.insertar(new MesaPedido(new Mesa(2), new Pedido(5)));
//        System.out.println(oMesaPedidoLN.getObjeto(new MesaPedido(new Mesa(2), new Pedido(1))));

//PEDIDO_PERSONA
//        oPedidoPersonaLN.insertar(new PedidoPersona(new Pedido(1), new Persona("20202020")));
//        oPedidoPersonaLN.eliminar(new PedidoPersona(new Pedido(2), new Persona("30303030")));
//VENTA
//        oVentaLN.actualizar(new Venta(1, "22-01-09 13:12:56", 15.60, 0.00, 15.60, new Caja(1)));

//PEDIDO_VENTA
//        oPedidoVentaLN.actualizar(new PedidoVenta(new Pedido(1), new Venta(1), "PLATILLO1=5.00, PLATILLO2=5.00,PLATILLO3=5.60", 15.60));
//        System.out.println(oPedidoVentaLN.getObjeto(new PedidoVenta(new Pedido(1), new Venta(1))));

//        System.out.println(oProductoLN.listarPorCategoria(new Categoria(2)));

        Producto oProducto= new Producto();
        
        oProducto.setCodigoProducto(1);
        oProducto.setNombreProducto("PRODUCTOX");
        oProducto.setStockProducto(10.00);
        oProducto.setUnidadMedidaProducto(Producto.medida.CAJA.toString());
        oProducto.setContenidoProducto("contenido");
        oProducto.setMonedaProducto(Producto.moneda.SOLES.toString());
        oProducto.setPrecioUnitario(10.00);
        oProducto.setPrecioMedida(10.00);
        oProducto.setPrecioCompraProducto(10.00);
        oProducto.setStockMinimo(10.00);
        oProducto.setFotoProducto(Util.Imagen.getImagen("D:\\TamyDevJava\\Restaurante\\src\\img\\pilsen.jpg"));
        oProducto.setoCategoria(new Categoria(2));
        
        oProductoLN.actualizar(oProducto);
        
    }
    


 }
