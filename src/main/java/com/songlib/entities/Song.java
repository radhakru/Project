package com.songlib.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="songs")
public class Song {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="filmname")
	private String filmname;
	
	@Column(name="heroname")
	private String heroname;
	
	@Column(name="heroinename")
	private String heroinename;
	
	@Column(name="singername")
	private String singername;
	
	@Column(name="songname")
	private String songname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilmname() {
		return filmname;
	}

	public void setFilmname(String filmname) {
		this.filmname = filmname;
	}

	public String getHeroname() {
		return heroname;
	}

	public void setHeroname(String heroname) {
		this.heroname = heroname;
	}

	public String getHeroinename() {
		return heroinename;
	}

	public void setHeroinename(String heroinename) {
		this.heroinename = heroinename;
	}

	public String getSingername() {
		return singername;
	}

	public void setSingername(String singername) {
		this.singername = singername;
	}

	public String getSongname() {
		return songname;
	}

	public void setSongname(String songname) {
		this.songname = songname;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", filmname=" + filmname + ", heroname=" + heroname + ", heroinename=" + heroinename
				+ ", singername=" + singername + ", songname=" + songname + "]";
	}
	
	
	
	
	

}
