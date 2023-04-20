<%--
  Created by IntelliJ IDEA.
  User: Vĩ Trần
  Date: 4/19/2023
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="icon" href="${pageContext.request.contextPath}/assets/images/logo.PNG">
    <title>General Post</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
            crossorigin="anonymous"
    />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
          integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/navigation/generalPost.css"/>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>
<div class="content">
    <c:if test="${postList.size() > 0}">

        <div class="row align-items-start">
            <c:forEach items="${postList}" var="post">
                <div class=" xl col-2 xs small medium large" >
                    <div class="detail-post">
                        <p class="fw-bolder" onclick="showDetailPost(${post.getId()})">${post.getTitle()}</p>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>
    <c:if test="${postList.size() == 0}">
        <h2 class="message-not-found">${message}</h2>
    </c:if>
    <jsp:include page="../common/footer.jsp"></jsp:include>
</div>
</body>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"
></script>
<script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-element-bundle.min.js"></script>
<script type="text/javascript">
    function showDetailPost(id) {
        console.log(id);
        location.href = "home?action=detail&id=" + id;
    }

    function handleDropdown() {
        let statusShowDropdownHeader = document.getElementsByClassName("show")[0];
        if (statusShowDropdownHeader == undefined) {
            let dropdownMenuHeader = document.getElementById("dropdown-menu-header");
            dropdownMenuHeader.style.display = "none";
        } else {
            let dropdownMenuHeader = document.getElementById("dropdown-menu-header");
            dropdownMenuHeader.style.display = "block";
        }
    }
</script>
</html>

