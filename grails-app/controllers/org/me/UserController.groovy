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

        [contents:contentService.getViewable(new Date())]
    }

    /**
     * SHow the selected content
     * @return
     */
    def show() {
        [document: Content.get(params.id)]
    }
}
