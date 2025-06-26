import java.util.ArrayList;

public class Suspect {
	private String name;
	private String encodedName;
	private String Country;
	private String city;
	private ArrayList<String> phoneNumbers = new ArrayList<>();
	
	private ArrayList<Suspect> possiblePartners = new ArrayList<>();
	
	public Suspect(String name, String encodedName, String Country, String city)
	{
		this.name = name;
		this.encodedName = encodedName;
		this.Country = Country;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCodeName() {
		return encodedName;
	}

	public void setEncodedName(String encodedName) {
		this.encodedName = encodedName;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public ArrayList<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(ArrayList<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
	public ArrayList<Suspect> getPossiblePartners(){
		return this.possiblePartners;
	}
	
	
	public void addNumber(String number)
	{
		phoneNumbers.add(number);
	}
	
	public void addPossibleSuspect(Suspect s)
	{
		if(!(possiblePartners.contains(s))) {
			possiblePartners.add(s);
			
		}
	}
	
	public boolean  isConnectedTo(Suspect aSuspect)
	{
		if(this.possiblePartners.contains(aSuspect))
			return true;
		return false;
	}
	
	public ArrayList<Suspect> getCommonPartners(Suspect aSuspect)
	{
		ArrayList<Suspect> commonPartners= new ArrayList<>();
		
		for(Suspect p : possiblePartners)
		{
			if(aSuspect.getPossiblePartners().contains(p))
				commonPartners.add(p);		
		}
		return commonPartners;
	}
	
	public void printPossiblePartners()
	{
		System.out.println("Possible partners of " + this.name);
		for(Suspect s : possiblePartners)
		{
			if(this.Country.equals(s.Country))
				System.out.println(s.getName() + s.getCodeName() + "*");
			else
				System.out.println(s.getName() + s.getCodeName());
		}
	}
	
	
	public ArrayList<Suspect> SuggestedPartners()
	{
		ArrayList<Suspect> SuggestedPartners = new ArrayList<>();
		ArrayList<Suspect> temp = new ArrayList<>();
		
		for(Suspect s : this.possiblePartners)
		{
			temp = s.getPossiblePartners();
			for(Suspect su : temp)
			{
				if(!this.isConnectedTo(su) && !SuggestedPartners.contains(su) && !(su.equals(this)))
				{
					SuggestedPartners.add(su);
				}
			}
		}
		return SuggestedPartners;
		
		
	}
	
	
	

}