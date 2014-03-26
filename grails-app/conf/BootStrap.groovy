import org.apache.commons.lang.RandomStringUtils
import org.apache.commons.lang.math.RandomUtils
import org.me.Content

class BootStrap {

    def init = { servletContext ->

        Date now = new Date();


        500.times() {
            def content = new Content(author: RandomStringUtils.randomAscii(10),
                startDate: now,
                endDate: now+RandomUtils.nextInt(180) + 1,
                documentKey: RandomStringUtils.randomAscii(10),
                entry: RandomStringUtils.randomAscii(100) ).save(failOnError:true)
        }

        def content = new Content (author:'larry', startDate: now, endDate: now+6,  documentKey: "news1", entry: 'hello world')
        content.save(failOnError: true)

        def content2 = new Content (author:'larry', startDate: now+2, endDate: now+3,  documentKey: "news2", entry: 'hello world2')
        content2.save(failOnError: true)

        def content3 = new Content (author:'larry',  documentKey: "news3", entry: 'hello world2')
        content3.save(failOnError: true)

    }
    def destroy = {
    }
}
