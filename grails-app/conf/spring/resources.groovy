import eu.salonexperts.utils.ApplicationContextHolder

// Place your Spring DSL code here
beans = {
	localeResolver(org.springframework.web.servlet.i18n.FixedLocaleResolver) {
		defaultLocale = "el_GR"
	}
	
	applicationContextHolder(ApplicationContextHolder) { bean ->
		bean.factoryMethod = 'getInstance'
	}
}
