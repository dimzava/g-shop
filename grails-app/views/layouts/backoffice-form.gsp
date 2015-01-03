<g:applyLayout name="backoffice-main">
<html>
	<g:set var="entityName" value="${message(code: entity+'.genitive')}" />
	<head>
	    <title><g:message code="action.${actionTitle}.entity" args="[entityName]"/></title>
	</head>
	<body>
		<content tag="header"><g:message code="action.${actionTitle}.entity" args="[entityName]"/></content>
		<g:pageProperty name="page.formErrors"/>
		<g:pageProperty name="page.form"/>	
	</body>
</html>
</g:applyLayout>