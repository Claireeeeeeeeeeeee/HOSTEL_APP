package com.claire.hostelmanagementsystem.models

class payment {
    var name: String = ""
    var typeofroom: String = ""
    var userid: String = ""
    var checkindate:String=""
    var checkoutdate:String=""
    var id:String=""

    constructor(name: String, typeofroom: String, userid: String, checkindate: String, checkoutdate: String ,id: String ) {
        this.name = name
        this.typeofroom = typeofroom
        this.userid = userid
        this.checkindate=checkindate
        this.checkoutdate=checkoutdate
        this.id=id
    }


    constructor(name: Any, typeofroom: Any, userid: Any, checkindate: Any, checkoutdate: Any, id: String)
}