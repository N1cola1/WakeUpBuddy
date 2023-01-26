package com.example.wkbApi.models

import javax.persistence.*

@Entity
@Table(name="alarms")
class Alarm {
    @Column(nullable = false)
    var name: String = ""
    @Column(nullable = false)
    var time: String = ""
    var day: Int? = null
    var sound: String? = null
    var vibration: String? = null
    var isActive: Boolean = true
    @ManyToOne
    var group: Group? = null
    @ManyToOne
    var user: User? = null
    @Id
    @GeneratedValue
    var id: Long? = null
}