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
	java.awt.EventQueue.invokeLater(new Runnable() {
		@Override
	    public void run() {
	         WelcomeWindow welcomeWindow = new WelcomeWindow();
	         welcomeWindow.setVisible(true);
	         try {
    			 Thread.sleep(9000);
    		 }
    		 catch (Exception ex) {
    			 System.out.println("An error occurred! Please try again!");
    		 }
	         welcomeWindow.dispose();
	        }
	      });
    if (!args[0].equals("0")) {
      DBcon.deleteTables();
      DBcon.createTables();
      Flow.adminSettingsEntry();
      boolean run = true;
      while (run) {
    	  try {
    		  Flow.dataEntry();
    		  break;
    	  } catch (Exception e) {
    		  System.out.println("An error occured! Try again!");
    	  }
      }
    } else {
    DBcon.loadData();
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