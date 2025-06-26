public class PhoneCall extends Communication {
	private int durationInSecs;
	
	public PhoneCall(String number1,String number2,int year,int month,int day,int durationInSecs)
	{
		super(number1,number2,year,month,day);
		this.durationInSecs = durationInSecs;
	}
	
	public PhoneCall()
	{
		super();
	}
	
	public int getDurationInSecs() {
		return durationInSecs;
	}


	public void setDurationInSecs(int durationInSecs) {
		this.durationInSecs = durationInSecs;
	}


	public void printInfo()
	{
		System.out.println("This phone call has the following info");
		System.out.println("Between" + this.getNumber1() + "---" + this.getNumber2());
		System.out.println("on " + this.getDay() + "/" + this.getMonth() + "/" + this.getYear());
		System.out.println("Duration:" + this.durationInSecs);
	}

}
