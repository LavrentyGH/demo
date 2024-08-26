package com.example.demo.mappers

import com.example.demo.dto.TodoDto
import com.example.demo.entity.TodoEntity

object Mapper {
    fun mapperToEntity(todoDto: TodoDto): TodoEntity {
        return TodoEntity().apply {
            status = todoDto.status!!
            text = todoDto.text
        }
    }
    fun mapperToDto(todo: TodoEntity): TodoDto{
        return TodoDto().apply {
            status = todo.status
            text = todo.text
        }
    }

}