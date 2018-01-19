package com.dongua.dotlin.bean

import org.greenrobot.greendao.annotation.Entity
import org.greenrobot.greendao.annotation.Id

/**
 * author: Lewis
 * data: On 18-1-11.
 */
@Entity
class Note {
    constructor(content: String, impLevel: Int, isDone: Boolean = false) {
        this.content = content
        this.impLevel = impLevel
        this.isDone = isDone
    }

    @Id(autoincrement = true)
    val id: Long? = null
    var author: String? = null
    var content: String? = null
    var updateTime: Long? = null
    var createTime: Long? = null
    var alertTIme: Long? = null
    var impLevel: Int? = null
    var isDone: Boolean  = false

}