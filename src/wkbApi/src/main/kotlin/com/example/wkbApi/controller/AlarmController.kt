package com.example.wkbApi.controller

import com.example.wkbApi.AlarmRepository
import com.example.wkbApi.models.Alarm
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/alarms")
class AlarmController(private val repository: AlarmRepository) {

    @GetMapping
    fun getAllAlarms(): Iterable<Alarm> {
        println("getAllAlarms called")
        return repository.findAll()
    }

    @PostMapping
    fun createAlarm(@RequestBody newAlarm: Alarm) {
        repository.save(newAlarm)
    }

    @GetMapping("/{id}")
    fun getAlarmById(@PathVariable id: String): Alarm? {
        return repository.findById(id)
    }
}