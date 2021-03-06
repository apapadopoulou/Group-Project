
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;

/**
 *
 * @author BusyB
 */
public class CrEventOrAddTask extends javax.swing.JFrame {

    /**
     * Creates new form CrEventOrAddTask.
     */
    private int n;
    private MiddleManager mm;
    private TopManager tp;
    public CrEventOrAddTask(int n, Employee emp) {
        this.n = n;
        if (n == 3 || n == 4)
            mm = (MiddleManager) emp;
        else
            tp = (TopManager) emp;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        showDate();
        showTime();
        jLabel1.setVisible(false);
        addOrCreate.setVisible(false);
        comboDif.setVisible(false);
        comboImp.setVisible(false);
        date1.setVisible(false);
        days.setVisible(false);
        description.setVisible(false);
        hours.setVisible(false);
        levOfDif.setVisible(false);
        levOfimp.setVisible(false);
        minutes.setVisible(false);
        months.setVisible(false);
        select.setVisible(false);
        slash1.setVisible(false);
        slash2.setVisible(false);
        textArea.setVisible(false);
        time1.setVisible(false);
        title.setVisible(false);
        titleText.setVisible(false);
        twoDots.setVisible(false);
        typeOfEvent.setVisible(false);
        types.setVisible(false);
        years.setVisible(false);
        jScrollPane1.setVisible(false);
        jScrollPane2.setVisible(false);
        employeesList.setVisible(false);
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

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        today = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        addLAbel = new javax.swing.JLabel();
        event = new javax.swing.JRadioButton();
        singleTask = new javax.swing.JRadioButton();
        groupTask = new javax.swing.JRadioButton();
        busyBLabel = new javax.swing.JLabel();
        OKButton = new javax.swing.JButton();
        typeOfEvent = new javax.swing.JLabel();
        types = new javax.swing.JComboBox();
        title = new javax.swing.JLabel();
        titleText = new javax.swing.JTextField();
        date1 = new javax.swing.JLabel();
        days = new javax.swing.JComboBox();
        slash2 = new javax.swing.JLabel();
        slash1 = new javax.swing.JLabel();
        months = new javax.swing.JComboBox();
        years = new javax.swing.JComboBox();
        time1 = new javax.swing.JLabel();
        hours = new javax.swing.JComboBox();
        twoDots = new javax.swing.JLabel();
        minutes = new javax.swing.JComboBox();
        description = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        select = new javax.swing.JLabel();
        addOrCreate = new javax.swing.JButton();
        levOfDif = new javax.swing.JLabel();
        levOfimp = new javax.swing.JLabel();
        comboImp = new javax.swing.JComboBox();
        comboDif = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();        
        DefaultListModel model1 = new DefaultListModel();
        if (n == 3 || n == 4){
            for (int i = 1; i < Department.departments.size(); i++) {
            	if (Department.departments.get(i).getManagerId().equals(mm.getID())) {
            		for (int j = 0; j < Department.departments.get(i).getEmployeesOfDepartment().size(); j++) {
            			model1.addElement(Department.departments.get(i).getEmployeesOfDepartment().get(j).getNameSurname());
            		}
            	}
            }
        } else {
            for (Employee employee : Employee.employees) {
                model1.addElement(employee.getNameSurname());
            }
        }
        employeesList = new javax.swing.JList(model1);
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(CrEventOrAddTask.class.getResource("/images/smallLogo.PNG")));

        jPanel1.setBackground(new java.awt.Color(255, 222, 89));

        today.setFont(new java.awt.Font("Bookman Old Style", 1, 24));
        today.setText("Today");

        date.setFont(new java.awt.Font("Bookman Old Style", 1, 18));
        date.setText("Date");

        time.setFont(new java.awt.Font("Bookman Old Style", 1, 18));
        time.setText("Time");

        addLAbel.setFont(new java.awt.Font("Arial", 1, 24));
        addLAbel.setText("Add:");

        event.setBackground(new java.awt.Color(255, 222, 89));
        buttonGroup.add(event);
        event.setFont(new java.awt.Font("Arial", 0, 18));
        event.setText("Event");

        singleTask.setBackground(new java.awt.Color(255, 222, 89));
        buttonGroup.add(singleTask);
        singleTask.setFont(new java.awt.Font("Arial", 0, 18));
        singleTask.setText("Single Task");
        singleTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleTaskActionPerformed(evt);
            }
        });

        groupTask.setBackground(new java.awt.Color(255, 222, 89));
        buttonGroup.add(groupTask);
        groupTask.setFont(new java.awt.Font("Arial", 0, 18));
        groupTask.setText("Group Task");
        groupTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupTaskActionPerformed(evt);
            }
        });

        busyBLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busyb.jpg"))); // NOI18N

        OKButton.setText("OK");
        OKButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OKButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OKButtonMouseClicked(evt);
            }
        });
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        typeOfEvent.setFont(new java.awt.Font("Arial", 0, 18));
        typeOfEvent.setText("Type of event:");

        types.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Appointment", "Meeting", "Main event", "Other" }));
        types.setSelectedIndex(-1);
        
        title.setFont(new java.awt.Font("Arial", 0, 18));
        title.setText("Title:");

        date1.setFont(new java.awt.Font("Arial", 0, 18));
        date1.setText("Date:");

        days.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        days.setSelectedItem(null);

        slash2.setFont(new java.awt.Font("Arial", 1, 18));
        slash2.setText("/");

        slash1.setFont(new java.awt.Font("Arial", 1, 18));
        slash1.setText("/");

        months.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        months.setSelectedItem(null
        );

        years.setModel(new javax.swing.DefaultComboBoxModel(MyCalendar.year));

        time1.setFont(new java.awt.Font("Arial", 0, 18));
        time1.setText("Time:");

        hours.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        hours.setSelectedIndex(-1);
        hours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hoursActionPerformed(evt);
            }
        });

        twoDots.setFont(new java.awt.Font("Arial", 1, 18));
        twoDots.setText(":");

        minutes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        minutes.setSelectedIndex(-1);
       
        description.setFont(new java.awt.Font("Arial", 0, 18));
        description.setText("Description");

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        select.setFont(new java.awt.Font("Arial", 0, 18));
        select.setText("Select Employee(s)");

        addOrCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addOrCreate.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addOrCreateMouseClicked(evt);
            }
        });

        levOfDif.setFont(new java.awt.Font("Arial", 0, 18));
        levOfDif.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        levOfDif.setText("Level of difficulty:");

        levOfimp.setFont(new java.awt.Font("Arial", 0, 18));
        levOfimp.setText("Level of importance:");

        comboImp.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        comboImp.setSelectedIndex(-1);

        comboDif.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        comboDif.setSelectedIndex(-1);

        employeesList.setModel(model1);
        jScrollPane2.setViewportView(employeesList);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12));
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Not valid fields. Please try again.");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png")));
        jLabel13.setText("Home");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(580, 580, 580)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(addOrCreate)
                                            .addComponent(jLabel1)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(description)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(date1)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(days, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(slash1))
                                                .addComponent(typeOfEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(time1)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(hours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(types, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addComponent(twoDots)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(minutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(months, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(slash2)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(years, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(68, 68, 68)
                                                    .addComponent(title)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(levOfDif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(levOfimp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(comboImp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(comboDif, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addComponent(jScrollPane1)
                                        .addComponent(select))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(384, 384, 384)
                                .addComponent(addLAbel)
                                .addGap(18, 18, 18)
                                .addComponent(event)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(singleTask)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(groupTask)
                                .addGap(18, 18, 18)
                                .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(302, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(today)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(busyBLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(today, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(addLAbel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(event, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(singleTask, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(groupTask, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(73, 73, 73))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(types, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(title)
                                .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(typeOfEvent))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(years, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(date1)
                        .addComponent(days, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(months, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(slash1)
                        .addComponent(slash2)
                        .addComponent(levOfimp)
                        .addComponent(comboImp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(time1)
                    .addComponent(hours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twoDots)
                    .addComponent(levOfDif)
                    .addComponent(comboDif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(description)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(select, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(addOrCreate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(busyBLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void singleTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleTaskActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_singleTaskActionPerformed

    private void groupTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupTaskActionPerformed
       
    }//GEN-LAST:event_groupTaskActionPerformed

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OKButtonActionPerformed

    private void hoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hoursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hoursActionPerformed

    private void OKButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OKButtonMouseClicked
        employeesList.setVisible(true);        
        jScrollPane2.setVisible(true);
        if (event.isSelected()) {
        	comboDif.setVisible(false);
            comboImp.setVisible(false);
            levOfDif.setVisible(false);
            levOfimp.setVisible(false);
            addOrCreate.setText("Create event");
            addOrCreate.setVisible(true);
            date1.setText("Date:");
            date1.setVisible(true);
            days.setVisible(true);
            months.setVisible(true);
            years.setVisible(true);
            slash1.setVisible(true);
            slash2.setVisible(true);
            description.setVisible(true);
            employeesList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            time1.setVisible(true);
            hours.setVisible(true);
            twoDots.setVisible(true);
            minutes.setVisible(true);
            jScrollPane1.setVisible(true);            
            select.setVisible(true);
            textArea.setVisible(true);
            title.setVisible(true);
            titleText.setVisible(true);
            typeOfEvent.setVisible(true);
            types.setVisible(true);
            
        }
        else if (singleTask.isSelected()){
            addOrCreate.setText("Add Task");
            addOrCreate.setVisible(true);
            comboDif.setVisible(true);
            comboImp.setVisible(true);
            date1.setText("Due Date:");
            date1.setVisible(true);
            days.setVisible(true);
            description.setVisible(true);
            employeesList.setSelectionMode(
                    ListSelectionModel.SINGLE_SELECTION);            
            levOfDif.setVisible(true);
            levOfimp.setVisible(true);
            months.setVisible(true);
            select.setVisible(true);
            slash1.setVisible(true);
            slash2.setVisible(true);
            textArea.setVisible(true);
            years.setVisible(true);
            jScrollPane1.setVisible(true);            
            time1.setVisible(false);
            title.setVisible(false);
            titleText.setVisible(false);
            twoDots.setVisible(false);
            typeOfEvent.setVisible(false);
            types.setVisible(false);
            hours.setVisible(false);
            minutes.setVisible(false);                 
        } else if (groupTask.isSelected()){
        addOrCreate.setText("Add Task");
            addOrCreate.setVisible(true);
            comboDif.setVisible(true);
            comboImp.setVisible(true);
            date1.setText("Due Date:");
            date1.setVisible(true);
            days.setVisible(true);
            description.setVisible(true);            
            levOfDif.setVisible(true);
            levOfimp.setVisible(true);
            employeesList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            months.setVisible(true);
            select.setVisible(true);
            slash1.setVisible(true);
            slash2.setVisible(true);
            textArea.setVisible(true);
            years.setVisible(true);
            jScrollPane1.setVisible(true);                 
            time1.setVisible(false);
            title.setVisible(false);
            titleText.setVisible(false);
            twoDots.setVisible(false);
            typeOfEvent.setVisible(false);
            types.setVisible(false);
            hours.setVisible(false);
            minutes.setVisible(false);
                    
        }
            
        
        
    }//GEN-LAST:event_OKButtonMouseClicked

    private void addOrCreateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addOrCreateMouseClicked
        if (event.isSelected()){
            
                String type =  types.getSelectedItem().toString();
                String title1;
                title1 = titleText.getText();
                String date2 = days.getSelectedItem().toString() + "/" + 
                        months.getSelectedItem().toString() + "/" +
                        years.getSelectedItem().toString();
	           if (Day.validDate(date2)) {
	                String time2;
	                time2 = hours.getSelectedItem().toString() + ":" +
	                        minutes.getSelectedItem().toString();
	                String desc;
	                desc = textArea.getText();
	                ArrayList <String> empls = new ArrayList <String>();
	                int[] emloyeesIndices = employeesList.getSelectedIndices();   
	                if (n == 5) {	                                
		                for (int i = 0; i < emloyeesIndices.length; i++) {
		                    Employee em = Employee.employees.get(emloyeesIndices[i]);
		                    empls.add(em.getID());                   
		                }
	                } else {
	                	for (int i = 0; i < emloyeesIndices.length; i++) {
	                		Employee em = Employee.searchEmployeeByName2(String.valueOf(employeesList
	                				.getModel().getElementAt(emloyeesIndices[i])));
	                		empls.add(em.getID());	
	                	}
	                }
               Event event = new Event(title1, date2, time2, desc, type, empls);
            
            } else {

                    jLabel1.setVisible(true);
            }
        } else {
        	Calendar c = Calendar.getInstance();
            String startDate = c.get(Calendar.DAY_OF_MONTH) + "/" + c.get(Calendar.MONTH) + "/" 
                    +c.get(Calendar.YEAR);
            String dueDate = days.getSelectedItem().toString() + "/" + 
                        months.getSelectedItem().toString() + "/" +
                        years.getSelectedItem().toString();
            String desc;
            desc = textArea.getText();
            int importance = comboImp.getSelectedIndex() + 1;
            int difficulty =  comboDif.getSelectedIndex() + 1;
            if (singleTask.isSelected()){
                String employeeId = Employee.searchEmployeeByName2(
                    String.valueOf(employeesList.getModel().getElementAt(employeesList
                    		.getSelectedIndex()))).getID();
                Task task = new Task(startDate, dueDate, desc, importance, difficulty, 
                    employeeId);
            } else {
            	ArrayList <String> empls = new ArrayList <String>();
                int[] emloyeesIndices = employeesList.getSelectedIndices();   
                if (n == 5) {	                                
	                for (int i = 0; i < emloyeesIndices.length; i++) {
	                    Employee em = Employee.employees.get(emloyeesIndices[i]);
	                    empls.add(em.getID());                   
	                }
                } else {
                	for (int i = 0; i < emloyeesIndices.length; i++) {
                		Employee em = Employee.searchEmployeeByName2(String.valueOf(employeesList
                				.getModel().getElementAt(emloyeesIndices[i])));
                		empls.add(em.getID());	
                	}
                }
                Task task = new Task(startDate, dueDate, desc, importance, difficulty,
                    empls);
            }
        }
    }//GEN-LAST:event_addOrCreateMouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {
    	if (n == 3 || n ==4)//GEN-FIRST:event_jLabel13MouseClicked
    		new FirstWindow(mm).setVisible(true);
    	else
    		new FirstWindow(tp).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel13MouseClicked
    private javax.swing.JButton OKButton;
    private javax.swing.JLabel addLAbel;
    private javax.swing.JButton addOrCreate;
    private javax.swing.JLabel busyBLabel;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JComboBox comboDif;
    private javax.swing.JComboBox comboImp;
    private javax.swing.JLabel date;
    private javax.swing.JLabel date1;
    private javax.swing.JComboBox days;
    private javax.swing.JLabel description;
    private javax.swing.JList employeesList;
    private javax.swing.JRadioButton event;
    private javax.swing.JRadioButton groupTask;
    private javax.swing.JComboBox hours;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel levOfDif;
    private javax.swing.JLabel levOfimp;
    private javax.swing.JComboBox minutes;
    private javax.swing.JComboBox months;
    private javax.swing.JLabel select;
    private javax.swing.JRadioButton singleTask;
    private javax.swing.JLabel slash1;
    private javax.swing.JLabel slash2;
    private javax.swing.JTextArea textArea;
    private javax.swing.JLabel time;
    private javax.swing.JLabel time1;
    private javax.swing.JLabel title;
    private javax.swing.JTextField titleText;
    private javax.swing.JLabel today;
    private javax.swing.JLabel twoDots;
    private javax.swing.JLabel typeOfEvent;
    private javax.swing.JComboBox types;
    private javax.swing.JComboBox years;
}