<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- Example of accessing and displaying the newPostList data on home.jsp -->
<html>
<head>
  <!-- ... Your head content ... -->
</head>
<body>
<h1>List of Posts</h1>
<div class="post">
  <c:forEach items="${newPostList}" var="post">
    <div class="postItem">
      <a href="detail" class="title-post">
      <c:out value="${post.title}" /> <!-- Example of accessing a property of Post object -->
      <!-- ... Other properties of Post object ... -->
      </a>
<%--      <div class="datePost">--%>
<%--        <c:out value="${post.datePost}" />--%>
<%--      </div>--%>
      <div class="contentPost">
        <c:out value="${fn:substring(post.content,0, 250)}..." />
      </div>

    </div>
  </c:forEach>
</div>
</body>
</html>
