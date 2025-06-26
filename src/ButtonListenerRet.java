import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListenerRet implements ActionListener{
			private Registry reg;
			
			public ButtonListenerRet(Registry reg) {
				this.reg = reg;
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				SearchSuspect search = new SearchSuspect(reg);
				
			}
			
		}
//DEN ME AFHNE NA VALW 2 ACTIONLISTENERS STO SUSPECTPAGE
//GIAFTO ANAGKASTHKA NA DHMIOURGIOSO NEA KLASH