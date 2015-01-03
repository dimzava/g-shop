import eu.salonexperts.catalog.Category

class BootStrap {

    def init = { servletContext ->
		loadCategories()
    }
    
	def destroy = {
    }
	
	def loadCategories() {
		if(Category.count() == 0) {
			for(i in 1..20) {
				def category = new Category(
					name: "Κατηγορία ${i}",
					description: "Μία σύντομη περιγραφή για την κατηγορία ${i}",
					permalink: "category-${i}",
					metaDescription: "Μετα-περιγραφή για την κατηγορία ${i}",
					metaKeywords: "κατηγορία, ${i}"
				).save()
			}
		}
	}
}
