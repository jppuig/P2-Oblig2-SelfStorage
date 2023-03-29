// Juan Pedro Puig - 281088
// Nicolás Valsecchi - 192765

package interfaz;

import dominio.Sistema;
import dominio.ArchivoLectura;
import dominio.Contrato;
import dominio.Deposito;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

public class VentanaInicio extends javax.swing.JFrame {
    //Atributos
    private Sistema modelo;
    
    //Constructor
    public VentanaInicio(Sistema unSistema) {
        modelo = unSistema;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonIniciar0 = new javax.swing.JButton();
        jButtonContinuarAnterior = new javax.swing.JButton();
        jButtonLeerDatosArchivo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Auto-almacenamiento");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Bienvenido al programa de auto-almacenamiento");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("¿Cómo desea iniciar el programa?");

        jButtonIniciar0.setText("Iniciar un programa nuevo");
        jButtonIniciar0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciar0ActionPerformed(evt);
            }
        });

        jButtonContinuarAnterior.setText("Continuar el programa que cerró anteriormente");
        jButtonContinuarAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonContinuarAnteriorActionPerformed(evt);
            }
        });

        jButtonLeerDatosArchivo.setText("Iniciar un programa nuevo a partir de datos de un archivo");
        jButtonLeerDatosArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLeerDatosArchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel2)))
                .addContainerGap(92, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonLeerDatosArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                    .addComponent(jButtonContinuarAnterior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonIniciar0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addComponent(jButtonIniciar0)
                .addGap(18, 18, 18)
                .addComponent(jButtonContinuarAnterior)
                .addGap(18, 18, 18)
                .addComponent(jButtonLeerDatosArchivo)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Boton para iniciar un programa nuevo
    private void jButtonIniciar0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciar0ActionPerformed
        VentanaMenu ventana = new VentanaMenu(modelo);
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonIniciar0ActionPerformed

    
    //Boton para continuar con el programa anterior
    private void jButtonContinuarAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonContinuarAnteriorActionPerformed
        modelo = modelo.cargarSistema();
        if (!modelo.getCargo()) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar el programa anterior con éxito. Se inició un nuevo programa.", "Error", JOptionPane.WARNING_MESSAGE);
            modelo.setCargo(true);
        } else {
            int largo = modelo.getListaContratos().size();
            if (largo != 0) {
                int id = modelo.getListaContratos().get(largo-1).getIdContrato()+1;
                Contrato.setIdContratosTotal(id);
            }
            
        }
        
        VentanaMenu ventana = new VentanaMenu(modelo);
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonContinuarAnteriorActionPerformed

    //Boton para leer datos de un archivo
    private void jButtonLeerDatosArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLeerDatosArchivoActionPerformed
        //https://mkyong.com/swing/java-swing-jfilechooser-example/
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Elegir el archivo para iniciar el programa:");

        int returnValue = jfc.showDialog(null, "Abrir archivo");
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            ArchivoLectura arch = new ArchivoLectura(jfc.getSelectedFile().getPath());
            boolean hay = arch.hayMasLineas();
            if (!hay) {
                JOptionPane.showMessageDialog(this, "El archivo no contiene ninguna línea.\nElija otro archivo u otra opción del menú.", "Archivo vacío", JOptionPane.WARNING_MESSAGE);
            } else {
                while (hay) {
                    String[] prop = arch.linea().split("#");
                    boolean conEstantes = prop[2].equals("S");
                    boolean refrigerado = prop[3].equals("S");
                    Deposito d = new Deposito(Integer.parseInt(prop[0]), Integer.parseInt(prop[1]), conEstantes, refrigerado);
                    modelo.agregarDeposito(d);
                    hay = arch.hayMasLineas();
                }

                arch.cerrar();
                VentanaMenu ventana = new VentanaMenu(modelo);
                ventana.setVisible(true);
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_jButtonLeerDatosArchivoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonContinuarAnterior;
    private javax.swing.JButton jButtonIniciar0;
    private javax.swing.JButton jButtonLeerDatosArchivo;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
