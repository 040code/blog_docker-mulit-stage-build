package demo.service;

import demo.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface NotesRepository extends CrudRepository<Note, Long> {

    Note findById(Long id);

    Page<Note> findAll(Pageable page);

}
