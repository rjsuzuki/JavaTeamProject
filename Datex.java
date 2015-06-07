public class Datex {
	private int month;
	private int day;
	private int year;
	// Constructor
	public Datex() {
		month = 0;
		day = 0;
		year = 0;
	}
	// Constructor
	public Datex(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	};
	public String getMonth() {
		switch(month) {
		case 1:
			return new String("January");
		case 2:
			return new String("Febuary");
		case 3:
			return new String("March");
		case 4:
			return new String("April");
		case 5:
			return new String("May");
		case 6:
			return new String("June");
		case 7:
			return new String("July");
		case 8:
			return new String("August");
		case 9:
			return new String("September");
		case 10:
			return new String("October");
		case 11:
			return new String("November");
		case 12:
			return new String("December");
		default:
			return null;
		}
	}
	public int getDay() {
		return day;
	}
	public int getYear() {
		return year;
	}
	public String getDate() {
		return new String(getMonth() + " " + day + " " + year);
	}
}
