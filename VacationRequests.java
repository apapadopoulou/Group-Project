import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author BusyB
 */
public class VacationRequests extends javax.swing.JFrame {

    /**
     * Creates new form TimeOffWindow
     */
    private int n;
    private Employee emp;
    
    public VacationRequests(int n, Employee emp) {
        this.n = n;
        this.emp = emp;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        showDate();
        showTime();
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
        currentDate = new javax.swing.JLabel();
        currentTime = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        requests = new javax.swing.JList();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        accept_button = new javax.swing.JButton();
        decline_button = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        comment_field = new javax.swing.JTextField();
        days = new javax.swing.JLabel();
        comments = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        day = new javax.swing.JLabel();
        month = new javax.swing.JLabel();
        year = new javax.swing.JLabel();
        DefaultListModel model = new DefaultListModel();
        if (Request.vacRequests.isEmpty())
        	model.addElement("No requests");
        else {			
	        for (int i = 0; i < Request.vacRequests.size(); i++) {
	        	String employee = Employee.searchEmployeeById(Request.vacRequests.get(i).getEmpId()).getNameSurname();
	        	model.addElement(employee);
	        }
        }
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(VacationRequests.class.getResource("/images/smallLogo.PNG")));

        jPanel1.setBackground(new java.awt.Color(255, 222, 89));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("Vacation requests");

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel2.setText("Today");

        currentDate.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        currentDate.setText("DATE:");

        currentTime.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        currentTime.setText("TIME:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        jLabel3.setText("Home");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busyb.jpg"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel5.setText("Requests:");

        requests.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        requests.setModel(model);
        requests.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        requests.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        requests.setSelectionBackground(new java.awt.Color(0, 0, 0));
        requests.addListSelectionListener(new ListSelectionListener() {
        	public void valueChanged(ListSelectionEvent evt) {
                requestsValueChanged(evt);
              }
        });
        jScrollPane1.setViewportView(requests);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel6.setText("Date:");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel7.setText("Number of days:");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel8.setText("Comments:");

        accept_button.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        accept_button.setText("Accept");
        accept_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accept_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accept_buttonActionPerformed(evt);
            }
        });

        decline_button.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        decline_button.setText("Decline");
        decline_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        decline_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decline_buttonActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel9.setText("Add a comment:");

        comment_field.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        comment_field.setForeground(new java.awt.Color(204, 204, 204));
        comment_field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        comment_field.setText("Optional");
       
        days.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        days.setText("");

        comments.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        comments.setText("");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setText("/");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel13.setText("/");

        day.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        day.setText("");

        month.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        month.setText("");

        year.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        year.setText("");

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
                                .addComponent(currentTime)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 341, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(711, 711, 711)
                                .addComponent(jLabel3)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(currentDate)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(54, 54, 54)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(18, 18, 18)
                                                .addComponent(comments))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(18, 18, 18)
                                                .addComponent(days))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(18, 18, 18)
                                                .addComponent(day)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(month)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(year)))
                                        .addGap(649, 649, 649))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(accept_button)
                                        .addGap(84, 84, 84)
                                        .addComponent(decline_button))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel9))
                                        .addGap(18, 18, 18)
                                        .addComponent(comment_field, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(currentTime)
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel13)
                                            .addComponent(day)
                                            .addComponent(month)
                                            .addComponent(year))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7)
                                            .addComponent(days))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel8)
                                            .addComponent(comments)))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(97, 97, 97)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel9)
                                            .addComponent(comment_field, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(accept_button)
                                            .addComponent(decline_button))
                                        .addGap(189, 189, 189))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        new FirstWindow(emp).setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jLabel3MouseClicked
    private void requestsValueChanged(ListSelectionEvent evt) {
    	Employee emp = Employee.searchEmployeeByName2(requests.getSelectedValue().toString());
    	Request req = Request.searchRequest(emp.getID());
    	day.setText(req.getDate().substring(0, 2));
    	month.setText(req.getDate().substring(3, 5));
    	year.setText(req.getDate().substring(6));
    	days.setText(String.valueOf(req.getDays()));
    	comments.setText(req.getDesc());
    }

    private void decline_buttonActionPerformed(java.awt.event.ActionEvent evt) {
    	Employee emp = Employee.searchEmployeeByName2(requests.getSelectedValue().toString());
    	Request req = Request.searchRequest(emp.getID());
    	req.setAccepted(false);
    	req.setDesc(comment_field.getText()); 
    }
    
    private void accept_buttonActionPerformed(java.awt.event.ActionEvent evt) {
    	Employee emp = Employee.searchEmployeeByName2(requests.getSelectedValue().toString());
    	Request req = Request.searchRequest(emp.getID());
    	req.setAccepted(true);
    	req.setDesc(comment_field.getText());
    }
    private javax.swing.JButton accept_button;
    private javax.swing.JTextField comment_field;
    private javax.swing.JLabel comments;
    private javax.swing.JLabel currentDate;
    private javax.swing.JLabel currentTime;
    private javax.swing.JLabel day;
    private javax.swing.JLabel days;
    private javax.swing.JButton decline_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel month;
    private javax.swing.JList requests;
    private javax.swing.JLabel year;
}