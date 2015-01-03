package eu.salonexperts.utils

class UrlMappingsUtils {
	
	public final static def GRAILS_APPLICATION = ApplicationContextHolder.grailsApplication
	public final static def GRAILS_CONFIG = ApplicationContextHolder.config
	public final static List<String> ALL_BACKOFFICE_CONTROLLERS = ["eu.salonexperts.backoffice"]
	public final static String DEFAULT_BACKOFFICE_URL_PREFIX = "backoffice"
	
	public static def controllersToPrefix() {
		def controllersToPrefix = GRAILS_CONFIG?.controllersToPrefix ?: ALL_BACKOFFICE_CONTROLLERS
		def result = []
		controllersToPrefix?.each { controllerName ->
			GRAILS_APPLICATION?.controllerClasses?.each { controllerClass ->
				if(controllerClass.fullName.startsWith(controllerName) && !result.contains(controllerClass.logicalPropertyName)) {
					result.add(controllerClass.logicalPropertyName)
				}
			}
		}
		return result
	}
	
	public static def backofficeUrlPrefix() {
		return GRAILS_CONFIG?.backofficeUrlPrefix ?: DEFAULT_BACKOFFICE_URL_PREFIX
	}
	
}
