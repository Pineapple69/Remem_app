package com.example.domik.remem;
import java.util.Date;
/**
 * @author juraj
 *
 */
public class OurDateClass {

	int day, month, year, hour, min;

	/**
	 * Constructor
	 */
	OurDateClass(){
		
	}

	/**
	 *
	 * @param d
     */
	public void setDay(int d){
		day =d;
	}

	/**
	 *
	 * @param m
     */
	public void setMonth(int m){
		month = m;
	}

	/**
	 *
	 * @param y
     */
	public void setYear(int y){
		year = y;
	}

	/**
	 *
	 * @param h
     */
	public void setHours(int h){
		hour = h;
	}

	/**
	 *
	 * @param m
     */
	public void setMinutes(int m){
		min = m;
	}

	/**
	 *
	 * @return
     */
	public int returnDay(){
		return day;
	}

	/**
	 *
	 * @return
     */
	public int returnMonth(){
		return month;
	}

	/**
	 *
	 * @return
     */
	public int returnYear(){
		return year;
	}

	/**
	 *
	 * @return
     */
	public int returnHours(){
		return hour;
	}

	/**
	 *
	 * @return
     */
	public int returnMinutes(){
		return min;
	}
	/**
	 * Compare two dates which are given like string is specific format
	 * @param firstDateFormat
	 * @param secondDateFormat
	 * @return if first date is bigger return 1 if second is bigger return 2 if are the same return 0 otherwise return -1
	 */
	public int compareDates(String firstDateFormat, String secondDateFormat){
		OurDateClass firstDate = new OurDateClass();
		firstDate.setDateFromDateFormat(secondDateFormat);
		
		OurDateClass secondDate = new OurDateClass();
		secondDate.setDateFromDateFormat(secondDateFormat);
		
		if(firstDate.returnYear() > secondDate.returnYear())
			return 1;
		else if(firstDate.returnYear() < secondDate.returnYear())
			return 2;
		else if (firstDate.returnYear() == secondDate.returnYear()){
			if(firstDate.returnMonth() > secondDate.returnMonth())
				return 1;
			else if(firstDate.returnMonth() < secondDate.returnMonth())
				return 2;
			else if(firstDate.returnMonth() == secondDate.returnMonth()){
				if(this.returnDay() > secondDate.returnDay())
					return 1;
				else if(firstDate.returnDay() < secondDate.returnDay())
					return 2;
				else if(firstDate.returnDay() == secondDate.returnDay())
					return 0;
			}
		}
		return -1;
	}
	
	/**
	 * Compare two times in string specific format 
	 * @param firstTimeFormat
	 * @param secondTimeFormat
	 * @return if first date is bigger return 1 if second is bigger return 2 if are the same return 0 otherwise return -1
	 */
	public int compareTimes(String firstTimeFormat, String secondTimeFormat){
		OurDateClass firstTime = new OurDateClass();
		firstTime.setTimeFromTimeformat(firstTimeFormat);
		OurDateClass secondTime = new OurDateClass();
		secondTime.setTimeFromTimeformat(secondTimeFormat);
		
		if(firstTime.returnHours() > secondTime.returnHours())
			return 1;
		else if(firstTime.returnHours() < secondTime.returnHours())
			return 2;
		else if(firstTime.returnHours() == secondTime.returnHours()){
			if(firstTime.returnMinutes() > secondTime.returnMinutes())
				return 1;
			else if(firstTime.returnMinutes() < secondTime.returnMinutes())
				return 2;
			else if(firstTime.returnMinutes() == secondTime.returnMinutes())
				return 0;
		}
	return -1;		
	}

	/**
	 *
	 * @return
     */
	public String returnDate(){
		return this.returnDay()+"."+this.returnMonth()+"."+this.returnYear();
	}

	/**
	 *
	 * @return
     */
	public String returnTime(){
		return this.returnHours()+":"+this.returnMinutes();
	}

	/**
	 *
	 * @return
     */
	public String returnAllDate(){
		return this.returnDate()+" - "+this.returnTime();
	}

	/**
	 *
	 * @param date
     */
	public void setTodayDate(Date date){
		day = date.getDate();
		month = date.getMonth();
		month++;
				
		year = date.getYear();
		year += 1900;
	}

	/**
	 *
	 * @param date
     */
	public void setTimeNow(Date date){
		hour = date.getHours();
		min = date.getMinutes();

	}

	/**
	 *
	 * @param dateFormat
     */
	public void setDateFromDateFormat(String dateFormat){
		String DAY = this.showStringNumberFromDatetime(dateFormat, 0, '.');
		day = Integer.parseInt(DAY);

		String MONTH = this.showStringNumberFromDatetime(dateFormat, 1, '.');
		month = Integer.parseInt(MONTH);
		
		String YEAR = this.showStringNumberFromDatetime(dateFormat, 2, '.');
		year = Integer.parseInt(YEAR);
	}

	/**
	 * set time from time format
	 * @param timeFormat
     */
	public void setTimeFromTimeformat(String timeFormat){
		String HOURS = this.showStringNumberFromDatetime(timeFormat, 0, ':');
		hour = Integer.parseInt(HOURS);
		
		String MIN = this.showStringNumberFromDatetime(timeFormat, 1, ':');
		if(MIN.charAt(0)=='0')
			min = MIN.charAt(1); 
		else
			min = Integer.parseInt(MIN);
	}

	/**
	 * method is read number from time format at position
	 * @param s = time format
	 * @param count = nuber position in time format 0 = before separator 1 = behind separator
	 * @param ch = separator between HOURS and MINUTES in time format
     * @return
     */
	private String showStringNumberFromDatetime(String s, int count, char ch){
		int countOfSeparator =0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length() ; i++){
			if(s.charAt(i) == ch)
				countOfSeparator++;
			else if(s.charAt(i) != ch && countOfSeparator == count)				
				sb.append(s.charAt(i));
		}
		return sb.toString();
	}

	/**
	 * Count the next plusHour in year
	 * @param plusHour
     */
	public void plusHoursToDate(int plusHour){
		hour += plusHour;
		if(hour>=24){
			hour -= 24;
			day++;
			if(month%2 ==1){
				if(month <= 7){
					if(day>31){
						day -= 31;
						month++;
						if(month>12){
							month -= 12;
							year++;
						}
					}
				}else{
					if(day>30){
						day -= 30;
						month++;
						if(month>12){
							month -= 12;
							year++;
						}
					}
				}
			}
			else if(month%2 ==0){
				if(month ==2){
					if(year%4 ==0){
						if(day>29){
							day -= 29;
							month++;
						}
					}else{
						if(day>28){
							day -= 28;
							month++;
						}
					}
				}
				else if(month != 2){
					if(month < 7){
						if(day>30){
							day -= 30;
							month++;
							if(month>12){
								month -= 12;
								year++;
							}	
						}
					}else{
						if(day>31){
							day -= 31;
							month++;
							if(month>12){
								month -= 12;
								year++;
							}	
						}
					}
				}
			}
		}

	}
}
