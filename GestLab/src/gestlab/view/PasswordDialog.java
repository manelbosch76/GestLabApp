
package gestlab.view;

import gestlab.model.Usuario;
import gestlab.restfulclient.UsuarioClientSsl;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 * Classe que gestiona la finestra d'entrada/modificació de dades d'una empresa
 * @author manel bosch
 */
public class PasswordDialog extends javax.swing.JDialog {
    
    Usuario usuario;
    private UsuarioClientSsl uClient;

    /**
     * Crea un nou formulari per canviar el password
     * @author manel bosch
     * @param parent finestra mare
     * @param modal manté el focus fins a tancar la finestra
     * @param usuario Usuario a modificar-li el password
     */
    public PasswordDialog(java.awt.Frame parent, boolean modal, Usuario usuario) {
        super(parent, modal);
        initComponents();
        this.usuario = usuario;
        openClient();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitol = new javax.swing.JLabel();
        jPanelDadesEmpresa = new javax.swing.JPanel();
        jLabelPasswdOld = new javax.swing.JLabel();
        jLabelPasswdNew = new javax.swing.JLabel();
        jLabelPasswdNew2 = new javax.swing.JLabel();
        jPasswordFieldOld = new javax.swing.JPasswordField();
        jPasswordFieldNew = new javax.swing.JPasswordField();
        jPasswordFieldNew2 = new javax.swing.JPasswordField();
        jPanelBotons = new javax.swing.JPanel();
        jButtonSave = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabelTitol.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabelTitol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitol.setText("GestLab: Contrasenya");

        jLabelPasswdOld.setText("Password antic:");

        jLabelPasswdNew.setText("Password nou:");

        jLabelPasswdNew2.setText("Repetir password nou:");

        jPasswordFieldOld.setText("jPasswordField1");

        jPasswordFieldNew.setText("jPasswordField1");

        jPasswordFieldNew2.setText("jPasswordField1");

        javax.swing.GroupLayout jPanelDadesEmpresaLayout = new javax.swing.GroupLayout(jPanelDadesEmpresa);
        jPanelDadesEmpresa.setLayout(jPanelDadesEmpresaLayout);
        jPanelDadesEmpresaLayout.setHorizontalGroup(
            jPanelDadesEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadesEmpresaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadesEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadesEmpresaLayout.createSequentialGroup()
                        .addComponent(jLabelPasswdNew2)
                        .addGap(18, 18, 18)
                        .addComponent(jPasswordFieldNew2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDadesEmpresaLayout.createSequentialGroup()
                        .addGroup(jPanelDadesEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPasswdOld)
                            .addComponent(jLabelPasswdNew))
                        .addGap(65, 65, 65)
                        .addGroup(jPanelDadesEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordFieldNew, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordFieldOld, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanelDadesEmpresaLayout.setVerticalGroup(
            jPanelDadesEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadesEmpresaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadesEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPasswdOld)
                    .addComponent(jPasswordFieldOld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadesEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPasswdNew)
                    .addComponent(jPasswordFieldNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadesEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPasswdNew2)
                    .addComponent(jPasswordFieldNew2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jButtonSave.setText("Guardar");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonClear.setText("Netejar");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel·lar");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotonsLayout = new javax.swing.GroupLayout(jPanelBotons);
        jPanelBotons.setLayout(jPanelBotonsLayout);
        jPanelBotonsLayout.setHorizontalGroup(
            jPanelBotonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonClear)
                .addGap(61, 61, 61)
                .addComponent(jButtonCancel)
                .addContainerGap())
        );

        jPanelBotonsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonCancel, jButtonClear, jButtonSave});

        jPanelBotonsLayout.setVerticalGroup(
            jPanelBotonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelBotonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonClear)
                    .addComponent(jButtonCancel)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelBotons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelDadesEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitol)
                .addGap(18, 18, 18)
                .addComponent(jPanelDadesEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelBotons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Mètode per guardar les noves dades
     * @param evt Event que es produeix en prémer el botó
     */
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        if(checkPasswd()){
            usuario.setContrasena(String.valueOf(jPasswordFieldNew.getPassword()));
            uClient.edit_JSON(usuario, usuario.getId());
            uClient.close();
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null,"Contrassenyes errònies","Alert !!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    /**
     * Mètode per netejar les dades introduides
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        jPasswordFieldOld.setText("");
        jPasswordFieldNew.setText("");
        jPasswordFieldNew2.setText("");
    }//GEN-LAST:event_jButtonClearActionPerformed

    /**
     * Mètode per cancelar l'entrada de dades i per tant tancar el programa
     * @author manel bosch
     * @param evt Event que representa prémer el botó
     */
    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        uClient.close();
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLabelPasswdNew;
    private javax.swing.JLabel jLabelPasswdNew2;
    private javax.swing.JLabel jLabelPasswdOld;
    private javax.swing.JLabel jLabelTitol;
    private javax.swing.JPanel jPanelBotons;
    private javax.swing.JPanel jPanelDadesEmpresa;
    private javax.swing.JPasswordField jPasswordFieldNew;
    private javax.swing.JPasswordField jPasswordFieldNew2;
    private javax.swing.JPasswordField jPasswordFieldOld;
    // End of variables declaration//GEN-END:variables

    /**
     * Mètode per inicialitzar el UsuarioClient que accedirà al servei RESTful
     * @author manel bosch
     */
    private void openClient(){
        uClient = new UsuarioClientSsl(usuario.getToken());
    }
  
    /**
     * Mètode per saber si el canvi de password és correcte
     * @author manel bosch
     * @return true o false
     */
    private boolean checkPasswd(){
        return String.valueOf(jPasswordFieldOld.getPassword()).equals(usuario.getContrasena())
                && !Arrays.equals(jPasswordFieldOld.getPassword(), jPasswordFieldNew.getPassword())
                && Arrays.equals(jPasswordFieldNew.getPassword(), jPasswordFieldNew2.getPassword());
    }
}
