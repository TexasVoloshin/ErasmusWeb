
package com.karolinawoloszyn.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "erasmusinfo")

public class ErasmusInfo {

	@Id
	@Column(name = "user_id")
	private int userId;

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

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return String.format("Customer[userId=%d, ErasmusName='%s', ErasmusSurname='%s']", userId,
				ErasmusName, ErasmusSurname);
	}

	/*
	 * "ErasmusInfo [idErasmusInfo=" + idErasmusInfo + ", ErasmusEmail=" +
	 * ErasmusEmail + ", ErasmusName=" + ErasmusName + ", ErasmusSurname=" +
	 * ErasmusSurname + ", ErasmusGender=" + ErasmusGender + ", ErasmusCountry=" +
	 * ErasmusCountry + ", ErasmusUni=" + ErasmusUni + ", ErasmusStudies=" +
	 * ErasmusStudies + ", ErasmusFacultyAGH=" + ErasmusFacultyAGH +
	 * ", ErasmusSupervisor=" + ErasmusSupervisor + ", Dormitory=" + Dormitory +
	 * "]"; }
	 */

}