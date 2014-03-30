package org.me
/**
 * Restful client controller for administrative functions.
 * Note that some methods are not implemented.
 */
class ContentRestClientController {

    static allowedMethods = [save: ['GET', 'POST'], list: 'GET', get: 'GET']

    def contentRestClientService

    def list() {

        render contentRestClientService.list()
    }


    def get() {

        render contentRestClientService.get(params.int('id'))
    }

    def save() {


        if (params.author && params.documentKey && params.entry) {


            org.me.client.Content content = new org.me.client.Content(
                    author: params.author, documentKey: params.documentKey, entry: params.entry)

            try {
                contentRestClientService.save(content)
            }
            catch (Exception ex) {

                flash.message = ex.toString()
                return
            }

            flash.message = "SAVED"
        } else {
            flash.message = "missing input"
        }
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
