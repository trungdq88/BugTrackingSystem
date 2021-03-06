<%@include file="../shared/header.jsp" %>
<%@include file="../shared/sidebar.jsp" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main table-responsive">
            <h1 class="page-header">${requestScope.project.name}</h1>
            <p class="text-muted">${requestScope.project.description}</p>
            <br/>
            <div class="row" style="margin-bottom: 20px;">
                <%@include file="shared/menu.jsp"%>
                <div class="col-sm-6 text-right">
                    <button onclick="toggleCreateMilestone()" class="btn btn-success">New milestone</button>
                </div>              
            </div>
            <div id="create-milstone" class="hidden">
                <form action="milestone" method="Post">
                    <div>
                        <label>Name</label><br>
                        <input type="text" name="name" placeholder="New milestone name..."/>
                    </div>
                    <div>
                        <label>Description</label><br>
                        <textarea rows="5" placeholder="Description" name="description"></textarea><br>
                    </div>
                    <div>
                        <label>Deadline</label><br>
                        <input type="text" style="width: 20%" name="date" placeholder="Dealine"/>
                    </div>                  
                    <input type="hidden" value="7" name="projectId"/>
                    <input type="hidden" name="action" value="create" />
                    <div class="col-sm-3" style="float: right;">
                        <button type="button" onclick="toggleCreateMilestone()" class="btn btn-default">Cancel</button>
                        <button type="submit" class="btn btn-success">Create milestone</button>
                    </div>
                    <div style="clear: both;"></div>
                </form>
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
                            <div class="col-sm-6">
                                <a href="#" class="issue-title">Demo</a>
                                <div>
                                    <strong>Closed</strong>
                                    14 hours ago
                                    <span>
                                        <i class="fa fa-clock-o"></i> 
                                        last updated about 14 hours ago
                                    </span>
                                </div>
                                <div>
                                    description
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="progress progress-medium">
                                    <div class="progress-bar" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
                                        <span class="sr-only">60% Complete</span>
                                    </div>
                                </div>
                                <div>
                                    <span><strong>100%</strong> complete</span>
                                    <span>0 open</span>
                                    <span>1 closed</span>
                                </div>
                                <div>
                                    <a href="#"><span>Edit</span></a>
                                    <a href="#"><span>Reopen</span></a>
                                    <a href="#"><span>Delete</span></a>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-sm-6">
                                <a href="#" class="issue-title">Demo</a>
                                <div>
                                    <strong>Closed</strong>
                                    14 hours ago
                                    <span>
                                        <i class="fa fa-clock-o"></i> 
                                        last updated about 14 hours ago
                                    </span>
                                </div>
                                <div>
                                    description
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="progress progress-medium">
                                    <div class="progress-bar" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
                                        <span class="sr-only">60% Complete</span>
                                    </div>
                                </div>
                                <div>
                                    <span><strong>100%</strong> complete</span>
                                    <span>0 open</span>
                                    <span>1 closed</span>
                                </div>
                                <div>
                                    <a href="#"><span>Edit</span></a>
                                    <a href="#"><span>Reopen</span></a>
                                    <a href="#"><span>Delete</span></a>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>

<%@include file="../shared/footer.jsp" %>
