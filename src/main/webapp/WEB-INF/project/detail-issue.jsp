<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../shared/header.jsp" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main table-responsive">
            <h1 class="page-header">${requestScope.project.name}</h1>
            <p class="text-muted">${requestScope.project.description}</p>
            <br/>
            <div class="row" style="margin-bottom: 20px;">
                <%@include file="shared/menu.jsp"%>
                <div class="col-sm-4">
                    <div class="input-group">
                        <div class="input-group-btn">
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Filters <span class="caret"></span></button>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </div><!-- /btn-group -->
                        <i class="fa fa-search icon-search"></i>
                        <input style="padding-left: 30px;" type="text" class="form-control" placeholder="is:issue is:open ">
                    </div>
                </div>

                <div class="col-sm-2 text-right">
                    <a href="${pageContext.request.contextPath}/issue?action=create&projectId=${requestScope.project.id}" class="btn btn-success">New issue</a>
                </div>
            </div> 
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">
                    <span style="margin-top: 5px; display: inline-block">
                        <a href="${pageContext.request.contextPath}/project?action=view&id=1&status=open">
                            <span ${param.status == "open" || empty param.status ? 'class="selected"' : 'class="text-muted"'}>
                                <i class="fa fa-exclamation-circle"></i> ${requestScope.openCount} Open
                            </span>
                        </a>
                        <a href="${pageContext.request.contextPath}/project?action=view&id=1&status=close">
                            <span ${param.status == "close" ? 'class="selected"' : 'class="text-muted"'}>
                                <i class="fa fa-check"></i> ${requestScope.closeCount} Closed
                            </span>
                        </a>
                    </span>
                    <div class="pull-right">
                        <div class="btn-group">
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Author <span class="caret"></span></button>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </div>
                        <div class="btn-group">
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Labels <span class="caret"></span></button>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </div>
                        <div class="btn-group">
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Milestones <span class="caret"></span></button>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </div>
                        <div class="btn-group">
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Assignee <span class="caret"></span></button>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </div>
                        <div class="btn-group">
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Sort <span class="caret"></span></button>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <ul class="list-group">
                    <c:forEach items="${requestScope.issues}" var="issue">
                    <li class="list-group-item">
                        <div class="issue-item row">
                            <div class="issue-status status-${param.status}">#${issue.id}</div>
                            <div class="issue-main">
                                <a href="${pageContext.request.contextPath}/issue?action=view&id=${issue.id}" class="issue-title">${issue.name}</a>
                                <span class="label" style="background-color: red;">Bug</span>
                                <div>
                                    <span name="opened-by">opened on
                                        <fmt:formatDate type="both" dateStyle="medium" timeStyle="medium"
                                                               value="${issue.createDate}" /></span>
                                        by ${issue.username}
                                    <span name="issue-milestone"></span>
                                </div>
                            </div>
                            <div class="issue-comment">
                                <a href="#">
                                    <i class="fa fa-comment"></i>
                                    3
                                </a>
                            </div>
                        </div>
                    </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>

<%@include file="../shared/footer.jsp" %>
