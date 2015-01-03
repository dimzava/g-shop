		<div id="${divId}" class="${divCssClass}">
	     	<div class="modal-header">
	     		<a href="#" class="close">x</a>
	      		<h3>${header}</h3>
	     	</div>
	    	<div class="modal-body">
	    		<p>${body}</p>
	    	</div>
	    	<div class="modal-footer">
	    		<g:form name="${formName}" controller="${controller}" action="${action}" params="${params}">
	    			<button type="submit" class="${mainBtnCssClass}">${mainBtnLabel}</button>
	    			<a href="#" class="${secondaryBtnCssClass}">${secondaryBtnLabel}</a>
	    		</g:form>
	    	</div>
    	</div>