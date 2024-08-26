package com.example.demo.dto

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Null
import lombok.Data
import org.hibernate.validator.constraints.Length
import java.time.LocalDateTime

@Data
class TodoDto {
    @Null(groups = [ChangeStatus::class, ChangeText::class])
    private val id: Long? = null

    @Null(groups = [ChangeStatus::class])
    @NotNull(groups = [Create::class, ChangeText::class])
    var text: @Length(max = 160, min = 3, groups = [Create::class, ChangeText::class]) String? = null

    @Null(groups = [ChangeText::class])
    @NotNull(groups = [ChangeStatus::class])
    var status: Boolean? = null

    @Null(groups = [ChangeText::class, ChangeStatus::class])
    val createdAt: LocalDateTime? = null

    @Null(groups = [ChangeStatus::class, ChangeText::class])
    val updatedAt: LocalDateTime? = null

    interface ChangeStatus
    interface Create
    interface ChangeText
}