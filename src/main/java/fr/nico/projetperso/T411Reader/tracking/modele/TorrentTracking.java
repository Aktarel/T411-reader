package fr.nico.projetperso.T411Reader.tracking.modele;

public class TorrentTracking {

	private String comment; 
	private String name;
	private boolean seeder;
	private String size;
	private String left;
	
	public String getLeft() {
		return left;
	}
	public void setLeft(String left) {
		this.left = left;
	}
	private boolean finished;


	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	
}
