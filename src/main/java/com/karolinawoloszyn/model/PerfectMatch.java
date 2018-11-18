package com.karolinawoloszyn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "erasmus_mentor_match")

public class PerfectMatch {
	@Id
	@Column(name = "mentor_id")
	private int mentorId;

	public int getMentorId() {
		return mentorId;
	}

	public void setMentorId(int mentorId) {
		this.mentorId = mentorId;
	}

	public int getErasmusId() {
		return erasmusId;
	}

	public void setErasmusId(int erasmusId) {
		this.erasmusId = erasmusId;
	}

	@Column(name = "erasmus_id")
	private int erasmusId;

}
