<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Index-test</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Css/estilo.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        
<form method="post" action="ingreso">
<label>Usuario
</label>
<input type="text" id="usuario" name="usuario">
</br>
<label>contraseña
</label>
<input type="password" id="contrasena" name="contrasena">
</br>
<label>tipo de usuario</label>
<select type="text" name="seleccion" style="width:250px;height:45px">
                        <option> Seleccionar Usuario </option>
                        <option> Estudiante </option>
                        <option> Docente </option>
                        <option> Administrador </option>
                    </select>
                    <button  type="submit">Ingresar!</button>
</form>


    </body>
</html>
    