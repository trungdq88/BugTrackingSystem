<%@include file="../shared/header.jsp" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main table-responsive">
            <h1 class="page-header">Demo</h1>
            <div class="row" style="margin-bottom: 20px;">
                <%@include file="shared/menu.jsp"%>
            </div>

            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">
                    <span style="margin-top: 5px; display: inline-block">
                        <b>3 members</b>
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
                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-sm-8">
                                <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                                trungdq88
                            </div>
                            <div class="col-sm-2" style="text-align: right;">
                                Developer
                            </div>
                            <div class="col-sm-2">
                                <a href="#"><span><i class="fa fa-edit"></i>Edit</span></a>
                                <a href="#"><span><i class="fa fa-remove"></i>Delete</span></a>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-sm-8">
                                <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                                hainnt
                            </div>
                            <div class="col-sm-2" style="text-align: right;">
                                Tester
                            </div>
                            <div class="col-sm-2">
                                <a href="#"><span><i class="fa fa-edit"></i>Edit</span></a>
                                <a href="#"><span><i class="fa fa-remove"></i>Delete</span></a>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-sm-8">
                                <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                                hoappt
                            </div>
                            <div class="col-sm-2" style="text-align: right;">
                                Project Manager
                            </div>
                            <div class="col-sm-2">
                                <a href="#"><span><i class="fa fa-edit"></i>Edit</span></a>
                                <a href="#"><span><i class="fa fa-remove"></i>Delete</span></a>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>

<%@include file="../shared/footer.jsp" %>
