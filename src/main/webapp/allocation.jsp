<%-- 
    Document   : allocation
    Created on : 28-Oct-2023, 4:11:01 am
    Author     : HP
--%>

<%@page language="java" contentType="text/html; charset=UFT-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Work Allocation</title>
    </head>
    <body>
        <h1>Allocated Tasks</h1>
        <h2>Add a New Task</h2>
                <form action="WorkAllocationServlet" method="post">
                    Task Name: <input type="text" name="taskName"><br>
                    Priority: <input type="number" name="priority"><br>
                    Required Skill: <input type="number" name="requiredSkill"><br>
                    <input type="submit" value="Add Task">
                </form>
        <table>
            <tr>
                <th>Task Name</th>
                <th>Assigned To</th>
                <th>Priority</th>
            </tr>
            
            <c:forEach var="task" items="${allocatedTasks}">
                <tr>
                    <td>${task.name}</td>
                    <td>${task.assignedTo}</td>
                    <td>${task.priority}</td>
                </tr>
            </c:forEach>
        </table>
                
    </body>
</html>
