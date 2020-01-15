package gr.aueb.dmst.ProgrammingII.BusyB.BusyB;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author BusyB
 */
public class MyCalendar extends javax.swing.JFrame {

    protected static String year[] = years();
    private final int n;
    private final Employee emp;
    public MyCalendar(int n, Employee emp) {
        this.emp = emp;
        this.n = n;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        ShowDate();
        ShowTime();
        dateNot.setVisible(false);        
    }
    void ShowDate(){
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("EEEE dd-MM-yyyy");
        date1.setText(s.format(d)); 
    }
    void ShowTime(){
        new Timer(0, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              Date d = new Date();
              SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
              time1.setText(s.format(d));
            }
        }
        ).start();
    }
    public static String[] years(){
      String years[] = new String[100];
      int y;
        y = Calendar.getInstance().get(Calendar.YEAR);
      for (int i = 1; i < years.length; i++) {
        years[i]= String.valueOf(y);
        y++;
      }
      return years;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        today = new javax.swing.JLabel();
        time1 = new javax.swing.JLabel();
        date1 = new javax.swing.JLabel();
        showCale = new javax.swing.JLabel();
        select = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        days = new javax.swing.JComboBox();
        days.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        days.setSelectedIndex(day-1);
        slash1 = new javax.swing.JLabel();
        month = new javax.swing.JComboBox();
        month.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        int month1 = c.get(Calendar.MONTH);
        month.setSelectedIndex(month1);
        slash2 = new javax.swing.JLabel();
        years = new javax.swing.JComboBox();
        years.setModel(new javax.swing.DefaultComboBoxModel(year));
        int year1 = c.get(Calendar.YEAR);
        years.setSelectedItem(String.valueOf(year1));
        jLabel13 = new javax.swing.JLabel();
        OKButton = new javax.swing.JButton();
        dateNot = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        eventsAndRem = new javax.swing.JLabel();	
        jScrollPane1 = new javax.swing.JScrollPane();	
        eventList = new javax.swing.JList();
        ArrayList<Event> eventsList = Event.onlyEventsList(emp.getCalendar().get(0).getDailyProgram());
        eventsList = Event.sortByTime(eventsList);
        if (!eventsList.isEmpty()){
            for (Event eventsList1 : eventsList) {
            	if (eventsList1.getType().equals(""))
            		model2.addElement(eventsList1.toString());
            	else
            		model2.addElement(eventsList1.toStringWithType());
            }
        } else 
            model2.addElement("No events or reminders for today");
        tasksLabel = new javax.swing.JLabel();	
        jScrollPane2 = new javax.swing.JScrollPane();	
        taskList = new javax.swing.JList();	
        ArrayList<Task> tasks = new ArrayList<Task>();
        tasks = Task.onlyTasksList(emp.getCalendar().get(0).getDailyProgram());               
        if (tasks.isEmpty()){
            model1.addElement("No Tasks for today");
        } else {
            int i;
            if(jComboBox1.getSelectedIndex() == 0) {
            	model1.removeAllElements();
                tasks = Task.sortByDate(tasks);
            } else if (jComboBox1.getSelectedIndex() == 1){
            	model1.removeAllElements();
                tasks = Task.sortByImp(tasks);
            }
            for (i = 0; i < tasks.size(); i++){
                if (tasks.get(i).getImportance() == 0 && tasks.get(i).getDifficulty() == 0)
                    model1.addElement(tasks.get(i).toStringSimpleTask());
                else 
                    model1.addElement(tasks.get(i).toStringEvaluatedTask());
            }
        }
        doneButton = new javax.swing.JButton();
        help = new javax.swing.JLabel();
        	
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 222, 89));
        setIconImage(Toolkit.getDefaultToolkit().getImage(MyCalendar.class.getResource("/images/smallLogo.PNG")));

        jPanel1.setBackground(new java.awt.Color(255, 222, 89));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busyb.jpg"))); // NOI18N

        today.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        today.setText("Today");

        time1.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        time1.setText("Time");

        date1.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        date1.setText("Date");

        showCale.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        showCale.setText("Show Calendar");

        select.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        select.setText("Select date:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 0, 255));
        jLabel4.setText("here");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("If you want to add Task, Event or Reminder to your Program press");

        
        slash1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        slash1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        slash1.setText("/");

        

        slash2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        slash2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        slash2.setText("/");

        

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

        OKButton.setText("OK");
        OKButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OKButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OKButtonMouseClicked(evt);
            }
        });

        dateNot.setForeground(new java.awt.Color(255, 0, 0));
        dateNot.setText("Not valid date. Please try again!");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Sort by:");
        doneButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        doneButton.setText("Done");   
        doneButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        doneButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doneButtonMouseClicked(evt);
            }
        });

        help.setText("Please select every task that is completed and then click Done Button!");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Date","Importance" }));
        jComboBox1.setSelectedIndex(0);
        eventsAndRem.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N	
        eventsAndRem.setText("Events and Reminders");	
        eventList.setModel(model2);
        jScrollPane1.setViewportView(eventList);	
        tasksLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N	
        tasksLabel.setText("Tasks");	
        taskList.setModel(model1);	
        jScrollPane2.setViewportView(taskList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(time1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(today, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(date1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)	
                            .addGroup(jPanel1Layout.createSequentialGroup()	
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)	
                                    .addComponent(showCale)	
                                    .addGroup(jPanel1Layout.createSequentialGroup()	
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)	
                                            .addGroup(jPanel1Layout.createSequentialGroup()	
                                                .addComponent(select)	
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))	
                                            .addGroup(jPanel1Layout.createSequentialGroup()	
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)	
                                                .addGap(27, 27, 27)))	
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)	
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)	
                                            .addGroup(jPanel1Layout.createSequentialGroup()	
                                                .addComponent(days, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)	
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)	
                                                .addComponent(slash1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)	
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)	
                                                .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)	
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)	
                                                .addComponent(slash2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)	
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)	
                                                .addComponent(years, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))	
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()	
                                        .addGap(10, 10, 10)	
                                        .addComponent(eventsAndRem)))	
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)	
                                    .addGroup(jPanel1Layout.createSequentialGroup()	
                                        .addGap(628, 628, 628)	
                                        .addComponent(jLabel13))	
                                    .addGroup(jPanel1Layout.createSequentialGroup()	
                                        .addGap(18, 18, 18)	
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)	
                                            .addComponent(dateNot)	
                                            .addGroup(jPanel1Layout.createSequentialGroup()	
                                                .addGap(48, 48, 48)	
                                                .addComponent(OKButton))))))	
                            .addGroup(jPanel1Layout.createSequentialGroup()	
                                .addGap(10, 10, 10)	
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)	
                                    .addComponent(tasksLabel)	
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)	
                                        .addGap(32, 32, 32)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(doneButton)
                                            .addComponent(help)))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))))))	
                .addContainerGap())
            );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(today)
                            .addComponent(showCale)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(days, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(select)
                            .addComponent(slash1)
                            .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(slash2)
                            .addComponent(years, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OKButton)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(time1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateNot, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)	
                .addComponent(eventsAndRem)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(help)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(doneButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tasksLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 426, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        new FirstWindow(emp).setVisible(true);        
        this.setVisible(false);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        new TaskOrReminderWindow1(n, emp).setVisible(true);        
        this.setVisible(false);
    }//GEN-LAST:event_jLabel4MouseClicked
    
    private void OKButtonMouseClicked(java.awt.event.MouseEvent evt) { 
        String date2;
        taskList.setVisible(false);
		jScrollPane2.setVisible(false);
		tasksLabel.setVisible(false);
		doneButton.setVisible(false);	
		help.setVisible(false);
		jLabel2.setVisible(false);
		jComboBox1.setVisible(false);
        if (days.getSelectedIndex() == -1  || month.getSelectedIndex()  == -1
                || years.getSelectedIndex() == -1)
            dateNot.setVisible(true);
        else {
            dateNot.setVisible(false);
            date2 = days.getSelectedItem().toString() + "/" + 
                        month.getSelectedItem().toString() + "/" +
                        years.getSelectedItem().toString();
            if (!Day.validDate(date2))
                dateNot.setVisible(true);
            else {
            	taskList.setVisible(false);
        		jScrollPane2.setVisible(false);
        		tasksLabel.setVisible(false);
        		doneButton.setVisible(false);	
        		help.setVisible(false);
        	    model2.removeAllElements();
            ArrayList<Event> eventsList = Event.onlyEventsList(emp.searchDay(date2).getDailyProgram());
            eventsList = Event.sortByTime(eventsList);
            if (!eventsList.isEmpty()){
                for (Event eventsList1 : eventsList) {
                	if (eventsList1.getType().equals(""))
                		model2.addElement(eventsList1.toString());
                	else
                		model2.addElement(eventsList1.toStringWithType());
                }                    
            } else 
                model2.addElement("No events or reminders for today");
            eventList.setModel(model2);
            	if (emp.getCalendar().get(0).equals(emp.searchDay(date2))) {
	                model1.removeAllElements();	                
	                dateNot.setVisible(false);
	                ArrayList<Task> tasks = new ArrayList<Task>();
	                tasks = Task.onlyTasksList(emp.searchDay(date2).getDailyProgram());               
	                if (tasks.isEmpty()){
	                    model1.addElement("No Tasks for today");
	                } else {
	                    int i;
	                    if(jComboBox1.getSelectedIndex() == 0){
	                    	model1.removeAllElements();
	                        tasks = Task.sortByDate(tasks);
	                    } else if (jComboBox1.getSelectedIndex() == 1){
	                    	model1.removeAllElements();
	                        tasks = Task.sortByImp(tasks);
	                    }
	                    for (i = 0; i < tasks.size(); i++){
	                        if (tasks.get(i).getImportance() == 0 && tasks.get(i).getDifficulty() == 0)
	                            model1.addElement(tasks.get(i).toStringSimpleTask());
	                        else 
	                            model1.addElement(tasks.get(i).toStringEvaluatedTask());
	                    }
	                }
	                taskList.setModel(model1);
	                taskList.setVisible(true);
            		jScrollPane2.setVisible(true);
            		tasksLabel.setVisible(true);
            		doneButton.setVisible(true);
            		help.setVisible(true);
            	}
            }
        }
    }
    private void doneButtonMouseClicked(java.awt.event.MouseEvent evt) { 
        String date2;
        date2 = days.getSelectedItem().toString() + "/" + 
                month.getSelectedItem().toString() + "/" +
                years.getSelectedItem().toString();
        ArrayList<Task> tasks = new ArrayList<Task>();
        tasks = Task.onlyTasksList(emp.searchDay(date2).getDailyProgram());
        if (!tasks.isEmpty()) {
	        int[] tasksIndices = taskList.getSelectedIndices();
	        ArrayList<String> taskToString = new ArrayList<String>();
	        for (int i = 0; i < tasksIndices.length; i++) {
	        	taskToString.add(taskList.getModel().getElementAt(tasksIndices[i]).toString());
	        }
	        for (int i = 0; i < taskToString.size(); i++) {
	            String s = taskToString.get(i);
	            Task.searchTask(s, tasks).setStatus(true);
	        }
        }
        model1.removeAllElements();
        dateNot.setVisible(false);
        if (tasks.isEmpty()){
            model1.addElement("No Tasks for today");
        } else {
            if(jComboBox1.getSelectedIndex() == 0) {
                tasks = Task.sortByDate(tasks);
            } else if (jComboBox1.getSelectedIndex() == 1) {
                tasks = Task.sortByDesc(tasks);
            } else {
                tasks = Task.sortByImp(tasks);
            }
            for (Task task : tasks) {
                if (task.getImportance() == 0 && task.getDifficulty() == 0) {
                    model1.addElement(task.toStringSimpleTask());
                } else {
                    model1.addElement(task.toStringEvaluatedTask());
                }
            }
            }
            eventList.setModel(model1);
    }
    private javax.swing.JButton OKButton;
    private javax.swing.JLabel date1;
    private javax.swing.JLabel dateNot;
    private javax.swing.JComboBox days;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelDPro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox month;
    private javax.swing.JLabel select;
    private javax.swing.JLabel showCale;
    private javax.swing.JLabel slash1;
    private javax.swing.JLabel slash2;
    private javax.swing.JLabel time1;
    private javax.swing.JLabel today;
    private javax.swing.JComboBox years;
    private javax.swing.JLabel eventsAndRem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList eventList;
    private javax.swing.JLabel tasksLabel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList taskList;
    DefaultListModel model1 = new DefaultListModel();
    DefaultListModel model2 = new DefaultListModel();
    private javax.swing.JButton doneButton;
    private javax.swing.JLabel help;
}
