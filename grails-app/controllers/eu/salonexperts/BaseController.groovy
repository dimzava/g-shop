package eu.salonexperts

import eu.salonexperts.utils.MessageType
import eu.salonexperts.catalog.Category
import grails.util.GrailsNameUtils

abstract class BaseController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def index() {
		redirect(action: "list", params: params)
	}
	
	def list() {
		params.max = Math.min(params.max ? params.int("max") : 10, 100)
		return [
			("${getDomainLogicalPropertyName()}List".toString()): getDomainClass().list(params), 
			("${getDomainLogicalPropertyName()}Total".toString()): getDomainClass().count()
		]
	}
	
	def show() {
		def instance = getDomainClass().get(params.id)
		redirectIfNotFound(instance)
		return [(getDomainLogicalPropertyName()): instance]
	}
	
	def create() {
		return [
			(getDomainLogicalPropertyName()): newDomainInstance(),
			returnAction: determineReturnAction()
		]
	}
	
	def save() {
		def instance = newDomainInstance()
		if(!instance.hasErrors() && instance?.validate()) {
			saveAndRedirect(instance)
		}
		else {
			showSaveErrors(instance)
		}
	}
	
	private def saveAndRedirect(instance) {
		try {
			getService().save(instance)
			saveSuccessMessage("action.save.entity.success", [message(code: "${getDomainLogicalPropertyName()}.single.full"), instance?."${getIdentifyingPropertyForDeletion()}"])
			redirect(action: "show", id: instance.id, params: [max: params.max, offset: params.offset])
		}
		catch(e) {
      log.debug "e.class : ${e.class}"
			render( view: "create", model: [(getDomainLogicalPropertyName()): e.instance, returnAction: determineReturnAction()] )
		}
	}
	
	def edit() {
		def instance = getDomainClass().get(params.id)
		redirectIfNotFound(instance)
		return [
			(getDomainLogicalPropertyName()): instance,
			returnAction: determineReturnAction()
		]
	}
	
	def update() {
		def instance = getDomainClass().get(params.id)
		redirectIfNotFound(instance)
		if( hasLockingErrors(instance) ) {
			showUpdateErrors(instance)
		}
		else {
			instance.properties = params
			if( !instance.hasErrors() && instance.validate() ) {
				updateAndRedirect(instance)
			}
			else {
				showUpdateErrors(instance)
			}
		}
	}
	
	private def updateAndRedirect(instance) {
		try {
			getService().update(instance)
			saveSuccessMessage("action.update.entity.success", [message(code: "${getDomainLogicalPropertyName()}.single.full"), instance?."${getIdentifyingPropertyForDeletion()}"])
			redirect(action: "show", id: instance.id, params: [max: params.max, offset: params.offset])
		}
		catch(e) {
			render(view: "edit", model: [(getDomainLogicalPropertyName()): e.instance, returnAction: determineReturnAction()])
		}
	}
	
	def delete() {
		def instance = getDomainClass().get(params.id)
		redirectIfNotFound(instance)
		def identifyingProperty = instance."${getIdentifyingPropertyForDeletion()}"
		deleteAndRedirect(instance, identifyingProperty)
	}
	
	private def deleteAndRedirect(instance, instanceName) {
		try {
			getService().delete(instance)
			saveSuccessMessage("action.delete.entity.success", [message(code: "${getDomainLogicalPropertyName()}.single.full"), instanceName])
			redirect(action: "list", params: [max: params.max, offset: params.offset])
		}
		catch(e) {
			saveErrorMessage("action.delete.entity.fail", [message(code: "${getDomainLogicalPropertyName()}.single.full"), instanceName])
			redirect(action: "show", id: params.id, params: [max: params.max, offset: params.offset])
		}
	}
	
	/**
	 * Determines the property to be used for displaying user-friendly messages upon deletion,
	 * e.g. <em>Category "Foo bar" deleted successfully</em>, where "Foo bar" is the value of
	 * the <code>name</code> property in the case of Category (i.e. <code>category.name</code>). 
	 * 
	 * @return the identifying property
	 */
	protected def getIdentifyingPropertyForDeletion() {
		return "name"
	}
	
	protected def newDomainInstance() {
		def newDomainInstance = getGrailsDomainClass().newInstance()
		newDomainInstance.properties = params
		return newDomainInstance
	}
	
	protected def getGrailsDomainClass() {
		return grailsApplication.getArtefactByLogicalPropertyName("Domain", getDomainLogicalPropertyName())
	}
	
	protected def getDomainClass() {
		return getGrailsDomainClass()?.clazz
	}
	
	protected def getDomainLogicalPropertyName() {
		return GrailsNameUtils.getLogicalPropertyName(this.class.name, "Controller")
	}
	
	protected def getDomainLogicalName() {
		return GrailsNameUtils.getLogicalName(this.class, "Controller")
	}
	
	protected def getService() {
		String beanName = "${getDomainLogicalPropertyName()}Service"
		return grailsApplication.mainContext.getBean(beanName)
	}
	
	protected def determineReturnAction() {
		def returnAction = "list"
		if(request.getHeader("referer")?.contains("show") || params.returnAction?.contains("show")) {
			returnAction = "show"
		}
		return returnAction
	}

	protected def redirectIfNotFound(instance) {
		if(!instance) {
			saveErrorMessage("action.show.entity.fail", [message(code: "${getDomainLogicalPropertyName()}.single.full"), params.id])
			redirect(action: "list", params: [max: params.max, offset: params.offset])
		}
	}
	
	protected def showSaveErrors(instance) {
		render( view: "create", model: [(getDomainLogicalPropertyName()): instance, returnAction: determineReturnAction()] )
	}
	
	protected def hasLockingErrors(instance) {
		if(params.version) {
			def version = params.long("version")
			if(instance.version > version) {
				instance.errors.rejectValue("version", "action.update.versionError")
			}
		}
		return instance.errors.hasFieldErrors("version")
	}
	
	protected def showUpdateErrors(instance) {
		render( view: "edit", model: [(getDomainLogicalPropertyName()): instance, returnAction: determineReturnAction()] )
	}
	
	protected def saveSuccessMessage(code, args) {
		saveFlashMessage(code, args, MessageType.SUCCESS)
	}
	
	protected def saveErrorMessage(code, args) {
		saveFlashMessage(code, args, MessageType.ERROR)
	}
	
	protected def saveFlashMessage(code, args, type) {
		flash.message = message(code: code, args: args)
		flash.messageType = type
	}
}
