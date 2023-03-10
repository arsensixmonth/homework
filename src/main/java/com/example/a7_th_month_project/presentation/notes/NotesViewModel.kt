package com.example.a7_th_month_project.presentation.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a7_th_month_project.base.BaseViewModel
import com.example.a7_th_month_project.domain.model.Note
import com.example.a7_th_month_project.domain.usecase.*
import com.example.a7_th_month_project.domain.utils.ResultStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val getAllNoteUseCase: GetAllNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase,
    private val createNoteUseCase: CreateNoteUseCase
) : BaseViewModel() {
    private val _noteState = MutableStateFlow<UIState<List<Note>>>(UIState.Empty())
    val noteState = _noteState.asStateFlow()

    private val _deleteNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val deleteNoteState = _deleteNoteState.asStateFlow()

    private val _updateNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val updateState = _updateNoteState.asStateFlow()

    private val _createNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val createNoteState = _createNoteState.asStateFlow()

    fun getAllNotes() {
        getAllNoteUseCase().collectFlow(_noteState)
    }

    fun delete(note: Note) {
        deleteNoteUseCase(note).collectFlow(_deleteNoteState)
    }

    fun updateNotes(note: Note) {
        updateNoteUseCase(note).collectFlow(_updateNoteState)
    }

    fun createNotes(note: Note) {
        createNoteUseCase(note).collectFlow(_createNoteState)
    }

}