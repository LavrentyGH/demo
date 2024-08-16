package com.example.demo.mappers

import com.example.demo.dto.TodoDto
import com.example.demo.entity.TodoEntity
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

@Mapper
interface TodoMapper {
    /**Instance of TodoMapper. */
    var INSTANCE = Mappers.getMapper(TodoMapper::class.java)
    fun todoToDto(todo: TodoEntity?): TodoDto?

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    fun dtoToEntity(todoDto: TodoDto?): TodoEntity?
}