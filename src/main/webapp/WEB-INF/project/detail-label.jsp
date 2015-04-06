<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../shared/header.jsp" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main table-responsive">
            <h1 class="page-header">${requestScope.project.name}</h1>
            <p class="text-muted">${requestScope.project.description}</p>
            <br/>
            <div class="row" style="margin-bottom: 20px;">
                <%@include file="shared/menu.jsp"%>

                <div class="col-sm-6 text-right">
                    <button onclick="toggleCreateLabel()" class="btn btn-success">New label</button>
                </div>
            </div>
            <div id="create-label" class="hidden">
                <form action="label" method="post">
                    <input type="text" name="name" placeholder="New label name..." class="col-sm-5 input-text"/>
                    <button id="demo-color" type="button">Your Label</button>
                    <input id="label-color-bg" type="hidden" value="" name="color-bg"/>
                    <input id="label-color-text" type="hidden" value="" name="color-text"/>
                    <input type="hidden" value="${param.id}" name="projectId"/>
                    <input type="hidden" name="action" value="create" />
                    <div class="col-sm-3" style="float: right;">
                        <button type="button" onclick="toggleCreateLabel()" class="btn btn-default">Cancel</button>
                        <button type="submit" class="btn btn-success">Create label</button>
                    </div>
                    <div style="clear: both;"></div>
                </form>
            </div>

            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">
                    <span style="margin-top: 5px; display: inline-block">
                        <b>${requestScope.labels.size()} labels</b>
                    </span>
                    <div class="pull-right">
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
                    <c:forEach var="label" items="${requestScope.labels}">
                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-sm-8">
                                <span class="label label-big"
                                      style="background-color: ${label.colorBg}; color: ${label.colorText}">
                                    ${label.name}</span>
                            </div>
                            <div class="col-sm-2" style="text-align: right;">
                                1 open issues
                            </div>
                            <div class="col-sm-2">
                                <a href="#"><span><i class="fa fa-edit"></i> Edit</span></a>
                                <a href="#"><span><i class="fa fa-remove"></i> Delete</span></a>
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
