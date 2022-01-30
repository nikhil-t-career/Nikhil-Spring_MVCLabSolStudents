<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student Details</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<h2 class="text-center">Student Details</h2>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Add Student</div>
				</div>
				<div class="panel-body">
					<form:form action="saveStudent" cssClass="form-horizontal"
						method="post" modelAttribute="student">

						<!-- need to associate this data with student id -->
						<form:hidden path="id" />

						<div class="form-group">
							<label for="name" class="col-md-3 control-label">Name</label>
							<div class="col-md-9">
								<form:input path="name" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="department" class="col-md-3 control-label">Department</label>
							<div class="col-md-9">
								<form:input path="department" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label for="country" class="col-md-3 control-label">Country</label>
							<div class="col-md-9">
								<form:input path="country" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<form:button cssClass="btn btn-primary">Submit</form:button>
							</div>
						</div>

					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>