package com.example.Voting.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table
public class Voter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = true)
	private String name;
	@Column
	private String role;
	@Column()
	private int age;
	
	public Voter() {}
	
	public Voter(String name, String role, int age) {
		super();
		this.name = name;
		this.role = role;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Voter [id=" + id + ", name=" + name + ", role=" + role + ", age=" + age + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@PrePersist
    @PreUpdate
    private void validateAge() {
        if (age <= 18) {
            throw new IllegalArgumentException("User must be older than 18 years");
        }
    }
	

}
