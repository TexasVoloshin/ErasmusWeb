
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
	private String erasmus_email;

	@Column(name = "erasmus_name")
	private String erasmus_name;

	@Column(name = "erasmus_surname")
	private String erasmus_surname;

	@Column(name = "erasmus_gender")
	private String erasmus_gender;

	@Column(name = "erasmus_tel")
	private String erasmus_tel;
	
	

	@Column(name = "erasmus_country")
	private String erasmus_country;

	@Column(name = "erasmus_uni")
	private String erasmus_uni;

	@Column(name = "erasmus_studies")
	private String erasmus_studies;

	@Column(name = "erasmus_facultyAGH")
	private String erasmus_facultyAGH;

	@Column(name = "erasmus_supervisor")
	private String erasmus_supervisor;

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

	public String getErasmus_email() {
		return erasmus_email;
	}

	public void setErasmus_email(String Erasmus_email) {
		erasmus_email = Erasmus_email;
	}

	public String getErasmus_name() {
		return erasmus_name;
	}

	public void setErasmus_name(String Erasmus_name) {
		erasmus_name = Erasmus_name;
	}

	public String getErasmus_surname() {
		return erasmus_surname;
	}

	public void setErasmus_surname(String Erasmus_surname) {
		erasmus_surname = Erasmus_surname;
	}

	public String getErasmus_gender() {
		return erasmus_gender;
	}

	public void setErasmus_gender(String Erasmus_gender) {
		erasmus_gender = Erasmus_gender;
	}
	
	public  String getErasmus_tel() {
		return erasmus_tel;
	}

	public void setErasmus_tel(String Erasmus_tel) {
		erasmus_tel = Erasmus_tel;
	}
	public String getErasmus_country(String erasmus_country) {
		return erasmus_country;
	}

	public void setErasmus_country(String Erasmus_country) {
		erasmus_country = Erasmus_country;
	}

	public String getErasmus_uni() {
		return erasmus_uni;
	}

	public void setErasmus_uni(String Erasmus_uni) {
		erasmus_uni = Erasmus_uni;
	}

	public String getErasmus_studies(String erasmus_studies) {
		return erasmus_studies;
	}

	public void setErasmus_studies(String Erasmus_studies) {
		erasmus_studies = Erasmus_studies;
	}

	public String getErasmus_facultyAGH(String erasmus_facultyAGH) {
		return erasmus_facultyAGH;
	}

	public void setErasmus_facultyAGH(String Erasmus_facultyAGH) {
		erasmus_facultyAGH = Erasmus_facultyAGH;
	}

	public String getErasmus_supervisor() {
		return erasmus_supervisor;
	}

	public void setErasmus_supervisor(String Erasmus_supervisor) {
		erasmus_supervisor = Erasmus_supervisor;
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
				erasmus_name, erasmus_surname, erasmus_email, erasmus_gender,  erasmus_uni, erasmus_tel, erasmus_studies,  erasmus_country,  erasmus_facultyAGH);
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