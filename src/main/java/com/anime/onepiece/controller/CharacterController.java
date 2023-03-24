package com.anime.onepiece.controller;

import com.anime.onepiece.model.Character;
import com.anime.onepiece.model.FullCharacter;
import com.anime.onepiece.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    @CrossOrigin
    @GetMapping("/characters/{id}")
    public List<Character> findAllCharacters(@PathVariable("id") Integer id){
        List<Character> characters = characterService.findAllCharacters(id);
        return characters;
    }

    @CrossOrigin
    @GetMapping("/fullcharacters/{id}")
    public FullCharacter findFullCharacter(@PathVariable("id") Integer id){
        FullCharacter fullCharacter = characterService.findFullCharacter(id);
        return fullCharacter;
    }

}
