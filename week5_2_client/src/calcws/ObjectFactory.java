
package calcws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the calcws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RemoveNote_QNAME = new QName("http://calcws/", "removeNote");
    private final static QName _RemoveNoteResponse_QNAME = new QName("http://calcws/", "removeNoteResponse");
    private final static QName _AddNote_QNAME = new QName("http://calcws/", "addNote");
    private final static QName _GetNotes_QNAME = new QName("http://calcws/", "getNotes");
    private final static QName _GetNotesResponse_QNAME = new QName("http://calcws/", "getNotesResponse");
    private final static QName _AddNoteResponse_QNAME = new QName("http://calcws/", "addNoteResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: calcws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetNotesResponse }
     * 
     */
    public GetNotesResponse createGetNotesResponse() {
        return new GetNotesResponse();
    }

    /**
     * Create an instance of {@link AddNoteResponse }
     * 
     */
    public AddNoteResponse createAddNoteResponse() {
        return new AddNoteResponse();
    }

    /**
     * Create an instance of {@link AddNote }
     * 
     */
    public AddNote createAddNote() {
        return new AddNote();
    }

    /**
     * Create an instance of {@link GetNotes }
     * 
     */
    public GetNotes createGetNotes() {
        return new GetNotes();
    }

    /**
     * Create an instance of {@link RemoveNote }
     * 
     */
    public RemoveNote createRemoveNote() {
        return new RemoveNote();
    }

    /**
     * Create an instance of {@link RemoveNoteResponse }
     * 
     */
    public RemoveNoteResponse createRemoveNoteResponse() {
        return new RemoveNoteResponse();
    }

    /**
     * Create an instance of {@link Note }
     * 
     */
    public Note createNote() {
        return new Note();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveNote }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calcws/", name = "removeNote")
    public JAXBElement<RemoveNote> createRemoveNote(RemoveNote value) {
        return new JAXBElement<RemoveNote>(_RemoveNote_QNAME, RemoveNote.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveNoteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calcws/", name = "removeNoteResponse")
    public JAXBElement<RemoveNoteResponse> createRemoveNoteResponse(RemoveNoteResponse value) {
        return new JAXBElement<RemoveNoteResponse>(_RemoveNoteResponse_QNAME, RemoveNoteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNote }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calcws/", name = "addNote")
    public JAXBElement<AddNote> createAddNote(AddNote value) {
        return new JAXBElement<AddNote>(_AddNote_QNAME, AddNote.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNotes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calcws/", name = "getNotes")
    public JAXBElement<GetNotes> createGetNotes(GetNotes value) {
        return new JAXBElement<GetNotes>(_GetNotes_QNAME, GetNotes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNotesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calcws/", name = "getNotesResponse")
    public JAXBElement<GetNotesResponse> createGetNotesResponse(GetNotesResponse value) {
        return new JAXBElement<GetNotesResponse>(_GetNotesResponse_QNAME, GetNotesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNoteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calcws/", name = "addNoteResponse")
    public JAXBElement<AddNoteResponse> createAddNoteResponse(AddNoteResponse value) {
        return new JAXBElement<AddNoteResponse>(_AddNoteResponse_QNAME, AddNoteResponse.class, null, value);
    }

}
