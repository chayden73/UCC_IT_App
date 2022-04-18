package com.example.uccitapp

class StaffModel {
    var name : String = ""
    var title : String = ""
    var programme : String = ""
    var email : String = ""
    var phone : String = ""
    var photo_name : String = ""

    constructor(name: String, title: String, programme: String, email: String, phone: String, photo_name: String) {
        this.name = name
        this.title = title
        this.programme = programme
        this.email = email
        this.phone = phone
        this.photo_name = photo_name
    }
}