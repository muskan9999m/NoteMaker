package Servlets;

import java.io.IOException;
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
 * Servlet implementation class updateServlet
 */
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			int noteId=Integer.parseInt(request.getParameter("id").trim());
			String title=request.getParameter("title");
			String content=request.getParameter("noteContent");
			Session s=factryyy.getFactory().openSession();
			Transaction t=s.beginTransaction();
			note n=(note)s.get(note.class, noteId);
			n.setContent(content);
			n.setTitle(title);
			n.setDateAdded(new Date());
			//done
			s.saveOrUpdate(n);
			
			t.commit();
			response.sendRedirect("allNotes.jsp");
			
		}
		catch(Exception e)
		{e.printStackTrace();}
	}

}
