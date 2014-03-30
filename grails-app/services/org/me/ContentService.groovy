package org.me

import grails.transaction.Transactional

/**
 * Services to manage the content domain
 */
@Transactional
class ContentService {

    def getViewable(Date date, int max, int offset) {

        Content.findAllByStartDateLessThanAndEndDateGreaterThan(date, date, [sort: "documentKey", max:max, offset:offset])
    }

    def getViewable(Date date) {

        Content.findAllByStartDateLessThanAndEndDateGreaterThan(date, date, [sort: "documentKey"])
    }


    def search(Content content) {

        def documentKey = content.documentKey ?: "%"
        def author = content.author ?: "%"

        def criteria = Content.createCriteria()

        criteria.list {
            and {
                like ( "documentKey", documentKey)
                like ( "author" , author )
            }
        }

    }
}
