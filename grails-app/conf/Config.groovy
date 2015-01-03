import org.apache.log4j.DailyRollingFileAppender

// locations to search for config files that get merged into the main config
// config files can either be Java properties files or ConfigSlurper scripts

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.app.context = "/"
grails.project.groupId = "eu.salonexperts"// change this to alter the default package name and Maven publishing destination

grails.controllers.defaultScope = "singleton"
grails.web.url.converter = "hyphenated"

grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [ html: ['text/html','application/xhtml+xml'],
                      xml: ['text/xml', 'application/xml'],
                      text: 'text/plain',
                      js: 'text/javascript',
                      rss: 'application/rss+xml',
                      atom: 'application/atom+xml',
                      css: 'text/css',
                      csv: 'text/csv',
                      all: '*/*',
                      json: ['application/json','text/json'],
                      form: 'application/x-www-form-urlencoded',
                      multipartForm: 'multipart/form-data'
                    ]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']


// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// set per-environment serverURL stem for creating absolute links
environments {
    development {
        grails.logging.jul.usebridge = true
    }
    production {
        grails.logging.jul.usebridge = false
//        grails.serverURL = "http://www.changeme.com"
    }
}

/**
 * Logging configuration
 */
def logPattern = '%d{yyyy-MM-dd HH:mm:ss,SSS} %p %c{2} - %m%n'
log4j = {
	appenders {
		console name: 'stdout', layout:pattern(conversionPattern: logPattern)
		'null' name: 'stacktrace'
		environments {
			production {
				// rolling file per date
				appender new DailyRollingFileAppender(name: 'fileAppender', datePattern: "'.'yyyy-MM-dd", fileName: "/opt/mypath/myLog.log", layout: pattern(conversionPattern: logPattern))
				'null' name: 'stdout'
				// mail appender
//				appender new org.apache.log4j.net.SMTPAppender(
//					name: 'mail',
//					to: 'dimzava@gmail.com',
//					from: 'noreply@salonexperts.eu',
//					threshold: org.apache.log4j.Level.WARN,
//					bufferSize: 1,
//					subject: "Error on SalonExperts",
//					layout: pattern(conversionPattern: logPattern),
//					//SMTPDebug: true,
//					SMTPHost: 'localhost'
//				)
			}
		}
	}
	
	root {
		error 'stdout', 'fileAppender', 'mail'
//		debug 'stdout'
	}
	
	error  'org.codehaus.groovy.grails.web.servlet',
		   'org.codehaus.groovy.grails.web.pages',
		   'org.codehaus.groovy.grails.web.sitemesh',
		   'org.codehaus.groovy.grails.web.mapping.filter',
		   'org.codehaus.groovy.grails.web.mapping',
		   'org.codehaus.groovy.grails.commons',
		   'org.codehaus.groovy.grails.plugins',
		   'org.codehaus.groovy.grails.orm.hibernate',
		   'org.springframework',
		   'org.hibernate',
		   'net.sf.ehcache.hibernate',
		   
		   'grails.app.services.org.grails.plugin.resource',
		   'grails.app.taglib.org.grails.plugin.resource',
		   'grails.app.resourceMappers.org.grails.plugin.resource',
		   'grails.app.services.NavigationService'
   
	warn	'org.mortbay.log'
	
	debug	'eu.salonexperts',
		   	'grails.app'
	 
	environments {
		production {
			info	'eu.salonexperts',
					'grails.app'
		}
	}
	   
}

/**
 * Twitter bootstrap plugin configuration
 */
grails.plugins.twitterbootstrap.fixtaglib = true

/**
 * Navigation plugin configuration
 */
navigation.backoffice = [
	[controller: 'dashboard', action: 'index', title: 'dashboard', order: 1],

	[controller: 'sales', action: 'index', path: 'sales', title: 'sales', order: 2, subItems: [
			[action: 'orders', title: 'orders'],
			[action: 'returns', title: 'returns'],
			[action: 'customers', title: 'customers'],
			[action: 'coupons', title: 'coupons']
		]
	],

	[controller: 'catalog', action: 'index', path: 'catalog', title: 'catalog', order: 3, subItems: [
			[action: 'categories', title: 'categories'],
			[action: 'products', title: 'products'],
			[action: 'attributes', title: 'attributes'],
			[action: 'options', title: 'options'],
			[action: 'brands', title: 'brands']
		]
	],

	[controller: 'report', action: 'index', path: 'report', title: 'reports', order: 4, subItems: [
			[action: 'sales', title: 'sales'],
			[action: 'products', title: 'products']
		]
	],

	[controller: 'system', action: 'index', path: 'system', title: 'system', order: 5, subItems: [
			[action: 'settings', title: 'settings'],
			[action: 'users', title: 'users'],
			[action: 'localisation', title: 'localisation']
		]
	]
]
