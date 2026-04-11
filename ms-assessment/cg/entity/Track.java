package com.cg.entity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "abes_track")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String albumName;
    private LocalDate releaseDate;

    public Track() {}

    public Track(String title, String albumName, LocalDate releaseDate) {
        this.title = title;
        this.albumName = albumName;
        this.releaseDate = releaseDate;
    }

    public Integer getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAlbumName() {
        return albumName;
    }
    public LocalDate getReleaseDate() {
        return releaseDate;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}


















/*
package com.example.springboot_assessment_1.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="abes_track")
public class Track {
	
	
	private Integer id;
	private String title;
	private String albumName;
	private LocalDate releaseDate;
	public Track() {
		
	}
	public Track(String title, String albumName, LocalDate releaseDate) {
		super();
		this.title = title;
		this.albumName = albumName;
		this.releaseDate = releaseDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	
	
}











/*
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "abes_track")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "track_id")
    private Long id;

    @Column(name = "track_title")
    private String title;

    @Column(name = "album_name")
    private String albumName;

    @Column(name = "release_dt")
    private LocalDate releaseDate;

    // Default Constructor
    public Track() {}

    // Parameterized Constructor
    public Track(String title, String albumName, LocalDate releaseDate) {
        this.title = title;
        this.albumName = albumName;
        this.releaseDate = releaseDate;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAlbumName() {
        return albumName;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}

*/