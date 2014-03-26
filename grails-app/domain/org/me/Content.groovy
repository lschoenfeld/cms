package org.me

/**
 * Domain object holding content
 */
class Content {

    String documentKey
    String author
    Date startDate = new Date()
    Date endDate = new Date(Long.MAX_VALUE)
    String entry

    static mapping = {
    }



    static constraints = {
        documentKey  unique:true

        endDate (validator: { val, obj ->
            val?.after(obj.startDate)
        })

    }
}
