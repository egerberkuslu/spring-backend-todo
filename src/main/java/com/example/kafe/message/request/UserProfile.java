package com.example.kafe.message.request;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NaturalId;

import com.example.kafe.model.Role;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class UserProfile {
	 	private String name;
	 	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private String username;
	 
	    @NaturalId
	    private String email;
	    
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(name = "user_roles", 
	      joinColumns = @JoinColumn(name = "user_id"), 
	      inverseJoinColumns = @JoinColumn(name = "role_id"))
	    private Set<Role> roles = new HashSet<>();

		public UserProfile(String name, String username, String email, Set<Role> roles) {
			super();
			this.name = name;
			this.username = username;
			this.email = email;
			this.roles = roles;
		}

		public UserProfile() {
			super();
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Set<Role> getRoles() {
			return roles;
		}

		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}
		
		
}
