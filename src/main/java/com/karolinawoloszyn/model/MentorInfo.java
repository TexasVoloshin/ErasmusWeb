
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
@Table(name = "mentorinfo")

public class MentorInfo {

	@Id
	@Column(name = "user_id")
	private int userId;

	@Column(name = "mentor_email")
	private String mentor_email;
	
	@Column(name = "mentor_tel")
	private String mentor_tel;

	@Column(name = "mentor_name")
	private String mentor_name;

	@Column(name = "mentor_surname")
	private String mentor_surname;

	@Column(name = "mentor_gender")
	private String mentor_gender;

	@Column(name = "mentor_countryOfErasmus")
	private String mentor_countryOfErasmus;

	@Column(name = "mentor_uni")
	private String mentor_uni;

	@Column(name = "mentor_studies")
	private String mentor_studies;

	@Column(name = "mentor_facultyAGH")
	private String mentor_facultyAGH;

	@Column(name = "mentor_supervisor")
	private String mentor_supervisor;

	@Column(name = "Dormitory")
	private String Dormitory;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	public User getUser() {
		return user;
	}

	public   void setUser(User user) {
		this.user = user;
	}
	
	public int getUserId() {
		return userId;
	}

	public   void setUserId(int userId) {
	this.userId = userId;
	}

	public String getMentor_email() {
		return mentor_email;
	}

	public void setMentor_email(String Mentor_email) {
		mentor_email = Mentor_email;
	}

	public  String getMentor_tel() {
		return mentor_tel;
	}

	public void setMentor_tel(String Mentor_tel) {
		mentor_tel = Mentor_tel;
	}
	public String getMentor_name() {
		return mentor_name;
	}

	public void setMentor_name(String Mentor_name) {
		mentor_name = Mentor_name;
	}

	public String getMentor_surname() {
		return mentor_surname;
	}

	public void setMentor_surname(String Mentor_surname) {
		mentor_surname = Mentor_surname;
	}

	public String getMentor_gender() {
		return mentor_gender;
	}

	public void setMentor_gender(String Mentor_gender) {
		mentor_gender = Mentor_gender;
	}

	public String getMentor_countryOfErasmus() {
		return mentor_countryOfErasmus;
	}

	public void setMentor_country(String Mentor_countryOfErasmus) {
		mentor_countryOfErasmus = Mentor_countryOfErasmus;
	}

	public String getMentor_uni() {
		return mentor_uni;
	}

	public void setMentor_uni(String Mentor_uni) {
		mentor_uni = Mentor_uni;
	}

	public String getMentor_studies() {
		return mentor_studies;
	}

	public void setMentor_studies(String Mentor_studies) {
		mentor_studies = Mentor_studies;
	}

	public String getMentor_facultyAGH() {
		return mentor_facultyAGH;
	}

	public void setMentor_facultyAGH(String Mentor_facultyAGH) {
		mentor_facultyAGH = Mentor_facultyAGH;
	}

	public String getMentor_supervisor() {
		return mentor_supervisor;
	}

	public void setMentor_supervisor(String Mentor_supervisor) {
		mentor_supervisor = Mentor_supervisor;
	}

	public String getDormitory() {
		return Dormitory;
	}

	public void setDormitory(String dormitory) {
		Dormitory = dormitory;
	}

	@Override
	public String toString() {
		return String.format("Customer[userId=%d, mentor_name='%s', mentor_surname='%s', mentor_email='%s', mentor_gender='%s',  mentor_uni='%s', mentor_tel='%s', mentor_studies='%s',  mentor_countryOfErasmus='%s',  mentor_facultyAGH='%s']", userId,
				mentor_name, mentor_surname, mentor_email, mentor_gender,  mentor_uni, mentor_tel, mentor_studies,  mentor_countryOfErasmus,  mentor_facultyAGH);
	}

	/*
	 * "MentorInfo [idMentorInfo=" + idMentorInfo + ", MentorEmail=" +
	 * MentorEmail + ", MentorName=" + MentorName + ", MentorSurname=" +
	 * MentorSurname + ", MentorGender=" + MentorGender + ", MentorCountry=" +
	 * MentorCountry + ", MentorUni=" + MentorUni + ", MentorStudies=" +
	 * MentorStudies + ", MentorFacultyAGH=" + MentorFacultyAGH +
	 * ", MentorSupervisor=" + MentorSupervisor + ", Dormitory=" + Dormitory +
	 * "]"; }
	 */

}