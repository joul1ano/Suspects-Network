import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;

public class SearchSuspect extends JFrame{
	private JButton find;
	private JTextField suspect;
	private JPanel panel;
	private Registry reg;
	private JButton visualize;
	
	public SearchSuspect(Registry reg) {
		this.setSize(370,200);
		this.setTitle("Find Suspect");
		
		find = new JButton("Find");
		ButtonListener button = new ButtonListener();
		find.addActionListener(button);
		
		suspect = new JTextField("Please enter suspect's name");
		panel = new JPanel();
		
		visualize = new JButton("Visualize Network");
		visualize.addActionListener(new ActionListener() {

		
			public void actionPerformed(ActionEvent e) {
				SuspectsNetwork sn = new SuspectsNetwork(reg);
				
			}
			
		});
		
		panel.add(suspect);
		panel.add(find);
		panel.add(visualize);
		
		this.setContentPane(panel);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.reg = reg;
	}
	
	
	//METHODOS getReg XRHSIMOPOIEITAI STH KLASH ButtonListenerRet DHLADH GIA TO KOUMPI RETURN TO SEARCH 
	public Registry getReg() {
		return reg;
	}


	class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			String temp = suspect.getText().toString();
			ArrayList<Suspect> suspects = reg.getSuspects();
			boolean found = false;
			Suspect theSuspect = null;
			
			for(Suspect s : suspects)
			{
				if(s.getName().equals(temp)) {
					found = true;
					theSuspect = s;
				}
			}
			if(found == false)
				JOptionPane.showMessageDialog(null,"Suspect " + temp + " Not Found");
			else
			{
				SuspectPage suspectPage = new SuspectPage(theSuspect,reg);
			}
			
			
					
		}
		
	}
}
