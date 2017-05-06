package demo.service;

import demo.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service("noteService")
@Transactional
public class NotesServiceImpl implements NotesService {

    @Resource
    private NotesRepository notesRepository;

    @Override
    public Note save(Note note) {
        return this.notesRepository.save(note);
    }

    @Override
    public Note get(Long id) {
        return this.notesRepository.findById(id);
    }

    @Override
    public Page<Note> findAll(Pageable page) {
        return this.notesRepository.findAll(page);
    }
}
