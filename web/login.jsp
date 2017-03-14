<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <html:form action="/validateLogin.do">
	    <table align="center">
		<tr>
		    <td>Ingresa tu usuario y contraseña</td>
		    <td>Usuario:</td>
		    <td><html:text property="user"/></td>
		</tr>
		<tr>
		    <td>Password:</td>
		    <td><html:password property="password"/></td>
		</tr>
		<tr>
		    <td><input type="button" value="Cancelar" style="font-size: 14px; color: blue;" /></td>
		    <td><input type="submit" value="Aceptar" style="font-size: 14px; color: blue;"/></td>
		</tr>
	    </table>
	    
	</html:form>
    </body>
</html>
