package gr.aueb.dmst.ProgrammingII.BusyB.BusyB;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author BusyB
 */
public class Notifications extends javax.swing.JFrame {

    /**
     * Creates new form Notifications
     */
    Employee emp;
    public Notifications(Employee emp) {
        this.emp = emp;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        ShowDate();
        ShowTime();
    }
    void ShowDate(){
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("EEEE dd-MM-yyyy");
        date1.setText(s.format(d)); 
    }
    void ShowTime() {
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

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        today = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        date1 = new javax.swing.JLabel();
        notifications = new javax.swing.JLabel();
        Tasks = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        vacReqList = new javax.swing.JList();
        DefaultListModel model1 = new DefaultListModel();
        for (int i = 0; i < Request.getVacRequests().size(); i++){
            if (Request.getVacRequests().get(i).getEmpId().equals(emp.getID())){
                String s;
                if (Request.getVacRequests().get(i).isAccepted())
                s = "Your vacation request for " + Request.getVacRequests().get(i).
                getDate() + " has been accepted. Comments:" +
                Request.getVacRequests().get(i).getComments();
                else
                s = "Your vacation request for " + Request.getVacRequests().get(i).
                getDate() + " has been rejected. Comments:" +
                Request.getVacRequests().get(i).getComments();
                model1.addElement(s);
            }

        }
        vacReq = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taskList1 = new javax.swing.JList();
        DefaultListModel model = new DefaultListModel();
        Calendar c = Calendar.getInstance();
        String date = c.get(Calendar.DAY_OF_MONTH) + "/" + c.get(Calendar.MONTH) + "/" 
                +c.get(Calendar.YEAR);
        for (int i = 0; i < Program.allPrograms.size(); i++){
            if (Program.allPrograms.get(i) instanceof Task){
                Task t1 = (Task) Program.allPrograms.get(i);
                if (t1.getStatus() && t1.getEmpID().equals(emp.getID())){
                    String st = "You have completed the Task " + t1.getDesc() + "in time!";
                    model.addElement(st);
                }        
            }
        }
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(Notifications.class.getResource("/images/smallLogo.PNG")));


        jPanel1.setBackground(new java.awt.Color(255, 222, 89));

        today.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        today.setText("Today");

        time.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        time.setText("Time");

        date1.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        date1.setText("Date");

        notifications.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        notifications.setText("Notifications");

        Tasks.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Tasks.setText("Tasks");

        vacReqList.setModel(model1);
        jScrollPane1.setViewportView(vacReqList);

        vacReq.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        vacReq.setText("Vacation Requests");

        taskList1.setModel(model);
        jScrollPane2.setViewportView(taskList1);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busyb.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        jLabel2.setText("Home");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(today, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(265, 265, 265)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Tasks)
                                    .addComponent(vacReq, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(346, 346, 346)
                                .addComponent(notifications, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(today, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(notifications, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Tasks, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(vacReq, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {
        new FirstWindow(emp).setVisible(true);
        this.setVisible(false);
    }
    private javax.swing.JLabel Tasks;
    private javax.swing.JLabel date1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel notifications;
    private javax.swing.JList taskList1;
    private javax.swing.JLabel time;
    private javax.swing.JLabel today;
    private javax.swing.JLabel vacReq;
    private javax.swing.JList vacReqList;
}
