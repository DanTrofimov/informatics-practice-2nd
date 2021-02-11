<%@tag description="simple form tag" pageEncoding="UTF-8"%>
<%@attribute name="title" fragment="true" %>
<%@attribute name="value" required="true"%>
<%@attribute name="method" required="true"%>

<form action="sign-in" method="${method}" class="form" id="form-tag">
    <jsp:invoke fragment="title"/>
    <input name="email" placeholder="E-mail">
    <input name="password" type="password" placeholder="Password">
    <input type="submit" value="${value}">
</form>

<style>
    <%@include file="/style/form-styles.css" %>
</style>