<!-- эта страница загружается изначально,
томкат не находит соотвествующий сервлет
и потом видит, что уже есть готовая страница и возвращает ее-->

<html>
<body>
<h2>Hello World!</h2>
<!-- атрибут action задает адрес по которому отправить запрос, method - тип запроса -->
<form action="add" method="post">
    <!-- атрибут name задает имя параметра-->
    <input type="text" name="data">

    <!-- принажатии отправляет post запрос
    по адресу /add с параметром data,
    который берется из тектового поля выше-->
    <input type="submit" value="PUT">
</form>

<!-- тут аналогично-->
<form action="delete" method="post">
    <input type="text" name="data">
    <input type="submit" value="DELETE">
</form>
</body>
</html>
