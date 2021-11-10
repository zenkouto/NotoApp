package dev.owl.notoapp.feature_note.domain.use_case

import dev.owl.notoapp.feature_note.domain.model.InvalidNoteException
import dev.owl.notoapp.feature_note.domain.model.Note
import dev.owl.notoapp.feature_note.domain.repository.NoteRepository

class AddNote(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note){
        if(note.title.isBlank()){
            throw InvalidNoteException("The title of the Note can't be empty.")
        }
        if(note.content.isBlank()){
            throw InvalidNoteException("Note is Empty!!")
        }
        repository.insertNote(note)
    }
}