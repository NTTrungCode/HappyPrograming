<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Skill</title>
    </head>
    <body>
        <h1>List of Skills</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Status</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="s" items="${skills}">
                    <tr>
                        <td>${s.id}</td>
                        <td>${s.name}</td>
                        <td>
                            <c:choose>
                                <c:when test="${s.status == 1}">
                                    Active
                                </c:when>
                                <c:otherwise>
                                    Inactive
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <form action="updateSkill" method="post">
                                <input type="hidden" name="id" value="${s.id}">
                                <button type="submit">Update</button>
                            </form>
                        </td>
                        <td>
                            <form action="deleteSkill" method="post">
                                <input type="hidden" name="id" value="${s.id}">
                                <button type="submit">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
