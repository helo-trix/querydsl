package de.test.example;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Superior")
public class Superior extends BaseSupervisor {
}