package com.example.wkbApi

import com.example.wkbApi.models.*
import org.springframework.data.repository.CrudRepository

interface AlarmRepository : CrudRepository<Alarm, Long> {
    fun findAllByUserIdOrderByIsActive(userId: Long): List<Alarm>
    fun findAllByOrderByIsActive(): List<Alarm>
}

interface UserRepository : CrudRepository<User, Long> {
    fun findByUsername(username: String): User?
}

interface GroupRepository : CrudRepository<Group, Long> {

}