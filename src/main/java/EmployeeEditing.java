package gr.aueb.dmst.ProgrammingII.BusyB.BusyB;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.Timer;
/**
 *
 * @author BusyB
 */
public class EmployeeEditing extends javax.swing.JFrame {

    /**
     * Creates new form EmployeeEditing
     */
    private Employee emp;
    public EmployeeEditing(int n, Employee emp) {
        this.emp = emp;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        showDate();
        showTime();
        warning.setVisible(false);
    }

    void showDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("EEEE dd-MM-yyyy");
        currentDate.setText(s.format(d));
    }

    void showTime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                currentTime.setText(s.format(d));

            }
        }
        ).start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        currentDate = new javax.swing.JLabel();
        currentTime = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DefaultListModel model = new DefaultListModel();
         for (int i = 1; i < Employee.employees.size(); i++){
            model.addElement(Employee.employees.get(i).getNameSurname());
        }
        employees_list = new javax.swing.JList();
        manage_button = new javax.swing.JButton();
        add_button = new javax.swing.JButton();
        delete_button = new javax.swing.JButton();
        warning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(EmployeeEditing.class.getResource("/images/smallLogo.PNG")));

        jPanel1.setBackground(new java.awt.Color(255, 222, 89));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        jLabel1.setText("Home");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busyb.jpg"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel3.setText("Today");

        currentDate.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        currentDate.setText("Date:");

        currentTime.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        currentTime.setText("Time:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel4.setText("Manage employees");

        employees_list.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        employees_list.setModel(model);
        employees_list.setToolTipText("");
        employees_list.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employees_list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        employees_list.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(employees_list);

        manage_button.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        manage_button.setText("Manage employee's personal data");
        manage_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manage_button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manage_buttonMouseClicked(evt);
            }
        });

        add_button.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        add_button.setText("Add employee");
        add_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add_button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_buttonMouseClicked(evt);
            }
        });

        delete_button.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        delete_button.setText("Delete employee");
        delete_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete_button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delete_buttonMouseClicked(evt);
            }
        });

        warning.setFont(new java.awt.Font("Arial", 2, 13)); // NOI18N
        warning.setForeground(new java.awt.Color(255, 0, 0));
        warning.setText("You haven't selected any employee!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(currentTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1497, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(delete_button)
                                    .addComponent(manage_button)
                                    .addComponent(add_button)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(warning)))
                        .addGap(521, 521, 521))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(617, 617, 617)
                                .addComponent(jLabel1)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(currentDate, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(currentDate))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel4)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(manage_button)
                        .addGap(131, 131, 131)
                        .addComponent(delete_button)
                        .addGap(18, 18, 18)
                        .addComponent(warning)
                        .addGap(125, 125, 125)
                        .addComponent(add_button))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(currentTime)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 328, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {
        new FirstWindow(emp).setVisible(true);
        this.setVisible(false);

    }

    private void delete_buttonMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        if (employees_list.getSelectedIndex() == -1) {
            warning.setVisible(true);
        } else {
            warning.setVisible(false);
            Employee e = Employee.employees.get(employees_list.getSelectedIndex());            
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {                    
                    new DeleteEmployee(e).setVisible(true);
                }
            });
        }
    }

    private void add_buttonMouseClicked(java.awt.event.MouseEvent evt) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddEmployeeWindow().setVisible(true);
            }
        });
    }

    private void manage_buttonMouseClicked(java.awt.event.MouseEvent evt) {
        warning.setVisible(false);        
        if (employees_list.getSelectedIndex() == -1)
            warning.setVisible(true);
        else {
        	Employee e = Employee.employees.get(employees_list.getSelectedIndex());
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ManageEmployeeWindow(emp).setVisible(true);
                }
            });
        }
    }
    private javax.swing.JButton add_button;
    private javax.swing.JLabel currentDate;
    private javax.swing.JLabel currentTime;
    private javax.swing.JButton delete_button;
    private javax.swing.JList employees_list;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton manage_button;
    private javax.swing.JLabel warning;
}
