<%--
  Created by IntelliJ IDEA.
  User: Vĩ Trần
  Date: 4/18/2023
  Time: 9:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<div class="header">
  <div class="left-header">
      <a onClick="navigateNewPage('#')" href="home"><img class="logo" src="${pageContext.request.contextPath}/assets/images/logo.PNG" alt=""></a>
  </div>
  <div class="right-header">
    <form class="form-search-header d-flex" action="home?action=search" method="post">
      <input type="text" class="input-search-header" name="search" placeholder="Search">
      <button class="search-btn d-flex align-items-end" type="submit"><i class="fa-solid fa-magnifying-glass"></i>
      </button>
    </form>
    <div class="account-user">
      <div class="dropdown">
        <button class="dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false"
                style="background: transparent; outline: 0; border: 0; color: #d9d9d9">
          <i class="fa-solid fa-house-user"></i>
        </button>
        <ul class="dropdown-menu">
          <c:if test="${(sessionScope.account.isAdmin() ? 1: 0) == 1}">
            <li><a class="dropdown-item" href="admin">Admin Management</a></li>
          </c:if>
          <li><a class="dropdown-item" href="logout">Log out</a></li>
        </ul>
      </div>
    </div>
  </div>
</div>

