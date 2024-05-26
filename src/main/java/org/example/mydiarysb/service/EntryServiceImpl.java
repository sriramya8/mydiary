package org.example.mydiarysb.service;

import org.example.mydiarysb.entity.Entry;
import org.example.mydiarysb.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EntryServiceImpl implements EntryService{
    @Autowired
    private EntryRepository entryRepository;

    @Override
    public Entry save(Entry entry) {
        return entryRepository.save(entry);
    }

    @Override
    public void delete(Entry entry) {
        entryRepository.delete(entry);
    }

    @Override
    public Entry find(long id) {
        return entryRepository.getReferenceById(id);
    }

    @Override
    public List<Entry> findAll() {
        return entryRepository.findAll();
    }

    @Override
    public List<Entry> findByUserid(long userid) {
        return entryRepository.findByUserid(userid);
    }
}
