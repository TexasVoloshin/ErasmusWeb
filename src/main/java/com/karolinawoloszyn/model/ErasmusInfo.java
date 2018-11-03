
package com.karolinawoloszyn.model;
import java.util.Set;
import javax.persistence.NamedQuery;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name = "erasmusinfo")

public class ErasmusInfo {
 
 public int getIdErasmusInfo() {
		return idErasmusInfo;
	}

	public void setIdErasmusInfo(int idErasmusInfo) {
		this.idErasmusInfo = idErasmusInfo;
	}

	public String getErasmusEmail() {
		return ErasmusEmail;
	}

	public void setErasmusEmail(String erasmusEmail) {
		ErasmusEmail = erasmusEmail;
	}

	public String getErasmusName() {
		return ErasmusName;
	}

	public void setErasmusName(String erasmusName) {
		ErasmusName = erasmusName;
	}

	public String getErasmusSurname() {
		return ErasmusSurname;
	}

	public void setErasmusSurname(String erasmusSurname) {
		ErasmusSurname = erasmusSurname;
	}

	public String getErasmusGender() {
		return ErasmusGender;
	}

	public void setErasmusGender(String erasmusGender) {
		ErasmusGender = erasmusGender;
	}

	public String getErasmusCountry() {
		return ErasmusCountry;
	}

	public void setErasmusCountry(String erasmusCountry) {
		ErasmusCountry = erasmusCountry;
	}

	public String getErasmusUni() {
		return ErasmusUni;
	}

	public void setErasmusUni(String erasmusUni) {
		ErasmusUni = erasmusUni;
	}

	public String getErasmusStudies() {
		return ErasmusStudies;
	}

	public void setErasmusStudies(String erasmusStudies) {
		ErasmusStudies = erasmusStudies;
	}

	public String getErasmusFacultyAGH() {
		return ErasmusFacultyAGH;
	}

	public void setErasmusFacultyAGH(String erasmusFacultyAGH) {
		ErasmusFacultyAGH = erasmusFacultyAGH;
	}

	public String getErasmusSupervisor() {
		return ErasmusSupervisor;
	}

	public void setErasmusSupervisor(String erasmusSupervisor) {
		ErasmusSupervisor = erasmusSupervisor;
	}

	public String getDormitory() {
		return Dormitory;
	}

	public void setDormitory(String dormitory) {
		Dormitory = dormitory;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

@Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private int idErasmusInfo;
 
 @Column(name = "ErasmusEmail")
 private String ErasmusEmail;
 
 @Column(name = "ErasmusName")
 private String ErasmusName; 
 
 @Column(name = "ErasmusSurname")
 private String ErasmusSurname;
 
 @Column(name = "ErasmusGender")
 private String ErasmusGender;
 
 @Column(name = "ErasmusCountry")
 private String ErasmusCountry;
 
 @Column(name = "ErasmusUni")
 private String ErasmusUni;
 
 @Column(name = "ErasmusStudies")
 private String ErasmusStudies;
 
 @Column(name = "ErasmusFacultyAGH")
 private String ErasmusFacultyAGH;
 
 @Column(name = "ErasmusSupervisor")
 private String ErasmusSupervisor;
 
 @Column(name = "Dormitory")
 private String Dormitory;
 
 @ManyToMany(cascade=CascadeType.ALL)
 @JoinTable(name="user_role", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
 private Set<Role> roles;

 
}