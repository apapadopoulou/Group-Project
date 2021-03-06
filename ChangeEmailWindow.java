
import java.awt.Toolkit;
import javax.swing.JFrame;
/**
 * This window appears when an employee wants to change his/her email.
 *
 * @author BusyB
 */
public class ChangeEmailWindow extends javax.swing.JFrame {
    /**
     * Creates new form ChangeEmailWindow.
     */
	 private javax.swing.JTextField email;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JTextField new_email;
	    private javax.swing.JButton ok_button;
	    private javax.swing.JLabel warning;
    private Employee emp; 
    public ChangeEmailWindow(Employee emp) {
        this.emp = emp;
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        warning.setVisible(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        new_email = new javax.swing.JTextField();
        ok_button = new javax.swing.JButton();
        warning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(ChangeEmailWindow.class.getResource("/images/smallLogo.PNG")));
        jPanel1.setBackground(new java.awt.Color(255, 222, 89));
        jPanel1.setPreferredSize(new java.awt.Dimension(470, 470));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busyb.jpg")));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 20));
        jLabel2.setText("Current email:");
        email.setFont(new java.awt.Font("Arial", 0, 18));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 20));
        jLabel3.setText("New email:");

        new_email.setFont(new java.awt.Font("Arial", 0, 18));

        ok_button.setFont(new java.awt.Font("Arial", 0, 20));
        ok_button.setText("OK!");
        ok_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ok_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ok_buttonMouseClicked(evt);
            }
        });

        warning.setFont(new java.awt.Font("Arial", 0, 13));
        warning.setForeground(new java.awt.Color(255, 0, 0));
        warning.setText("Invalid inputs!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(new_email, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(ok_button)
                                .addGap(123, 123, 123)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(warning)
                .addGap(153, 153, 153))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(new_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(ok_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }
    private void ok_buttonMouseClicked(java.awt.event.MouseEvent evt) {
        String mail = email.getText();
        if (mail.equals(emp.getEmail())){
            warning.setVisible(false);
            if (Checkers.isValidEmail(new_email.getText())){
                Account.searchAccountByEmployee(emp).setEmail(new_email.getText());
                emp.setEmail(new_email.getText());
            } else {
                warning.setText("The new email you entered is not valid");
                warning.setVisible(true);
                new_email.setText("");
            }
        } else {
            warning.setText("The current email you entered is not valid");
            warning.setVisible(true);
            email.setText("");
        }
    }
}
