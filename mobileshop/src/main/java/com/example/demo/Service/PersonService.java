package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Person;
import com.example.demo.Repository.Personrepo;

@Service
public class PersonService {
@Autowired
 Personrepo repobj;
public Person addPerson(Person name)
{
	return repobj.save(name);
}
public List<Person> getPerson()
{
	return repobj.findAll();
}
}