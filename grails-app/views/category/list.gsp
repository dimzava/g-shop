<html>
<head>
	<g:set var="entity" value="category" scope="request"/>
	<g:set var="instanceTotal" value="${categoryTotal}" scope="request"/>
	<meta name="layout" content="backoffice-list"/>
</head>
<body>
	<content tag="list">
		<table class="zebra-striped">
			<thead>
				<tr>
					<th><g:message code="category.name"/></th>
					<th><g:message code="category.permalink"/></th>
					<th><g:message code="category.description"/></th>
					<th><g:message code="category.productCount"/></th>
					<th><g:message code="action.plural"/></th>
				</tr>
			</thead>
			<tbody>
			<g:each in="${categoryList}" var="category">
				<tr>
					<td><g:link action="show" id="${category?.id}" params="${params}">${fieldValue(bean: category, field: 'name')} [${category.renderHierarchy()}]</g:link></td>
					<td>${fieldValue(bean: category, field: 'permalink')}</td>
					<td>${fieldValue(bean: category, field: 'description')}</td>
					<td>${fieldValue(bean: category, field: 'productCount')}</td>
					<td>
						<g:link controller="category" action="edit" id="${category?.id}" params="${params}" class="iconified edit"><g:message code="action.edit"/></g:link>
						&nbsp;
						<g:link controller="category" action="delete" id="${category?.id}" params="${params}" 
								class="iconified delete"
								data-controls-modal="modal-delete-inlist" 
			  					data-backdrop="true" 
			  					data-keyboard="true"
			  					data-instance-name="${category?.name}"><g:message code="action.delete"/></g:link>
					</td>
				</tr>
			</g:each>
			</tbody>
		</table>
	</content>
	<content tag="paginate">
		<tb:paginate controller="catalog" action="categories" total="${instanceTotal}"/>
	</content>
</body>
	
</html>