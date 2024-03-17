package org.example.monolith.layered.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BeltItem implements Comparable<BeltItem> {

    @GeneratedValue
    @Id
    private Long id;

    @Column
    private String description;

    public BeltItem() {
    }

    public BeltItem(final BeltItem other) {
        this.id = other.id;
        this.description = other.description;
    }

    public BeltItem(final Long id, final String description) {
        this.id = id;
        this.description = description;
    }

    public BeltItem(final String description) {
        this.description = description;
    }

    @Override
    public int compareTo(@Nonnull final BeltItem o) {
        if (this.id != null && o.id != null) {
            return (int) (this.id - o.id);
        }
        if (this.description != null && o.description != null) {
            return this.description.compareToIgnoreCase(o.description);
        }
        return 0;
    }
}
