package com.example.a7_th_month_project.domain.usecase

import com.example.a7_th_month_project.domain.model.Note
import com.example.a7_th_month_project.domain.repository.NoteRepository
import javax.inject.Inject

class UpdateNoteUseCase@Inject constructor(private val noteRepository: NoteRepository) {
    operator fun invoke(note: Note) = noteRepository.updateNote(note)

}