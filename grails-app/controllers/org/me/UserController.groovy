package org.me

/**
 * Controller for user to view content
 */
class UserController {

    def contentService

    /**
     * Show all viewable content.  Viewable =  current data is within date range
     * @return
     */
    def index() {

        int max = params.int('max') ?: 10
        int offset = params.int('offset') ?: 0

        def list = contentService.getViewable(new Date())

        def page = contentService.getViewable(new Date(), max, offset)

        params.max=10

        [contents:page, total:list.size()]
    }

    /**
     * SHow the selected content
     * @return
     */
    def show() {
        [document: Content.get(params.id)]
    }
}
