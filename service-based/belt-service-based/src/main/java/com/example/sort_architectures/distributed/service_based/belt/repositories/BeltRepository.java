package com.example.sort_architectures.distributed.service_based.belt.repositories;

import com.example.sort_architectures.distributed.service_based.belt.entities.BeltItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeltRepository extends CrudRepository<BeltItem, Long> {
}
