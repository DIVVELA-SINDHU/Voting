package com.example.Voting.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table
public class Votes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private int vid;
	@Column
	private int cid;
	@Column
	private String status = "notCasted";
	
	public Votes() {}
	
	public Votes(int vid, int cid) {
		super();
		this.vid = vid;
		this.cid = cid;
	}



	public int getVid() {
		return vid;
	}



	public void setVid(int vid) {
		this.vid = vid;
	}



	public int getCid() {
		return cid;
	}



	public void setCid(int cid) {
		this.cid = cid;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "Votes [id=" + id + ", vid=" + vid + ", cid=" + cid + ", status=" + status + "]";
	}



	@PrePersist
	    public void castVote() {
	        this.status = "casted";
	    }

}
