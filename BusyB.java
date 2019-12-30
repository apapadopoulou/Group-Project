/**
 * This is the main class of the application. User runs the app for the first time from the command line, 
 * using an argument.
 */ 
public class BusyB {
  /**
  * Main method checks if the first cell of args array is null. If it is not, 
  * the initial data entry begins to run.
  * @author BusyB
  * @param args
  */
  public static void main(String[] args) {
    if (!args[0].equals("0")) {
      DBcon.deleteTables();
      DBcon.createTables();
      AdminWindow aw = new AdminWindow();
      aw.hello();
    } else {
      java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
  public void run() {
          new LoginWindow().setVisible(true);
        }
      });
    }
  }
}

/** 
*End of BusyB class.
*/