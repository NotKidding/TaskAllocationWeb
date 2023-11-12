<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Task Allocation</title>
    <script>
        function updateSkills(selectElement) {
            var selectedRole = selectElement.value;
            var skillSelect = selectElement.parentNode.querySelector('.skill-select');

            // Simulating getting skills dynamically based on the selected role
            // You would typically fetch this information from a database or a service
            var skills = {
                "Development": ["Front-End Developer", "Back-End Developer", "Mobile Web Developer", "JavaScript Developer"],
                "Design and User Experience": ["UI/UX Designer"],
                "Specialized development": ["Web Accessibility Developer", "Web Security Developer", "Web Performance Developer", "Web API Developer"]
                // Add more roles and their respective skills here
            };

            // Clear the previous skill options
            skillSelect.innerHTML = "";

            // Add skills based on the selected role
            skills[selectedRole].forEach(function(skill) {
                var option = document.createElement("option");
                option.value = skill;
                option.textContent = skill;
                skillSelect.appendChild(option);
            });
        }

        function addMemberSection() {
            var membersContainer = document.getElementById("membersContainer");
            var memberCount = document.querySelectorAll('.member').length + 1;

            var memberDiv = document.createElement('div');
            memberDiv.classList.add('member');
            memberDiv.innerHTML = `
                <input type="text" name="memberName${memberCount}" placeholder="Member ${memberCount}">
                <select name="role${memberCount}" onchange="updateSkills(this)"> <!-- Fixed function name here -->
                    <option value="" selected disabled>-Select Role-</option>
                    <option value="Development">Development</option>
                    <option value="Design and User Experience">Design and User Experience</option>
                    <option value="Specialized development">Specialized development</option>
                </select>
                <select name="skill${memberCount}" class="skill-select">
                    <option value="" selected disabled>Select Skill</option>
                    <!-- Skill will be dynamically populated based on the selected role -->
                </select>
                <button onclick="deleteMember(this.parentNode)">Delete</button>
            `;

            membersContainer.appendChild(memberDiv);
        }

        function deleteMember(memberNode) {
            memberNode.parentNode.removeChild(memberNode);
        }
    </script>
</head>
<body>
    <h1>Task Allocation</h1>
    
    <form action="/TaslAllocationWeb/WorkAllocationServlet.java" method="post"> <!-- Form to submit the data -->
        <div id="membersContainer"></div>
        <button type="button" onclick="addMemberSection()">Add Member</button>
        <button type="submit">Submit</button> <!-- Submit button to send the data -->
    </form>
</body>
</html>