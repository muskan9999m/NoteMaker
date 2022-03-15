<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <%@include file="required.jsp" %>  
<title>Add Notes</title>

</head>
<body>
 
<%@include file="navbar.jsp" %>
<br>
<br>
 <div class="container ">

  <h1>Yaha daalo apne notes....</h1>
  

  <form action="saveNoteServlet" method="post">
  <div class="mb-3">
    <label for="Title" class="form-label">Title</label>
    <input name="title" required="required" type="text" class="form-control" id="title" aria-describedby="emailHelp">
    
  <div class="mb-3">
    <label for="NoteContent" class="form-label">Note Cotent</label>
    <textarea name="noteContent" required="required"  style="height: 300px;" id="cotent" placeholder="notes...." class="form-control"></textarea>
   
  </div>
 
  <button type="submit" class="btn btn-primary">ADD</button>
</form>
  
  </div>
</body>
</html>