package org.me

import grails.test.mixin.TestFor
import org.me.UserController
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UserController)
class UserControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test index action"() {

        ContentService contentService;
        def mockControl
        def result


        setup:
        mockControl = mockFor(ContentService)

        mockControl.demand.getViewable(1..1) { Date d ->
            [new Content(author:'me', documentKey:'doc2', entry:'hello')]


        }
        mockControl.demand.getViewable(1..1) { Date d , int max, int offset ->
            [new Content(author:'me', documentKey:'doc2', entry:'hello')]

        }
        contentService = mockControl.createMock()
        controller.contentService = contentService

        when:

        def model = controller.index()

        then:
        assert model.size() ==2
        assert model.contents.size() ==1
        assert model.total == 1
    }


    void "test show action"() {
    }

}
