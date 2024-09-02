package com.itdhub.newprojet.web.rest.NosControllers;

import com.infobip.auth.Authentication;
import com.itdhub.newprojet.domain.NosClasses.Notes;
import com.itdhub.newprojet.service.NosServices.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    }

