package demo.web;

import demo.model.Note;
import demo.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class NoteController {

    @Autowired
    public NotesService notesService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createNote(@RequestBody Note note, UriComponentsBuilder uriComponentsBuilder) {
        notesService.save(note);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Note get(@PathVariable("id") Long id) {

        return notesService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<Note> list(@RequestParam(required = false) Pageable page) {

        return notesService.findAll(page);
    }
}
