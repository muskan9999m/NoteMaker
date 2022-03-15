<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="org.hibernate.*,com.helps.*,java.util.*,notes.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ALL NOTES</title>
<%@include file="required.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<br>
	<br>
	<div class="container ">
		<h1>ALL NOTES</h1>

		<div class="row">

			<div class="col-12">

				<%

 Session s=factryyy.getFactory().openSession();
 Query q=s.createQuery("from note");
 List<note> list=q.list();
 for(note not: list){
 %>
				<div class="card mt-3 ">
					<div class="card-body">
						<h5 class="card-title"><%= not.getTitle()%></h5>
						<p class="card-text"><%= not.getContent()%></p>
						<h6 style="text-align: right;"><%= not.getDateAdded()%></h6>
						<a href="deleteServlet?noteId=<%=not.getId() %>" class="btn btn-danger">Delete</a>
						<a href="Edit.jsp?noteId=<%=not.getId() %>" class="btn btn-primary">Update</a>
					</div>
				</div>

				<%
 }
 s.close();
 %>
			</div>

		</div>


	</div>



</body>
</html>