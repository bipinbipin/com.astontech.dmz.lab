<%@include file="includes/header.jsp" %>
<%--<%@include file="includes/navbar.jsp" %>--%>


    <form:form class="form-horizontal" modelAttribute="user" action="/user" method="post">

        UserName: <form:input path="name" />
        <br>
        Password: <form:input path="password" />
        <br>
        <form:button type="submit" value="submit" class="btn btn-primary">Submit</form:button>

    </form:form>

    BALANCE: ${balance}

<%@include file="includes/footer.jsp" %>
