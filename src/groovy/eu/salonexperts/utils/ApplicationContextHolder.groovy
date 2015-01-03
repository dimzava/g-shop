package eu.salonexperts.utils

import javax.servlet.ServletContext

import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.plugins.GrailsPluginManager
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware

/**
 * 
 * @author Dimitris Zavaliadis
 * 
 * See http://burtbeckwith.com/blog/?p=1017
 * 
 */
@Singleton
class ApplicationContextHolder implements ApplicationContextAware {
		
	private ApplicationContext ctx
	
	private static final Map<String, Object> TEST_BEANS = [:]
	
	void setApplicationContext(ApplicationContext applicationContext) {
		this.ctx = applicationContext
	}
	
	static ApplicationContext getApplicationContext() {
		return getInstance().ctx
	}
	
	static Object getBean(String name) {
		return TEST_BEANS[name] ?: getApplicationContext()?.getBean(name)
	}
	
	static GrailsApplication getGrailsApplication() {
		return getBean("grailsApplication")
	}
	
	static ConfigObject getConfig() {
		return getGrailsApplication()?.config
	}

	static ServletContext getServletContext() {
		return getBean("servletContext")
	}

	static GrailsPluginManager getPluginManager() {
		return getBean("pluginManager")
	}

	// For testing
	static void registerTestBean(String name, bean) {
		TEST_BEANS[name] = bean
	}

	// For testing
	static void unregisterTestBeans() {
		TEST_BEANS.clear()
	}
	
}
