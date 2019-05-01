package com.revature.beans;

import java.time.LocalDate;

public class Actor {
	private int id;
	private String name;
	private LocalDate dateOfBirth;
	private String publicist;

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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPublicist() {
		return publicist;
	}

	public void setPublicist(String publicist) {
		this.publicist = publicist;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((publicist == null) ? 0 : publicist.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (publicist == null) {
			if (other.publicist != null)
				return false;
		} else if (!publicist.equals(other.publicist))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Actor [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", publicist=" + publicist + "]";
	}

	public Actor(int id, String name, LocalDate dateOfBirth, String publicist) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.publicist = publicist;
	}

	public Actor() {
		super();
	}

}
