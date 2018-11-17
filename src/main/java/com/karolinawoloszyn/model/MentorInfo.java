
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
	private String mentorEmail;
	
	@Column(name = "mentor_tel")
	private String mentorTel;

	@Column(name = "mentor_name")
	private String mentorName;

	@Column(name = "mentor_surname")
	private String mentorSurname;

	@Column(name = "mentor_gender")
	private String mentorGender;

	@Column(name = "mentor_countryOfErasmus")
	private String mentorCountryOfErasmus;

	@Column(name = "mentor_uni")
	private String mentorUni;

	@Column(name = "mentor_studies")
	private String mentorStudies;

	@Column(name = "mentor_facultyAGH")
	private String mentorFacultyAGH;

	@Column(name = "mentor_supervisor")
	private String mentorSupervisor;

	@Column(name = "ESN_member")
	private String esnMember;

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


	public String getMentorEmail() {
		return mentorEmail;
	}

	public void setMentorEmail(String mentorEmail) {
		this.mentorEmail = mentorEmail;
	}

	public String getMentorTel() {
		return mentorTel;
	}

	public void setMentorTel(String mentorTel) {
		this.mentorTel = mentorTel;
	}

	public String getMentorName() {
		return mentorName;
	}

	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}

	public String getMentorSurname() {
		return mentorSurname;
	}

	public void setMentorSurname(String mentorSurname) {
		this.mentorSurname = mentorSurname;
	}

	public String getMentorGender() {
		return mentorGender;
	}

	public void setMentorGender(String mentorGender) {
		this.mentorGender = mentorGender;
	}

	public String getMentorCountryOfErasmus() {
		return mentorCountryOfErasmus;
	}

	public void setMentorCountryOfErasmus(String mentorCountryOfErasmus) {
		this.mentorCountryOfErasmus = mentorCountryOfErasmus;
	}

	public String getMentorUni() {
		return mentorUni;
	}

	public void setMentorUni(String mentorUni) {
		this.mentorUni = mentorUni;
	}

	public String getMentorStudies() {
		return mentorStudies;
	}

	public void setMentorStudies(String mentorStudies) {
		this.mentorStudies = mentorStudies;
	}

	public String getMentorFacultyAGH() {
		return mentorFacultyAGH;
	}

	public void setMentorFacultyAGH(String mentorFacultyAGH) {
		this.mentorFacultyAGH = mentorFacultyAGH;
	}

	public String getMentorSupervisor() {
		return mentorSupervisor;
	}

	public void setMentorSupervisor(String mentorSupervisor) {
		this.mentorSupervisor = mentorSupervisor;
	}

	public String getEsnMember() {
		return esnMember;
	}

	public void setEsnMember(String esnMember) {
		this.esnMember = esnMember;
	}

	@Override
	public String toString() {
		return String.format("Customer[userId=%d, mentor_name='%s', mentor_surname='%s', mentor_email='%s', mentor_gender='%s',  mentor_uni='%s', mentor_tel='%s', mentor_studies='%s',  mentor_countryOfErasmus='%s',  mentor_facultyAGH='%s']", userId,
				mentorName, mentorSurname, mentorEmail, mentorGender,  mentorUni, mentorTel, mentorStudies,  mentorCountryOfErasmus,  mentorFacultyAGH);
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