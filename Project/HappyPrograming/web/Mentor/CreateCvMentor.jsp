<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" type="text/css" href="file.css">

    </head>
    <body>
        <div class="container">
            <div class="form-container">
                <form action="create" type="body" class="form" method="get">
                    <div>
                        <h3>Create new CV of Mentor</h3>
                    </div>
                    <table class="table1">
                        <tr>
                            <th>ID:</th>
                            <th><input type="text"  name="id" required></th>
                        </tr>
                        <tr>
                            <th>Image:</th>
                            <th><input type="text"  name="ava" required></th>
                        </tr>
                        <tr>
                            <th>Job:</th>
                            <th><input type="text"  name="job" id="job" required></th>
                        </tr>
                        <tr>
                            <th>Introduction:</th>
                            <th><textarea rows="3" cols="35" name="intro" id="intro" required></textarea> </th>
                        </tr>
                        <tr>
                            <th>Skills:</th>
                            <th>
                                <table>
                                         <c:forEach items= "${skills}"  var= "o">
                                         <tr>
                                              <th>${o.name}</th>
                                            <th><input type="checkbox" value="${o.id}" ></th>  
                                         </tr>                                          
                                        </c:forEach>

                                </table>
                            </th>
                        </tr>
                        <tr>
                        <tr>
                            <th>Achivement:</th>
                            <th><textarea rows="3" cols="35" name="achivement" id="achivement" required></textarea> </th>
                        </tr>                                    
                        </tr>
                        <tr>
                            <th><button type = "submit" value="create" href="homepage.jsp">create</button></th>
                            <th><input type ="reset" value="reset"></th>
                        </tr>

                    </table>

                </form>
            </div>
        </div>
    </body>
    <style>
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .form-container {
            border: 1px solid #ccc;
            padding: 120px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin: 15px;
        }
    </style>
</html>