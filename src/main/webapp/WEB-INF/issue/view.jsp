
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../shared/header.jsp"%>
<%@include file="../shared/sidebar.jsp" %>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2">
    <div class=" col-md-12">
        <h1 class="page-header">
            ${requestScope.issue.name} <small>#${requestScope.issue.id}</small>
        </h1>
        <p>
            <c:choose>
                <c:when test="${requestScope.issue.status == 0}">
                    <span class="label label-success label-big">Open</span>
                </c:when>
                <c:otherwise>
                    <span class="label label-danger label-big">Closed</span>
                </c:otherwise>
            </c:choose>
            &nbsp;
            <span class="text-muted"><b>${requestScope.creator.username}</b> opened this issue on
            <fmt:formatDate  type="both" dateStyle="medium" timeStyle="medium"
                             value="${requestScope.issue.createDate}" /> · ${requestScope.comments.size()} comments</span>
        </p>
    </div>
    <div class="col-md-9">
        <div id="issue-content">
            <div class="panel panel-default">
                <div class="panel-heading">

                    <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                    <b>${requestScope.creator.username}</b> commented on
                    <fmt:formatDate  type="both" dateStyle="medium" timeStyle="medium"
                                     value="${requestScope.issue.createDate}" /></div>
                <div class="panel-body">
                    ${requestScope.issue.content}
                </div>
            </div>
        </div>
        <div id="comments">
            <c:forEach items="${requestScope.comments}" var="comment">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                        <b>${comment.userId}</b> commented on
                        <fmt:formatDate  type="both" dateStyle="medium" timeStyle="medium"
                                         value="${comment.createdDate}" /></div>
                    <div class="panel-body">
                            ${comment.commentContent}
                    </div>
                </div>
            </c:forEach>
        </div>
        <div id="issue-comment">
            <form action="/BTS/issue" method="post">
                <b><label for="issue-comment-box">Your comment:</label></b>
                <p>
                    <textarea id="issue-comment-box" class="ckeditor" name="issue-comment" required></textarea>
                </p>
                <p class="text-right">
                    <input type="hidden" name="issue-id" value="${requestScope.issue.id}"/>
                    <input type="hidden" name="action" value="comment"/>
                    <input type="submit" class="btn btn-success" value="Comment"/>
                </p>
            </form>
        </div>
    </div>
</div>
<%@include file="../shared/footer.jsp"%>