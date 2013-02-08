package com.jayway.template.sample;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PersonDTO {
	public PersonDTO(String userName) {
		this.userName = userName;
	}
	public PersonDTO() {
	}
	public String userName;
}
