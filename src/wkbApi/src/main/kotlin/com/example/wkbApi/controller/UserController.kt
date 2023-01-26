package com.example.wkbApi.controller

import com.example.wkbApi.UserRepository
import com.example.wkbApi.models.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(private val repository: UserRepository) {
    @GetMapping
    fun getAllUser(): Iterable<User> {
        return repository.findAll()
    }

    @PostMapping
    fun createUser(@RequestBody newUser: User) {
        repository.save(newUser)
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: String): User? {
        return repository.findById(id)
    }
}
