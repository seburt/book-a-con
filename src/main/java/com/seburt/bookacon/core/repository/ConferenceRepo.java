package com.seburt.bookacon.core.repository;

import com.seburt.bookacon.core.model.ConferenceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConferenceRepo extends CrudRepository<ConferenceEntity, String> {
}
