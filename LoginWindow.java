/* LoginWindow
*
*Copyright 2019 BusyB
*/
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;

/*
 * This class contains the code for the construction of the login window
 */

/**
 *
 * @author Eirini Maria Nikolakopoulou
 */
public class LoginWindow extends javax.swing.JFrame {

    /*
     * Creates new form LoginWindow.
     */
    /** Final variables for the color display */
    public final int r = 255;
    public final int g = 222;
    public final int b = 89;
    /** The construstor for the Login Window*/
    public LoginWindow() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method construst all the object needed for the construstion.
     * It also defines the action listeners for every button 
      */                       
  
    private void initComponents() {
        /** The font behind the username and the pasword fiels. */
        lowerBackground = new javax.swing.JPanel();
        /** Label for the word 'password'.*/
        textPassword = new javax.swing.JLabel();
        /** Label for the word 'email'. */
        textEmail = new javax.swing.JLabel();
        /** Field for the email. */
        emailField = new javax.swing.JTextField();
        /** Field for the password. */
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        /* Label for the BusyB icon. */
        busyBicon = new javax.swing.JLabel();
        /** The font behind the Login title.*/
        upperBackground = new javax.swing.JPanel();
        /** Label for the exit. */
        exitLabel = new javax.swing.JLabel();
        /** Label for tthe minimize of the window. */
        minimize = new javax.swing.JLabel();
        /** Label for the word 'Login' */
        loginTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(LoginWindow.class.getResource("/images/smallLogo.PNG")));
        setUndecorated(true); // No default background

        lowerBackground.setBackground(new java.awt.Color(r, g, b));

        textPassword.setFont(new java.awt.Font("Arial Black", 0, 14)); 
        textPassword.setText("Password :");

        textEmail.setFont(new java.awt.Font("Arial Black", 0, 14)); 
        textEmail.setText("Email :");

        emailField.setBackground(new java.awt.Color(240, 240, 240));
        emailField.setFont(new java.awt.Font("Arial Black", 0, 14)); 
        emailField.setForeground(new java.awt.Color(0, 0, 0));
        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }

			private void jTextField1ActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				
			}
        });

        passwordField.setBackground(new java.awt.Color(240, 240, 240));
        passwordField.setFont(new java.awt.Font("Arial Black", 0, 14)); 
        passwordField.setForeground(new java.awt.Color(0, 0, 0));
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }

			private void jPasswordField1ActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				
			}
        });

        loginButton.setBackground(new java.awt.Color(0, 0, 0));
        loginButton.setFont(new java.awt.Font("Arial Black", 0, 12)); 
        loginButton.setForeground(new java.awt.Color(255, 222, 89));
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        busyBicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busyb.jpg")));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(lowerBackground);
        lowerBackground.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textPassword)
                            .addComponent(textEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(145, 145, 145))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(busyBicon)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textEmail))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPassword)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(busyBicon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        upperBackground.setBackground(new java.awt.Color(0, 0, 0));

       
        exitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png")));
        exitLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(final java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }
        });

        minimize.setBackground(new java.awt.Color(255, 222, 89));
        minimize.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        minimize.setForeground(new java.awt.Color(255, 222, 89));
        minimize.setText("-");
        minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(final java.awt.event.MouseEvent evt) {
                jLabelMinMouseClicked(evt);
            }
        });

        loginTitle.setBackground(new java.awt.Color(255, 222, 89));
        loginTitle.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        loginTitle.setForeground(new java.awt.Color(255, 222, 89));
        loginTitle.setText("Login");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(upperBackground);
        upperBackground.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loginTitle)
                .addGap(131, 131, 131)
                .addComponent(minimize)
                .addGap(18, 18, 18)
                .addComponent(exitLabel)
                .addGap(8, 8, 8))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(minimize)
                    .addComponent(exitLabel)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(loginTitle)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(upperBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lowerBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(upperBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(lowerBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>                        
                           

    private void jLabelCloseMouseClicked(final java.awt.event.MouseEvent evt) {                                         
        System.exit(0);
    }                                        

    private void jLabelMinMouseClicked(final java.awt.event.MouseEvent evt) {                                       
       this.setState(JFrame.ICONIFIED);
    }                                      

    private void jButton1ActionPerformed(final java.awt.event.ActionEvent evt) {
         String email = emailField.getText();
         String password = passwordField.getText();
         int n;
         Account ac;
         ac = Account.searchAccountByEmail(email);
         if ( ac == null){
             WrongInput wi = new WrongInput();
             wi.setVisible(true);
             wi.pack();
             wi.setLocationRelativeTo(null);
             wi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             emailField.setText("");
             passwordField.setText("");
             emailField.requestFocus();
         } else if (ac.getPassword().equals(password)) {
            n = Account.typeOfEmployee(ac.getEmployee());
            ac.setHasDefaultPass(ac.getHasDefaultPass());
            if (ac.getHasDefaultPass() == 0){       
                   java.awt.EventQueue.invokeLater(new Runnable() {
                   public void run() {
                        new DefaultPassword(ac.getEmployee()).setVisible(true);
                        }
                    });
                this.dispose();
            } else {
                java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                new FirstWindow(ac.getEmployee()).setVisible(true);
                }
            });
           this.dispose();
            
            }
         } 
    }                 

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify                     
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel busyBicon;
    private javax.swing.JLabel loginTitle;
    private javax.swing.JLabel textPassword;
    private javax.swing.JLabel textEmail;
    private javax.swing.JLabel exitLabel;
    private javax.swing.JLabel minimize;
    private javax.swing.JPanel lowerBackground;
    private javax.swing.JPanel upperBackground;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField emailField;
    // End of variables declaration                   
}
