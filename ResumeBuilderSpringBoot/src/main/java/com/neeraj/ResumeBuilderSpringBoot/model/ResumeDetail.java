package com.neeraj.ResumeBuilderSpringBoot.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ResumeDetails")
public class ResumeDetail 
{
	
	//toString Method is here
	@Override
	public String toString() {
		return "ResumeDetail [id=" + id + ", name=" + name + ", mobile=" + mobile + ", email="
				+ email + ", linkdinId=" + linkdinId + ", GitId=" + gitId + ", declaration=" + declaration + "]";
	}
	
	
	//Table Data 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @NotNull
	private int id;
	
	@NotEmpty(message="This field can not be empty")
	private String name;
	
	@NotEmpty(message="This field can not be empty")
	private String mobile;
	
	@NotEmpty(message="This field can not be empty")
	@Email
	private String email ;
	
	private String linkdinId;
	
	
	private String gitId;
	
	//@Length(min=10 ,max=600)
	//@NotEmpty(message="This field can not be empty")
	private String declaration;
	
	//Getters And Setters Here 

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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLinkdinId() {
		return linkdinId;
	}

	public void setLinkdinId(String linkdinId) {
		this.linkdinId = linkdinId;
	}

	public String getGitId() {
		return gitId;
	}

	public void setGitId(String gitId) {
		this.gitId = gitId;
	}
	
	public String getDeclaration() {
		return declaration;
	}

	public void setDeclaration(String declaration) {
		this.declaration = declaration;
	}
}
