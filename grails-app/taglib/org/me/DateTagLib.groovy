package org.me

class DateTagLib {
    static defaultEncodeAs = 'html'


    static namespace = "dt"

    def formatDate = { attrs ->

        if (attrs.date.getTime() != java.lang.Long.MAX_VALUE)
            out << new java.text.SimpleDateFormat("MMM dd, yyyy").format(attrs.date)
        else
            out << 'NO EXPIRATION'
    }
}
