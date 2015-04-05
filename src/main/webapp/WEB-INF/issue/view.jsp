
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <span class="text-muted"><b>trungdq88</b> opened this issue on Mar 7 · 0 comments</span>
        </p>
    </div>
    <div id="issue-content" class="col-md-9">
        <div class="panel panel-default">
            <div class="panel-heading"><b>trungdq88</b> commented on Mar 7</div>
            <div class="panel-body">
                ${requestScope.issue.content}
            </div>
        </div>
    </div>
</div>
<%@include file="../shared/footer.jsp"%>