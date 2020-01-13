
import java.awt.Toolkit;


 /** To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BusyB
 */
public class DeleteEmployee extends javax.swing.JFrame {

    /**
     * Creates new form DeleteEmployee
     */
    private Employee emp;
    public DeleteEmployee(Employee emp) {
        this.emp = emp;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    /**<editor-fold defaultstate="collapsed" desc="Generated Code">
    //GEN-BEGIN:initComponents*/
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteEmployee.class.getResource("/images/smallLogo.PNG")));

        jPanel1.setBackground(new java.awt.Color(255, 222, 120));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); /** NOI18N */
        jLabel1.setText("Are you sure you want to delete this employee?");

        jToggleButton1.setText("Yes");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("No");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(jToggleButton1)
                .addGap(27, 27, 27)
                .addComponent(jToggleButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton2))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    } /** </editor-fold>//GEN-END:initComponents */

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) { /**GEN-FIRST:event_jToggleButton1ActionPerformed*/
        Employee.employees.remove(emp);
        if (emp instanceof BasicEmployee)
            BasicEmployee.basicEmployees.remove((BasicEmployee)emp);
        else if (emp instanceof MiddleManager)
            MiddleManager.middleManagers.remove((MiddleManager) emp);
        else
            TopManager.topManagers.remove((TopManager) emp);
        this.dispose();
    } /**GEN-LAST:event_jToggleButton1ActionPerformed */

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) { /**GEN-FIRST:event_jToggleButton2ActionPerformed*/
       this.dispose();
    } /**GEN-LAST:event_jToggleButton2ActionPerformed */

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /** Set the Nimbus look and feel
        //<editor-fold defaultstate="collapsed" desc=" Look and feel
    	setting code (optional) ">
        If Nimbus (introduced in Java SE 6) is not available,
        stay with the default look and feel.
        For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DeleteEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /**</editor-fold>*/

        /** Create and display the form */
        /**java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteEmployee().setVisible(true);
            }
        });*/
    }

    /** Variables declaration - do not modify//GEN-BEGIN:variables*/
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    /** End of variables declaration//GEN-END:variables */
}

/**
*End of DeleteEmployee class
*/