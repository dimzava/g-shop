<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title><g:layoutTitle/> | Salon Experts Backoffice</title>
    <r:require modules="application, bootstrap, bootstrap-custom, html5shim"/>
    <r:layoutResources/>
  </head>
  <body>
    <div class="topbar" data-dropdown="dropdown">
      <div class="topbar-inner">
        <div class="container-fluid">
          <a class="brand" href="${createLink(controller: 'dashboard')}">Salon Experts Backoffice</a>
          <ul class="nav">
       		<nav:eachItem group="backoffice" var="navItem">
            	<g:if test="${!navItem.subItems}">
            		<li${navItem.active ? ' class=\"active\"' : ''}><a href="${navItem.link}"><g:message code="navigation.backoffice.${navItem.title}"/></a></li>
				</g:if>
				<g:else>
					<li class="dropdown${navItem.active ? ' active' : ''}">
						<a class="dropdown-toggle" href="#"><g:message code="navigation.backoffice.${navItem.title}"/></a>
						<ul class="dropdown-menu">
							<g:each in="${navItem.subItems}" var="navSubItem"> <%-- TODO didn't manage to make it work with nav:eachSubItem - var appears null --%>
								<li>
									<g:link controller="${navSubItem.controller}" action="${navSubItem.action}">
										<g:message code="navigation.backoffice.${navSubItem.controller}.${navSubItem.title}"/>
									</g:link>
								</li>
							</g:each>	
						</ul>
					</li>
				</g:else>
           	</nav:eachItem>
          </ul>
          <p class="pull-right">Logged in as <a href="#">dimzava</a></p>
        </div>
      </div>
    </div>
    <div class="container-fluid">
   		<div class="content">
   			<div class="page-header">
		  		<h1><g:pageProperty name="page.header"/></h1>
			</div>
			<g:if test="${flash?.message}">
            <div class="alert-message ${flash.messageType ?: eu.salonexperts.utils.MessageType.INFO} fade in" data-alert="alert">
            	<a class="close" href="#">x</a>
            	<p><strong>${flash.message}</strong></p>
            </div>
       		</g:if>
			<g:layoutBody/>
	  	</div>	
      	<footer>
      		<p class="pull-right">&copy; Salon Experts 2011</p>
      	</footer>
    </div>
	<r:layoutResources/>
  </body>
</html>