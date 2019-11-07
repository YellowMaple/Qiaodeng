
package com.qiaodengtiyu.qiaodeng.domain

import com.qiaodengtiyu.qiaodeng.util.smartTruncate

/**
 * Domain objects are plain Kotlin data classes that represent the things in our app. These are the
 * objects that should be displayed on screen, or manipulated by the app.
 *
 * @see database for objects that are mapped to the database
 * @see network for objects that parse or prepare network calls
 */

/**
 * Videos represent a devbyte that can be played.
 */
data class Video(val title: String,
                 val description: String,
                 val url: String,
                 val updated: String,
                 val thumbnail: String) {

    /**
     * Short description is used for displaying truncated descriptions in the UI
     */
    val shortDescription: String
        get() = description.smartTruncate(200)
}
data class Sport(
        var id:String?="1",//id
        var type: String ="羽毛球",//运动类别
        var name:String="航天杯",//比赛名称
        var date:List<String>?,//比赛时间
        var locations:List<String>?,//地点
        var sponsors:List<String>?,//赞助商
        var managers:List<String>?,//管理员
        var referees:List<String>?,//裁判
        var players:List<String>?,//运动员吧
        var rule:String?//规则
)
