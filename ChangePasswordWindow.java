
import java.awt.Toolkit;
import javax.swing.JFrame;
/**
 * This window appears when an employee changes his/her password.
 *
 * @author BusyB
 */
public class ChangePasswordWindow extends javax.swing.JFrame {

    /**
     * Creates new form ChangePasswordWindow.
     */
	  private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JPasswordField new_password1;
	    private javax.swing.JPasswordField new_password2;
	    private javax.swing.JButton ok_button;
	    private javax.swing.JPasswordField password;
	    private javax.swing.JLabel warning;
    private Employee emp;
    public ChangePasswordWindow(Employee emp) {
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
        password = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        new_password2 = new javax.swing.JPasswordField();
        ok_button = new javax.swing.JButton();
        new_password1 = new javax.swing.JPasswordField();
        warning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(ChangePasswordWindow.class.getResource("/images/smallLogo.PNG")));

        jPanel1.setBackground(new java.awt.Color(255, 222, 89));
        jPanel1.setPreferredSize(new java.awt.Dimension(470, 470));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busyb.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel2.setText("Type current password:");

        password.setSelectionColor(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel3.setText("Type new password:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel4.setText("Retype new password:");

        new_password2.setSelectionColor(new java.awt.Color(0, 0, 0));

        ok_button.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        ok_button.setText("Change password");
        ok_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ok_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ok_buttonMouseClicked(evt);
            }
        });


        new_password1.setSelectionColor(new java.awt.Color(0, 0, 0));

        warning.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        warning.setForeground(new java.awt.Color(255, 0, 0));
        warning.setText("Invalid inputs!Please try again");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(new_password2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(new_password1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(ok_button))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(warning)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(new_password1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(new_password2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(ok_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ok_buttonMouseClicked(java.awt.event.MouseEvent evt) {
        warning.setVisible(false);
        try {        	
            char[] pas_emp = password.getPassword();            
            String pass = "";
            for (int i = 0; i < pas_emp.length; i++) {
            	pass += pas_emp[i];
            }
            char[] new_pass_emp1 = new_password1.getPassword();
            String new_password1 = "";
            for (int i = 0; i < new_pass_emp1.length; i++ ) {
            	new_password1 += new_pass_emp1[i];
            }
            char[] new_pass_emp2 = new_password2.getPassword();
            String new_password2 = "";
            for (int i = 0; i < new_pass_emp2.length; i++ ) {
            	new_password2 += new_pass_emp2[i];
            }
            boolean b = new_password1.equals(new_password2);
            if(Account.searchAccountByEmployee(emp).getPassword().equals(pass)) {
            	if (b) {
            		if (Checkers.isValidPassword(new_password1)) {
            			Account.searchAccountByEmployee(emp).setPassword(new_password1);
            		} else {
            			warning.setText("Invalid new password. Password's length"+
                                "must be between 6 and 15.");
            			warning.setVisible(true);
            		}
            	} else {
            		warning.setText("Invalid inputs");
                    warning.setVisible(true);
            	}
            } else {
            	warning.setText("Please enter your current password");
                warning.setVisible(true);
            } 

        } catch (NullPointerException e){
            warning.setText("Please enter your current password");
            warning.setVisible(true);
        }
    }
  
}
