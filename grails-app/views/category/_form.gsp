	<content tag="formErrors">
		<g:hasErrors bean="${category}">
			<div class="alert-message error fade in" data-alert="alert">
	        	<a href="#" class="close">x</a>
	        	<g:if test="${category?.errors.hasFieldErrors('version')}">
	        		<p><strong><g:message error="${category?.errors?.getFieldError('version')}"/></strong></p>
	        	</g:if>
	        	<g:else>
	        		<p><strong><g:message code="action.save.errors"/></strong></p>
	        	</g:else>
	      	</div>
		</g:hasErrors>
	</content>
	<content tag="form">
	<g:if test="${actionName == 'create'}">
		<g:set var="action" value="save"/>
	</g:if>
	<g:elseif test="${actionName == 'edit'}">
		<g:set var="action" value="update"/>
	</g:elseif>
	<g:else>
		<g:set var="action" value="${actionName}"/>
	</g:else>
	<g:form controller="category" action="${action}" class="form-stacked">
		<g:hiddenField name="returnAction" value="${returnAction}"/>
		<g:hiddenField name="max" value="${params.max}"/>
		<g:hiddenField name="offset" value="${params.offset}"/>
		<g:if test="${action == 'update'}">
			<g:hiddenField name="id" value="${category?.id}"/>
			<g:hiddenField name="version" value="${category?.version}"/>
		</g:if>
		
        <fieldset>        	
          <div class="clearfix ${hasErrors(bean: category, field: 'name', 'error')}">
            <label for="name"><g:message code="category.name"/> <span class="required">*</span></label>
            <div class="input">
            	<g:textField name="name" value="${category?.name}" class="span12" autofocus="autofocus"/>
            	<g:hasErrors bean="${category}" field="name">
					<g:eachError bean="${category}" field="name">
						<span class="help-inline"><g:message error="${it}"/></span>
					</g:eachError>
            	</g:hasErrors>
            </div>
          </div><!-- /clearfix -->
          
          <div class="clearfix ${hasErrors(bean: category, field: 'permalink', 'error')}">
            <label for="permalink"><g:message code="category.permalink"/> <span class="required">*</span></label>
            <div class="input">
            	<g:textField name="permalink" value="${category?.permalink}" class="span12"/>
            	<g:hasErrors bean="${category}" field="permalink">
					<g:eachError bean="${category}" field="permalink">
						<span class="help-inline"><g:message error="${it}"/></span>
					</g:eachError>
            	</g:hasErrors>
            </div>
          </div><!-- /clearfix -->
          
          <div class="clearfix ${hasErrors(bean: category, field: 'parent', 'error')}">
            <label for="parent"><g:message code="category.parent"/></label>
            <div class="input">
            <g:select id="parent" 
           			name="parent.id" 
       				value="${category?.parent?.id}"
				    noSelection="${['null': '-- ' + message(code: 'category.none') + ' --']}"
				    from='${eu.salonexperts.catalog.Category.list()}'
				    optionKey="id" 
				    optionValue="name"
				    class="span12"></g:select>
		    <g:hasErrors bean="${category}" field="parent">
				<g:eachError bean="${category}" field="parent">
					<span class="help-inline"><g:message error="${it}"/></span>
				</g:eachError>
           	</g:hasErrors>
		    </div>
          </div><!-- /clearfix -->
          
          <div class="clearfix ${hasErrors(bean: category, field: 'description', 'error')}">
            <label for="textarea"><g:message code="category.description"/> <span class="required">*</span></label>
            <div class="input">
           		<g:textArea name="description" value="${category?.description}" rows="5" class="span12"/>
           		<g:hasErrors bean="${category}" field="description">
					<g:eachError bean="${category}" field="description">
						<span class="help-inline"><g:message error="${it}"/></span>
					</g:eachError>
            	</g:hasErrors>
            </div>
          </div><!-- /clearfix -->
          
          <div class="clearfix ${hasErrors(bean: category, field: 'metaDescription', 'error')}">
            <label for="textarea"><g:message code="category.metaDescription"/></label>
            <div class="input">
           		<g:textArea name="metaDescription" value="${category?.metaDescription}" rows="3" class="span12"/>
              	<g:hasErrors bean="${category}" field="metaDescription">
					<g:eachError bean="${category}" field="metaDescription">
						<span class="help-inline"><g:message error="${it}"/></span>
					</g:eachError>
            	</g:hasErrors>
            </div>
          </div><!-- /clearfix -->
          
          <div class="clearfix ${hasErrors(bean: category, field: 'metaKeywords', 'error')}">
            <label for="textarea"><g:message code="category.metaKeywords"/></label>
            <div class="input">
           		<g:textArea name="metaKeywords" value="${category?.metaKeywords}" rows="3" class="span12"/>
           		<g:hasErrors bean="${category}" field="metaKeywords">
					<g:eachError bean="${category}" field="metaKeywords">
						<span class="help-inline"><g:message error="${it}"/></span>
					</g:eachError>
            	</g:hasErrors>
            </div>
          </div><!-- /clearfix -->
          
        </fieldset>
        <div class="actions">
        	<button type="submit" class="btn primary large icon alternative approve"><g:message code="action.save"/></button>
          	&nbsp;
          	<g:link action="${returnAction}" id="${params.id}" params="${[max: params.max, offset: params.offset]}" class="btn large icon remove"><g:message code="action.cancel"/></g:link>
        </div>
      </g:form>
      </content>