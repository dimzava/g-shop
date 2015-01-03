<g:applyLayout name="backoffice-main">
<html>
	<g:set var="entityName" value="${message(code: entity+'.plural')}" />
	<head>
	    <title>${entityName}</title>
	</head>
	<body>
		<content tag="header">${entityName}</content>
		<div class="actions-non-form clearfix">
			<g:set var="from" value="${params.offset ? params.int('offset')+1 : 1}"/>
			<g:set var="to" value="${params.offset ? params.int('offset')+params.int('max') : 10}"/>
			<p class="list-meta"><g:message code="list.meta" args="[from, to, instanceTotal]"/></p>
	   		<a class="btn large primary icon add alternative pull-right" href="${g.createLink(controller: controllerName, action: 'create', params: params)}">
	   			<g:message code="action.create.entity" args="[message(code: entity+'.genitive')]"/></a>
		</div>
		<g:pageProperty name="page.list"/>
	    <g:pageProperty name="page.paginate"/>
	    
	    <!-- modal content -->
	    <se:modalDelete divId="modal-delete-inlist"/>
    	<!-- end of modal content -->	
	</body>
</html>
</g:applyLayout>