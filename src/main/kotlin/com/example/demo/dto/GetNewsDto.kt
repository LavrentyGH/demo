package com.example.demo.dto

import com.example.demo.entity.TodoEntity
import lombok.AllArgsConstructor
import lombok.Data

@Data
@AllArgsConstructor
class GetNewsDto {
    private val content: List<TodoEntity>? = null
    private val notReady: Int? = null
    private val numberOfElements: Int? = null
    private val ready: Int? = null
}