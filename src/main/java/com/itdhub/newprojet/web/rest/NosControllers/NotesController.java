package com.itdhub.newprojet.web.rest.NosControllers;

import com.infobip.auth.Authentication;
import com.itdhub.newprojet.domain.NosClasses.Notes;
import com.itdhub.newprojet.service.NosServices.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NotesController {
    private final NotesService notesService;

    @Autowired
    public NotesController(NotesService notesService) {

        this.notesService = notesService;
    }

    @GetMapping("/notes")
    public ResponseEntity<List<Notes>> getAllNotes() {
        List<Notes> notes = notesService.getAllNotes();
            return ResponseEntity.ok(notes);
        }
    @GetMapping("/etudiant/{etudiantId}")
    public ResponseEntity<List<Notes>> getNotesByEtudiantId(@PathVariable Long etudiantId) {
        List<Notes> notes = notesService.getNotesByEtudiantId(etudiantId);
        return ResponseEntity.ok(notes);
    }

    @GetMapping("/matiere/{matiere}")
    public ResponseEntity<Notes> getNoteByMatiere(@PathVariable String matiere) {
        Notes note = notesService.getNoteByMatiere(matiere);
        return ResponseEntity.ok(note);
    }
    @PostMapping
    public ResponseEntity<Notes> createNote(@RequestBody Notes note) {
        Notes savedNote = notesService.saveNote(note);
        return ResponseEntity.ok(savedNote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        notesService.deleteNote(id);
        return ResponseEntity.noContent().build();
    }

    }

