
package calcws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "addNote", namespace = "http://calcws/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addNote", namespace = "http://calcws/")
public class AddNote {

    @XmlElement(name = "text", namespace = "")
    private String text;

    /**
     * 
     * @return
     *     returns String
     */
    public String getText() {
        return this.text;
    }

    /**
     * 
     * @param text
     *     the value for the text property
     */
    public void setText(String text) {
        this.text = text;
    }

}
