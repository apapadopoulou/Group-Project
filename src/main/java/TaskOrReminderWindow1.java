package gr.aueb.dmst.ProgrammingII.BusyB.BusyB;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author BusyB
 *
 */
public class TaskOrReminderWindow1 extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form TaskOrReminderWindow1
     */
    private final String[] years = years();
    private final int n;
    private final Employee emp;

    public TaskOrReminderWindow1(int n, Employee emp) {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.n = n;
        this.emp = emp;
        initComponents();
        showDate();
        showTime();
        groupButton();
        jLabel2.setVisible(false);
        people_list.setVisible(false);
        jScrollPane1.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel9.setVisible(false);
        due_day.setVisible(false);
        due_month.setVisible(false);
        due_year.setVisible(false);
        jLabel10.setVisible(false);
        reminder_text.setVisible(false);
        description.setVisible(false);
        jLabel11.setVisible(false);
        jLabel12.setVisible(false);
        jLabel13.setVisible(false);
        jLabel14.setVisible(false);
        day.setVisible(false);
        month.setVisible(false);
        year.setVisible(false);
        jLabel15.setVisible(false);
        jLabel16.setVisible(false);
        hours.setVisible(false);
        minutes.setVisible(false);
        jLabel17.setVisible(false);
        title.setVisible(false);
        add_button.setVisible(false);
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
    public static String[] years(){
      String years[] = new String[150];
      int year = Calendar.getInstance().get(Calendar.YEAR)-150;
      for (int i = 1; i < years.length; i++) {
        years[i]= String.valueOf(year);
        year++;        	
      }
      return years;    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        currentDate = new javax.swing.JLabel();
        currentTime = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        grouptask = new javax.swing.JRadioButton();
        personaltask = new javax.swing.JRadioButton();
        reminder = new javax.swing.JRadioButton();
        ok_button = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        due_day = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        due_month = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        due_year = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        reminder_text = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        description = new javax.swing.JTextField();
        day = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        month = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        year = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        hours = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        minutes = new javax.swing.JComboBox();
        event = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        title = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < Employee.employees.size(); i++) {
        	model.addElement(Employee.employees.get(i).getNameSurname());
        }
        people_list = new javax.swing.JList(model);
        add_button = new javax.swing.JButton();
        warning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(TaskOrReminderWindow1.class.getResource("/images/smallLogo.PNG")));

        jPanel2.setBackground(new java.awt.Color(255, 222, 89));
        jPanel2.setToolTipText("");
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel5.setText("Today");

        currentDate.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        currentDate.setText("DATE: ");
        currentDate.setAlignmentY(0.0F);

        currentTime.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        currentTime.setText("TIME: ");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel6.setText("Add to Program");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busyb.jpg"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jLabel8.setText("Add to your program:");

        grouptask.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        grouptask.setText("  Group Task");
        grouptask.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        personaltask.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        personaltask.setText("  Personal Task");
        personaltask.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        reminder.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        reminder.setText("  Reminder");
        reminder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ok_button.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        ok_button.setText("OK");
        ok_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ok_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ok_buttonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel2.setText("Add people in the Group Task:");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        jLabel1.setText("Home");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel3.setText("Due Date:");

        due_day.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        due_day.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" })
        );
        due_day.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        due_day.setSelectedIndex(-1);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel4.setText("/");

        due_month.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        due_month.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        due_month.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        due_month.setSelectedIndex(-1);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel9.setText("/");

        due_year.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        due_year.setModel(new javax.swing.DefaultComboBoxModel(MyCalendar.year));

        jLabel10.setFont(new java.awt.Font("Arial", 3, 20)); // NOI18N
        jLabel10.setText("Don't forget!");

        reminder_text.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        reminder_text.setSelectionColor(new java.awt.Color(0, 0, 0));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel11.setText("Description:");

        day.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        day.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" })
        );
        day.setSelectedIndex(-1);

        jLabel12.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel12.setText("Date:");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel13.setText("/");

        month.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        month.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        month.setSelectedIndex(-1);

        jLabel14.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel14.setText("/");

        year.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        year.setModel(new javax.swing.DefaultComboBoxModel(MyCalendar.year));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel15.setText("Time:");

        hours.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        hours.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
        hours.setSelectedIndex(-1);
        
        jLabel16.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel16.setText(":");

        minutes.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        minutes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        minutes.setSelectedIndex(-1);
        
        event.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        event.setText("Event");
        event.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel17.setText("Title:");

        title.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        title.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        title.setSelectionColor(new java.awt.Color(0, 0, 0));

        people_list.setSelectionMode(DefaultListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(people_list);

        add_button.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        add_button.setText("Add");
        add_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add_button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_buttonMouseClicked(evt);
            }
        });

        warning.setFont(new java.awt.Font("Arial", 2, 13)); // NOI18N
        warning.setForeground(new java.awt.Color(255, 0, 0));
        warning.setText("Invalid insert! Please insert again.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(currentDate)
                            .addComponent(currentTime))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(671, 671, 671)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(570, 570, 570)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(18, 18, 18)
                                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(due_day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(due_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(due_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(353, 353, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(929, 929, 929)
                        .addComponent(ok_button))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(682, 682, 682)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(reminder_text, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(871, 871, 871)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(grouptask, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(personaltask)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(event, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(reminder, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(858, 858, 858)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(925, 925, 925)
                        .addComponent(add_button)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(warning)
                        .addGap(520, 520, 520))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1)))
                        .addGap(21, 21, 21)
                        .addComponent(currentDate))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentTime)
                .addGap(22, 22, 22)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(grouptask)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(personaltask)
                .addGap(10, 10, 10)
                .addComponent(reminder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(event)
                .addGap(26, 26, 26)
                .addComponent(ok_button)
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(hours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(minutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(due_day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(due_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(due_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reminder_text, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addGap(45, 45, 45)
                .addComponent(add_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        currentDate.getAccessibleContext().setAccessibleName("Date:");
        currentTime.getAccessibleContext().setAccessibleName("Time:");

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void ok_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ok_buttonActionPerformed
        // TODO add your handling code here:
        if (grouptask.isSelected()) {
            add_button.setVisible(true);
            jLabel2.setVisible(true);
            people_list.setVisible(true);
            jScrollPane1.setVisible(true);
            jLabel3.setVisible(true);
            jLabel4.setVisible(true);
            jLabel9.setVisible(true);
            due_day.setVisible(true);
            due_month.setVisible(true);
            due_year.setVisible(true);
            jLabel10.setVisible(false);
            reminder_text.setVisible(false);
            jLabel11.setVisible(true);
            description.setVisible(true);
            jLabel12.setVisible(false);
            jLabel13.setVisible(false);
            jLabel14.setVisible(false);
            day.setVisible(false);
            month.setVisible(false);
            year.setVisible(false);
            jLabel15.setVisible(false);
            jLabel16.setVisible(false);
            hours.setVisible(false);
            minutes.setVisible(false);
            jLabel17.setVisible(false);
            title.setVisible(false);
        } else if (personaltask.isSelected()) {
            add_button.setVisible(true);
            jLabel2.setVisible(false);
            people_list.setVisible(false);
            jScrollPane1.setVisible(false);
            jLabel3.setVisible(true);
            jLabel4.setVisible(true);
            jLabel9.setVisible(true);
            due_day.setVisible(true);
            due_month.setVisible(true);
            due_year.setVisible(true);
            jLabel10.setVisible(false);
            reminder_text.setVisible(false);
            jLabel11.setVisible(true);
            description.setVisible(true);
            jLabel12.setVisible(false);
            jLabel13.setVisible(false);
            jLabel14.setVisible(false);
            day.setVisible(false);
            month.setVisible(false);
            year.setVisible(false);
            jLabel15.setVisible(false);
            jLabel16.setVisible(false);
            hours.setVisible(false);
            minutes.setVisible(false);
            jLabel17.setVisible(false);
            title.setVisible(false);
        } else if (reminder.isSelected()) {
            add_button.setVisible(true);
            jLabel2.setVisible(false);
            people_list.setVisible(false);
            jScrollPane1.setVisible(false);
            jLabel3.setVisible(false);
            jLabel4.setVisible(false);
            jLabel9.setVisible(false);
            due_day.setVisible(false);
            due_month.setVisible(false);
            due_year.setVisible(false);
            jLabel10.setVisible(true);
            reminder_text.setVisible(true);
            jLabel11.setVisible(false);
            description.setVisible(false);
            jLabel12.setVisible(true);
            jLabel13.setVisible(true);
            jLabel14.setVisible(true);
            day.setVisible(true);
            month.setVisible(true);
            year.setVisible(true);
            jLabel15.setVisible(true);
            jLabel16.setVisible(true);
            hours.setVisible(true);
            minutes.setVisible(true);
            jLabel17.setVisible(false);
            title.setVisible(false);
        } else if (event.isSelected()) {
            add_button.setVisible(true);
            jLabel2.setVisible(false);
            people_list.setVisible(false);
            jScrollPane1.setVisible(false);
            jLabel3.setVisible(false);
            jLabel4.setVisible(false);
            jLabel9.setVisible(false);
            due_day.setVisible(false);
            due_month.setVisible(false);
            due_year.setVisible(false);
            jLabel10.setVisible(false);
            reminder_text.setVisible(false);
            description.setVisible(true);
            jLabel11.setVisible(true);
            jLabel12.setVisible(true);
            jLabel13.setVisible(true);
            jLabel14.setVisible(true);
            day.setVisible(true);
            month.setVisible(true);
            year.setVisible(true);
            jLabel15.setVisible(true);
            jLabel16.setVisible(true);
            hours.setVisible(true);
            minutes.setVisible(true);
            jLabel17.setVisible(true);
            title.setVisible(true);
        }


    }//GEN-LAST:event_ok_buttonActionPerformed
        private void add_buttonMouseClicked(java.awt.event.MouseEvent evt) {
        warning.setVisible(false);
        if (grouptask.isSelected()){            
            ArrayList <String> empls = new ArrayList <String>();
            int[] emloyeesIndices = people_list.getSelectedIndices();                                           
            for (int i = 0; i < emloyeesIndices.length; i++) {
                    Employee em = Employee.employees.get(emloyeesIndices[i]);
                    empls.add(em.getID());                   
                }
            String desc = description.getText();
            String date2 = due_day.getSelectedItem().toString() + "/" + 
                        due_month.getSelectedItem().toString() + "/" +
                        due_year.getSelectedItem().toString();
            if (!Day.validDate(date2))
                warning.setVisible(true);
            else {
            	Calendar c = Calendar.getInstance();
                String startDate = c.get(Calendar.DAY_OF_MONTH) + "/" + (c.get(Calendar.MONTH) + 1) + "/" 
                        +c.get(Calendar.YEAR);
                Task t1 = new Task(startDate, date2, desc, 0, 0, empls);  
            }
        } else if (personaltask.isSelected()){
            String desc = description.getText();
            String date2 = due_day.getSelectedItem().toString() + "/" + 
                        due_month.getSelectedItem().toString() + "/" +
                        due_year.getSelectedItem().toString();
            if (!Day.validDate(date2))
                warning.setVisible(true);
            else {
            	Calendar c = Calendar.getInstance();
                String startDate = c.get(Calendar.DAY_OF_MONTH) + "/" + (c.get(Calendar.MONTH) + 1) + "/" 
                        +c.get(Calendar.YEAR);
                Task t = new Task(startDate, date2, desc, 0, 0, emp.getID());             
            }
        } else if (reminder.isSelected() || event.isSelected()){
            String desc = description.getText();
            String time = hours.getSelectedItem().toString() + "/" +
                    minutes.getSelectedItem().toString();
            String date2 = due_day.getSelectedItem().toString() + "/" + 
                        due_month.getSelectedItem().toString() + "/" +
                        due_year.getSelectedItem().toString();
            if (!Day.validDate(date2))
                warning.setVisible(true);
            else {
                ArrayList<String> employee = new ArrayList<String>();
                    employee.add(emp.getID());
                if (reminder.isSelected()){
                    Event e = new Event("", date2, time, desc, "reminder", employee);
                }
                else {
                  Event e = new Event (title.getText(), date2, time, desc, "" , employee);
                }
            }
        } 
        
    }

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        new FirstWindow(emp).setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jLabel1MouseClicked

    private void groupButton() {

        ButtonGroup bg1 = new ButtonGroup();

        bg1.add(grouptask);
        bg1.add(personaltask);
        bg1.add(reminder);
        bg1.add(event);

    }
    private javax.swing.JButton add_button;
    private javax.swing.JLabel currentDate;
    private javax.swing.JLabel currentTime;
    private javax.swing.JComboBox day;
    private javax.swing.JTextField description;
    private javax.swing.JComboBox due_day;
    private javax.swing.JComboBox due_month;
    private javax.swing.JComboBox due_year;
    private javax.swing.JRadioButton event;
    private javax.swing.JRadioButton grouptask;
    private javax.swing.JComboBox hours;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox minutes;
    private javax.swing.JComboBox month;
    private javax.swing.JButton ok_button;
    private javax.swing.JList people_list;
    private javax.swing.JRadioButton personaltask;
    private javax.swing.JRadioButton reminder;
    private javax.swing.JTextField reminder_text;
    private javax.swing.JTextField title;
    private javax.swing.JLabel warning;
    private javax.swing.JComboBox year;
}
