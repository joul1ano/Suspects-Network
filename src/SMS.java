public class SMS extends Communication {
	private String content;
	
	public SMS(String number1,String number2,int year,int month,int day,String content)
	{
		super(number1,number2,year,month,day);
		this.content = content;
	}
	
	
	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public void printInfo()
	{
		System.out.println("This SMS has the following info");
		System.out.println("Between" + this.getNumber1() + "---" + this.getNumber2());
		System.out.println("on " + this.getDay() + "/" + this.getMonth() + "/" + this.getYear());
		System.out.println("Text:" + this.content);
	}

}