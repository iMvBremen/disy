package domdemo;

import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class DOMValidateDTD {
	public static void main(String args[]) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setValidating(true);
			DocumentBuilder db = dbf.newDocumentBuilder();
			db.setErrorHandler(new org.xml.sax.ErrorHandler() {
				// Ignore the fatal errors
				public void fatalError(SAXParseException exception)
						throws SAXException {
				}

				// Validation errors
				public void error(SAXParseException e) throws SAXParseException {
					System.out.println("Error at " + e.getLineNumber()	+ " line.");
					System.out.println(e.getMessage());
//					System.exit(0);
				}

				// Show warnings
				public void warning(SAXParseException err)
						throws SAXParseException {
					System.out.println(err.getMessage());
//					System.exit(0);
				}
			});
			Document d = db.parse(new FileInputStream("server.xml"));
			final NodeList nodeList = d.getElementsByTagName("Server");
			if (nodeList != null) {
				for (int i = 0; i < nodeList.getLength(); i++) {
					final Node rootNode = nodeList.item(i);
					final NamedNodeMap nnm = rootNode.getAttributes();
					final Node portNode = nnm.getNamedItem("port");	
					portNode.setNodeValue("323");
					System.out.println(portNode);
				}
			}
			
			DOMSource source = new DOMSource(d);
			StreamResult sr = new StreamResult(System.out);
			// StreamResult sr = new StreamResult(new File("server.xml"));
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer t = tf.newTransformer();
			//t.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM,"employees.dtd");
			t.transform(source, sr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}