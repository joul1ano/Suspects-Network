public abstract class Communication {
	private String number1;
	private String number2;
	private int year;
	private int month;
	private int day;
	
	public Communication(String number1,String number2,int year,int month,int day)
	{
		this.day = day;
		this.month = month;
		this.number1 = number1;
		this.number2 = number2;
		this.year = year;
	}
	
	public Communication()
	{
		
	}
	
	public String getNumber1() {
		return number1;
	}

	public void setNumber1(String number1) {
		this.number1 = number1;
	}

	public String getNumber2() {
		return number2;
	}

	public void setNumber2(String number2) {
		this.number2 = number2;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}



	public abstract void printInfo();

}
