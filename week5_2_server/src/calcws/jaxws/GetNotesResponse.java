
package calcws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getNotesResponse", namespace = "http://calcws/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getNotesResponse", namespace = "http://calcws/")
public class GetNotesResponse {

    @XmlElement(name = "return", namespace = "", nillable = true)
    private beans.Note[] _return;

    /**
     * 
     * @return
     *     returns Note[]
     */
    public beans.Note[] getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(beans.Note[] _return) {
        this._return = _return;
    }

}
