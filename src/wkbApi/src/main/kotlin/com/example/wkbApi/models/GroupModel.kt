package com.example.wkbApi.models

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "groups")
class Group {
    @Column(nullable = false)
    var name: String = ""
    @ManyToMany(mappedBy = "groups")
    var users: List<User> = mutableListOf()
    @OneToMany(mappedBy = "group")
    var alarms: List<Alarm> = mutableListOf()
    @Id
    @GeneratedValue
    var id: Long? = null
}