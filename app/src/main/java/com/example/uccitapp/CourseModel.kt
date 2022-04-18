package com.example.uccitapp

class CourseModel {
    var code :String = ""
    var name : String = ""
    var credits : String = ""
    var prereq : String = ""
    var description : String? = null

    public constructor(code: String, name: String, credits: String, prereq: String, description : String) {
        this.code = code
        this.name = name
        this.credits = credits
        this.prereq = prereq
        this.description = description
    }

    constructor(){

    }



}