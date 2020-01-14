import java.awt.Toolkit;
public class DefaultPassword extends javax.swing.JFrame {
	/** 
	 * To change this template file, choose Tools | Templates
	 * and open the template in the editor.
	 *
	 * @author BusyB
	 */
    /**
     * Creates new form DefaultPassword
     */
    private Employee emp;
    public DefaultPassword(Employee emp) {
        this.emp = emp;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    /** <editor-fold defaultstate="collapsed" desc="Generated Code">*/
    /**GEN-BEGIN:initComponents*/
    private void initComponents() {

        background = new javax.swing.JPanel();
        TextForDefPass = new javax.swing.JLabel();
        OKButton = new javax.swing.JButton();
        OKButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(DefaultPassword.class.getResource("/images/smallLogo.PNG")));
        setUndecorated(true);
        getContentPane().setLayout(null);

        background.setBackground(new java.awt.Color(255, 255, 140));

        TextForDefPass.setFont(new java.awt.Font("Arial", 1, 12));
        TextForDefPass.setText("You are using the default password. "
            + "If you want to change it go to settings.");

        OKButton.setText("OK");
        OKButton.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
         public void mouseClicked(java.awt.event.MouseEvent evt) {
                OKButtonMouseClicked(evt);
         }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(background);
        background.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
          jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(209, 209, 209))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(TextForDefPass)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(TextForDefPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(background);
        background.setBounds(0, 0, 470, 100);

        setSize(new java.awt.Dimension(469, 97));
        setLocationRelativeTo(null);
    }

    private void OKButtonMouseClicked(java.awt.event.MouseEvent evt) { /**GEN-FIRST:event_OKButtonMouseClicked*/
            java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FirstWindow(emp).setVisible(true);
                }
            });
           this.dispose();
    }
    private javax.swing.JButton OKButton;
    private javax.swing.JLabel TextForDefPass;
    private javax.swing.JPanel background;
}
