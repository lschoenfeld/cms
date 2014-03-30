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

        http.request(GET, JSON) { req ->
            uri.path = "contents"
            headers.'Accept' = 'application/json'
            headers.'Content-Type' = 'application/json'


            response.success = { resp, json ->
                def contents = []


                json.each { it ->
                   contents <<  new Content(it)
                }
               contents
            }
        }
    }


    def get(int id) {
        def http = new HTTPBuilder("http://localhost:8080/cms/");

        http.request(GET, JSON) { req ->
            uri.path = "contents/${id}"
            headers.'Accept' = 'application/json'
            headers.'Content-Type' = 'application/json'


            response.success = { resp, json ->
                new Content(json);
            }
        }
    }


     def save(org.me.client.Content content) {
        def http = new HTTPBuilder("http://localhost:8080/cms/");

        http.request(POST, JSON) { req ->
            uri.path = "contents"
            headers.'Accept' = 'application/json'
            headers.'Content-Type' = 'application/json'
            body = content



            response.success = { resp, json ->

                new Content(json)
            }
        }

    }
}
