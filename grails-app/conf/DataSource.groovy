dataSource {
    pooled = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop','update'
			url = "jdbc:mysql://127.0.0.1/salonexperts?createDatabaseIfNotExist=true&amp;useUnicode=true&amp;characterEncoding=utf-8"
			driverClassName = "com.mysql.jdbc.Driver"
			username = "salonexperts"
			password = "salonexperts"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb"
        }
    }
    production {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop','update'
			url = "jdbc:mysql://127.0.0.1/salonexperts?createDatabaseIfNotExist=true&amp;useUnicode=true&amp;characterEncoding=utf-8"
			driverClassName = "com.mysql.jdbc.Driver"
			username = "salonexperts"
			password = "salonexperts"
            // For MySQL production scenarios enable the following settings
//          pooled = true
//          properties {
//               minEvictableIdleTimeMillis=1800000
//               timeBetweenEvictionRunsMillis=1800000
//               numTestsPerEvictionRun=3
//               testOnBorrow=true
//               testWhileIdle=true
//               testOnReturn=true
//               validationQuery="SELECT 1"
//          }
        }
    }
}
