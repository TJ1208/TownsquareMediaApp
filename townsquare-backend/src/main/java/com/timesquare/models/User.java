package com.timesquare.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private long userId;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "pasword", nullable = false)
	private String password;
	
	@Column(name = "profileImg")
	@Lob
	private String profileImg;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "profileBio")
	@Lob
	private String profileBio;
	
	@Column(name = "backgroundImg")
	@Lob
	private String backgroundImg;
	
	@Column(name = "birthDate", nullable = false)
	private java.sql.Date birthDate;
	
	@Column(name = "birthplace")
	private String birthplace;
	
	@Column(name = "homeTown")
	private String homeTown;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Address> addresses;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Friend> users;
	
	@OneToMany(mappedBy = "friend", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Friend> friends;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Image> images;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Contact> contacts;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Work> workplaces;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Education> educations;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Post> posts;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Comment> comments;
	
	@OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Request> requests;
	

}
