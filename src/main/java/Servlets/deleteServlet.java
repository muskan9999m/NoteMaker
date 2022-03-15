package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helps.factryyy;

import notes.note;

/**
 * Servlet implementation class deleteServlet
 */
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int noteId=Integer.parseInt(request.getParameter("noteId").trim());
		Session s=factryyy.getFactory().openSession();
		note n=(note)s.get(note.class, noteId);
		Transaction t=s.beginTransaction();
		s.delete(n);
		t.commit();
		response.sendRedirect("allNotes.jsp");
		s.close();
	}
	



}
