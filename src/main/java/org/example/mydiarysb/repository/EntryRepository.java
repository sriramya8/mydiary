package org.example.mydiarysb.repository;

import org.example.mydiarysb.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EntryRepository extends JpaRepository<Entry, Long> {
    @Query(value="select * from entries where userid=:userid", nativeQuery=true)
    public List<Entry> findByUserid(long userid);
}
