<!DOCTYPE html>
<html>
    <head>
        <title>Cities</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        </head>
    <body>
        <h2>List of users ordered by name in descending order</h2>
        
        <table>
            <tr>
                <th>Id</th>  
                <th>Firstame</th>
                <th>Lastname</th>  
                <th>Email</th>
                
            </tr>        

            <#list users as user>
                <tr>
                    <td>${user.id}</td> 
                    <td>${user.firstame}</td> 
                    <td>${user.lastname}</td>
                                        <td>${user.email}</td>
                    
                    
                </tr>
            </#list>        
        </table>                
    </body>
</html>