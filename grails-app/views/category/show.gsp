<html>
<g:set var="entity" value="category" scope="request"/>
<g:set var="entityIdentifyingProperty" value="${category?.name}" scope="request"/>
<head>
	<meta name="layout" content="backoffice-show"/>
</head>
<body>
	<content tag="list">
		<table class="name-value">
			<tbody>
				<tr>
					<th><g:message code="category.name"/></th>
					<td>${category.name ?: "&mdash;"}</td>
				</tr>
				<tr>
					<th><g:message code="category.permalink"/></th>
					<td>${category.permalink ?: "&mdash;"}</td>
				</tr>
				<tr>
					<th><g:message code="category.description"/></th>
					<td>${category.description ?: "&mdash;"}</td>
				</tr>
				<tr>
					<th><g:message code="category.metaDescription"/></th>
					<td>${category.metaDescription ?: "&mdash;"}</td>
				</tr>
				<tr>
					<th><g:message code="category.metaKeywords"/></th>
					<td>${category.metaKeywords ?: "&mdash;"}</td>
				</tr>
				<tr>
					<th><g:message code="category.productCount"/></th>
					<td>${category.productCount}</td>
				</tr>
				<tr>
					<th><g:message code="category.hierarchy"/></th>
					<td>${category.renderHierarchy() ?: "&mdash;"}</td>
				</tr>
			</tbody>
		</table>
	</content>
</body>
	
</html>