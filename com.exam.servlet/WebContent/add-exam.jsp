<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
  <title>Add Exam</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <h1>Add Exam</h1>
  <form method="post" action="AddExamServlet">
    <label>Exam Name:</label><input type="text" name="examName" required><br>
    <label>Date:</label><input type="date" name="date" required><br>
    <label>Subject:</label><input type="text" name="subject" required><br>
    <label>Duration (in minutes):</label><input type="number" name="duration" required><br>
    <input type="submit" value="Add Exam">
  </form>
</body>
</html>
