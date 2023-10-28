/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Classes;

import Classes.SampleData;
import Classes.Task;
import Classes.TeamMember;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(name = "WorkAllocationServlet", urlPatterns = {"/WorkAllocationServlet"})
public class WorkAllocationServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Handle task allocation here
        
        //For example, let's create some sample tasks and team members
        List<Task> tasks = SampleData.createSampleTasks();
        List<TeamMember> teamMembers = SampleData.createSampleTeamMembers();
        
        //you can implement your dynamic work allocation algorithm here
        
        //for now, let's assign task to team memnbers as an example
        assignTasksToTeamMembers(tasks, teamMembers);
        
        //Prepare the response content
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Task Allocation</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Task Allocation Result</h1>");
            
            //Display the allocation task
            out.println("<table>");
            out.println("<tr><th>Task Name</th><th>Assigned To</th><th>Priority</th></tr>");
            for (Task currentTask : tasks){
                out.println("<tr>");
                out.println("<td>" + currentTask.getName() + "</td>");
                out.println("<td>" + currentTask.getAssignedTo() + "</td>");
                out.println("<td>" + currentTask.getPriority() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }
   
   // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String taskName = request.getParameter("taskName");
        int priority = Integer.parseInt(request.getParameter("priority"));
        int requiredSkill = Integer.parseInt(request.getParameter("requiredSkill"));
        
        //Create a new task with the form data
        Task newTask = new Task(taskName, priority, requiredSkill);
        
        //Add the new task to your list of tasks
        SampleData.addTask(newTask);
        // Task newTask = new Task(taskName, priority, requiredSkill);
        
        // List<Task> tasks = SampleData.createSampleTasks();
        //tasks.add(newTask);
        
        List<Task> tasks = SampleData.createSampleTasks();
        System.out.println("Number of tasks: "+ tasks.size());
        
       
        //redirect back to the allocation.jsp page
        response.sendRedirect("allocation.jsp");
        request.setAttribute("allocatedTasks", tasks);
        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Task Allocation Srevlet";
    }
    
    //Custom method to assign task to team members (for example)
    private void assignTasksToTeamMembers(List<Task> tasks, List<TeamMember> teamMembers){
        //Assign tasks to team members based on your dynamic allocation algorith
        if (tasks == null || teamMembers == null || tasks.isEmpty() || teamMembers.isEmpty()){
        //Handle invalid input
        
        return;
        }
        int currentMemberIndex = 0;
        
        for(Task task : tasks){
            if (currentMemberIndex >= teamMembers.size()){
                //If we run out of team members, loop bsck to the front member
                currentMemberIndex = 0;
            }
            TeamMember assignedMember = teamMembers.get(currentMemberIndex);
            task.setAssignedTo(assignedMember.getName());
            assignedMember.addWork(1);//increment workload (for demonstartion)
            currentMemberIndex++;
        }
    }

}
