package com.songlib.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.songlib.entities.Song;

public interface SongRepository extends CrudRepository<Song,Integer>{
	
	public List<Song> findAll();

}
