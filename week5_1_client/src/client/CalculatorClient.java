package client;
import java.math.BigInteger;

import calcws.*;

class CalculatorClient {
	
	public static void main(String args[])
	{
    	CalculatorService service = new CalculatorService();
        Calculator calculatorProxy = service.getCalculatorPort();

        BigInteger a = BigInteger.valueOf(Long.MAX_VALUE);
        BigInteger b = BigInteger.valueOf(Long.MAX_VALUE);          
        BigInteger result = calculatorProxy.add(a,b);
        System.out.println(""+ a + " + " + b + " = " + result);

        a = BigInteger.valueOf(Long.MAX_VALUE / 2);
	    b = BigInteger.valueOf(Long.MAX_VALUE);
        result = calculatorProxy.add(a,b);
        System.out.println(""+ a + " + " + b + " = " + result);
	}
}