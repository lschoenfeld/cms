import org.me.Content

class BootStrap {

    def init = { servletContext ->

        def content = new Content (author:'larry')
        content.createDate = new Date();
        content.updateDate = new Date();
        content.entry = "This is the content of this document"
        content.save();


        def content2 = new Content (author:'larry')
        content2.createDate = new Date();
        content2.updateDate = new Date();
        content2.entry = "Content 2 info"
        content2.save();
    }
    def destroy = {
    }
}
