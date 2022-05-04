package edu.egg.libreria.service;

import edu.egg.libreria.entity.Publisher;
import edu.egg.libreria.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepository publisherRepository;

    @Transactional
    public void create(Publisher publisherDto){
        Publisher publisher = new Publisher();
        publisher.setName(publisherDto.getName());
        publisher.setRegistration(true);

        publisherRepository.save(publisher);
    }

    @Transactional
    public void update(Publisher publisherDto) throws Exception {
        Publisher publisher = publisherRepository.findById(publisherDto.getId()).orElseThrow(() -> new Exception("Error"));

        publisher.setName(publisherDto.getName());
        publisher.setRegistration(publisherDto.isRegistration());

        publisherRepository.save(publisher);
    }

    @Transactional(readOnly = true)
    public Publisher getById(Integer id){
        return publisherRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<Publisher> getAll(){
        return publisherRepository.findAll();
    }

    @Transactional
    public void deleteById(Integer id){
        publisherRepository.deleteById(id);
    }

}
