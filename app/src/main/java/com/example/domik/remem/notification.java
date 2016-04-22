package com.example.domik.remem;
/**
 * @author juraj
 *
 */
public class notification {
	
	 private String date, time, status;

	/**
	 * Constructor
	 */
	 notification(){
		 
	 }

	/**
	 * 2nd Constructor
	 * @param date
	 * @param time
	 * @param status
     */
	 notification(String date, String time, String status){
		 this.date = date;
		 this.time = time;
		 this.status = status;
	}

	/**
	 *
	 * @param d
     */
	public void setNotificationDate(String d){
		this.date = d;
	}

	/**
	 *
	 * @param t
     */
	public void setNotificationTime(String t){
		this.time = t;
	}

	/**
	 *
	 * @param s
     */
	public void setNotificationStatus(String s){
		this.status = s;
	}

	/**
	 *
	 * @return
     */
	public String returnNotificationDate(){
		return this.date;
	}

	/**
	 *
	 * @return
     */
	public String returnNotificationTime(){
		return this.time;
	}

	/**
	 *
	 * @return
     */
	public String returnNotificationStatus(){
		return this.status;
	}

}
