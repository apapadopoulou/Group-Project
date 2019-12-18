public class Admin {
	private Employee administrator;
	public Admin() {
		AdminWindow aw = new AdminWindow();
		administrator = aw.adminSettingsEntry();
	}
}
