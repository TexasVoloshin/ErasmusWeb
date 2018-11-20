package com.karolinawoloszyn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "erasmus_mentor_match")
public class PerfectMatch {
	
	@Id
	@Column(name = "id")
	private int id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "erasmus_id")
	private ErasmusInfo erasmus;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mentor_id")
	private MentorInfo mentor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ErasmusInfo getErasmus() {
		return erasmus;
	}

	public void setErasmus(ErasmusInfo erasmus) {
		this.erasmus = erasmus;
	}

	public MentorInfo getMentor() {
		return mentor;
	}

	public void setMentor(MentorInfo mentor) {
		this.mentor = mentor;
	}

}
