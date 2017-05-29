package domdemo;

import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/*
 * Expects arguments to be of "args[0...n](String filepath | file_year.txt)"
 */

class CreateDomXml {	
	public static void main(String[] args) {
		List<String> filePaths;
		
		if (args.length > 0) {
			try {
				filePaths = Arrays.asList(args);
			} catch (Exception e) {
				return;
			}
		} else {
			return;
		}
		
		boolean rootSet = false;
		
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();

			Element root = doc.createElement("trekking");
			
			for (String filePath : filePaths) {
				final File file = new File(filePath);
				if (file.exists()) {
					// Check if root is set
					if (!rootSet) {
						// Not yet set, so we'll check name of first file 
						// and get year attribute out of that for root
						int year = 0;
						
						String yearString = file.getName();
		      			int startPos = yearString.lastIndexOf("_");
		      			int endPos = yearString.lastIndexOf(".");
		      			if (startPos > 0 && endPos > startPos) {
		      				yearString = yearString.substring(startPos+1, endPos);
			      			try {
			      				year = Integer.parseInt(yearString);
			      			} catch (Exception e) {
			      				return;
			      			}
		      			}
						
						root.setAttribute("jaar", ""+year);
						// all it to the xml tree
						doc.appendChild(root);	
						
						// Root now set, boolean to true
						rootSet = true;
					}
					
					// create child element
	      			Element e = doc.createElement("lijstje");
	      			root.appendChild(e);
	      			
	      			// Add name element
	      			String name = file.getName();
	      			int pos = name.lastIndexOf("_");
	      			if (pos > 0) {
	      			    name = name.substring(0, pos);
	      			}
	      			
	      			Element child = doc.createElement("naam");
	      			Text tn = doc.createTextNode(name);
	      			child.appendChild(tn);
	      			e.appendChild(child);
					
					try {
				    	  // Scan each line from the file
				    	  final Scanner scanner = new Scanner(file);
				    	  while (scanner.hasNextLine()) {
				    		  // Get next line
				        	  final String value = scanner.nextLine();
				        	  // Check if the String is not empty
				        	  if (!value.isEmpty()) {
				        		// Add kado element
				      			child = doc.createElement("kado");
				      			tn = doc.createTextNode(value);
				      			child.appendChild(tn);
				      			e.appendChild(child);			        		  
				        	  }
				          }
				          scanner.close();
				      } catch (FileNotFoundException err) {
				    	  err.printStackTrace();
				      }					
				}
			}

			TransformerFactory tf = TransformerFactory.newInstance();

			Transformer t = tf.newTransformer();
			t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			t.setOutputProperty(OutputKeys.INDENT, "yes");
			t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount",
					"3");

			DOMSource ds = new DOMSource(doc);
			Result dest = new StreamResult(System.out);
			//Result dest = new StreamResult(new File("verlanglijstjes.xml"));
			t.transform(ds, dest);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}