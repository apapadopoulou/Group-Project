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
public class ShowDepartments extends javax.swing.JFrame {

    /**
     * Creates new form ShowDepartments
     */
    private int n;
    private MiddleManager mm;
    public ShowDepartments(int n, Employee emp) {
        this.n = n;
        mm = MiddleManager.searchMiddleManager(emp.getNameSurname());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        showDate();
        showTime();       
        depart.setVisible(false);
        employeesOfDepartment.setVisible(false);
        jScrollPane2.setVisible(false);
        selectEmployee.setVisible(false);
        depNot.setVisible(false);
        empNot.setVisible(false);
        
    }
     void showDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("EEEE dd-MM-yyyy");
        date.setText(s.format(d));
    }

    void showTime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                time.setText(s.format(d));

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
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DefaultListModel model1 = new DefaultListModel();
        for (int i = 1; i < Department.departments.size(); i++){
        	if (Department.departments.get(i).getManagerId().equals(mm.getID()))
        		model1.addElement(Department.departments.get(i).getName());
        }
        mmDepartments = new javax.swing.JList(model1);
        jScrollPane2 = new javax.swing.JScrollPane();
        DefaultListModel model2 = new DefaultListModel();       
        employeesOfDepartment = new javax.swing.JList();
        depart = new javax.swing.JLabel();
        selectEmployee = new javax.swing.JToggleButton();
        jLabel13 = new javax.swing.JLabel();
        selectDep = new javax.swing.JToggleButton();
        depNot = new javax.swing.JLabel();
        empNot = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(ShowDepartments.class.getResource("/images/smallLogo.PNG")));

        jPanel1.setBackground(new java.awt.Color(255, 222, 89));

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel1.setText("Today");

        date.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        date.setText("Date");

        time.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        time.setText("Time");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busyb.jpg"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel3.setText("Manage Departments");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText("Managing departments:");

        
        mmDepartments.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(mmDepartments);

        
        employeesOfDepartment.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(employeesOfDepartment);

        depart.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        

        selectEmployee.setText("Select Employee");
        selectEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectEmployeeMouseClicked(evt);
            }
        });
        
        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        jLabel13.setText("Home");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        selectDep.setText("Select Department");
        selectDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectDepActionPerformed(evt);
            }
        });

        depNot.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        depNot.setForeground(new java.awt.Color(255, 0, 0));
        depNot.setText("Please select a department!");

        empNot.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        empNot.setForeground(new java.awt.Color(255, 0, 0));
        empNot.setText("Please select an employee!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(318, 318, 318)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(depart)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(depNot)
                                            .addComponent(selectDep)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(empNot)
                                            .addComponent(selectEmployee)))))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date)
                        .addGap(7, 7, 7)
                        .addComponent(time))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(selectDep)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(depNot)
                .addGap(47, 47, 47)
                .addComponent(depart, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(selectEmployee)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(empNot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 452, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {
        new FirstWindow(mm).setVisible(true);
        this.setVisible(false);
    }

    private void selectDepActionPerformed(java.awt.event.ActionEvent evt) {
    	depNot.setVisible(false);
    	if (mmDepartments.getSelectedIndex() == -1 ){
    	   depNot.setText("Please select a department!");
           depNot.setVisible(true);
       } else {
    	   depart.setText(mmDepartments.getSelectedValue().toString());
    	   DefaultListModel model2 = new DefaultListModel();
    	   Department d = Department.searchDepartmentByName(mmDepartments.getSelectedValue().toString());
           for (int i = 0; i < d.getEmployeesOfDepartment().size(); i++){
   	            model2.addElement(d.getEmployeesOfDepartment().get(i).getNameSurname());
   	        }
           employeesOfDepartment.setModel(model2);
           depNot.setVisible(false);
            depart.setVisible(true);
            jScrollPane2.setVisible(true);
            employeesOfDepartment.setVisible(true);
            selectEmployee.setVisible(true);
       }
    }

    private void selectEmployeeMouseClicked(java.awt.event.MouseEvent evt) {
        if (employeesOfDepartment.getSelectedIndex() == -1){
            empNot.setVisible(true);
        } else {        
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new EmployeeOverview(n,BasicEmployee.searchEmployeeByName2(String.
                            valueOf(employeesOfDepartment.getModel().getElementAt(employeesOfDepartment
                            		.getSelectedIndex()))))
                            .setVisible(true);
                }
            });
        }
    }
    private javax.swing.JLabel date;
    private javax.swing.JLabel depNot;
    private javax.swing.JLabel depart;
    private javax.swing.JLabel empNot;
    private javax.swing.JList employeesOfDepartment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList mmDepartments;
    private javax.swing.JToggleButton selectDep;
    private javax.swing.JToggleButton selectEmployee;
    private javax.swing.JLabel time;
}