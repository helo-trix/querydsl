package de.test.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import jakarta.annotation.PostConstruct;

@Service
public class PersonService {
	private final Logger logger = LogManager.getLogger(PersonService.class);

	private PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@PostConstruct
	public void test() {
		String personId = "ca28f581-b489-4d6c-9171-c5f5143b2529";
		findPersons(personId).forEach(person -> logger.info(person.getId()));
	}

	public Iterable<Person> findPersons(String supervisorId) {
		BooleanBuilder builder = new BooleanBuilder();
		QPerson qPerson = QPerson.person;
		
		BooleanExpression isManager = qPerson.managers.any().supervisor.id.eq(supervisorId);
		BooleanExpression isSuperior = qPerson.managers.any().isNull().and(qPerson.superiors.any().supervisor.id.eq(supervisorId));
		builder.andAnyOf(isManager, isSuperior);
		
		return personRepository.findAll(builder);
	}
}