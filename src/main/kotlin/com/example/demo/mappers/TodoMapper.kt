package com.example.demo.mappers

import com.example.demo.dto.TodoDto
import com.example.demo.entity.TodoEntity
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

@Mapper
class TodoMapper {

    fun todoDTOToEntity(todoDto: TodoDto): TodoEntity {
        var todoEntity = TodoEntity()
        todoEntity.status = todoDto.status!!
        todoEntity.text = todoDto.text!!

        return todoEntity

    }
//    companion object {
//        val INSTANCE: TodoMapper = Mappers.getMapper(TodoMapper::class.java)
//    }
//    fun todoToDto(todo: TodoEntity?): TodoDto {return TodoDto()
//    }
//    fun dtoToEntity(todoDto: TodoDto?): TodoEntity {return TodoEntity()}

//    /**Instance of TodoMapper. */
//    companion object {
//        var INSTANCE = Mappers.getMapper(TodoMapper::class.java)
//    }
//    fun todoToDto(todo: TodoEntity?): TodoDto?
//
//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "status", ignore = true)
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
//    fun dtoToEntity(todoDto: TodoDto?): TodoEntity?
}