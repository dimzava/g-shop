modules = {
	
	'application' {
		defaultBundle 'application'
		
		resource url: '/js/application.js'
	}
	
	'bootstrap-custom' {
		defaultBundle 'salonexperts'
		
		resource url: '/css/bootstrap-custom.css'
	}
	
	'html5shim' {
		defaultBundle 'utils'
		
		resource url: '/js/utils/html5.js', disposition: 'head', wrapper: { s -> "<!--[if lt IE 9]>$s<![endif]-->" }
	}
}