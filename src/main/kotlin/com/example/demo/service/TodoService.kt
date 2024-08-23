package com.example.demo.service

import com.example.demo.dto.GetNewsDto
import com.example.demo.dto.TodoDto
import com.example.demo.entity.TodoEntity
import com.example.demo.mappers.TodoMapper
import com.example.demo.reposirores.TodoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TodoService {

    @Autowired
    private val todoRepository: TodoRepository? = null

    @Transactional
    fun create(dto: TodoDto?): TodoDto? {
        val entity: TodoEntity = TodoMapper.  TodoMapper. toToEntity(dto)!!

        todoRepository?.save(entity)
        return TodoMapper.INSTANCE.todoToDto(entity)
    }

    @Transactional
    fun delete(id: Long?) {
        todoRepository?.deleteById(id!!)
    }

    @Transactional
    fun deleteAllReady() {
        todoRepository?.deleteAllByStatus(true)
    }

    @Transactional
    fun patch(dto: TodoDto) {
        todoRepository?.updateStatus(dto.status)
    }

    @Transactional
    fun patchStatus(id: Long?, dto: TodoDto) {
        todoRepository?.findById(id!!)?.ifPresent { entity -> entity.status = dto.status!! }
    }

    @Transactional
    fun patchText(id: Long?, dto: TodoDto) {
        todoRepository?.findById(id!!)?.ifPresent { entity -> entity.status = dto.status!! }
    }

    fun getPaginated(page: Int, perPage: Int?, status: Boolean?): GetNewsDto? {
        val pageable: Pageable = PageRequest.of(page - 1, perPage!!, Sort.by("createdAt"))
        val todoEntities: List<TodoEntity>
        todoEntities = if (status == null) {
            todoRepository?.findAll(pageable)!!.getContent()
        } else ({
            todoRepository?.findByStatus(status, pageable)
        }) as List<TodoEntity>
        val ready: Int = todoRepository?.findAllByStatus(true)!!
        val notReady: Int = todoRepository?.findAllByStatus(false)!!
        val allElements = ready + notReady
        return GetNewsDto(todoEntities, notReady, allElements, ready)
    }
}