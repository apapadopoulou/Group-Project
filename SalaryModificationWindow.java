
import java.awt.Toolkit;
import javax.swing.JFrame;
 /**
 * @author BusyB
 */
public class SalaryModificationWindow extends javax.swing.JFrame {

    /**
     * Creates new form SalaryModificationWindow
     */
   
    private Employee emp;
    public SalaryModificationWindow(Employee emp) {      
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
        employee = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        salary = new javax.swing.JLabel();
        new_salary = new javax.swing.JTextField();
        ok_button = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        warning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Salary Modification");
        setIconImage(Toolkit.getDefaultToolkit().getImage(SalaryModificationWindow.class.getResource("/images/smallLogo.PNG")));
        setPreferredSize(new java.awt.Dimension(471, 471));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 222, 89));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 20));
        jLabel1.setText("Employee's name:");

        employee.setFont(new java.awt.Font("Arial", 0, 18));
        employee.setText(emp.getNameSurname());

        jLabel4.setFont(new java.awt.Font("Arial", 1, 20));
        jLabel4.setText("Old salary:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 20));
        jLabel5.setText("New salary:");

        salary.setFont(new java.awt.Font("Arial", 0, 18));
        salary.setText(String.valueOf(emp.getSalary()));

        new_salary.setFont(new java.awt.Font("Arial", 0, 18));
        new_salary.setSelectionColor(new java.awt.Color(0, 0, 0));
       
        ok_button.setFont(new java.awt.Font("Arial", 0, 20));
        ok_button.setText("OK");
        ok_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busyb.jpg")));

        warning.setFont(new java.awt.Font("Arial", 0, 13));
        warning.setForeground(new java.awt.Color(255, 0, 0));
        warning.setText("Not valid salary!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(warning)
                .addGap(26, 26, 26)
                .addComponent(jLabel8))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(new_salary)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(ok_button)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(salary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel1))
                        .addGap(27, 27, 27)
                        .addComponent(employee)))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(employee))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(salary))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(new_salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(ok_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(warning)))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }
    private void ok_buttonMouseClicked(java.awt.event.MouseEvent evt) {
        String text = new_salary.getText();
        try {
            warning.setVisible(false);
            double d = Double.parseDouble(text);
            emp.setSalary(d);
        } catch (NumberFormatException nfe) {
            new_salary.setText("");
            warning.setVisible(true);
        }
    }

    
    private void formWindowClosed(java.awt.event.WindowEvent evt) {
        // TODO add your handling code here:

    }
    public javax.swing.JLabel employee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField new_salary;
    private javax.swing.JButton ok_button;
    public javax.swing.JLabel salary;
    private javax.swing.JLabel warning;
}