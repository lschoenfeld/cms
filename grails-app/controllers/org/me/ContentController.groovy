package org.me

import grails.rest.RestfulController
import grails.transaction.Transactional

/**
 * Restful content management controller
 */

class ContentController {

    def contentService

    static allowedMethods = [search : "POST"]

    static responseFormats = ['json', 'xml']

    /**
     * GET cms/contents
     * @return
     */

    def index() {

        respond Content.list()
    }

    /**
     * GET cms/contents/id
     * @param content
     * @return
     */
    def show(Content content) {

        respond content
    }

    /**
     * POST cms/contents
     * @param content
     * @return
     */

    def save(Content content) {

        if (content.hasErrors()) {
            respond content.errors
        } else {
            content.save()
            respond content
        }

    }

    /**
     * PUT  cms/contents/{id}
     * @param content
     * @return
     */

    def update(Content content) {

        if (content.hasErrors()) {
            respond content.errors
        } else {
            content.save()
            respond content
        }
    }

    /**
     * DELETE cms/contents/id
     * @param content
     * @return
     */

    def delete(Content content) {
        content.delete()
        respond Content.list()
    }

    def search(Content content) {

        def list = contentService.search(content)


        respond list
    }
}
