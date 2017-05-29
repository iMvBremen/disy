//Calculator.java
package calcws;

import javax.jws.WebService;

import beans.Note;
import beans.QueryBean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.jws.WebParam;

@WebService
public class NoteService {
    
	public boolean addNote(@WebParam(name="text") String text) {
		final Note note = new Note();
		note.setText(text);
		if (note.isValid()) {
			note.setTime(Calendar.getInstance().getTimeInMillis());
			return note.add();
		}
		
		return false;
	}
	
	public boolean removeNote(@WebParam(name="id") int id) {
		final Note note = new Note();
		note.setId(id);
		return note.delete();
	}
	
	public Note[] getNotes() {
		final List<Note> notes = new ArrayList<Note>();
		
		final QueryBean qb = new QueryBean();
		qb.setQuery("SELECT * FROM Notes");
		for (String[] result : qb.getResultTable()) {
			final Note note = new Note();
			note.setId(Integer.parseInt(result[0]));
			note.setTime(Long.parseLong(result[1]));
			note.setText(result[2]);
			notes.add(note);
		}
		
		return notes.toArray(new Note[notes.size()]);
	}
	
}