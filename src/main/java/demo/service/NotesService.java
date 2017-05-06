package demo.service;

import demo.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NotesService {

    Note save(Note note);

    Note get(Long id);

    Page<Note> findAll(Pageable page);

}
