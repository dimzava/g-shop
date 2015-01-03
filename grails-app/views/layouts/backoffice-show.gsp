<g:applyLayout name="backoffice-main">
<html>
	<g:set var="entityName" value="${message(code: entity+'.genitive')}" />
	<head>
	    <title><g:message code="action.show.entity" args="[entityName]"/></title>
	</head>
	<body>
		<content tag="header"><g:message code="action.show.entity" args="[entityName]"/></content>
		<div class="actions-non-form clearfix">
			<p class="list-meta"><g:link action="list" params="${params}">&larr; <g:message code="action.list.return"/></g:link></p>
			<div class="pull-right">
				<a class="btn large primary icon alternative edit" 
					href="${g.createLink(controller: controllerName, action: 'edit', params: params)}">
	   				<g:message code="action.edit.entity" args="[entityName]"/></a>
  				&nbsp;
  				<a href="${g.createLink(controller: controllerName, action: 'delete', params: params)}"
  				   class="btn large danger icon alternative trash" 
  				   data-controls-modal="modal-delete-show" 
  				   data-backdrop="true" 
  				   data-keyboard="true"><g:message code="action.delete.entity" args="[entityName]"/></a>
			</div>
		</div>
		<g:pageProperty name="page.list"/>
		
		<!-- modal content -->
		<se:modalDelete divId="modal-delete-show"/>
    	<!-- end of modal content -->
	</body>
</html>
</g:applyLayout>