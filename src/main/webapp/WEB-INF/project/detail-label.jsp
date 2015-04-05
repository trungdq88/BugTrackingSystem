<%@include file="../shared/header.jsp" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main table-responsive">
            <h1 class="page-header">Demo</h1>
            <div class="row" style="margin-bottom: 20px;">
                <div class="btn-group col-sm-6" role="group" aria-label="Basic example">
                    <a href="project?action=view" class="btn btn-default">Issues</a>
                    <a href="project?action=label"  class="btn btn-primary">Labels</a>
                    <a href="project?action=milestone"  class="btn btn-default">Milestones</a>
                </div>
            </div> 

            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">
                    <div class="col-sm-2">
                        <label style="font-size: 13pt;">3 labels</label>
                    </div>
                    <div class="col-sm-offset-11">
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
                </div>
                <ul class="list-group">
                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-sm-8">
                                <span class="label label-big" style="background-color: red;">
                                    Bug</span>
                            </div>
                            <div class="col-sm-2" style="text-align: right;">
                                1 open issues
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
                                <span class="label label-big" style="background-color: #139ff7;"></i>Mobile</span>
                            </div>
                            <div class="col-sm-2" style="text-align: right;">
                                2 open issues
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
                                <span class="label label-big" style="background-color: violet;"></i>Web Service</span>
                            </div>
                            <div class="col-sm-2" style="text-align: right;">
                                0 open issues
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
