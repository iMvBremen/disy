
package calcws;

import java.math.BigInteger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Calculator", targetNamespace = "http://calcws/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Calculator {


    /**
     * 
     * @param a
     * @param b
     * @return
     *     returns java.math.BigInteger
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "add", targetNamespace = "http://calcws/", className = "calcws.Add")
    @ResponseWrapper(localName = "addResponse", targetNamespace = "http://calcws/", className = "calcws.AddResponse")
    @Action(input = "http://calcws/Calculator/addRequest", output = "http://calcws/Calculator/addResponse")
    public BigInteger add(
        @WebParam(name = "a", targetNamespace = "")
        BigInteger a,
        @WebParam(name = "b", targetNamespace = "")
        BigInteger b);

}