package com.example.demo.controller

import com.example.demo.dto.CustomSuccessResponse
import com.example.demo.dto.GetNewsDto
import com.example.demo.dto.TodoDto
import com.example.demo.entity.TodoEntity
import com.example.demo.service.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/v1/todo")
class TodoController {
    @Autowired
    private val todoService: TodoService? = null

    @PostMapping
    fun create(@RequestBody @Validated(TodoDto.Create::class) dto: TodoDto?):
    Any{
    //ResponseEntity<CustomSuccessResponse<TodoEntity?>?>? {
        return ResponseEntity<Any?>(todoService?.create(dto), HttpStatus.CREATED)
    }

    @GetMapping
    fun getPaginated(
        @RequestParam page: Int?,
        @RequestParam perPage: Int?,
        @RequestParam(required = false) status: Boolean?
    ): ResponseEntity<CustomSuccessResponse<GetNewsDto?>?>? {
        return CustomSuccessResponse<GetNewsDto>().okWithData(todoService?.getPaginated(page!!, perPage, status))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long?): ResponseEntity<CustomSuccessResponse<Void?>?>? {
        todoService?.delete(id)
        return CustomSuccessResponse<Void>().ok()
    }

    @DeleteMapping
    fun deleteAllReady(): ResponseEntity<CustomSuccessResponse<Void?>?>? {
        todoService?.deleteAllReady()
        return CustomSuccessResponse<Void>().ok()
    }

    @PatchMapping
    fun patch(@RequestBody @Validated(TodoDto.ChangeStatus::class) dto: TodoDto?):
            ResponseEntity<CustomSuccessResponse<Void?>?>? {
        if (dto != null) {
            todoService?.patch(dto)
        }
        return CustomSuccessResponse<Void>().ok()
    }

    @PatchMapping("/status/{id}")
    fun patchByStatus(
        @PathVariable id: Long?,
        @RequestBody @Validated(TodoDto.ChangeStatus::class) dto: TodoDto?
    ): ResponseEntity<CustomSuccessResponse<Void?>?>? {
        todoService?.patchStatus(id, dto!!)
        return CustomSuccessResponse<Void>().ok()
    }

    @PatchMapping("/text/{id}")
    fun patchText(
        @PathVariable id: Long?,
        @RequestBody @Validated(TodoDto.ChangeText::class) dto: TodoDto?
    ): ResponseEntity<CustomSuccessResponse<Void?>?>? {
        todoService?.patchText(id, dto!!)
        return CustomSuccessResponse<Void>().ok()
    }
}