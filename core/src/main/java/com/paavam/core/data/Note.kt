package com.paavam.core.data

data class Note(
    var title: String,
    var content: String,
    var creationTime: Long,
    var updateTime: Long,
    var id: Long = 0,
    var priority: Int = 0,
    var wordCount: Int = 0,
)