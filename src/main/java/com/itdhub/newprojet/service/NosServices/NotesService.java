package com.itdhub.newprojet.service.NosServices;

import com.itdhub.newprojet.domain.NosClasses.Notes;
import com.itdhub.newprojet.repository.NosRepository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {
    private NotesRepository notesRepository;

    @Autowired
    public NotesService(NotesRepository notesRepository){

        this.notesRepository = notesRepository;
    }

    public List<Notes> getAllNotes() {

        return notesRepository.findAll();
    }

    public List<Notes> getNotesByEtudiantId(Long etudiantId) {
        return notesRepository.findByEtudiantId(etudiantId);
    }

    public Notes getNoteByMatiere(String matiere) {
        return notesRepository.findByMatiere(matiere);
    }

    public Notes saveNote(Notes note) {
        return notesRepository.save(note);
    }

    public void deleteNote(Long id) {
        notesRepository.deleteById(id);
    }

}
