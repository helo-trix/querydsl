package de.test.example;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity
public class Person extends BaseEntity {
	@OneToMany(mappedBy="subordinate", fetch = FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval = true)
	private List<Superior> superiors = new ArrayList<>();

	@OneToMany(mappedBy="subordinate", fetch = FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval = true)
	private List<Manager> managers = new ArrayList<>();

	public List<Superior> getSuperiors() {
		return superiors;
	}

	public List<Manager> getManagers() {
		return managers;
	}
}