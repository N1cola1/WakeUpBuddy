package com.example.wkbApi.controller

import com.example.wkbApi.UserRepository
import com.example.wkbApi.models.User
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("/users")
class UserController(private val repository: UserRepository) {
    @GetMapping
    fun getAllUser(@RequestParam(required = false) username: String?): Iterable<User> {
        if (username != null) {
            return listOf(repository.findByUsername(username))
        }
        return repository.findAll()
    }

    @PostMapping
    fun createUser(@RequestBody newUser: User): User {
        //todo validate the user data

        repository.save(newUser)
        return newUser
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) {
        repository.deleteById(id)
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): Optional<User> {
        val result = repository.findById(id)
        if (result.isEmpty) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }
        return result
    }

}
