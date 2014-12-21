package com.demo.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.test.AndroidTestCase;
import android.util.Log;

import com.demo.domain.Person;
import com.demo.service.PersonService;

public class PersonServiceTest extends AndroidTestCase{

	private static final String Tag = "PersonServiceTest";
	public void testPerson() throws Exception{
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("person.xml");
		List<Person> persons = PersonService.getPersons(inputStream);
		for(Person person:persons){
			Log.i(Tag, person.toString());
		}
	}
	
	public void testSave() throws Exception{
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(12,"vv",22));
		persons.add(new Person(12,"vv",22));
		persons.add(new Person(12,"vv",22));
		File file = new File(getContext().getFilesDir(), "test.xml");
		FileOutputStream outputStream = new FileOutputStream(file);
		PersonService.saveToXML(persons, outputStream);
	}
}
