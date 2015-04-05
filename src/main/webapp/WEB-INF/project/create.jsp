<%@include file="../shared/header.jsp" %>

<div class="container-fluid">
    <div class="row">
        <form action="" method="post">
            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main table-responsive">
                <h1 class="page-header">Create new project</h1>
                <table class="table table-striped">
                    <tr>
                        <td>
                            <label for="project-name">Name</label>
                        </td>
                        <td>
                            <input type="text" class="form-control" required
                                   id="project-name" name="project-name"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="project-code">Code</label>
                        </td>
                        <td>
                            <input type="text" class="form-control" required
                                   id="project-code" name="project-code"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="project-date">Start date</label>
                        </td>
                        <td>
                            <input type="date" class="form-control" required
                                   id="project-date" name="project-date"/>
                        </td>
                    </tr>
                </table>
                <div>
                    <b>Project summary:</b>
                </div>
                <br/>
                <textarea class="ckeditor" name="project-description"  required></textarea>
                <br/>
                <br/>
                <input type="hidden" name="action" value="create" />
                <input type="submit" class="btn btn-primary" value="Create project"/>
            </div>
        </form>
    </div>
</div>

<%@include file="../shared/footer.jsp" %>