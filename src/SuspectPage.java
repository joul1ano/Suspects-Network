import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class SuspectPage<ButtonListener2> extends JFrame{
	private JTextField name;
	private JTextField EncodedName;
	private JTextArea phones,smsArea,partnersArea,suggestedPartnersArea,countryArea;
	private JTextField numberToLookSMS;
	private JButton findSMS,returntosearch;
	private JPanel panel1;
	private JLabel partners, suggestedPartners;
	private Suspect suspect;
	private Registry reg;
	
	public SuspectPage(Suspect suspect, Registry reg) {
		this.suspect = suspect;
		this.reg = reg;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,800);
		this.setTitle("Suspect Page");
		
		//1H SEIRA TOU GUI
		name = new JTextField(suspect.getName(),10);
		EncodedName = new JTextField(suspect.getCodeName(),10);
		
		
		
		phones = new JTextArea(3,3);
		phones.setText(suspect.getPhoneNumbers().get(0));
		for(int i=1; i<suspect.getPhoneNumbers().size(); i++) {
			phones.append("\n" + suspect.getPhoneNumbers().get(i));
		}
		
		//2h SEIRA TOU GUI
		numberToLookSMS = new JTextField("Enter a number",10);
		
		smsArea = new JTextArea(10,15);
		
		findSMS = new JButton("Find SMS");
		ButtonListener1 but1 = new ButtonListener1();
		findSMS.addActionListener(but1);
		
		//3h SEIRA TOU GUI
		partners = new JLabel("Partners");
		
		partnersArea = new JTextArea(10,15);
		partnersArea.setText(suspect.getPossiblePartners().get(0).getName() + ", " + suspect.getPossiblePartners().get(0).getCodeName() + "\n");
		for(int i=1; i<suspect.getPossiblePartners().size(); i++)
			partnersArea.append(suspect.getPossiblePartners().get(i).getName() + ", " + suspect.getPossiblePartners().get(i).getCodeName() + "\n");
		
		//4h SEIRA TOU GUI
		suggestedPartners = new JLabel("             Suggested Partners---->");
		
		suggestedPartnersArea = new JTextArea(5,15);
		ArrayList<Suspect> suggestedPartnersArray= suspect.SuggestedPartners();
		
		if(suggestedPartnersArray.size()>0) {
			suggestedPartnersArea.setText(suggestedPartnersArray.get(0).getName() + "\n");
			for(int i=1; i<suggestedPartnersArray.size(); i++)
				suggestedPartnersArea.append(suggestedPartnersArray.get(i).getName() + "\n");
		}
		
		//5h SEIRA TOU GUI
		String country = suspect.getCountry();
		ArrayList<Suspect> suspectsArray = reg.getSuspects();
		ArrayList<String> temp = new ArrayList<>();
		for(Suspect s : suspectsArray)
			if(country.equals(s.getCountry()))
				temp.add(s.getName());
		countryArea = new JTextArea(5,30);
		countryArea.setText("Suspects coming from " + country + "\n");
		for(String s : temp)
			countryArea.append(s + "\n");
		
		//6h SEIRA TOU GUI
		returntosearch = new JButton("Return to Search Screen");
		ButtonListenerRet but2 = new ButtonListenerRet(reg);
		returntosearch.addActionListener(but2);
		
		
				
		
		
		panel1 = new JPanel(new FlowLayout());
		
		panel1.add(name);
		panel1.add(EncodedName);
		panel1.add(phones);
		panel1.add(numberToLookSMS);
		panel1.add(smsArea);
		panel1.add(findSMS);
		panel1.add(partners);
		panel1.add(partnersArea);
		panel1.add(suggestedPartners);
		panel1.add(suggestedPartnersArea);
		panel1.add(countryArea);
		panel1.add(returntosearch);
		
		this.setContentPane(panel1);
		this.setVisible(true);
	}
	
	//BUTTONLISTENER GIA TO KOUMPI FIND SMS
	public class ButtonListener1 implements ActionListener{

		@Override
		
		public void actionPerformed(ActionEvent e) {
			String number = numberToLookSMS.getText();
			ArrayList<String> theSuspectNumbers = suspect.getPhoneNumbers();
			ArrayList<SMS> messages = new ArrayList<>();
			ArrayList<String> allMessages = new ArrayList<>();
			for(String s : theSuspectNumbers) {
				messages = reg.getMessagesBetween(number, s);
				for(SMS m : messages)
					allMessages.add(m.getContent());
			}
			if(allMessages.size()>0) {
				smsArea.setText(allMessages.get(0) + "\n");
				for(int i=1; i<allMessages.size(); i++)
				{
					smsArea.append(allMessages.get(i) + "\n");
				}
			}
			
			
		}
		
		
}
}
