package org.example.monolith.layered.repositories;

import org.example.monolith.layered.entities.BeltItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeltRepository extends CrudRepository<BeltItem, Long> {
}
