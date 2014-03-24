package org.me

import grails.rest.RestfulController
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ContentController  {

    static responseFormats = ['json','xml']

    def index() {
        println 'index action'
        respond Content.list();
    }

    def show(Content content) {
        println 'show action'
        respond content
    }

    @Transactional
    def save(Content content) {

        if (content.hasErrors()) {
            respond content.errors
        }
        else {
            content.save()
            respond content
        }

    }

    @Transactional
    def update(Content content) {
        if (content.hasErrors()) {
            respond content.errors
        }
        else {
            content.save()
            respond content
        }

    }

    def delete(Content content) {
        content.delete()
        respond Content.list()
    }
}
