import java.util.Scanner;
<<<<<<< HEAD
=======
import javax.swing.JFrame;
//import project.Employee;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
>>>>>>> e6fd30b94f4b801f5470cdeb833771a6f88b4d76
import java.util.ArrayList;

public class Account {
	private Employee employee;
	private String email;
	private String password;
	private static ArrayList<Account> accounts = new ArrayList<Account>();
	private String department;
 	private String name;
 	private String surname;
 	private int telephone;
 	private String email;
 	private String id;
 	private String password; 
 	private static ArrayList<Account> accounts = new ArrayList<Account>();
 	/* Account's constructor */

 public Account(Employee e) {
	 this.employee = e;
	 this.email = e.getEmail();
	 password = Checkers.ValidPassword();
	 accounts.add(this); /*Account object entered on accounts ArrayList*/
 	public Account(Employee e) {
	 	department = e.getDepartmentName();
	 	name = e.getName();
	 	surname = e.getSurname();
	 	telephone = e.getTelephone();
	 	email = e.getEmail();
	 	id = e.getId();
	 	password = Checkers.ValidPassword();
	 	accounts.add(this); /*Account object entered on accounts ArrayList*/

	 	/*
	 	if (isValidEmail(email))
         	System.out.print("Valid Email");
     	else {
         	System.out.print("Invalid Email");
         	System.out.print("Please retype your Email");
		}
     	if (isValidFirstName(firstName))
         	System.out.print("Valid First Name");
     	else {
         	System.out.print("Invalid First Name");
     		System.out.print("Please retype your First Name");
		}
     	if (isValidLastName(lastName))
         	System.out.print("Valid Last Name");
     	else {
         	System.out.print("Invalid Last Name");
    		System.out.print("Please retype your Last Name");
		}
     	if (isValidPhoneNumber(phoneNo))
         	System.out.print("Valid Phone Number");
     	else {
         	System.out.print("Invalid Phone number");
     		System.out.print("Please retype your Phone Number");
		}
 		*/

	}

 	/* This method searches Employees' accounts by their email*/

 	public Account searchAccountByEmail(String email) {
 		boolean exists = false;
 		
 		for(int i = 0; i < accounts.size();) {
 			if (accounts.get(i).email == email) {
 				exists = true;
 				break;
 			}
 			if (exists == true) {
 				return accounts.get(i);
 			} else {
=======
 		for(int i=0;i<this.accounts.size();i++) {
 			if (this.accounts.get(i).getEmail()==email) {
 				exists=true;
 				break;
 			}
 			if(exists==true) {
 				return this.accounts;
 			}else {
>>>>>>> e6fd30b94f4b801f5470cdeb833771a6f88b4d76
 				System.out.println("The email you entered does not relate to an existing account");
 				return null;
 			}
 		}
 		return null;
 	}
<<<<<<< HEAD
 	/*This method checks if the password and the email of the input 
 	 * are equal to the password and the email of the user.*/
 	public boolean login() {
 		boolean success = false;
 		System.out.println("Welcome!");
=======
 	/*This method checks if the password and the email of the input
 	   are equal to the password and the email of the user.*/
 	public static boolean login() {
 		boolean success=false;
 		//System.out.println("Welcome!");
>>>>>>> e6fd30b94f4b801f5470cdeb833771a6f88b4d76
 		System.out.println("Please insert your email");
 		Scanner sc = new Scanner(System.in);
 			String email = sc.nextLine();
 			System.out.println("Please insert your password");
 			String password = sc.nextLine();
 			if (password.equals(searchAccountByEmail(email).password)) {
 				success = true;
 			}
 			sc.close();
 			return success;
 	}
 	public static void loginScreen() {
 		JFrame jf = new JFrame ("Welcome!");
 		jf.setBounds(0, 0, 800, 600);
 		System.out.println("Please login into your account: ");
 		login();
 		jf.setVisible(true);
 		//Tried to create the login window but failed
 		/* 
 		  * @(#)OptionPaneDemo.java	1.11 05/11/17 
 		  *  
 		  * Copyright (c) 2006 Sun Microsystems, Inc. All Rights Reserved. 
 		  *  
 		  * Redistribution and use in source and binary forms, with or without 
 		  * modification, are permitted provided that the following conditions are met: 
 		  *  
 		  * -Redistribution of source code must retain the above copyright notice, this 
 		  *  list of conditions and the following disclaimer. 
 		  *  
 		  * -Redistribution in binary form must reproduce the above copyright notice,  
 		  *  this list of conditions and the following disclaimer in the documentation 
 		  *  and/or other materials provided with the distribution. 
 		  *  
 		  * Neither the name of Sun Microsystems, Inc. or the names of contributors may  
 		  * be used to endorse or promote products derived from this software without  
 		  * specific prior written permission. 
 		  *  
 		  * This software is provided "AS IS," without a warranty of any kind. ALL  
 		  * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING 
 		  * ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE 
 		  * OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN MIDROSYSTEMS, INC. ("SUN") 
 		  * AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE 
 		  * AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS 
 		  * DERIVATIVES. IN NO EVENT WILL SUN OR ITS LICENSORS BE LIABLE FOR ANY LOST  
 		  * REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL,  
 		  * INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY  
 		  * OF LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE THIS SOFTWARE,  
 		  * EVEN IF SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES. 
 		  *  
 		  * You acknowledge that this software is not designed, licensed or intended 
 		  * for use in the design, construction, operation or maintenance of any 
 		  * nuclear facility. 
 		  
 		  
 		 
 		  * @(#)OptionPaneDemo.java	1.11 05/11/17 
 		  
 		  
 		  
 		 import javax.swing.*; 
 		 import javax.swing.event.*; 
 		 import javax.swing.text.*; 
 		 import javax.swing.border.*; 
 		 import javax.swing.colorchooser.*; 
 		 import javax.swing.filechooser.*; 
 		 import javax.accessibility.*; 
 		  
 		 import java.awt.*; 
 		 import java.awt.event.*; 
 		 import java.beans.*; 
 		 import java.util.*; 
 		 import java.io.*; 
 		 import java.applet.*; 
 		 import java.net.*; 
 		  
 		 
 		  * JOptionPaneDemo 
 		  * 
 		  * @version 1.11 11/17/05 
 		  * @author Jeff Dinkins 
 		  
 		 public class OptionPaneDemo extends DemoModule { 
 		  
 		     
 		      * main method allows us to run as a standalone demo. 
 		      
 		     public static void main(String[] args) { 
 		 	OptionPaneDemo demo = new OptionPaneDemo(null); 
 		 	demo.mainImpl(); 
 		     } 
 		  
 		     
 		      * OptionPaneDemo Constructor 
 		      
 		     public OptionPaneDemo(SwingSet2 swingset) { 
 		 	// Set the title for this demo, and an icon used to represent this 
 		 	// demo inside the SwingSet2 app. 
 		 	super(swingset, "OptionPaneDemo", "toolbar/JOptionPane.gif"); 
 		  
 		 	JPanel demo = getDemoPanel(); 
 		  
 		 	demo.setLayout(new BoxLayout(demo, BoxLayout.X_AXIS)); 
 		  
 		 	JPanel bp = new JPanel() { 
 		 	    public Dimension getMaximumSize() { 
 		 		return new Dimension(getPreferredSize().width, super.getMaximumSize().height); 
 		 	    } 
 		 	}; 
 		 	bp.setLayout(new BoxLayout(bp, BoxLayout.Y_AXIS)); 
 		  
 		 	bp.add(Box.createRigidArea(VGAP30)); 
 		 	bp.add(Box.createRigidArea(VGAP30)); 
 		  
 		 	bp.add(createInputDialogButton());      bp.add(Box.createRigidArea(VGAP15)); 
 		 	bp.add(createWarningDialogButton());    bp.add(Box.createRigidArea(VGAP15)); 
 		 	bp.add(createMessageDialogButton());    bp.add(Box.createRigidArea(VGAP15)); 
 		 	bp.add(createComponentDialogButton());  bp.add(Box.createRigidArea(VGAP15)); 
 		 	bp.add(createConfirmDialogButton());    bp.add(Box.createVerticalGlue()); 
 		  
 		 	demo.add(Box.createHorizontalGlue()); 
 		 	demo.add(bp); 
 		 	demo.add(Box.createHorizontalGlue()); 
 		     } 
 		  
 		     public JButton createWarningDialogButton() { 
 		 	Action a = new AbstractAction(getString("OptionPaneDemo.warningbutton")) { 
 		 	    public void actionPerformed(ActionEvent e) { 
 		 		JOptionPane.showMessageDialog( 
 		 		    getDemoPanel(), 
 		 		    getString("OptionPaneDemo.warningtext"), 
 		 		    getString("OptionPaneDemo.warningtitle"), 
 		 		    JOptionPane.WARNING_MESSAGE 
 		 		); 
 		 	    } 
 		 	}; 
 		 	return createButton(a); 
 		     } 
 		  
 		     public JButton createMessageDialogButton() { 
 		 	Action a = new AbstractAction(getString("OptionPaneDemo.messagebutton")) { 
 		 	    URL img = getClass().getResource("/resources/images/optionpane/bottle.gif"); 
 		 	    String imagesrc = "<img src=\"" + img + "\" width=\藬\" height=\蔴\">"; 
 		 	    String message = getString("OptionPaneDemo.messagetext"); 
 		 	    public void actionPerformed(ActionEvent e) { 
 		 		JOptionPane.showMessageDialog( 
 		 		    getDemoPanel(), 
 		 		    "<html>" + imagesrc + "<br><center>" + message + "</center><br></html>" 
 		 		); 
 		 	    } 
 		 	}; 
 		 	return createButton(a); 
 		     } 
 		  
 		     public JButton createConfirmDialogButton() { 
 		 	Action a = new AbstractAction(getString("OptionPaneDemo.confirmbutton")) { 
 		 	    public void actionPerformed(ActionEvent e) { 
 		                 int result = JOptionPane.showConfirmDialog(getDemoPanel(), getString("OptionPaneDemo.confirmquestion")); 
 		                 if(result == JOptionPane.YES_OPTION) { 
 		 		    JOptionPane.showMessageDialog(getDemoPanel(), getString("OptionPaneDemo.confirmyes")); 
 		 		} else if(result == JOptionPane.NO_OPTION) { 
 		                     JOptionPane.showMessageDialog(getDemoPanel(), getString("OptionPaneDemo.confirmno")); 
 		 		} 
 		 	    } 
 		 	}; 
 		 	return createButton(a); 
 		     } 
 		  
 		     public JButton createInputDialogButton() { 
 		 	Action a = new AbstractAction(getString("OptionPaneDemo.inputbutton")) { 
 		 	    public void actionPerformed(ActionEvent e) { 
 		                 String result = JOptionPane.showInputDialog(getDemoPanel(), getString("OptionPaneDemo.inputquestion")); 
 		                 if ((result != null) && (result.length() > 0)) { 
 		                     JOptionPane.showMessageDialog(getDemoPanel(), 
 		                                     result + ": " + 
 		                                     getString("OptionPaneDemo.inputresponse")); 
 		                 } 
 		 	    } 
 		 	}; 
 		 	return createButton(a); 
 		     } 
 		  
 		     public JButton createComponentDialogButton() { 
 		 	Action a = new AbstractAction(getString("OptionPaneDemo.componentbutton")) { 
 		 	    public void actionPerformed(ActionEvent e) { 
 		 		// In a ComponentDialog, you can show as many message components and 
 		 		// as many options as you want: 
 		  
 		 		// Messages 
 		                 Object[]      message = new Object[4]; 
 		                 message[0] = getString("OptionPaneDemo.componentmessage"); 
 		                 message[1] = new JTextField(getString("OptionPaneDemo.componenttextfield")); 
 		  
 		                 JComboBox cb = new JComboBox(); 
 		                 cb.addItem(getString("OptionPaneDemo.component_cb1")); 
 		                 cb.addItem(getString("OptionPaneDemo.component_cb2")); 
 		                 cb.addItem(getString("OptionPaneDemo.component_cb3")); 
 		                 message[2] = cb; 
 		  
 		                 message[3] = getString("OptionPaneDemo.componentmessage2"); 
 		  
 		 		// Options 
 		                 String[] options = { 
 		 		    getString("OptionPaneDemo.component_op1"), 
 		 		    getString("OptionPaneDemo.component_op2"), 
 		 		    getString("OptionPaneDemo.component_op3"), 
 		 		    getString("OptionPaneDemo.component_op4"), 
 		 		    getString("OptionPaneDemo.component_op5") 
 		 		}; 
 		                 int result = JOptionPane.showOptionDialog( 
 		 		    getDemoPanel(),                             // the parent that the dialog blocks 
 		 		    message,                                    // the dialog message array 
 		 		    getString("OptionPaneDemo.componenttitle"), // the title of the dialog window 
 		 		    JOptionPane.DEFAULT_OPTION,                 // option type 
 		 		    JOptionPane.INFORMATION_MESSAGE,            // message type 
 		 		    null,                                       // optional icon, use null to use the default icon 
 		 		    options,                                    // options string array, will be made into buttons 
 		 		    options[3]                                  // option that should be made into a default button 
 		 		); 
 		 		switch(result) { 
 		 		   case 0: // yes 
 		 		     JOptionPane.showMessageDialog(getDemoPanel(), getString("OptionPaneDemo.component_r1")); 
 		 		     break; 
 		 		   case 1: // no 
 		 		     JOptionPane.showMessageDialog(getDemoPanel(), getString("OptionPaneDemo.component_r2")); 
 		 		     break; 
 		 		   case 2: // maybe 
 		 		     JOptionPane.showMessageDialog(getDemoPanel(), getString("OptionPaneDemo.component_r3")); 
 		 		     break; 
 		 		   case 3: // probably 
 		 		     JOptionPane.showMessageDialog(getDemoPanel(), getString("OptionPaneDemo.component_r4")); 
 		 		     break; 
 		 		   default: 
 		 		     break; 
 		 		} 
 		  
 		 	    } 
 		 	}; 
 		 	return createButton(a); 
 		     } 
 		 		 
 		     public JButton createButton(Action a) { 
 		 	JButton b = new JButton() { 
 		 	    public Dimension getMaximumSize() { 
 		 		int width = Short.MAX_VALUE; 
 		 		int height = super.getMaximumSize().height; 
 		 		return new Dimension(width, height); 
 		 	    } 
 		 	}; 
 		 	// setting the following client property informs the button to show 
 		 	// the action text as it's name. The default is to not show the 
 		 	// action text. 
 		 	b.putClientProperty("displayActionText", Boolean.TRUE); 
 		 	b.setAction(a); 
 		 	// b.setAlignmentX(JButton.CENTER_ALIGNMENT); 
 		 	return b; 
 		     } 
 		  
 		 } */
 	}
 	//public static void main(String [] args) {
 	//	firstScreen();
 	//}

 	/* This method generates Employee's password */
 	public static string passwordGenerator() {
		PasswordGenerator gen = new PasswordGenerator();
		CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
		CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
		lowerCaseRule.setNumberOfCharacters(1);

		CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
		CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
		upperCaseRule.setNumberOfCharacters(1);

		CharacterData digitChars = EnglishCharacterData.Digit;
		CharacterRule digitRule = new CharacterRule(digitChars);
		digitRule.setNumberOfCharacters(1);

		CharacterData specialChars = new CharacterData() {
			public String getErrorCode() {
				return ERROR_CODE;
			}

		    public String getCharacters() {
		            return "!@#$%^&*()_+";
		    }
		};
		CharacterRule splCharRule = new CharacterRule(specialChars);
		splCharRule.setNumberOfCharacters(1);

		String password = gen.generatePassword(8, splCharRule, lowerCaseRule,
		   upperCaseRule, digitRule);
        return password;
	}
}
