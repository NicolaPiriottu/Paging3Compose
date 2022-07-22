package com.example.paging3compose.utils

import android.util.Log

//ext func that retrive the init char of name and surname
fun String.nameInit() = if (this.contains(" ")) {
    if (this != "")
        "${this.split(" ").first().toCharArray()[0]}" +
                "${this.split(" ").last().toCharArray()[0]}" else ""
} else
    this[0].toString()

//ext func that make Log.d from string
fun String.log() = Log.d(if (this.contains(':')) {
    this.substringBefore(':')
} else {
    "MY_DEBUG"
}, if (this.contains(':')) {
    this.substringAfter(':')
} else {
    this
})