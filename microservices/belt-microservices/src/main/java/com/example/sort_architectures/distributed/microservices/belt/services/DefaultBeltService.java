package com.example.sort_architectures.distributed.microservices.belt.services;

import com.example.sort_architectures.distributed.microservices.belt.dto.SortStatusDto;
import com.example.sort_architectures.distributed.microservices.belt.entities.BeltItem;
import com.example.sort_architectures.distributed.microservices.belt.exceptions.ItemPopppingException;
import com.example.sort_architectures.distributed.microservices.belt.exceptions.ItemsSortingException;
import com.example.sort_architectures.distributed.microservices.belt.repositories.BeltRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.random.RandomGenerator;

@Service
@AllArgsConstructor
public class DefaultBeltService implements BeltService {

    private static final double ERROR_RATE = 0.05;
    private static final RandomGenerator random = RandomGenerator.getDefault();
    private final BeltRepository beltRepository;
    private List<BeltItem> beltItemList;

    @Override
    public SortStatusDto startSorter() {
        return new SortStatusDto(SortStatusDto.Status.STARTED);
    }

    @Override
    public SortStatusDto stopSorter() {
        return new SortStatusDto(SortStatusDto.Status.STOPPED);
    }

    @Override
    public BeltItem popItem() throws ItemPopppingException {
        if (random.nextDouble() < ERROR_RATE) {
            throw new ItemPopppingException("Item not popped from the belt");
        }
        final var item = beltItemList.stream()
                .findFirst()
                .orElseThrow(() -> new ItemPopppingException("The sorter is empty"));
        beltItemList.remove(item);
        return item;
    }

    @Override
    public BeltItem placeItem(BeltItem item) {
        item = beltRepository.save(item);
        beltItemList.add(item);
        return item;
    }

    @Override
    public String sortItems() throws ItemsSortingException {
        if (random.nextDouble() < ERROR_RATE) {
            throw new ItemsSortingException("Item sorting failure");
        }

        beltItemList.sort(Comparator.naturalOrder());

        return "Items sorted successfully";
    }
}
