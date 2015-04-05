<%@include file="../shared/header.jsp" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main table-responsive">
            <h1 class="page-header">Demo</h1>
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

                <div class="col-sm-1">
                    <a href="${pageContext.request.contextPath}/issue?action=create" class="btn btn-success">New issue</a>
                </div>
            </div> 

            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">
                    <span style="margin-top: 5px; display: inline-block">
                        <a href="#">
                            <b>
                                <i class="fa fa-exclamation-circle"></i> 2 Open
                            </b>
                        </a>
                        <a href="#">
                            <span class="text-muted">
                                <i class="fa fa-check"></i> 7 Closed
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
                    <li class="list-group-item">
                        <div class="issue-item row">
                            <div class="issue-status">#1</div>
                            <div class="issue-main">
                                <a href="#" class="issue-title">Demo</a>
                                <span class="label" style="background-color: red;">Bug</span>
                                <div>
                                    <span name="opened-by">opened on Feb 4 by trungdq88 </span>
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
                    <li class="list-group-item">
                        <div class="issue-item row">
                            <div class="issue-status">#2</div>
                            <div class="issue-main">
                                <a href="#" class="issue-title">Demo</a>
                                <span class="label" style="background-color: #1392e9;">Mobile</span>
                                <span class="label" style="background-color: violet;">Web Service</span>
                                <div>
                                    <span name="opened-by">opened on Feb 4 by trungdq88 </span>
                                    <span name="issue-milestone"></span>
                                </div>
                            </div>
                            <div class="issue-comment">
                                <a href="#">
                                    <i class="fa fa-comment"></i>
                                    2
                                </a>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>

<%@include file="../shared/footer.jsp" %>
