package eu.salonexperts.catalog

import eu.salonexperts.assets.Image

class Product {
	
	/* Main data */
	String sku
	String name
	String description
	BigDecimal price
	BigDecimal cost
	/* Dimensions */
	Float weight
	Float height
	Float width
	Float depth
	/* SEO */
	String permalink
	String metaDescription
	String metaKeywords
	Collection<Image> images
	/* Metadata */
	Date dateCreated
	Date lastUpdated
	Date dateDeleted
	
	static hasMany = [images: Image]	
	
	static belongsTo = [
		category: Category,
		brand: Brand
	]
	
    static constraints = {
		metaDescription(nullable: true, maxSize: 160)
		metaKeywords(nullable: true)
		dateDeleted(nullable: true)
    }
}
