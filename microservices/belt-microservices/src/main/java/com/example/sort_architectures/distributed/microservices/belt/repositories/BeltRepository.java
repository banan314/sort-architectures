package com.example.sort_architectures.distributed.microservices.belt.repositories;

import com.example.sort_architectures.distributed.microservices.belt.entities.BeltItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeltRepository extends CrudRepository<BeltItem, Long> {
}
