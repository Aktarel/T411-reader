package fr.nico.projetperso.T411Reader.model;

import java.util.Date;

public class TorrentTracking {

	private String comment; 
	private String createdBy ; 
	private Date creationDate; 
	private String name;
	private boolean seeder;
	private long size; 


	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSeeder() {
		return seeder;
	}
	public void setSeeder(boolean seeder) {
		this.seeder = seeder;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	
}
