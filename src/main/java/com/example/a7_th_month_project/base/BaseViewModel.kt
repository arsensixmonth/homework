package com.example.a7_th_month_project.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a7_th_month_project.domain.utils.ResultStatus
import com.example.a7_th_month_project.presentation.notes.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {
    protected fun <T> Flow<ResultStatus<T>>.collectFlow(state: MutableStateFlow<UIState<T>>) {
        viewModelScope.launch {
            this@collectFlow.collect {
                when (it) {
                    is ResultStatus.Error -> state.value = UIState.Error(it.error)
                    is ResultStatus.Loading -> state.value = UIState.Loading()
                    is ResultStatus.Success -> if (it.data != null) {
                        state.value = UIState.Success(it.data)
                    }
                }
            }
        }
    }

}