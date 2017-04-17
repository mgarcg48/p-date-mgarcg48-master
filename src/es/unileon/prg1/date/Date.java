package es.unileon.prg1.date;

public class Date {

	private int day;
	private int month;
	private int year;
	
	public Date(){
		this.day=1;
		this.month=1;
		this.year=2017;
	}
	
	public Date(int day, int month, int year) throws DateException{
		StringBuffer m = new StringBuffer();

		if(day<=0){
			m.append("No se admiten dias negativos\n");
		}
		if(month<=0){
			m.append("No se admiten meses negativos\n");			
		}else{
			if(month>12){
				m.append("No hay meses mayores que 12\n");							
			}else{
				if(day>this.daysOfMonth(month)){
					m.append("Combinacion mes/dia erronea\n");						
				}				
			}
		}
		if(year<0){
			m.append("No se admiten años negativos\n");			
		}
		
		if(m.length()!=0){
			throw new DateException(m.toString());
		} else {
			this.day = day;
			this.month = month;
			this.year = year;
		}
	}
	
	public Date(Date another){
		this.day = another.getDay();
		this.month = another.getMonth();
		this.year = another.getYear();
	}
	
	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public void setDay(int day) throws DateException{
		if (day<=0){
			throw new DateException("No se admiten dias negativos\n");			
		}else{
			if(!this.isDayRight(day) ){
				throw new DateException("Combinacion mes/dia erronea\n");
			}else{
				this.day = day;
			}
		}
	}
	
	public void setMonth(int month) throws DateException{
		if(month<=0) {
			throw new DateException("No se admiten meses negativos\n");			
		}else{
			if(month>12){
				throw new DateException("No hay meses mayores que 12\n");
			}else{
				this.month = month;
			}
		}
	}

	public void setYear(int year) throws DateException{
		if(year<0) {
			throw new DateException("No se admiten años negativos\n");			
		}else{
			this.year = year;
		}
	}
	
	public Date tomorrow(){
		Date tomorrow = null;
		int d, m, y;		
		d = this.day;
		m = this.month;
		y = this.year;
		d++;
		if (d >this.daysOfMonth(month) ) {
			d = 1;
			m++;
			if (m>12){
				m = 1;
				y++;
			}	
		}
		try{
			tomorrow = new Date(d, m, y);
		} catch (DateException e){
			System.err.println("Date.tomorrow: " + e.getMessage());
		}
		return tomorrow;
	}
	
	public boolean isSameDay(Date other){
		if (this.day == other.getDay()){
			return true;
		}else
			return false;
	}
	
	public boolean isSameMonth(Date other){
		if (this.month == other.getMonth()){
			return true;
		} else {
			return false;
		}
	}

	public boolean isSameYear(Date other){
		return this.year == other.getYear();
	}

	public boolean isSame (Date other){
		return this.isSameDay(other) && this.isSameMonth(other) && this.isSameYear(other);
	}

	public String getMonthName(){
		String nombre = null;
		switch (this.month){
		case 1:
			nombre = "January";
			break;
		case 2:
			nombre = "February";
			break;
		case 3:
			nombre = "March";
			break;
		case 4:
			nombre = "April";
			break;
		case 5:
			nombre = "May";
			break;
		case 6:
			nombre = "June";
			break;
		case 7:
			nombre = "July";
			break;
		case 8:
			nombre = "August";
			break;
		case 9:
			nombre = "September";
			break;
		case 10:
			nombre = "October";
			break;
		case 11:
			nombre = "November";
			break;
		case 12:
			nombre = "December";
			break;
		}
		return nombre;
	}
		
	private boolean isDayRight(int day){
		return ((day>0)&&(day<=this.daysOfMonth(this.month)));
	}
	
	public int daysOfMonth(){
		return this.daysOfMonth(this.month);
	}
	
	private int daysOfMonth(int month){
		int dias = 0;
		switch (month){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			dias = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11: 
			dias = 30;
			break;
		case 2:
			dias = 28;
			break;
		default:
			dias = -1;
		}
		return dias;
	}

	public String getSeasonName(){
		String estacion = null;
		switch (this.month){
		case 1:
		case 2:
		case 3: 
			estacion = "Winter";
			break;
		case 4:
		case 5:
		case 6:
			estacion = "Spring";
			break;
		case 7:
		case 8:
		case 9:
			estacion = "Summer";
			break;
		case 10:
		case 11:
		case 12:
			estacion = "Autumn";
			break;
		}
		
		return estacion;
	}
	
	public String getMonthsLeft(){
		Date m = new Date(this);
		StringBuffer monthsLeft = new StringBuffer();
		
		try{
			for (int i = this.month + 1; i <= 12; i++){
				m.setMonth(i);
				monthsLeft.append(m.getMonthName() + " ");
			}
		} catch (DateException e){
			System.err.println("Date.getMonthsLeft: " + e.getMessage());
		}
		return monthsLeft.toString();
	}
	
	public String getDaysLeftOfMonth(){
		Date m = tomorrow();
		StringBuffer daysLeft = new StringBuffer();
		
		try{
			for (int i = m.getDay(); isDayRight(i); i++) {
				m.setDay(i);
				daysLeft.append(m.toString() + " ");
			}
		} catch (DateException e){
			System.err.println("Date.getDaysLeftOfMonth: " + e.getMessage());
		}
		return daysLeft.toString();
	}
	
	public String getMonthsSameDays(){
		Date m = new Date(this);
		StringBuffer months = new StringBuffer();
		try{
			for ( int i = 1; i <= 12; i++) {
				m.setMonth(i);
				if ( m.daysOfMonth() == this.daysOfMonth() ) {
					months.append(m.getMonthName() + " ");
				}
			}
		} catch (DateException e){
			System.err.println("Date.getMonthsSameDays: " + e.getMessage());
		}
		return months.toString();
	}

	public int daysPast(){
		int resultado;
		resultado = 0;
		try{
			Date m = new Date(1,1,this.year);
		
			for ( int i = 1; i < this.month; i++ ) {
				resultado += m.daysOfMonth();
				m.setMonth(i + 1);
			}
		} catch (DateException e){
			System.err.println("Date.daysPast: " + e.getMessage());
		}
		
		return resultado + this.day - 1;
	}

	public int numRandomTriesEqualDate(){
        	int intentos, d, m, y;
        	intentos = 0;
        	try{
        		do{
        			m = (int) (Math.random()*12) + 1;
        			d = (int) (Math.random()*this.daysOfMonth(m) ) + 1;
        			y = this.year;
        			intentos++;
        		} while ( !this.isSame(new Date(d,m,y) ) );
		} catch (DateException e){
			System.err.println("Date.numRandomTriesEqualsDate: " + e.getMessage());
		}

        	return intentos;
   	}
	
	private String nameOfDay(int day) {
		String dias;
		switch (day) {
		case 1: 
			dias = "Monday";
			break;
		case 2: 
			dias = "Tuesday";
			break;
		case 3: 
			dias = "Wednesday";
			break;
		case 4: 
			dias = "Thursday";
			break;
		case 5: 
			dias = "Friday";
			break;
		case 6: 
			dias = "Saturday";
			break;
		case 7: 
			dias = "Sunday";
			break;
		default:
			dias = "Wrong day";
		}
		return dias;
	}
	
	public String dayOfWeek(int unoDeEnero){
		int dias;
		dias=(daysPast()%7 + unoDeEnero)%7;
		return nameOfDay(dias);
	}
	
	public String toString(){
		return this.day + "/" + this.month + "/" + this.year;
	}
	
}
