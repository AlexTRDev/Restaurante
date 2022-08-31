package modelo.vista;

import controlador.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.Entidades.*;

/**
 *
 * @author ALEX
 */
public class MantenimientoProducto extends javax.swing.JDialog {

    private boolean isNuevo;
    private String url;
    private Producto oProducto;
    private final ProductoCONTROL oProductoCONTROL;

    public MantenimientoProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        oProductoCONTROL = new ProductoCONTROL();
        cargarComboCategoria();
    }

    public boolean isIsNuevo() {
        return isNuevo;
    }

    public void setIsNuevo(boolean isNuevo) {
        this.isNuevo = isNuevo;
    }

    public Producto getoProducto() {
        return oProducto;
    }

    public void setoProducto(Producto oProducto) {
        this.oProducto = oProducto;
    }

    public void llenarCampos() {
        cbxCategoria.setSelectedItem(oProducto.getoCategoria()); //---> Falta crear el combo box con las categorias
        rbtnSoles.setSelected(true);
        rbtnUnidad.setSelected(true);
        if (!isNuevo) {
            txtNombre.setText(oProducto.getNombreProducto());
            txtPrecioCompra.setText(oProducto.getPrecioCompraProducto().toString());
            txtPrecioMedida.setText(oProducto.getPrecioMedida().toString());
            txtPrecioUnitario.setText(oProducto.getPrecioUnitario().toString());
            txtStock.setText(oProducto.getStockProducto().toString());
            txtStockMinimo.setText(oProducto.getStockMinimo().toString());
            txtAreaContenido.setText(oProducto.getContenidoProducto());

            switch (oProducto.getMonedaProducto()) {
                case "SOLES":
                    rbtnSoles.setSelected(true);
                    break;
                case "DOLARES":
                    rbtnDolares.setSelected(true);
                    break;
                case "EUROS":
                    rbtnEuros.setSelected(true);
                    break;
                default:
                    break;
            }

            switch (oProducto.getUnidadMedidaProducto()) {
                case "KILOGRAMOS":
                    rbtnKilogramo.setSelected(true);
                    break;
                case "LITROS":
                    rbtnLitro.setSelected(true);
                    break;
                case "UNIDAD":
                    rbtnUnidad.setSelected(true);
                    break;
                case "CAJA":
                    rbtnCaja.setSelected(true);
                    break;
                case "PAQUETE":
                    rbtnPaquete.setSelected(true);
                    break;
                default:
                    break;
            }

            try {
                byte[] imagenBD = oProducto.getFotoProducto();
                BufferedImage oBufferedImage = null;
                InputStream oInputStream = new ByteArrayInputStream(imagenBD);
                oBufferedImage = ImageIO.read(oInputStream);
                ImageIcon miIcono = new ImageIcon(oBufferedImage.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), 0));
                lblImagen.setIcon(miIcono);
            } catch (IOException ex) {
                Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public final void cargarComboCategoria() {
        DefaultComboBoxModel items = new CategoriaCONTROL().cargarComboBox();
        cbxCategoria.setModel(items);
    }

    public void rutaImagen() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            url = chooser.getSelectedFile().toString();
            colocarImagen(url);
        }
    }

    public void colocarImagen(String url) {
        try {
            byte[] imagenBD = Util.Imagen.getImagen(url);
            BufferedImage oBufferedImage = null;
            InputStream oInputStream = new ByteArrayInputStream(imagenBD);
            oBufferedImage = ImageIO.read(oInputStream);
            ImageIcon miIcono = new ImageIcon(oBufferedImage.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), 0));
            lblImagen.setIcon(miIcono);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardar() {
        Producto obj = new Producto();
            obj.setContenidoProducto(txtAreaContenido.getText());
            obj.setNombreProducto(txtNombre.getText());
            obj.setPrecioCompraProducto(Double.parseDouble(txtPrecioCompra.getText()));
            obj.setPrecioMedida(Double.parseDouble(txtPrecioMedida.getText()));
            obj.setPrecioUnitario(Double.parseDouble(txtPrecioUnitario.getText()));
            obj.setStockMinimo(Double.parseDouble(txtStockMinimo.getText()));
            obj.setStockProducto(Double.parseDouble(txtStock.getText()));
            obj.setoCategoria((Categoria) cbxCategoria.getSelectedItem());

            if (rbtnDolares.isSelected()) {
                obj.setMonedaProducto("DOLARES");
            } else if (rbtnEuros.isSelected()) {
                obj.setMonedaProducto("EUROS");
            } else {
                obj.setMonedaProducto("SOLES");
            }

            if (rbtnCaja.isSelected()) {
                obj.setUnidadMedidaProducto("CAJA");
            } else if (rbtnKilogramo.isSelected()) {
                obj.setUnidadMedidaProducto("KILOGRAMOS");
            } else if (rbtnLitro.isSelected()) {
                obj.setUnidadMedidaProducto("LITROS");
            } else if (rbtnPaquete.isSelected()) {
                obj.setUnidadMedidaProducto("PAQUETE");
            } else {
                obj.setUnidadMedidaProducto("UNIDAD");
            }
            obj.setFotoProducto(Util.Imagen.getImagen(url));
            
        if (isNuevo) {
            oProductoCONTROL.Insertar(obj);

        } else {
            obj.setCodigoProducto(oProducto.getCodigoProducto());
            oProductoCONTROL.Actualizar(obj);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupoMedida = new javax.swing.ButtonGroup();
        btnGrupoMoneda = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPrecioUnitario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPrecioMedida = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPrecioCompra = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtStockMinimo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        rbtnUnidad = new javax.swing.JRadioButton();
        rbtnCaja = new javax.swing.JRadioButton();
        rbtnPaquete = new javax.swing.JRadioButton();
        rbtnKilogramo = new javax.swing.JRadioButton();
        rbtnLitro = new javax.swing.JRadioButton();
        rbtnSoles = new javax.swing.JRadioButton();
        rbtnDolares = new javax.swing.JRadioButton();
        rbtnEuros = new javax.swing.JRadioButton();
        cbxCategoria = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaContenido = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        lblGuardar = new javax.swing.JLabel();
        lblCancelar = new javax.swing.JLabel();
        btnBuscarImagen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setText("CATEGORIA");

        jLabel2.setText("NOMBRE");

        jLabel3.setText("MONEDA");

        jLabel4.setText("PRECIO UNITARIO");

        txtPrecioUnitario.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPrecioUnitario.setText("0.00");

        jLabel5.setText("PRECIO MEDIDA");

        txtPrecioMedida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPrecioMedida.setText("0.00");

        jLabel6.setText("PRECIO COMPRA");

        txtPrecioCompra.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPrecioCompra.setText("0.00");

        jLabel7.setText("STOCK");

        txtStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtStock.setText("0.00");

        jLabel8.setText("STOCK MINIMO");

        txtStockMinimo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtStockMinimo.setText("0.00");

        jLabel9.setText("UNIDAD DE MEDIDA");

        btnGrupoMedida.add(rbtnUnidad);
        rbtnUnidad.setText("Unidad");

        btnGrupoMedida.add(rbtnCaja);
        rbtnCaja.setText("Caja");

        btnGrupoMedida.add(rbtnPaquete);
        rbtnPaquete.setText("Paquete");

        btnGrupoMedida.add(rbtnKilogramo);
        rbtnKilogramo.setText("Kg");

        btnGrupoMedida.add(rbtnLitro);
        rbtnLitro.setText("Ltrs.");

        btnGrupoMoneda.add(rbtnSoles);
        rbtnSoles.setText("S/.");

        btnGrupoMoneda.add(rbtnDolares);
        rbtnDolares.setText("$.");

        btnGrupoMoneda.add(rbtnEuros);
        rbtnEuros.setText("€.");

        cbxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStockMinimo)
                            .addComponent(txtStock)
                            .addComponent(txtPrecioCompra)
                            .addComponent(txtPrecioMedida)
                            .addComponent(txtPrecioUnitario)
                            .addComponent(txtNombre)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rbtnSoles, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnDolares, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnEuros, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rbtnUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnCaja)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnPaquete)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnKilogramo)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnLitro)))
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnUnidad)
                    .addComponent(rbtnCaja)
                    .addComponent(rbtnPaquete)
                    .addComponent(rbtnKilogramo)
                    .addComponent(rbtnLitro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnSoles)
                    .addComponent(rbtnDolares)
                    .addComponent(rbtnEuros))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPrecioMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtStockMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("IMAGEN"));

        lblImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel12.setText("CONTENIDO");

        txtAreaContenido.setColumns(20);
        txtAreaContenido.setRows(5);
        jScrollPane2.setViewportView(txtAreaContenido);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 40, 15));

        lblGuardar.setText("GUARDAR");
        lblGuardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGuardarMouseClicked(evt);
            }
        });
        jPanel5.add(lblGuardar);

        lblCancelar.setText("CANCELAR");
        lblCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCancelarMouseClicked(evt);
            }
        });
        jPanel5.add(lblCancelar);

        btnBuscarImagen.setText("Buscar imagen");
        btnBuscarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarImagenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnBuscarImagen))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBuscarImagen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarImagenActionPerformed
        rutaImagen();
//        colocarImagen(url);
    }//GEN-LAST:event_btnBuscarImagenActionPerformed

    private void lblCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblCancelarMouseClicked

    private void lblGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuardarMouseClicked
        guardar();
        this.dispose();
    }//GEN-LAST:event_lblGuardarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarImagen;
    private javax.swing.ButtonGroup btnGrupoMedida;
    private javax.swing.ButtonGroup btnGrupoMoneda;
    private javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCancelar;
    private javax.swing.JLabel lblGuardar;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JRadioButton rbtnCaja;
    private javax.swing.JRadioButton rbtnDolares;
    private javax.swing.JRadioButton rbtnEuros;
    private javax.swing.JRadioButton rbtnKilogramo;
    private javax.swing.JRadioButton rbtnLitro;
    private javax.swing.JRadioButton rbtnPaquete;
    private javax.swing.JRadioButton rbtnSoles;
    private javax.swing.JRadioButton rbtnUnidad;
    private javax.swing.JTextArea txtAreaContenido;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioCompra;
    private javax.swing.JTextField txtPrecioMedida;
    private javax.swing.JTextField txtPrecioUnitario;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtStockMinimo;
    // End of variables declaration//GEN-END:variables

}
