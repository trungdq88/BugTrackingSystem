
    <div class="btn-group col-sm-6" role="group" aria-label="Basic example">
        <a href="${pageContext.request.contextPath}/project?action=view&id=${param.id}"
           class="btn btn-${param.action == 'view' ? 'primary' : 'default'}">Issues</a>
        <a href="${pageContext.request.contextPath}/project?action=label&id=${param.id}"
           class="btn btn-${param.action == 'label' ? 'primary' : 'default'}">Labels</a>
        <a href="${pageContext.request.contextPath}/project?action=milestone&id=${param.id}"
           class="btn btn-${param.action == 'milestone' ? 'primary' : 'default'}">Milestones</a>
        <a href="${pageContext.request.contextPath}/project?action=member&id=${param.id}"
           class="btn btn-${param.action == 'member' ? 'primary' : 'default'}">Members</a>
    </div>