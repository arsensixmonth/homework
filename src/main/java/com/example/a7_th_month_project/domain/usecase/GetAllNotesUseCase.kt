package com.example.a7_th_month_project.domain.usecase

import com.example.a7_th_month_project.domain.model.Note
import com.example.a7_th_month_project.domain.repository.NoteRepository
import com.example.a7_th_month_project.domain.utils.ResultStatus
import java.util.concurrent.Flow
import javax.inject.Inject

class GetAllNoteUseCase@Inject constructor(private val noteRepository: NoteRepository) {
    operator fun invoke() : kotlinx.coroutines.flow.Flow<ResultStatus<List<Note>>> {
        return noteRepository.getAllNotes()
    }

}