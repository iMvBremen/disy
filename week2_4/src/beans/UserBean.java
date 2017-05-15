package beans;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UserBean {
	private String name;
	private String password;
	private long lastLogin;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setLastLogin(long lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	public long getLastLogin() {
		return lastLogin;
	}
	
	public String getFormattedLastLogin() {
		final Calendar calendar = Calendar.getInstance();	    	  		
	  	// Set the current time of the Calendar
	  	calendar.setTimeInMillis(lastLogin);
	  	// Format the parsed time and return it
	  	return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSXXX").format(calendar.getTime());
	}
	
	public void updateLastLogin() {
		this.lastLogin = Calendar.getInstance().getTimeInMillis();
	}
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    
	    // Check of the given Object's name and password are the 
	    // same as this Object
	    final UserBean other = (UserBean) o;
	    return ( name != null && name.equals(other.getName()) )
	    		&& ( password != null && password.equals(other.getPassword()) );
	}

	@Override
	public int hashCode() {
	    return super.hashCode();
	}
}
