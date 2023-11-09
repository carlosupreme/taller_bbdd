package views.localidades;

import exceptions.ValidationModelException;
import java.sql.SQLException;
import models.Localidad;
import models.Municipio;
import models.Validator;
import repositories.LocalidadRepository;
import views.MessageHandler;
import views.RealTimeValidator;
import views.ValidationRule;

@SuppressWarnings("serial")
public class CrearLocalidad extends javax.swing.JDialog {

    private final LocalidadRepository localidadRepository;
    private final Localidades parent;
    private final Municipio municipio;

    public CrearLocalidad(java.awt.Frame parent, LocalidadRepository localidadRepository, Municipio municipio) {
        super(parent, true);
        initComponents();
        this.parent = (Localidades) parent;
        this.localidadRepository = localidadRepository;
        this.municipio = municipio;
        agregarBtn.setEnabled(false);
        this.tituloLbl.setText("Crear localidad de " + municipio.getNombre());

        RealTimeValidator.addValidation(idTextField, new ValidationRule(this::esIdValido, idError));
        RealTimeValidator.addValidation(nombreTextField, new ValidationRule(Validator::esNombreValido, nombreError));
    }

    private boolean esIdValido(String id) throws ValidationModelException {
        try {
            Validator.esIdValido(Long.parseLong(id));
        } catch (ValidationModelException ex) {
            throw ex;
        } catch (NumberFormatException ex) {
            throw new ValidationModelException("El id debe ser un numero entero positivo");
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        nombrePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        idError = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        nombrePanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        nombreError = new javax.swing.JLabel();
        nombreTextField = new javax.swing.JTextField();
        tituloLbl = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        cancelarBtn1 = new javax.swing.JButton();
        agregarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar proveedor");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));
        jPanel2.setPreferredSize(new java.awt.Dimension(700, 500));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombrePanel.setBackground(new java.awt.Color(254, 254, 254));
        nombrePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Id");
        jLabel2.setPreferredSize(new java.awt.Dimension(250, 16));
        nombrePanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        idError.setBackground(new java.awt.Color(254, 254, 254));
        idError.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        idError.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        idError.setOpaque(true);
        nombrePanel.add(idError, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 400, 20));

        idTextField.setToolTipText("");
        idTextField.setActionCommand("<Not Set>");
        idTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        idTextField.setMargin(new java.awt.Insets(2, 10, 2, 6));
        idTextField.setOpaque(true);
        idTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idTextFieldKeyTyped(evt);
            }
        });
        nombrePanel.add(idTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 400, 40));

        nombrePanel1.setBackground(new java.awt.Color(254, 254, 254));
        nombrePanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nombre");
        jLabel3.setPreferredSize(new java.awt.Dimension(250, 16));
        nombrePanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        nombreError.setBackground(new java.awt.Color(254, 254, 254));
        nombreError.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        nombreError.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        nombreError.setOpaque(true);
        nombrePanel1.add(nombreError, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 400, 20));

        nombreTextField.setToolTipText("");
        nombreTextField.setActionCommand("<Not Set>");
        nombreTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        nombreTextField.setMargin(new java.awt.Insets(2, 10, 2, 6));
        nombreTextField.setOpaque(true);
        nombreTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreTextFieldKeyTyped(evt);
            }
        });
        nombrePanel1.add(nombreTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 400, 40));

        nombrePanel.add(nombrePanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 106, 520, -1));

        jPanel2.add(nombrePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 106, 550, -1));

        tituloLbl.setFont(new java.awt.Font("Lato Heavy", 1, 18)); // NOI18N
        tituloLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloLbl.setText("Crear Localidad de ");
        tituloLbl.setPreferredSize(new java.awt.Dimension(700, 40));
        jPanel2.add(tituloLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 550, 70));

        jPanel6.setBackground(new java.awt.Color(254, 254, 254));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cancelarBtn1.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        cancelarBtn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelarBtn1.setForeground(new java.awt.Color(255, 255, 255));
        cancelarBtn1.setText("Cancelar");
        cancelarBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelarBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtn1ActionPerformed(evt);
            }
        });
        jPanel6.add(cancelarBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 120, 30));

        agregarBtn.setBackground(new java.awt.Color(129, 140, 248));
        agregarBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        agregarBtn.setForeground(new java.awt.Color(255, 255, 255));
        agregarBtn.setText("Agregar");
        agregarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        agregarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBtnActionPerformed(evt);
            }
        });
        jPanel6.add(agregarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 140, 30));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 550, 80));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void agregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBtnActionPerformed
        try {
            localidadRepository.save(new Localidad(municipio.getIdEntidad(), municipio.getId(), Long.parseLong(idTextField.getText().trim()), nombreTextField.getText().trim()));

            dispose();
            parent.loadEntries();
            MessageHandler.showSuccessMessage("Localidad creada", null);
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062) {
                MessageHandler.showErrorMessage("El <id> ya está registrado, intenta con otro");
                idTextField.selectAll();
                idTextField.requestFocus();
            }
        } catch (ValidationModelException ex) {
            MessageHandler.showErrorMessage(ex.getMessage());
        }
    }//GEN-LAST:event_agregarBtnActionPerformed

    private void cancelarBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtn1ActionPerformed
        dispose();
    }//GEN-LAST:event_cancelarBtn1ActionPerformed

    private void idTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idTextFieldKeyTyped
        if (!agregarBtn.isEnabled()) {
            agregarBtn.setEnabled(true);
        }
    }//GEN-LAST:event_idTextFieldKeyTyped

    private void nombreTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreTextFieldKeyTyped
        if (!agregarBtn.isEnabled()) {
            agregarBtn.setEnabled(true);
        }
    }//GEN-LAST:event_nombreTextFieldKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBtn;
    private javax.swing.JButton cancelarBtn1;
    private javax.swing.JLabel idError;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel nombreError;
    private javax.swing.JPanel nombrePanel;
    private javax.swing.JPanel nombrePanel1;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JLabel tituloLbl;
    // End of variables declaration//GEN-END:variables
}
