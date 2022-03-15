<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page
	import="org.hibernate.*,com.helps.*,java.util.*,notes.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>This is Edit Page</title>
<%@include file="required.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
	<br>
	<br>
	<div class="container ">
	<h1>Edit you Note :</h1>
	<% 
	int noteId=Integer.parseInt(request.getParameter("noteId").trim());
	Session s=factryyy.getFactory().openSession();
	note n=(note)s.get(note.class, noteId);
	%>
	
	<form action="updateServlet" method="post">
  <div class="mb-3">
  <input name="id" type="hidden" value="<%=n.getId() %>"/>
    <label for="Title" class="form-label">Title</label>
    <input name="title" required="required" type="text" class="form-control" id="title" value="<%=n.getTitle() %>"  aria-describedby="emailHelp">
    
  <div class="mb-3">
    <label for="NoteContent" class="form-label">Note Cotent</label>
    <textarea name="noteContent" required="required" value="<%=n.getContent() %>"  style="height: 300px;" id="cotent" placeholder="notes...." class="form-control"></textarea>
   
  </div>
 
  <button type="submit" class="btn btn-success">Save</button>
</form>
	
	</div>
</body>
</html>