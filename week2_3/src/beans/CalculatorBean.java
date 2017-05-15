package beans;

public class CalculatorBean 
{
    int xvalue = 0;
    int yvalue = 0;
    int statusX = 1;  // 1: success 0: error
    int statusY = 1;

    public void setXvalue(String sx)
    {
    	try
    	{
    		xvalue = Integer.parseInt(sx);
    	}
    	catch(Exception e)
    	{
    		statusX = 0;
    	}
    }
    
    public int getXvalue()
    {
    	return xvalue;
    }   
    
    public void setYvalue(String sy)
    {
    	try
    	{
    		yvalue = Integer.parseInt(sy);
    	}
    	catch(Exception e)
    	{
    		statusY = 0;
    	}    	
    }
    
    public int getYvalue()
    {
    	return yvalue;
    }  
        
    public int getSum() 
    {
        return xvalue + yvalue; 
    }
    
    public boolean isValid() 
    {
        return statusX == 1 && statusY == 1; 
    }
    
    public boolean isXvalid() {
    	return statusX == 1;
    }
    
    public boolean isYvalid() {
    	return statusY == 1;
    }
}
