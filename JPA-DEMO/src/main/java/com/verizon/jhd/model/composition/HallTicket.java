package com.verizon.jhd.model.composition;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="halltickets")
public class HallTicket {

	@Id
	private String hallticketNumber;
	private String candidateName;
	private String examTitle;
	
	@Embedded
	private Identification identity;
	
	public HallTicket() {
		
	}

	public HallTicket(String hallticketNumber, String candidateName, String examTitle, Identification identity) {
		super();
		this.hallticketNumber = hallticketNumber;
		this.candidateName = candidateName;
		this.examTitle = examTitle;
		this.identity = identity;
	}

	public String getHallticketNumber() {
		return hallticketNumber;
	}

	public void setHallticketNumber(String hallticketNumber) {
		this.hallticketNumber = hallticketNumber;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getExamTitle() {
		return examTitle;
	}

	public void setExamTitle(String examTitle) {
		this.examTitle = examTitle;
	}

	public Identification getIdentity() {
		return identity;
	}

	public void setIdentity(Identification identity) {
		this.identity = identity;
	}
	
	
}
