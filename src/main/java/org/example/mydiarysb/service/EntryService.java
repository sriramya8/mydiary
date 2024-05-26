package org.example.mydiarysb.service;

import org.example.mydiarysb.entity.Entry;

import java.util.List;

public interface EntryService {
    public Entry save(Entry entry);
    public void delete(Entry entry);
    public Entry find(long id);
    public List<Entry> findAll();
    public List<Entry> findByUserid(long userid);
}
