package ua.in.ip.notespgs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.in.ip.notespgs.entityes.Note;

import java.util.List;

@Repository
public interface NoteRepo extends JpaRepository<Note,Long> {
    List<Note> findByTitle(String title);
//    List<Note> findById(Long id);
}
