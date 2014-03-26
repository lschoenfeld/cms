package org.me

import grails.converters.JSON
import groovy.json.JsonSlurper

/**
 * Restful client controller for administrative functions.
 * Note that some methods are not implemented.
 */
class ContentRestClientController {



    def contentRestClientService

    def list(){

        render contentRestClientService.list()

    }


    def get(){

        render contentRestClientService.get(params.int('id'))
    }

    def save() {

        org.me.client. Content content = new org.me.client.Content(author : "mr client", documentKey: '!TheKEY', entry: 'blah blah blah')
        render contentRestClientService.save(content)

    }

    def update() {
        throw new Exception("Not supported")
    }

    def search() {
        throw new Exception("Not supported")
    }

    def handleException(Exception ex) {
        render "${ex.toString()}"
    }
}
