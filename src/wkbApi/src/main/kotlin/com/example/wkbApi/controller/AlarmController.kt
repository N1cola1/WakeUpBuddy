package com.example.wkbApi.controller

import com.example.wkbApi.AlarmRepository
import com.example.wkbApi.models.Alarm
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
@RequestMapping("/alarms")
class AlarmController(private val repository: AlarmRepository) {

    @GetMapping
    fun getAllAlarms(@RequestParam("userId") userId: Long?): Iterable<Alarm> {
        println("getAllAlarms called")

        if (userId != null) {
            return repository.findAllByUserIdOrderByIsActive(userId)
        }

        return repository.findAllByOrderByIsActive()
    }

    @PostMapping
    fun createAlarm(@RequestBody newAlarm: Alarm) {
        repository.save(newAlarm)
    }

    @DeleteMapping("/{id}")
    fun deleteAlarm(@PathVariable id: Long) {
        repository.deleteById(id)
    }

    @GetMapping("/{id}")
    fun getAlarmById(@PathVariable id: Long): Optional<Alarm> {
        val result = repository.findById(id)
        if (result.isEmpty) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }
        return result
    }
}