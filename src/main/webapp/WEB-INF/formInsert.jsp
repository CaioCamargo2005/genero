<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Resgistro</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
        <div class="container"></div>
        <h1>Novo Registro</h1>
        <form action="/insert" method="post">
            <label for="nome" class="form-label">Descrição</label>
            <input type ="text" name="nome" class="form-control"/>
            <button type="submit" class="btn btn-success">Salvar</button>
        </form>
    </body>
</html>