package xmldemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;


public class MyXMLHandler extends DefaultHandler {

	private int nspaties = 0;
	private int year;
	private boolean isTrekking = false;
	private boolean isLijstje = false;
	private boolean isNaam = false;
	private boolean isKado = false;
	private PrintWriter printWriter;
	
	private void writeSpaces(int n)
	{
		for (int i =0;i<n;i++)
			System.out.print(' ');
	}

	private void parseDocument(String bestand) {

		// Maak een parser factory (standaard)
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
			// Maak een nieuwe parser
			SAXParser sp = spf.newSAXParser();
			// parse het bestand 
			sp.parse(bestand, this);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	// Bij event: een startelement gevonden:
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		writeSpaces(nspaties);
		System.out.println("start: " + qName);
		
		if (qName.equals("trekking")) {
			isTrekking = true;
		} else if (qName.equals("lijstje")) {
			isLijstje = true;
		} else if (qName.equals("naam")) {
			isNaam = true;			
		} else if (qName.equals("kado")) {
			isKado = true;
		}
		
		if (attributes.getLength() > 0)
		{
			final String jaar = attributes.getValue("jaar");
			if (jaar != null) {
				year = Integer.parseInt(jaar);				
			}
		}
		
		nspaties += 3;
	}

	// Bij event: character data gevonden
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String s = new String(ch, start, length);
		if (!s.trim().equals(""))
		{
		   writeSpaces(nspaties);
		   System.out.println("chars: " + s.trim());
		   
		   if (isKado) {
			   // Write chars to file	
			   printWriter.println(s.trim());
		   } else if (isNaam) {
			   // Create new file for chars	
			   final File file = new File(s.trim() + "_" + year + ".txt");
			   if (!file.exists()) {
					try {
						file.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   }

			   try {
				   printWriter = new PrintWriter(file);
			   } catch (FileNotFoundException e) {
				   // TODO Auto-generated catch block
				   e.printStackTrace();
			   }
		   } else if (isLijstje) {
			   // About to create new file, but don't know name yet, so do nothing			   
		   }
	    }
	}

	// Bij event: een sluitelement gevonden:
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (qName.equals("trekking")) {
			isTrekking = false;
		} else if (qName.equals("lijstje")) {
			isLijstje = false;
			// Close file, we're done
			printWriter.close();
		} else if (qName.equals("naam")) {
			isNaam = false;			
		} else if (qName.equals("kado")) {
			isKado = false;
		}
		
		nspaties -= 3;
		writeSpaces(nspaties);
		System.out.println("end: " + qName);
	}

	public static void main(String[] args) {
		MyXMLHandler spe = new MyXMLHandler();
		spe.parseDocument("verlanglijstjes.xml");
        //spe.parseDocument("employees.xml");
	}
}
