package de.test.example;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "supervisor_type")
public abstract class BaseSupervisor  extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	private Person supervisor;
	@ManyToOne(fetch = FetchType.LAZY)
	private Person subordinate;

	public Person getSupervisor() {
		return supervisor;
	}

	public Person getSubordinate() {
		return subordinate;
	}
}