
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author BusyB
 */
public class AddEmployeeWindow extends javax.swing.JFrame {

    /**
     * Creates new form AddEmployeeWindow.
     */
    private final String[] years = years();

    public AddEmployeeWindow() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        warning.setVisible(false);
        jLabel12.setVisible(false);
        departments.setVisible(false);
        jScrollPane1.setVisible(false);
        groupButton();
    }

    public static String[] years() {
        String years[] = new String[150];
        int year = Calendar.getInstance().get(Calendar.YEAR) - 150;
        for (int i = 1; i < years.length; i++) {
            years[i] = String.valueOf(year);
            year++;
        }
        return years;
    }

    private void groupButton() {

        ButtonGroup bg1 = new ButtonGroup();

        bg1.add(basic);
        bg1.add(middle);
        bg1.add(top);

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        add_button = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        warning = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        surname = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        day = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        month = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        birthyear = new javax.swing.JComboBox();
        salary = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        basic = new javax.swing.JRadioButton();
        middle = new javax.swing.JRadioButton();
        top = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        departments = new javax.swing.JList();
        DefaultListModel model = new DefaultListModel();
        for (Department department : Department.departments) {
            model.addElement(department.getName());
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 222, 89));
        setIconImage(Toolkit.getDefaultToolkit().getImage(AddEmployeeWindow.class.getResource("/images/smallLogo.PNG")));

        jPanel1.setBackground(new java.awt.Color(255, 222, 89));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Add Employee's personal data");

        add_button.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        add_button.setText("Add");
        add_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add_button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_buttonMouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busyb.jpg"))); // NOI18N

        warning.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        warning.setForeground(new java.awt.Color(255, 0, 0));
        warning.setText("Invalid inputs!");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel3.setText("Name:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel4.setText("Surname:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel5.setText("Phone Number:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel6.setText("Email:");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel7.setText("Birthdate:");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel9.setText("Salary:");

        name.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        name.setSelectionColor(new java.awt.Color(0, 0, 0));
       
        surname.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        surname.setSelectionColor(new java.awt.Color(0, 0, 0));

        phone.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        phone.setSelectionColor(new java.awt.Color(0, 0, 0));

        email.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        day.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        day.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" })
        );
        day.setSelectedIndex(-1);
        day.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setText("/");

        month.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        month.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        month.setSelectedIndex(-1);
        month.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setText("/");

        birthyear.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        birthyear.setModel(new javax.swing.DefaultComboBoxModel(years));
        birthyear.setSelectedIndex(-1);
        birthyear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        salary.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        salary.setSelectionColor(new java.awt.Color(0, 0, 0));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel8.setText("Type of employee:");

        basic.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        basic.setText("Basic Employee");
        basic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        basic.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                basicMouseClicked(evt);
            }
        });
        middle.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        middle.setText("Middle Manager");
        middle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        middle.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                middleMouseClicked(evt);
            }
        });

        top.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        top.setText("Top Manager");
        top.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        top.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                topMouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel12.setText("Department:");

        departments.setModel(model);
        jScrollPane1.setViewportView(departments);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(add_button)
                    .addComponent(warning))
                .addGap(346, 346, 346)
                .addComponent(jLabel2))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(surname, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(birthyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salary, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(basic)
                            .addComponent(middle)
                            .addComponent(top)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12))
                                .addComponent(jLabel1)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(201, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12))
                        .addGap(17, 17, 17)
                        .addComponent(basic)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(middle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(top))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(birthyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(add_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(warning)
                        .addGap(28, 28, 28))))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   
    private void basicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_basicMouseClicked
        // TODO add your handling code here:
        jLabel12.setVisible(true);
        departments.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        departments.setVisible(true);
        jScrollPane1.setVisible(true);
    }//GEN-LAST:event_basicMouseClicked

    private void middleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_middleMouseClicked
        // TODO add your handling code here:
        jLabel12.setVisible(true);
        departments.setSelectionMode(DefaultListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        departments.setVisible(true);
        jScrollPane1.setVisible(true);
    }//GEN-LAST:event_middleMouseClicked

    private void topMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topMouseClicked
        // TODO add your handling code here:
        jLabel12.setVisible(false);
        departments.setVisible(false);
        jScrollPane1.setVisible(false);
    }//GEN-LAST:event_topMouseClicked
    private void add_buttonMouseClicked(java.awt.event.MouseEvent evt) {
        warning.setVisible(false);
        String birthdate = day.getSelectedItem().toString() + "/" + 
                        month.getSelectedItem().toString() + "/" +
                        birthyear.getSelectedItem().toString();
        if (!Checkers.isValidFirstName(name.getText())){
            warning.setText("Please enter a valid name!");
            warning.setVisible(true);
            return;
        } 
        if (!Checkers.isValidLastName(surname.getText())){
            warning.setText("Please enter a valid surname!");
            warning.setVisible(true);
            return;
        } 
        if (!Checkers.isValidPhoneNumber(phone.getText())){
            warning.setText("Please enter a valid phonenumber!");
            warning.setVisible(true);
            return;
        }
        if (!Checkers.isValidEmail(email.getText())){
            warning.setText("Please enter a valid email!");
            warning.setVisible(true);   
            return;
        }
        if (!Day.validDate(birthdate)) {
            warning.setText("Please enter a valid birthdate!");
            warning.setVisible(true);
            return;
        }
        try {
            Double.parseDouble(salary.getText());
        } catch (NumberFormatException e){
            warning.setText("Please enter a valid salary");
            warning.setVisible(true);
            return;
        }
        String empName = name.getText();
        String empSurname = surname.getText();
        String empPhonenumber = phone.getText();
        String empEmail = email.getText();
        double empSal = Double.parseDouble(salary.getText());
        if (basic.isSelected()){
           String dep_name = departments.getSelectedValue().toString();
           Department d = Department.searchDepartmentByName(dep_name);
           new BasicEmployee(empName, empSurname, empPhonenumber, empEmail, 
                   birthdate, d.getId(), empSal);
        } else if (middle.isSelected()){
            MiddleManager middleManager = new MiddleManager(empName, empSurname, 
                    empPhonenumber, empEmail, birthdate, empSal);
            ArrayList <String> deps = new ArrayList <String>();
            int[] depsIndices = departments.getSelectedIndices();                                            
            for (int i = 0; i < depsIndices.length; i++) {
                    Department.departments.get(depsIndices[i])
                    	.setManagerId(middleManager.getID());;
                                       
                }                            
        } else if(top.isSelected()){
            new TopManager(empName, empSurname, 
                    empPhonenumber, empEmail, birthdate, empSal);
        } else {
            warning.setText("Please select type of employee!");
            warning.setVisible(true);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_button;
    private javax.swing.JRadioButton basic;
    private javax.swing.JComboBox birthyear;
    private javax.swing.JComboBox day;
    private javax.swing.JList departments;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton middle;
    private javax.swing.JComboBox month;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phone;
    private javax.swing.JTextField salary;
    private javax.swing.JTextField surname;
    private javax.swing.JRadioButton top;
    private javax.swing.JLabel warning;
    // End of variables declaration//GEN-END:variables
}
//End of AddEmployeeWindow class.
