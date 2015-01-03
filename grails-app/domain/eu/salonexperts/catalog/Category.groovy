package eu.salonexperts.catalog

class Category {
	String name
	String permalink
	Category parent
	String description
	String metaDescription
	String metaKeywords
	Collection<Product> products
	
	static hasMany = [products: Product]
	
    static constraints = {
		name(blank: false, maxSize: 500)
		permalink(blank: false, maxSize: 200)
		parent(nullable: true)
		description(blank: false, maxSize: 3000)
		metaDescription(nullable: true, maxSize: 160)
		metaKeywords(nullable: true, maxSize: 200)
    }
	
	def hasProducts() {
		return !products?.isEmpty()
	}
	
	def getProductCount() {
		if(!hasProducts()) {
			return 0
		}
		return products?.size()
	}
	
	static def getHierarchyFor(Category category) {
		def hierarchy = []
		while(category != null) {
			hierarchy.add(category)
			category = category.parent
		}
		Collections.reverse(hierarchy)
		return hierarchy
	}
	
	def renderHierarchy() {
		def sb = new StringBuilder()
		Category.getHierarchyFor(this)?.eachWithIndex { cat, i ->
			if(i > 0) {
				sb.append(" &rarr; ")
			}
			sb.append(cat.name)
		}
		return sb.toString()	
	}
}
