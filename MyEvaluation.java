
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author BusyB
 */
public class MyEvaluation extends javax.swing.JFrame {

    /**
     * Creates new form MyEval
     */
    private Employee emp;
    private final double avg = Employee.getAvgScore();
    private double dep_avg;
    public MyEvaluation (int n,  Employee emp) {
        if (n == 1 || n ==2)
            dep_avg = Department.departmentScore(BasicEmployee
                    .searchEmployeeByName2(emp.getNameSurname())
                    .getDepartment());
        this.emp = emp;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        showDate();
        showTime();
        if (n != 1 && n != 2){
            depScore.setVisible(false);
        }
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
        today = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        myEval = new javax.swing.JLabel();
        busyb = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        myScore = new javax.swing.JLabel();
        depScore = new javax.swing.JLabel();
        compScore = new javax.swing.JLabel();
        output = new javax.swing.JLabel();
        if (emp.getScore() > avg)
        output.setText("Conglatulations! Your score is above the average score!");
        else
        output.setText("Your score is beneath the average score!");
        output1 = new javax.swing.JLabel();
        if (emp.getScore() > avg)
        output1.setText("Hard work pays off!");
        else
        output1.setText("Never give up because great things need time!");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(MyEvaluation.class.getResource("/images/smallLogo.PNG")));

        jPanel1.setBackground(new java.awt.Color(255, 222, 89));

        today.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        today.setText("Today");

        date.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        date.setText("Date");

        time.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        time.setText("Time");

        myEval.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        myEval.setText("My Evaluation");

        busyb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busyb.jpg"))); // NOI18N

        home.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        home.setText("Home");
        home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });

        myScore.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        myScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        myScore.setText(String.valueOf(emp.getScore()) + "/10");

        depScore.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        depScore.setText("Department's score is " + String.valueOf(dep_avg) + "/10");

        compScore.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        compScore.setText("Company's score is " + String.valueOf(avg) + "/10");

        output.setFont(new java.awt.Font("Bookman Old Style", 1, 20)); // NOI18N

        output1.setFont(new java.awt.Font("Bookman Old Style", 1, 20)); // NOI18N
        output1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(busyb, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(today)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(343, 343, 343)
                        .addComponent(myEval)
                        .addGap(528, 528, 528)
                        .addComponent(home))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(297, 297, 297)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(myScore, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(compScore, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(depScore, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(output, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(output1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(today, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(myEval)
                        .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myScore, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(depScore, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(compScore, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(output, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(output1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 397, Short.MAX_VALUE)
                .addComponent(busyb, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {
        new FirstWindow(emp).setVisible(true);
        this.setVisible(false);// TODO add your handling code here:
    }
    private javax.swing.JLabel busyb;
    private javax.swing.JLabel compScore;
    private javax.swing.JLabel date;
    private javax.swing.JLabel depScore;
    private javax.swing.JLabel home;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel myEval;
    private javax.swing.JLabel myScore;
    private javax.swing.JLabel output;
    private javax.swing.JLabel output1;
    private javax.swing.JLabel time;
    private javax.swing.JLabel today;
}
