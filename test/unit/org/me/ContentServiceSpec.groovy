package org.me

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification


@TestFor(ContentService)
@Mock([Content])
class ContentServiceSpec extends Specification {

    def setup() {


        def now = new Date()
        new Content (author:'larry1', startDate: now-1, endDate: now+16,  documentKey: "news1", entry: 'hello world1').save()
        new Content (author:'larry3', startDate: now-1, endDate: now+16,  documentKey: "news2", entry: 'hello world2').save()
        new Content (author:'larry3', startDate: now+1, endDate: now+16,  documentKey: "news3", entry: 'hello world3').save()
        new Content (author:'larry4', startDate: now+2, endDate: now+16,  documentKey: "news4", entry: 'hello world4').save()
        new Content (author:'larry5', startDate: now+3, endDate: now+16,  documentKey: "news5", entry: 'hello world5').save()
    }

    def cleanup() {
    }

    void "test search"() {

        setup:

        when:
        def result = service.search(content)

        then:
        result.size() == numberMatched

        where:

        content                                            | numberMatched
        new Content(author: "larry3")                      | 2
        new Content(author: "larry4", documentKey: "%ew%") | 1
        new Content(author: "%xyz%")                       | 0
    }


    void "test date range"() {

        setup:

        when:

        def result = service.getViewable(date)

        then:
        result.size() == records

        result*.documentKey == listing


        where:
        date | records | listing
        new Date() | 2 | ['news1', 'news2']
        new Date()+20 | 0 | []
        new Date() +5 | 5 | ['news1', 'news2', 'news3', 'news4', 'news5']
        new Date() -12 | 0 | []

    }
}
