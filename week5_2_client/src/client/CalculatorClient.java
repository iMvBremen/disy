package client;
import calcws.*;

class CalculatorClient {
	
	public static void main(String args[])
	{
    	NoteServiceService service = new NoteServiceService();
        NoteService noteServiceProxy = service.getNoteServicePort();

        System.out.println("Result:" + noteServiceProxy.addNote("HELE MOOIE TEKSSSSSSST"));
        /*for (Note note : noteServiceProxy.getNotes()) {
        	System.out.println("ID: "+note.getId() +" TIME: "+ note.getTime() +" TEXT: "+ note.getText());
        }*/
	}
}