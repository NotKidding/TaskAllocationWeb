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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;


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
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the form data
        Enumeration<String> parameterNames = request.getParameterNames();
        ArrayList<String> memberNames = new ArrayList<>();
        ArrayList<String> memberRoles = new ArrayList<>();
        ArrayList<String> memberSkills = new ArrayList<>();

        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            if (paramName.startsWith("memberName")) {
                memberNames.add(request.getParameter(paramName));
            } else if (paramName.startsWith("role")) {
                memberRoles.add(request.getParameter(paramName));
            } else if (paramName.startsWith("skill")) {
                memberSkills.add(request.getParameter(paramName));
            }
        }

        // Simulate task allocation (random allocation)
        ArrayList<String> tasks = new ArrayList<>();
        tasks.add("Task A");
        tasks.add("Task B");
        tasks.add("Task C");

        Collections.shuffle(tasks);

        // Allocate tasks randomly to team members
        int totalMembers = memberNames.size();
        for (int i = 0; i < tasks.size(); i++) {
            String task = tasks.get(i);
            String member = memberNames.get(i % totalMembers);
            // Here, ideally, you would assign the task to the specific member in your real algorithm
            System.out.println("Task '" + task + "' assigned to " + member);
        }

        // You can add further logic to handle this task allocation in a more sophisticated manner.
        // For example, considering skillsets or workload.

        // Redirect back to the form or any other page
        response.sendRedirect("allocation.jsp");
    }
}