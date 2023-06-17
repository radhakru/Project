package com.songlib.controllers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.songlib.entities.Song;
import com.songlib.respository.SongRepository;

@Controller

public class SongController {
	
	//create an instance of SongRepository.
	@Autowired
	private SongRepository songrepo;
	
	
	//create one controller for upload songs in bd.
	@RequestMapping("/")
	public String Songs(Model model) {
		model.addAttribute("title", "Home - Song Libray Project");
		model.addAttribute("song",new Song());
		return "addsongs";
	}
	
	@RequestMapping(value="/success",method=RequestMethod.POST)
	public String addSongs(@ModelAttribute("song") Song song,
			@RequestParam(value="profilesong") MultipartFile file) {
		
		try {
			if(file.isEmpty()) {
				System.out.println("not uploaded");
			}
			else {
				//upload file to folder and update the database.
				song.setSongname(file.getOriginalFilename());
				//store the song in static folder
				File files=new ClassPathResource("static/Songslib").getFile();
				
				//Paths.get(files.getAbsolutePath()+File.separatorChar+file.getOriginalFilename());
				Files.copy(file.getInputStream(), Paths.get(files.getAbsolutePath()+File.separatorChar+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			System.out.println("File is uploaded.");
			}
			
			
			
		System.out.println(song);
		songrepo.save(song);
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return "addsongs";
	}
	
	@RequestMapping("/songs")
	public String showsongs(Model model) {
		model.addAttribute("title","Show - Song Library");
		List<Song> songs=songrepo.findAll();
		
		model.addAttribute("song",songs);
		return "Showsongs";
	}

}
