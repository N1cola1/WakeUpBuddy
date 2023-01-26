package com.example.wkbApi

import com.example.wkbApi.models.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface AlarmRepository : CrudRepository<Alarm, Long> {
    fun findById(id: String): Alarm?
}

interface UserRepository : CrudRepository<User, Long> {
    fun findById(id: String): User?
}

interface GroupRepository : CrudRepository<Group, Long> {
    fun findById(id: String): Group?
}