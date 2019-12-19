public class BusyB {
	/**This is the main class of the app. User runs the app for the first time from the command line, using an argument.
	 * Main method checks if the first cell of args array is null. If it is not, the initial data entry begins to run.
	 * @param args
	 */
	public static void main (String[] args) {
		if (args[0] != null) {
			AdminWindow aw = new AdminWindow();
			aw.hello();
			
		}
	}
}
