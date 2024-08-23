package com.example.demo.dto

import com.fasterxml.jackson.annotation.JsonInclude
import lombok.Data
import lombok.NoArgsConstructor
import org.springframework.http.ResponseEntity

@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
data class CustomSuccessResponse<T>(
    var data: T? = null,
    val statusCode: Int = 0,
    val success: Boolean = true
) {

    fun <T> okWithData(data: T): ResponseEntity<CustomSuccessResponse<T>?>? {
        val customSuccessResponse: CustomSuccessResponse<T> = CustomSuccessResponse()
        customSuccessResponse.data = data
        return ResponseEntity.ok().body(customSuccessResponse)
    }

    fun ok(): ResponseEntity<CustomSuccessResponse<Void?>?>? {
        return ResponseEntity.ok().body(CustomSuccessResponse())
    }
}