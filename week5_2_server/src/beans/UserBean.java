package beans;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UserBean {
	private String name;
	private String password;
	private long lastLogin;
	private long logins;
	private QueryBean queryBean;
	
	public UserBean() {}
	
	public UserBean(UserBean userBean) {
		this.name = userBean.getName();
		this.password = userBean.getPassword();
		this.lastLogin = userBean.getLastLogin();
		this.logins = userBean.getLogins();
	}
	
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
	
	public void setLogins(long logins) {
		this.logins = logins;
	}
	
	public long getLogins() {
		return logins;
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
	
	public void incrLogins() {
		this.logins++;
	}
	
	public void query() {
		if (queryBean == null) {
			queryBean = new QueryBean();
		}
		
		queryBean.setQuery("SELECT * FROM Users WHERE name='"+name+"' AND password='"+password+"'");
		
		final String[][] resultTable = queryBean.getResultTable();
		if (resultTable != null && resultTable.length > 0) {
			this.lastLogin = Long.parseLong(resultTable[0][3]);
			this.logins = Long.parseLong(resultTable[0][4]);
		}
	}
	
	public boolean exists() {
		if (queryBean == null) {
			queryBean = new QueryBean();
		}
		
		queryBean.setQuery("SELECT * FROM Users WHERE name='"+name+"' AND password='"+password+"'");
		
		final String[][] resultTable = queryBean.getResultTable();
		if (resultTable != null) {
			for (String[] results : resultTable) {
				for (String result : results) {
					System.out.println(result);
				}
			}
			if (resultTable.length != 0) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean add() {
		if (queryBean == null) {
			queryBean = new QueryBean();
		}
		
		queryBean.setQuery("INSERT INTO Users VALUES ($nextid, '"+name+"', '"+password+"', '"+lastLogin+"', "+logins+")");
		
		return queryBean.getUpdatedRows() > 0;	
	}
	
	public boolean update() {
		if (queryBean == null) {
			queryBean = new QueryBean();
		}
		
		queryBean.setQuery("UPDATE Users SET last_login="+lastLogin+", logins="+logins+" WHERE name='"+name+"' AND password='"+password+"'");
		
		return queryBean.getUpdatedRows() > 0;	
	}
	
	public boolean isValid() {
		return name != null && password != null && !name.isEmpty() && !password.isEmpty();
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
