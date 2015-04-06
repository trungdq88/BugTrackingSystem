<%@include file="../shared/header.jsp" %>
<%@include file="../shared/sidebar.jsp" %>
<div class="container-fluid">
    <div class="row">
        <h1 class="page-header col-md-10 col-md-offset-2 main"
            style="margin-top: 10px; margin-bottom: 0">Create new issue</h1>
        <form action="${pageContext.request.contextPath}/issue" method="post">
            <div class="col-md-7 col-md-offset-2 main table-responsive">
                <table style="width: 100%">
                    <tr>
                        <td>
                            <label for="issue-name">Title</label>
                        </td>
                        <td>
                            <input type="text" class="form-control" required
                                   id="issue-name" name="issue-name"/>
                        </td>
                    </tr>
                </table>
                <br/>
                <div>
                    <b>Description:</b>
                </div>
                <br/>
                <textarea class="ckeditor" name="issue-description" required></textarea>
                <br/>
                <br/>
                <input type="hidden" name="action" value="create"/>
                <input type="hidden" name="project-id" value="${param.projectId}"/>
                <input type="submit" class="btn btn-primary" value="Create issue"/>
            </div>
            <div class="col-md-3">
                <br/>
                <p>
                    <b>Labels</b>
                    <a href="#">
                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                    </a><br/>
                    <span class="text-muted">No label</span>
                </p>
                <hr/>
                <p>
                    <b>Milestone</b>
                    <a href="#">
                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                    </a><br/>

                    <span class="text-muted">No milestone</span>
                </p>
                <hr/>
                <p>
                    <b>Assignee</b>
                    <a href="#">
                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                    </a><br/>
                    <span class="text-muted">No assignee</span> - <a href="#">Assign yourself</a>
                </p>
            </div>
        </form>
    </div>
</div>

<%@include file="../shared/footer.jsp" %>