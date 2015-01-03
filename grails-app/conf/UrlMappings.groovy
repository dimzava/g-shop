import eu.salonexperts.utils.UrlMappingsUtils

class UrlMappings {

	static mappings = {
		def backofficeControllers = UrlMappingsUtils.controllersToPrefix()
		// handle all non-backoffice controllers as per normal
//		"/$controller/$action?/$id?"{
//			constraints {
//				controller(validator: {
//					return !backofficeControllers?.contains(it)
//				})
//			}
//		}
//		
//		// add configured prefix to all backoffice controllers
//		backofficeControllers?.each { sc ->
//			"/${UrlMappingsUtils.backofficeUrlPrefix()}/${sc}/$action?/$id?"{
//				controller = sc
//			}
//		}
		
		"/${UrlMappingsUtils.backofficeUrlPrefix()}/$controller/$action?/$id?"()
		"/${UrlMappingsUtils.backofficeUrlPrefix()}/catalog/categories"(controller: "category", action: "list")

		"/"(view:"/index")
		
		"500"(view:'/error')
	}
}
