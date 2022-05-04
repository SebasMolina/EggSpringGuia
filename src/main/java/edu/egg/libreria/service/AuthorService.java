package edu.egg.libreria.service;

import edu.egg.libreria.entity.Author;
import edu.egg.libreria.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Transactional
    public void create(Author authorDto){
        Author author = new Author();

        author.setName(authorDto.getName());
        author.setRegistration(authorDto.isRegistration());
        //author.setDeregistration(authorDto.isDeregistration());

        authorRepository.save(author);
    }

    @Transactional
    public void update(Author authorDto) throws Exception {
        Author author = authorRepository.findById(authorDto.getId()).orElseThrow(() -> new Exception("Error"));

        author.setName(authorDto.getName());
        author.setRegistration(authorDto.isRegistration());
        //author.setDeregistration(authorDto.isDeregistration());

        authorRepository.save(author);
    }

    @Transactional(readOnly = true)
    public Author getById(int id){
        return authorRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<Author> getAll(){
        return authorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public void deleteById(int id){
        authorRepository.deleteById(id);
    }
    /*
    @Transactional(readOnly = true)
    public void deregisterById(int id){

        authorRepository.;
    }
    */
}
