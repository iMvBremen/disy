package beans;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Note {
	private int id;
	private long time;
	private String text;
	private QueryBean qb;
	
	public Note() {
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setTime(long time) {
		this.time = time;
	}
	
	public long getTime() {
		return time;
	}
	
	public String getFormattedTime() {
		final Calendar calendar = Calendar.getInstance();	    	  		
	  	// Set the current time of the Calendar
	  	calendar.setTimeInMillis(time);
	  	// Format the parsed time and return it
	  	return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSXXX").format(calendar.getTime());
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public boolean add() {
		if (qb == null) {
			qb = new QueryBean();
		}
		
		qb.setQuery("INSERT INTO Notes VALUES ($nextid, '"+time+"', '"+text+")");
		
		return qb.getUpdatedRows() > 0;	
	}
	
	public boolean delete() {
		if (qb == null) {
			qb = new QueryBean();
		}
		
		qb.setQuery("DELETE FROM Notes WHERE id='"+id+"'");
		
		return qb.getUpdatedRows() > 0;	
	}
	
	public boolean isValid() {
		return text != null && !text.isEmpty();
	}
}
