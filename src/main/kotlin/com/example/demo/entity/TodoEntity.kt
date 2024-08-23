package com.example.demo.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import lombok.experimental.Accessors
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "todo")
class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    var text: String? = null
    var status = false

    @CreationTimestamp
    private val createdAt: LocalDateTime? = null

    @UpdateTimestamp
    private val updatedAt: LocalDateTime? = null
}