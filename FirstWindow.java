
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BusyB
 */
public final class FirstWindow extends javax.swing.JFrame {

    /**
     * Creates new form FirstWindow
     */
    private final Employee emp;
    private final int num;
    public FirstWindow(Employee emp) {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.num = Account.typeOfEmployee(emp);
        this.emp = emp;
        initComponents();
        ShowDate();
        ShowTime();        
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
                time.setText(s.format(d));
               
            }
               
        }
        ).start();
    }
  
     /** This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        busyb = new javax.swing.JLabel();
        arrow1 = new javax.swing.JLabel();
        arrow2 = new javax.swing.JLabel();
        arrow3 = new javax.swing.JLabel();
        arrow4 = new javax.swing.JLabel();
        if ( num != 4 && num != 5 && num != 3) {
            arrow4.setText("Notifications");
            arrow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow_right.png")));
        } else {
            arrow4.setText("Create Event or Add Task");
            arrow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow_right.png")));
        }
        arrow5 = new javax.swing.JLabel();
        if (num != 3 && num != 4)
        arrow5.setText("My Evaluation");
        else
        arrow5.setText("Manage Departments");
        arrow6 = new javax.swing.JLabel();
        if (num == 1)
            arrow6.setText("");
        else if (num == 5) {
            arrow6.setFont(new java.awt.Font("Arial", 1, 24));
            arrow6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow_right.png")));
            arrow6.setText("Notifications");
            arrow6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));	
        } else if (num == 3 || num == 4) {
            arrow6.setFont(new java.awt.Font("Arial", 1, 24));
            arrow6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow_right.png")));
            arrow6.setText("My Evaluation");
            arrow6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        } else {
            arrow6.setFont(new java.awt.Font("Arial", 1, 24));
            arrow6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow_right.png")));
            arrow6.setText("Manage Employees");
            arrow6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }
        arrow7 = new javax.swing.JLabel();
        if (num == 4){
            arrow7.setFont(new java.awt.Font("Arial", 1, 24));
            arrow7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow_right.png")));
            arrow7.setText("Manage Employees");
            arrow7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        } else if (num == 3) {
            arrow7.setFont(new java.awt.Font("Arial", 1, 24));
            arrow7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow_right.png")));
            arrow7.setText("Notifications");
            arrow7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }
        arrow8 = new javax.swing.JLabel();
        if (num == 4) {
        	arrow8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow_right.png")));
            arrow8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N	
            arrow8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));	
            arrow8.setText("Notifications");
        }
        settings = new javax.swing.JLabel();
        today = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        date1 = new javax.swing.JLabel();
        sortBy = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
                       
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(date);
        DefaultListModel model1 = new DefaultListModel();
        ArrayList<Task> tasks = new ArrayList<Task>();
        if (emp.getCalendar().get(0).getDailyProgram().isEmpty())
        	 model1.addElement("No Tasks for Today");
        else {
	        for (int i = 0; i < emp.getCalendar().get(0).getDailyProgram().size(); i++){
	            if (emp.getCalendar().get(0).getDailyProgram().get(i) instanceof Task)
	            tasks.add((Task) emp.getCalendar().get(0).getDailyProgram().get(i));
	        }
	                    tasks = Task.sortByDate(tasks);
           for (Task task : tasks) {
        	   if (task.getImportance() == 0 && task.getDifficulty() == 0) {
                   model1.addElement(task.toStringSimpleTask());
               } else {
                   model1.addElement(task.toStringEvaluatedTask());
               }
           }
        }
        tasksList = new javax.swing.JList(); 
        events = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        eventsList2 = new javax.swing.JList();        
        ArrayList<String> eventsList = new ArrayList<String>();
        DefaultListModel model2 = new DefaultListModel();
        if (!emp.getCalendar().get(0).getDailyProgram().isEmpty()){
            for (int i = 0; i < emp.getCalendar().get(0).getDailyProgram().size(); i++){
                if (emp.getCalendar().get(0).getDailyProgram().get(i) instanceof Event){
                    Event ev = (Event) emp.getCalendar().get(0).getDailyProgram().get(i);
                    if(ev.getType().equals(""))
                    	eventsList.add(ev.toString());
                    else
                    	eventsList.add(ev.toStringWithType());
                }
            }
           for (String eventsList1 : eventsList) {
            model2.addElement(eventsList1);
           }
        } else if (eventsList.isEmpty())
        	model2.addElement("No events or reminders for today");       
        jLabelTeam = new javax.swing.JLabel();
        if (num != 3 && num != 4) {
            jLabelTeam.setText("");
        } else {
            jLabelTeam.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            jLabelTeam.setFont(new java.awt.Font("Arial", 1, 24));
            jLabelTeam.setText("Team");
        }
        jLabelTimeOffs = new javax.swing.JLabel();
        if ( num != 2 && num != 4)
        jLabelTimeOffs.setText("");
        else {
            jLabelTimeOffs.setFont(new java.awt.Font("Arial", 1, 24));
            jLabelTimeOffs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            jLabelTimeOffs.setText("Requests");
        }
        jLabelPayrolls = new javax.swing.JLabel();
        if ( num != 2 && num != 4)
        jLabelPayrolls.setText("");
        else {
            jLabelPayrolls.setFont(new java.awt.Font("Arial", 1, 24));
            jLabelPayrolls.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            jLabelPayrolls.setText("Payroll");
        }
        jComboBox2 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(FirstWindow.class.getResource("/images/smallLogo.PNG")));

        jPanel1.setBackground(new java.awt.Color(255, 242, 142));

        jPanel2.setBackground(new java.awt.Color(255, 222, 89));

        busyb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busyb.jpg"))); // NOI18N

        arrow1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        arrow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow_right.png"))); // NOI18N
        arrow1.setText("Show Calendar");
        arrow1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        arrow1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arrow1MouseClicked(evt);
            }
        });

        arrow2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        arrow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow_right.png"))); // NOI18N
        arrow2.setText("Add To Program");
        arrow2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        arrow2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arrow2MouseClicked(evt);
            }
        });

        arrow3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        arrow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow_right.png"))); // NOI18N
        arrow3.setText("Vacation Request");
        arrow3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        arrow3.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arrow3MouseClicked(evt);
            }
        });

        arrow4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        arrow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow_right.png"))); // NOI18N
        arrow4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        arrow4.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arrow4MouseClicked(evt);
            }
        });

        arrow5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        arrow5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow_right.png"))); // NOI18N
        arrow5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        arrow5.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arrow5MouseClicked(evt);
            }
        });

        arrow6.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arrow6MouseClicked(evt);
            }
        });

        arrow7.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arrow7MouseClicked(evt);
            }
        });

        arrow8.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arrow8MouseClicked(evt);
            }
        });

        settings.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settings.png"))); // NOI18N
        settings.setText("Settings");
        settings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        settings.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(settings, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(busyb, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(arrow6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(arrow3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(arrow1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arrow2)
                    .addComponent(arrow4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(arrow5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(arrow7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(arrow8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(511, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(arrow1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(arrow2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(arrow3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(arrow4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(arrow5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(arrow6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(arrow7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(arrow8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(busyb, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(settings)))
        );

        today.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        today.setText("Today");

        time.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        time.setText("Time");

        date1.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        date1.setText("Date");

        sortBy.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        sortBy.setText("Sort by:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Task and Reminders");

        tasksList.setModel(model1);
        jScrollPane1.setViewportView(tasksList);

        events.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        events.setText("Events");

        eventsList2.setModel(model2);
        jScrollPane2.setViewportView(eventsList2);

        jLabelTeam.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTeamMouseClicked(evt);
            }
        });

        jLabelTimeOffs.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTimeOffsMouseClicked(evt);
            }
        });

        jLabelPayrolls.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPayrollsMouseClicked(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Date", "Description", "Level Of importance" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel1.setText("Today's program");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(today, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(date1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(time, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(events)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTimeOffs, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPayrolls, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(sortBy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(today, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sortBy)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(events)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabelTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelTimeOffs, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPayrolls, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>                        

    private void arrow1MouseClicked(java.awt.event.MouseEvent evt) {                                    
        new MyCalendar(num, emp).setVisible(true);            
        this.setVisible(false);// TODO add your handling code here:
    }                                   

    private void arrow2MouseClicked(java.awt.event.MouseEvent evt) {                                    
        new TaskOrReminderWindow1(num, emp).setVisible(true);
        this.setVisible(false);// TODO add your handling code here:
    }                                

    private void arrow3MouseClicked(java.awt.event.MouseEvent evt) {                                    
        new VacationRequest(num, emp).setVisible(true);        
        this.setVisible(false);// TODO add your handling code here:
    }                                   

    private void arrow4MouseClicked(java.awt.event.MouseEvent evt) {                                    
         if ( num != 1 && num != 2){
           new CrEventOrAddTask(num, emp).setVisible(true);
        } else 
            new Notifications(emp).setVisible(true);
        this.setVisible(false);// TODO add your handling code here:
    }                                   

    private void arrow5MouseClicked(java.awt.event.MouseEvent evt) {                                    
        if ( num != 3 && num != 4)
            new MyEvaluation(num, emp).setVisible(true);
        else 
            new ShowDepartments(num, emp).setVisible(true);            
        this.setVisible(false);// TODO add your handling code here:
    }                                   

    private void jLabelTeamMouseClicked(java.awt.event.MouseEvent evt) {                                        
        if (num == 3 || num == 4)
            new Team(num, emp).setVisible(true);
        this.setVisible(false);// TODO add your handling code here:
    }                                       

    private void jLabelTimeOffsMouseClicked(java.awt.event.MouseEvent evt) {                                            
       if ( num == 2 || num == 4)
            new VacationRequests(num, emp).setVisible(true);
        this.setVisible(false);  // TODO add your handling code here:
    }                                           

    private void jLabelPayrollsMouseClicked(java.awt.event.MouseEvent evt) {                                            
        if ( num == 2|| num == 4)
           new SalaryWindow(num,emp).setVisible(true);
        this.setVisible(false);// TODO add your handling code here:
    }                                           

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(date);
        ArrayList<Task> tasks = new ArrayList<Task>();
        for (int i = 0; i < emp.getCalendar().get(0).getDailyProgram().size(); i++){
            if (emp.getCalendar().get(0).getDailyProgram().get(i) instanceof Task)
                tasks.add((Task) emp.getCalendar().get(0).getDailyProgram().get(i));
        }
        DefaultListModel model = new DefaultListModel();
        if (tasks.isEmpty()){
            model.addElement("No Tasks for today");
        } else {
            int i;
            if(jComboBox2.getSelectedIndex() == 0){
                model.removeAllElements();
                tasks = Task.sortByDate(tasks);
            } else if (jComboBox2.getSelectedIndex() == 1){
                model.removeAllElements();
                tasks = Task.sortByDesc(tasks);
            } else {
                model.removeAllElements();
                tasks = Task.sortByImp(tasks);
            }
            for (i = 0; i < tasks.size(); i++){
            	if (tasks.get(i).getImportance() == 0 && tasks.get(i).getDifficulty() == 0)
                    model.addElement(tasks.get(i).toStringSimpleTask());
                else 
                    model.addElement(tasks.get(i).toStringEvaluatedTask());
            }
        }
        tasksList.setModel(model);// TODO add your handling code here:
    }                                          

    private void arrow6MouseClicked(java.awt.event.MouseEvent evt) {                                    
       if (num == 3 || num == 4) {
            new MyEvaluation(num, emp).setVisible(true);
       } else if (num == 2)
           new EmployeeEditing(num,emp).setVisible(true);
       else if (num == 5)
           new Notifications(emp).setVisible(true);
       this.setVisible(false); // TODO add your handling code here:
    }                                   

    private void arrow7MouseClicked(java.awt.event.MouseEvent evt) {                                    
        if (num == 4)
            new EmployeeEditing(num,emp).setVisible(true);
        else if (num == 3)
        	new Notifications(emp).setVisible(true);        
        this.setVisible(false);
        // TODO add your handling code here:
    }                                   

    private void arrow8MouseClicked(java.awt.event.MouseEvent evt) {                                    
        if(num == 4) {
            new Notifications(emp).setVisible(true);
            this.setVisible(false);
        }// TODO add your handling code here:
    }                                   

    private void settingsMouseClicked(java.awt.event.MouseEvent evt) {                                      
        new SettingsWindow(num, emp).setVisible(true);
        this.setVisible(false);// TODO add your handling code here:
    }                                     

       // Variables declaration - do not modify//GEN-BEGIN:variables
      private javax.swing.JLabel arrow1;
    private javax.swing.JLabel arrow2;
    private javax.swing.JLabel arrow3;
    private javax.swing.JLabel arrow4;
    private javax.swing.JLabel arrow5;
    private javax.swing.JLabel arrow6;
    private javax.swing.JLabel arrow7;
    private javax.swing.JLabel arrow8;
    private javax.swing.JLabel busyb;
    private javax.swing.JLabel date1;
    private javax.swing.JLabel events;
    private javax.swing.JList eventsList2;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelPayrolls;
    private javax.swing.JLabel jLabelTeam;
    private javax.swing.JLabel jLabelTimeOffs;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel settings;
    private javax.swing.JLabel sortBy;
    private javax.swing.JList tasksList;
    private javax.swing.JLabel time;
    private javax.swing.JLabel today;
    // End of variables declaration//GEN-END:variables
}
