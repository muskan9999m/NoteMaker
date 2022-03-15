package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helps.factryyy;

import notes.note;

/**
 * Servlet implementation class saveNoteServlet
 */
public class saveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public saveNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String title=request.getParameter("title");
			String noteContent=request.getParameter("noteContent");
			
			note not=new note(title,noteContent,new Date());
		    Session session=factryyy.getFactory().openSession();
		    
		    Transaction t=session.beginTransaction();
		    session.save(not);
		    t.commit();
		    
		    out.print("<h1 style= 'text-align:center;'>done</h1>");
		    out.print("<h1 style=' text-align:center;'><a href='allNotes.jsp' >View All Notes</a></h1>");
		    
		    session.close();//bcs its thread safe
			
		}
		catch(Exception e)
		{e.printStackTrace();}
	}

}
