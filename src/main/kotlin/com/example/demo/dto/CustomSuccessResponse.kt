package com.example.demo.dto

import com.fasterxml.jackson.annotation.JsonInclude
import lombok.Data
import lombok.NoArgsConstructor
import org.springframework.http.ResponseEntity

@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
class CustomSuccessResponse<T> {
    private val data: T? = null
    private val statusCode = 0
    private val success = true
    fun <T> okWithData(data: T): ResponseEntity<CustomSuccessResponse<T>?>? {
        val customSuccessResponse: CustomSuccessResponse<T> = CustomSuccessResponse()
        customSuccessResponse.setData(data)
        return ResponseEntity.ok().body(customSuccessResponse)
    }

    fun ok(): ResponseEntity<CustomSuccessResponse<Void?>?>? {
        return ResponseEntity.ok().body(CustomSuccessResponse())
    }
}