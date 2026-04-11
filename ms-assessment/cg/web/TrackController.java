package com.cg.web;

import com.cg.entity.Track;
import com.cg.repo.TrackRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tracks")
public class TrackController {

    private final TrackRepository trackRepository;

    @Autowired
    public TrackController(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }
    @PostMapping
    public ResponseEntity<String> addTrack(@RequestBody Track track) {
        trackRepository.save(track);
        return ResponseEntity.ok("Track added successfully");
    }
    @GetMapping
    public ResponseEntity<List<Track>> getTracks() {
        List<Track> tracks = trackRepository.findAll();
        return ResponseEntity.ok(tracks);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Track>> getTracksByTitle(@RequestParam String title) {
        List<Track> tracks = trackRepository.findByTitle(title);
        return ResponseEntity.ok(tracks);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getTrack(@PathVariable Integer id) {

        Optional<Track> track = trackRepository.findById(id);

        if (track.isPresent()) {
            return ResponseEntity.ok(track.get());
        } else {
            return ResponseEntity.status(404)
                    .body("Track not found with id: " + id);
        }
    }
}














/*

/*
 * package com.cg.web;

import com.cg.entity.Track;
import com.cg.repo.TrackRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tracks")
public class TrackController {

    private final TrackRepository trackRepository;

    // Constructor Injection
    @Autowired
    public TrackController(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    // ---------------------------------------------------------
    // 1. Add Track
    // POST /tracks
    // ---------------------------------------------------------
    @PostMapping
    public ResponseEntity<String> addTrack(@RequestBody Track track) {
        trackRepository.save(track);
        return ResponseEntity.ok("Track added successfully");
    }

    // ---------------------------------------------------------
    // 2. Get All Tracks
    // GET /tracks
    // ---------------------------------------------------------
    @GetMapping
    public ResponseEntity<List<Track>> getTracks() {
        List<Track> tracks = trackRepository.findAll();
        return ResponseEntity.ok(tracks);
    }

    // ---------------------------------------------------------
    // 3. Get Tracks by Title
    // GET /tracks/search?title=xyz
    // ---------------------------------------------------------
    @GetMapping("/search")
    public ResponseEntity<List<Track>> getTracksByTitle(@RequestParam String title) {
        List<Track> tracks = trackRepository.findByTitle(title);
        return ResponseEntity.ok(tracks);
    }

    // ---------------------------------------------------------
    // 4. Get Track by ID
    // GET /tracks/{id}
    // ---------------------------------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<Object> getTrack(@PathVariable Long id) {

        Optional<Track> track = trackRepository.findById(id);

        if (track.isPresent()) {
            return ResponseEntity.ok(track.get());
        } else {
            return ResponseEntity.status(404)
                    .body("Track not found with id: " + id);
        }
    }
}*/
