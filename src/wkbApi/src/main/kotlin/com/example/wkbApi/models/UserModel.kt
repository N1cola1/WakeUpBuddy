package com.example.wkbApi.models

import javax.persistence.*

@Entity
@Table(name="users")
class User {
    var lastname: String = ""
    var firstname: String = ""
    @Column(nullable = false, unique = true)
    var username: String = ""
    @Column(nullable = false)
    var password: String = ""
    @ManyToMany
    @JoinTable(
        name = "group_user",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "group_id", referencedColumnName = "id")]
    )
    var groups: List<Group> = mutableListOf()
    @OneToMany(mappedBy = "user")
    var alarms: List<Alarm> = mutableListOf()
    @Id
    @GeneratedValue
    var id: Long? = null
}