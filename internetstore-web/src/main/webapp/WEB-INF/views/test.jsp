<html>
<head>
    <title>Index</title>
</head>
<body>
<%@include file="header.jsp" %>
<input type="text" id="suggest"/>
<script src="//api-maps.yandex.ru/2.1/?lang=ru_RU&amp;load=SuggestView&amp;onload=onLoad"></script>
<script>
    function onLoad(ymaps) {
        var suggestView = new ymaps.SuggestView('suggest');
    }
</script>
</body>
</html>