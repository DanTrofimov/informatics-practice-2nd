<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form action="sign-up" method="POST" class="registration-form">
    <h3 class="registration-form__title">Registration</h3>
    <input name="name" placeholder="Name">
    <input name="email" placeholder="E-mail">
    <input name="password" placeholder="Password">
    <input name="password-repeat" placeholder="Repeat password">
    <div class="checkbox-container">
        <input type="checkbox" name="user-agreement">
        <p class="agreement">Agreement to the processing of personal data</p>
    </div>
    <input type="submit" value="Sing Up">
</form>