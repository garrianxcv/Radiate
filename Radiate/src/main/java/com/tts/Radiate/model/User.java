package com.tts.Radiate.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.management.relation.Role;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.JoinTable;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int id;
	
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	@Lob
	private String bio;
	private String sex;
	@Lob
	private byte[] profilePic;
	private int active;
	
	
	@CreationTimestamp
	private Date createdAt;


	public void setRole(Set<com.tts.Radiate.model.Role> set) {
		// TODO Auto-generated method stub
		
	}

//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
//	private Set<Role> role;
//	 
	
	
}
