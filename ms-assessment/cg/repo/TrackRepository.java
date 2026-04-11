package com.cg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Track;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer>{
	List<Track> findByTitle(String title);
}











/*
package com.example.springboot_assessment_1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot_assessment_1.entity.Track;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer>{
	List<Track> findByTitle(String title);
}

*/