package com.example.demo.reposirores

import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository extends JpaRepository<TodoEntity, Long> {
    @Modifying
    @Query("UPDATE TodoEntity t SET t.status = :status")
    fun updateStatus(status: Boolean?)
    fun deleteAllByStatus(status: Boolean?)

    @Query("SELECT t from TodoEntity t where t.status = :status")
    fun findByStatus(status: Boolean?, pageable: Pageable?): List<TodoEntity?>?

    @Query("SELECT count(t.status) from TodoEntity t where t.status = :status")
    fun findAllByStatus(status: Boolean?): Int?
}