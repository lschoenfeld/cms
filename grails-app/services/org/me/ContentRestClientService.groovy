package org.me

import grails.transaction.Transactional
import groovyx.net.http.ContentType
import groovyx.net.http.HTTPBuilder


import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*

/**
 * Rest client service
 */
@Transactional
class ContentRestClientService {


    def list() {
        def http = new HTTPBuilder("http://localhost:8080/cms/");

        http.request(GET, TEXT) { req ->
            uri.path = "contents"
            headers.'Accept' = 'application/json'
            headers.'Content-Type' = 'application/json'


            response.success = { resp, json ->
                println 'success'
                def contents = []
                def jsonArray = grails.converters.JSON.parse(json.text)

                jsonArray.each { it ->
                   contents <<  new Content(it)
                }
               contents
            }
        }
    }


    def get(int id) {
        def http = new HTTPBuilder("http://localhost:8080/cms/");

        http.request(GET, TEXT) { req ->
            uri.path = "contents/${id}"
            headers.'Accept' = 'application/json'
            headers.'Content-Type' = 'application/json'


            response.success = { resp, json ->
                println json
                println json.getClass().getName()
                def text = json.text
                println text
                new Content(grails.converters.JSON.parse(text));
            }
        }
    }


    //TODO:  response body is not consistent type.  See this : http://stackoverflow.com/questions/19123702/groovy-restclient-returns-inconsistent-type-on-response-handler
    // THis is related to the content type in the request()
    def save(org.me.client.Content content) {
        def http = new HTTPBuilder("http://localhost:8080/cms/");

        http.request(POST, JSON) { req ->
            uri.path = "contents"
            headers.'Accept' = 'application/json'
            headers.'Content-Type' = 'application/json'
            body = content



            response.success = { resp, json ->
                println json
                println json.getClass().getName()


                new Content(json)
            }
        }

    }
}
