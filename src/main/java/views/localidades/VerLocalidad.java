package views.localidades;

import infrastructure.unsplashImages.ImageService;
import models.Localidad;

@SuppressWarnings("serial")
public final class VerLocalidad extends javax.swing.JDialog {

    private final Localidad localidad;

    public VerLocalidad(java.awt.Frame parent, Localidad localidad) {
        super(parent, true);
        initComponents();

        this.localidad = localidad;
        ImageService.setImage(localidad.getNombre(), imagePane);

        id.setText("#" + String.valueOf(localidad.getId()));
        nombre.setText(localidad.getNombre());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagePane = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        id = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalles de la localidad");
        setModal(true);
        setResizable(false);
        setSize(new java.awt.Dimension(400, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imagePane.setBackground(new java.awt.Color(102, 102, 102));
        imagePane.setPreferredSize(new java.awt.Dimension(400, 300));
        imagePane.setLayout(new java.awt.CardLayout());
        getContentPane().add(imagePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 200));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        id.setFont(new java.awt.Font("Lato Light", 0, 14)); // NOI18N
        id.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 30));

        nombre.setFont(new java.awt.Font("Lato Heavy", 1, 35)); // NOI18N
        nombre.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 380, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel id;
    private javax.swing.JPanel imagePane;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nombre;
    // End of variables declaration//GEN-END:variables
}
