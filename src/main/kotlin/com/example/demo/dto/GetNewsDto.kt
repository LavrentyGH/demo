package com.example.demo.dto

import com.example.demo.entity.TodoEntity
import lombok.AllArgsConstructor
import lombok.Data

@Data
@AllArgsConstructor
data class GetNewsDto (
    val content: List<TodoEntity>? = null,
    val notReady: Int? = null,
    val numberOfElements: Int? = null,
    val ready: Int? = null
        ) {
}