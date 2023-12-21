package com.spring_tutor.articles.DTO;

import javax.validation.constraints.NotEmpty;

public class AuthorDTO {
	@NotEmpty
	private Long id;

	@NotEmpty(message = "Name  should not be null or empty")
	private String name;

	@NotEmpty(message = "Gender should not be null or empty")
	private String gender;

	@NotEmpty(message = "Age should not be empty")
	private Integer age;

	@NotEmpty(message = "Email should not empty")
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
