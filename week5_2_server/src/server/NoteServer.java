//Calculator.java
package server;

import javax.xml.ws.Endpoint;

import beans.QueryBean;
import calcws.NoteService;

public class NoteServer {
    
    public static void main(String[] args){
        // create and publish an endpoint
        NoteService ns = new NoteService();
        Endpoint.publish("http://localhost:9191/noteservice", ns); 
        System.out.println("http://localhost:9191/noteservice published");
//        QueryBean qb = new QueryBean();
//        qb.setQuery("SELECT * FROM notes");
//        
//        for (String[] results : qb.getResultTable()) {
//        	for (String result : results) {
//        		System.out.println(result);
//        	}
//        }
    }
}