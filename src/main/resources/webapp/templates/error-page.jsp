<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib prefix="hd" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
  <hd:myhead mytitle="Error page"/>
</head>
<body class="bg-body-secondary">
<div class="container p-2">
  <div class="container-sm px-5 d-flex justify-content-center align-items-center">
    <h1 class="text-danger">ERROR</h1>
    <h3 class="text-danger"><%=exception.getMessage() %></h3>
  </div>
</div>
</body>
</html>