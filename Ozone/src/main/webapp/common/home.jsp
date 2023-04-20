<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- Example of accessing and displaying the newPostList data on home.jsp -->
<html>
<head>
    <!-- ... Your head content ... -->
</head>
<body>
<h1>List of Posts</h1>
<div>
    <div class="banner">
        <a href="http://phanmemmarketing.vn/download-phan-mem/">
            <img width="240" height="400" src="https://phanmemmarketing.vn/wp-content/uploads/2022/12/240x400.png" class="image wp-image-26257  attachment-full size-full"
                                                                     alt="" style="max-width: 100%; height: auto;"
                                                                     srcset="https://phanmemmarketing.vn/wp-content/uploads/2022/12/240x400.png 240w, https://phanmemmarketing.vn/wp-content/uploads/2022/12/240x400-180x300.png 180w"
                                                                     sizes="(max-width: 240px) 100vw, 240px"></a>
    </div>
<%--    <div class="Banners_wrapper__8fjJA Banners_sticky__7wV6o" style="--sticky:80px; --align:flex-start;">--%>
<%--        <div class="Banners_content__+mAzY">--%>
<%--            <a class="Banners_banner__z3Id2" href="https://fullstack.edu.vn/landing/htmlcss" target="_blank"--%>
<%--               rel="noreferrer">--%>
<%--                <img src="https://files.fullstack.edu.vn/f8-prod/banners/25/63dc61d4caec2.png" alt="HTML CSS Pro Banner"--%>
<%--                     title="HTML CSS Pro Banner"></a>--%>
<%--            <a class="Banners_banner__z3Id2" href="https://www.youtube.com/c/F8VNOfficial" target="_blank"--%>
<%--               rel="noreferrer"><img src="https://files.fullstack.edu.vn/f8-prod/banners/32/6421144f7b504.png"--%>
<%--                                     alt="F8 Youtube Banner" title="F8 Youtube Banner"></a></div>--%>
<%--    </div>--%>
    <div class="post">
        <c:forEach items="${newPostList}" var="post">
            <div class="postItem">
                <a href="home?action=detail&id=${post.getId()}" class="title-post">
                    <c:out value="${post.title}"/> <!-- Example of accessing a property of Post object -->
                    <!-- ... Other properties of Post object ... -->
                </a>
                <div class="contentPost">
                    <c:out value="${fn:substring(post.content,0, 250)}..."/>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
