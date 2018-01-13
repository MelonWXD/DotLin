package com.dongua.dotlin.bean

import org.greenrobot.greendao.annotation.Entity
import org.greenrobot.greendao.annotation.Id

/**
 * author: Lewis
 * data: On 18-1-11.
 */
@Entity
class Note {
    @Id(autoincrement = true)
    val id: Long? = null
    val author: String? = null
    val content: String? = null
    val updateTime: Long? = null
    val createTime: Long? = null
    val alertTIme: Long? = null

}