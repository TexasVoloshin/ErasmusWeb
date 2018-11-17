
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

	@Column(name = "erasmus_email")
	private String erasmusEmail;

	@Column(name = "erasmus_name")
	private String erasmusName;

	@Column(name = "erasmus_surname")
	private String erasmusSurname;

	@Column(name = "erasmus_gender")
	private String erasmusGender;

	@Column(name = "erasmus_tel")
	private String erasmusTel;
	
	

	@Column(name = "erasmus_country")
	private String erasmusCountry;

	@Column(name = "erasmus_uni")
	private String erasmusUni;

	@Column(name = "erasmus_studies")
	private String erasmusStudies;

	@Column(name = "erasmus_facultyAGH")
	private String erasmusFacultyAGH;

	@Column(name = "erasmus_supervisor")
	private String erasmusSupervisor;

	@Column(name = "dormitory")
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
		return erasmusEmail;
	}

	public void setErasmusEmail(String erasmusEmail) {
		this.erasmusEmail = erasmusEmail;
	}

	public String getErasmusName() {
		return erasmusName;
	}

	public void setErasmusName(String erasmusName) {
		this.erasmusName = erasmusName;
	}

	public String getErasmusSurname() {
		return erasmusSurname;
	}

	public void setErasmusSurname(String erasmusSurname) {
		this.erasmusSurname = erasmusSurname;
	}

	public String getErasmusGender() {
		return erasmusGender;
	}

	public void setErasmusGender(String erasmusGender) {
		this.erasmusGender = erasmusGender;
	}
	
	public  String getErasmusTel() {
		return erasmusTel;
	}

	public void setErasmusTel(String erasmusTel) {
		this.erasmusTel = erasmusTel;
	}
	public String getErasmusCountry() {
		return erasmusCountry;
	}

	public void setErasmusCountry(String erasmusCountry) {
		this.erasmusCountry = erasmusCountry;
	}

	public String getErasmusUni() {
		return erasmusUni;
	}

	public void setErasmusUni(String erasmusUni) {
		this.erasmusUni = erasmusUni;
	}

	public String getErasmusStudies() {
		return erasmusStudies;
	}

	public void setErasmusStudies(String erasmusStudies) {
		this.erasmusStudies = erasmusStudies;
	}

	public String getErasmusFacultyAGH() {
		return erasmusFacultyAGH;
	}

	public void setErasmusFacultyAGH(String erasmusFacultyAGH) {
		this.erasmusFacultyAGH = erasmusFacultyAGH;
	}

	public String getErasmusSupervisor() {
		return erasmusSupervisor;
	}

	public void setErasmusSupervisor(String erasmusSupervisor) {
		this.erasmusSupervisor = erasmusSupervisor;
	}

	public String getDormitory() {
		return Dormitory;
	}

	public void setDormitory(String dormitory) {
		Dormitory = dormitory;
	}

	@Override
	public String toString() {
		return String.format("Customer[userId=%d, erasmus_name='%s', erasmus_surname='%s', erasmus_email='%s', erasmus_gender='%s',  erasmus_uni='%s', erasmus_tel='%s', erasmus_studies='%s',  erasmus_country='%s',  erasmus_facultyAGH='%s']", userId,
				erasmusName, erasmusSurname, erasmusEmail, erasmusGender,  erasmusUni, erasmusTel, erasmusStudies,  erasmusCountry,  erasmusFacultyAGH);
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