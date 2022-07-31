package com.maytech.hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class songs {
	
	@Id
	private int id;
	
	private String songName;
	private String artist;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	@Override
	public String toString() {
		return "songs [id=" + id + ", songName=" + songName + ", artist=" + artist + ", getId()=" + getId()
				+ ", getSongName()=" + getSongName() + ", getArtist()=" + getArtist() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}

