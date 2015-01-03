package eu.salonexperts.catalog

class Brand {
	
	String name
	String description
	String permalink
	Collection<Product> products
	
	static hasMany = [products: Product]
	
    static constraints = {
		description(nullable: true)
    }
}
