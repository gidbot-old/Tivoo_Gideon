package Model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;


import filterMethods.KeywordFilter;


public class Process {
	
	private ArrayList<CalendarEvent> myEvents = new ArrayList<CalendarEvent>(); 
	public Process (ArrayList<CalendarEvent> inputEvents){
		myEvents = inputEvents; 
	}
	
	
	/*
	 * Returns an Arraylist of events which contains all the events
	 * that contain a "keyword" 
	 */
	public ArrayList<CalendarEvent> keyword(String keyword){
		ArrayList<CalendarEvent> myEventsCopy = new ArrayList<CalendarEvent>(); 
		for (CalendarEvent currentEvent: myEvents){
			// if the event has an index != -1. it means it contains the word
			// and therefore adds it to the list
			if (currentEvent.getMyName().indexOf(keyword) != -1){
				myEventsCopy.remove(currentEvent); 
			}
		}
		return myEventsCopy; 		
	}
	
	/*
	 * Returns an Arraylist of events which contains all the events
	 * within a given time frame
	 */
	public ArrayList<CalendarEvent> timeFrame(DateTime start, DateTime finish){
		ArrayList<CalendarEvent> myEventsCopy = new ArrayList<CalendarEvent>(); 
		for (CalendarEvent currentEvent: myEvents){
			//Start Date is greater than or equal to start date
			if (currentEvent.getMyStartDate().isAfter(start)){
				//End Date is less than or equal to finish date
				if (currentEvent.getMyEndDate().isBefore(finish)){
					myEventsCopy.add(currentEvent); 
				}
			}	
		}
		return myEventsCopy;
	}
	
	
}
