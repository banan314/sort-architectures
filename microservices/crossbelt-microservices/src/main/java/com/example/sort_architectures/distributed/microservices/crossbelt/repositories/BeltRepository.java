package com.example.sort_architectures.distributed.microservices.crossbelt.repositories;

import com.example.sort_architectures.distributed.microservices.crossbelt.entities.BeltItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeltRepository extends CrudRepository<BeltItem, Long> {
}
