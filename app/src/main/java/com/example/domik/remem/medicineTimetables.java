package com.example.domik.remem;
import java.sql.Date;
import java.util.ArrayList;
/**
 * @author juraj
 *
 */
public class medicineTimetables {

	private int ID;
	private medicine medicine;
	private String dateFrom, dateUntil, timeFrom, timeUntil;
	
	private ArrayList<notification> notificationsList= new ArrayList<notification>();
	private String active;
	
	
	/**
	 * constructor
	 */
	medicineTimetables(){

	}
	
	/**
	 * 
	 * @return
	 */
	public int returnIdOfTimetable(){
		return this.ID;
	}

	/**
	 *
	 * @param id
     */
	public void setIDOfTimetable(int id){
		this.ID = id;
	}

	/**
	 *
	 * @return
     */
	public ArrayList<notification> returnArrayListOfNotificaations(){
		return notificationsList;
	}

	/**
	 *
	 * @param s
     */
	public void setActive(String s){
		this.active = s;
	}

	/**
	 *
	 * @return
     */
	public String returnActive(){
		return this.active;
	}

	/**
	 *
	 * @param m
     */
	public void setMedicine(medicine m){
		this.medicine = m;
	}
	/**
	 * 
	 * @return
	 */
	public medicine returnMedicine(){
		return this.medicine;
	}
	
	/**
	 * 
	 * @return
	 */
	public String returnDate(String s){
		if(s.equals("from"))
			return this.dateFrom;
		else if(s.equals("to"))
			return this.dateUntil;
		
		return null;
	}

	/**
	 *
	 * @param s
	 * @return
     */
	public String returnTime(String s){
		if(s.equals("from"))
			return this.timeFrom;
		else if(s.equals("to"))
			return this.timeUntil;
		
		return null;
	}

	/**
	 *
	 * @param s
	 * @param date
     */
	public void setDate(String s, String date){
		if(s.equals("from"))
			this.dateFrom = date;
		else if(s.equals("to"))
			this.dateUntil = date;
	}

	/**
	 *
	 * @param s
	 * @param time
     */
	public void setTime(String s, String time){
		if(s.equals("from"))
			this.timeFrom = time;
		else if(s.equals("to"))
			this.timeUntil = time;
	}

	/**
	 * method used by server to set timetables
	 * @param selectMedicine
	 * @param howOften
	 * @param numberOfPills
	 * @param Date
     * @param time
     */
	public void setTimetableFromClient(String selectMedicine, int howOften, int numberOfPills, String Date, String time) {

		this.dateFrom = Date;
		this.timeFrom = time;
	 String medicineName = this.divideSelecMedicine("name", selectMedicine);
	 String strength = this.divideSelecMedicine("strength", selectMedicine);
	 OurDateClass ourTime = new OurDateClass();
	 ourTime.setDateFromDateFormat(dateFrom);
	 ourTime.setTimeFromTimeformat(timeFrom);
	 this.countDatesToTakePills(howOften, numberOfPills, ourTime);
	 this.dateUntil = ourTime.returnDate();
	 this.timeUntil = ourTime.returnTime();

	 medicine = new medicine();
	 medicine.setNameOfMedicine(medicineName);
	 medicine.setStrength(strength);
	 
	}

	/**
	 * method for counting the dates to take all count of medicine
	 * @param howOften
	 * @param numberOfPills
	 * @param ourTime
     */
	private void countDatesToTakePills(int howOften, int numberOfPills, OurDateClass ourTime) {
		// TODO make notifications and count all times for notifications, save notifications to timetable 
		
		for(int i =0; i < numberOfPills; i++){
			if(i==0)
				System.out.println(ourTime.returnAllDate());
			else{
			ourTime.plusHoursToDate(howOften);
			System.out.println(ourTime.returnAllDate());
			notificationsList.add(new notification(ourTime.returnDate(), ourTime.returnTime(), "new"));
			}
		}
		
	}

	/**
	 * method for divide message about medicine message form "name~~strength"
	 * @param arg
	 * @param string
     * @return
     */
	private String divideSelecMedicine(String arg, String string) {
		StringBuilder s = new StringBuilder();
			
		if(arg.equals("name")){
			for(int i = 0;i < string.length(); i++)
				if(string.charAt(i) != '~'){
					s.append(string.charAt(i));
				}
				else return s.toString();
		}
		else if(arg.equals("strength")){
			int c = 0;
			for(int i=0; i < string.length(); i++){
				if(string.charAt(i)== '~')
					c++;
				else if(c==2)
					s.append(string.charAt(i));
			}
		}
		return s.toString();
	}
	
}
