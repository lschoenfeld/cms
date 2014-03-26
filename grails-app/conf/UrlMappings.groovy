class UrlMappings {

	static mappings = {

        "/contents" (resources: 'content')

        "/contents/search" (controller: 'content', action: 'search')

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
