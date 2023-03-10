package com.example.a7_th_month_project.presentation.fillingNotes

import com.example.a7_th_month_project.base.BaseViewModel
import com.example.a7_th_month_project.domain.model.Note
import com.example.a7_th_month_project.domain.usecase.CreateNoteUseCase
import com.example.a7_th_month_project.domain.usecase.DeleteNoteUseCase
import com.example.a7_th_month_project.domain.usecase.GetAllNoteUseCase
import com.example.a7_th_month_project.domain.usecase.UpdateNoteUseCase
import com.example.a7_th_month_project.presentation.notes.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class FillingNotesViewModel @Inject constructor(
    private val getAllNoteUseCase: GetAllNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val editNoteUseCase: UpdateNoteUseCase,
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

    fun editNotes(note: Note) {
        editNoteUseCase(note).collectFlow(_updateNoteState)
    }

    fun createNotes(note: Note) {
        createNoteUseCase(note).collectFlow(_createNoteState)
    }
}


