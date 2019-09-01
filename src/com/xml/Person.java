package com.xml;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="person")
public class Person {
	
	//@XmlElement(name="first_name")
	private String firstName;
	//
	//@XmlElement(name="last_name")
	private String lastName;
	
	private List<String> books;
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@XmlElementWrapper(name="books")
	@XmlElement(name="book")
	public List<String> getBooks() {
		return Arrays.asList("one","two","three");
		
	}

	public void setBooks(List<String> books) {
		this.books = books;
	}

	public static void main(String[] args)
	{
		Person chad = new Person();
		chad.setFirstName("Chad");
		chad.setLastName("Ogle");
		chad.setBooks(Arrays.asList("One","Two","Three"));
		try {
			JAXBContext context = JAXBContext.newInstance(Person.class);
			Marshaller marshall = context.createMarshaller();
			
			marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			File file = new File("person.xml");
			
			marshall.marshal(chad, file);
			marshall.marshal(chad, System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
