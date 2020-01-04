
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public final class FirstWindow extends javax.swing.JFrame {

    /**
     * Creates new form FirstWindow
     */
    private Employee emp;
    private int num;
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
        currentDate.setText(s.format(d)); 
    }
    void ShowTime(){
        new Timer(0, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                currentTime.setText(s.format(d));
               
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

        try {
            jPanel1 =(javax.swing.JPanel)java.beans.Beans.instantiate(getClass().getClassLoader(), "FirstWindow_jPanel1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        currentDate = new javax.swing.JLabel();
        today_label = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        currentTime = new javax.swing.JLabel();
        jLabelTeam = new javax.swing.JLabel();
        if (num != 3 && num != 4) {
            jLabelTeam.setText("");
        } else {
            jLabelTeam.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            jLabelTeam.setFont(new java.awt.Font("Arial", 1, 24));
            jLabelTeam.setText("Team");
        }
        jLabelPayrolls = new javax.swing.JLabel();
        if ( num != 2 && num != 4)
        jLabelPayrolls.setText("");
        else {
            jLabelPayrolls.setFont(new java.awt.Font("Arial", 1, 24));
            jLabelPayrolls.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            jLabelPayrolls.setText("Payrolls");
        }
        jLabelTimeoffs = new javax.swing.JLabel();
        if ( num != 2 && num != 4)
        jLabelTimeoffs.setText("");
        else {
            jLabelTimeoffs.setFont(new java.awt.Font("Arial", 1, 24));
            jLabelTimeoffs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            jLabelTimeoffs.setText("Time offs");
        }
        SortBy = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        jPanel2 = new javax.swing.JPanel();
        arrow2 = new javax.swing.JLabel();
        arrow3 = new javax.swing.JLabel();
        settings = new javax.swing.JLabel();
        arrow1 = new javax.swing.JLabel();
        arrow4 = new javax.swing.JLabel();
        busyBicon = new javax.swing.JLabel();
        arrow5 = new javax.swing.JLabel();
        if (num != 3 && num != 4)
        arrow5.setText("My Evaluation");
        else
        arrow5.setText("Manage Departments");
        arrow6 = new javax.swing.JLabel();
        if (num != 3 && num !=4)
        arrow6.setText("");
        else {
            arrow6.setFont(new java.awt.Font("Arial", 1, 24));
            arrow6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow_right.png")));
            arrow6.setText("My Evaluation");
            arrow6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(FirstWindow.class.getResource("/images/smallLogo.PNG")));

        currentDate.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        currentDate.setText("Date");

        today_label.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        today_label.setText("TODAY");

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/list (1).png"))); // NOI18N
        jLabel2.setText("To Do List!");

        currentTime.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        currentTime.setText("Time");

        jLabelTeam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTeamMouseClicked(evt);
            }
        });

        jLabelPayrolls.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPayrollsMouseClicked(evt);
            }
        });

        jLabelTimeoffs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTimeoffsMouseClicked(evt);
            }
        });

        SortBy.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        SortBy.setText("Sort By:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Date", "Title", "Level of importance" }));

        jPanel2.setBackground(new java.awt.Color(255, 222, 89));
        jPanel2.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        arrow2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        arrow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow_right.png"))); // NOI18N
        arrow2.setText("Add to Program");
        arrow2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        arrow2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arrow2MouseClicked(evt);
            }
        });

        arrow3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        arrow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow_right.png"))); // NOI18N
        arrow3.setText("Time off Request");
        arrow3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        arrow3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arrow3MouseClicked(evt);
            }
        });

        settings.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settings_icon.png"))); // NOI18N
        settings.setText("Settings");
        settings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        settings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingsMouseClicked(evt);
            }
        });

        arrow1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        arrow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow_right.png"))); // NOI18N
        arrow1.setText("Show Calendar");
        arrow1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        arrow1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arrow1MouseClicked(evt);
            }
        });

        arrow4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        arrow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow_right.png"))); // NOI18N
        arrow4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        arrow4.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                arrow4ComponentAdded(evt);
            }
        });
        arrow4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arrow4MouseClicked(evt);
            }
        });

        busyBicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busyb.jpg"))); // NOI18N

        arrow5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        arrow5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow_right.png"))); // NOI18N
        arrow5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        arrow5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arrow5MouseClicked(evt);
            }
        });

        arrow6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        arrow6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arrow6MouseClicked(evt);
            }
        });

        if ( num != 4 && num != 5 && num != 3) {
            arrow4.setText("Event Request");
            arrow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow_right.png")));
        } else {
            arrow4.setText("Create Event or Add Task");
            arrow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow_right.png")));
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(settings)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(busyBicon))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(arrow1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(arrow2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(arrow6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arrow3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                    .addComponent(arrow4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(arrow5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(384, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(arrow1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(arrow2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(arrow3)
                .addGap(4, 4, 4)
                .addComponent(arrow4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(arrow5)
                .addGap(1, 1, 1)
                .addComponent(arrow6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(busyBicon, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(settings, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(currentTime)
                            .addComponent(today_label)
                            .addComponent(currentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabelTeam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                .addComponent(jLabelPayrolls, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabelTimeoffs, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SortBy, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)))
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(today_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentTime)
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SortBy, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelPayrolls, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTimeoffs, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1612, 907));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void arrow4ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_arrow4ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_arrow4ComponentAdded

    private void arrow3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arrow3MouseClicked
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyCalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyCalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyCalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyCalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TimeOffRequest(num, emp).setVisible(true);
            }
        });
        this.dispose();
    }//GEN-LAST:event_arrow3MouseClicked

    private void arrow1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arrow1MouseClicked
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
         
            public void run() {
                new MyCalendar(num, emp).setVisible(true);
            }
        });
        this.dispose();
    }//GEN-LAST:event_arrow1MouseClicked

    private void arrow4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arrow4MouseClicked
        if ( num != 1 && num != 2){
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrEventOrAddTask(num, emp).setVisible(true);
            }
        });
        } else {
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EventRequest(num, emp).setVisible(true);
            }
        });
        
        
        }
        this.dispose();
    }//GEN-LAST:event_arrow4MouseClicked

    private void arrow5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arrow5MouseClicked
        if ( num != 3 && num != 4){
             java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyEvaluation(num, emp).setVisible(true);
            }
        });
        } else {
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowDepartments(num, emp).setVisible(true);
            }
        });
        }
        this.dispose();
    }//GEN-LAST:event_arrow5MouseClicked

    private void arrow6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arrow6MouseClicked
       if (num == 3 || num == 4) {
             java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyEvaluation(num, emp).setVisible(true);
            }
        });     
       }
        this.dispose();
    }//GEN-LAST:event_arrow6MouseClicked

    private void jLabelTeamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTeamMouseClicked
        if (num == 3 || num == 4) {
         /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Team(num, emp).setVisible(true);
                }
            });
            this.dispose();
        }
        
    }//GEN-LAST:event_jLabelTeamMouseClicked

    private void arrow2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arrow2MouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaskOrReminderWindow1(num, emp).setVisible(true);
            }
        });
        this.dispose();
    }//GEN-LAST:event_arrow2MouseClicked

    private void jLabelTimeoffsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTimeoffsMouseClicked
        if ( num == 2 || num == 4){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TimeOffWindow(num, emp).setVisible(true);
            }
        });
        this.dispose();
        }
    }//GEN-LAST:event_jLabelTimeoffsMouseClicked

    private void jLabelPayrollsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPayrollsMouseClicked
       if ( num == 2|| num == 4){
           java.awt.EventQueue.invokeLater(() -> {
            new SalaryWindow(num,emp).setVisible(true);
        });
           this.dispose();
       }
    }//GEN-LAST:event_jLabelPayrollsMouseClicked

    private void settingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsMouseClicked
        java.awt.EventQueue.invokeLater(() -> {
            new SettingsWindow(num, emp).setVisible(true);
        });
           this.dispose();
    }//GEN-LAST:event_settingsMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FirstWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FirstWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FirstWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FirstWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            Department d = new Department("HR");
            BasicEmployee e = new BasicEmployee("Kostakis", "Mereos", "6971717171", "hdjshdjes@gmail.com", "19/09/2018",1);
		
            public void run() {
                new FirstWindow(e).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SortBy;
    private javax.swing.JLabel arrow1;
    private javax.swing.JLabel arrow2;
    private javax.swing.JLabel arrow3;
    private javax.swing.JLabel arrow4;
    private javax.swing.JLabel arrow5;
    private javax.swing.JLabel arrow6;
    private javax.swing.JLabel busyBicon;
    private javax.swing.JLabel currentDate;
    private javax.swing.JLabel currentTime;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelPayrolls;
    private javax.swing.JLabel jLabelTeam;
    private javax.swing.JLabel jLabelTimeoffs;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel settings;
    private javax.swing.JLabel today_label;
    // End of variables declaration//GEN-END:variables
}
