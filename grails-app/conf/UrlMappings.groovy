class UrlMappings {

	static mappings = {

        "/contents" (resources: 'content')

//       "/contents"(controller:"content"){
//           action = [GET:"index", POST:"save"]
//       }
//       "/contents/$id"(controller:"content"){
//            action = [GET:"show", PUT:"update", DELETE:"delete"]
//       }

        "/contents/$id?(.$format)?"(controller:"content"){
            action = [GET:"show", PUT:"update", DELETE:"delete", POST:"save"]
        }



        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
