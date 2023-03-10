package com.example.a7_th_month_project.base

import com.example.a7_th_month_project.data.local.NoteDao
import com.example.a7_th_month_project.data.mapper.toNoteEntity
import com.example.a7_th_month_project.domain.utils.ResultStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException

abstract class BaseRepository {
    protected fun <T> doRequest(request: suspend () ->T) = flow {
        emit(ResultStatus.Loading())
        try {
            val getAll = request()
            emit(ResultStatus.Success(getAll))
        } catch (e: IOException) {
            emit(ResultStatus.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}