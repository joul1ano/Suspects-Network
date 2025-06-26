import java.util.ArrayList;

public class Registry {
	private ArrayList<Communication> communications = new ArrayList<>();
	private ArrayList<Suspect> suspects= new ArrayList<>();
	
	
	public ArrayList<Suspect> getSuspects(){
		return suspects;
	}

	public void addSuspect(Suspect aSuspect)
	{
		suspects.add(aSuspect);
	}
	
	public void addCommunication(Communication aCommunication)
	{
		String num1,num2;
		Suspect suspect1 = null,suspect2 = null;
		boolean flag1=false, flag2=false;
		
		communications.add(aCommunication);
		num1 = aCommunication.getNumber1();
		num2 = aCommunication.getNumber2();
		
		for(Suspect s : suspects)
		{
			if((s.getPhoneNumbers().contains(num1))) {
				suspect1 = s;
				flag1 = true;
			}
			if((s.getPhoneNumbers().contains(num2))) {
				suspect2 = s;
				flag2 = true;
			}
				
		}
		if(flag1==true && flag2==true) {
			suspect1.addPossibleSuspect(suspect2);
			suspect2.addPossibleSuspect(suspect1);
		}
		
	}
	
	public Suspect getSuspectWithMostPartners()
	{
		int max = -1;
		Suspect maxS = null;
		
		for(Suspect s : suspects)
		{
			if(s.getPossiblePartners().size() >= max)
			{
				max = s.getPossiblePartners().size();
				maxS = s;
			}
		}
		return maxS;
	}
	
	public PhoneCall getLongestPhoneCallBetween(String number1, String number2)
	{
		int maxDuration = -1;
		Communication maxPhoneCall = new PhoneCall();
		
		
		for(Communication c : communications)
		{
			if(c instanceof PhoneCall)
			{
				if((c.getNumber1().equals(number1) || c.getNumber1().equals(number2)) && ((c.getNumber2().equals(number2) || c.getNumber2().equals(number1))))
				{
					if(((PhoneCall) c).getDurationInSecs() > maxDuration)
					{
						maxDuration = ((PhoneCall) c).getDurationInSecs();
						maxPhoneCall = c;
					}
				}				
			}
		}
		return (PhoneCall) maxPhoneCall;
	}
	
	public ArrayList<SMS> getMessagesBetween(String number1, String number2)
	{
		String content;
		ArrayList<SMS> messages = new ArrayList<SMS>();
	
		for(Communication c : communications)
		{
			if(c instanceof SMS)
			{
				if((c.getNumber1().equals(number1) || c.getNumber1().equals(number2)) && ((c.getNumber2().equals(number2) || c.getNumber2().equals(number1))))
				{
					content = ((SMS) c).getContent();
					if(content.contains("Bomb") || content.contains("Attack") || content.contains("Explosives") || content.contains("Gun"))
						messages.add((SMS) c);	
				}				
			}
		}
		return messages;
	}
	
	public void printSuspectsFromCountry(String country)
	{
		System.out.println("Suspects from " + country);
		for(Suspect c : suspects)
		{
			if(c.getCountry().equals(country))
			{
				System.out.println(c.getName() + "(" + c.getCodeName() + ")");
			}
		}
	}
	
	

}