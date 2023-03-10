package com.example.a7_th_month_project.domain.utils

sealed class ResultStatus<T>(
    val data: T? = null,
    val error: String = "Unknown error"
) {
    class Success<T>(data: T?) : ResultStatus<T>(data = data)
    class Loading<T>() : ResultStatus<T>()
    class Error<T>(msg: String) : ResultStatus<T>(error = msg)
}