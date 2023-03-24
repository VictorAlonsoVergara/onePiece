package com.anime.onepiece.model;

import java.util.List;

public class FullCharacter extends Character {
    private List<String> nicknames;
    private String about;
    private List<InfoCharacter> animes;
    private List<InfoCharacter> mangas;

    public FullCharacter() {
        super();
    }

    public FullCharacter(Integer idCharacter, String url, String imageUrl, String name, String role, List<String> nicknames, String about, List<InfoCharacter> animes, List<InfoCharacter> mangas) {
        super(idCharacter, url, imageUrl, name, role);
        this.nicknames = nicknames;
        this.about = about;
        this.animes = animes;
        this.mangas = mangas;
    }

    public List<String> getNicknames() {
        return nicknames;
    }

    public void setNicknames(List<String> nicknames) {
        this.nicknames = nicknames;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public List<InfoCharacter> getAnimes() {
        return animes;
    }

    public void setAnimes(List<InfoCharacter> animes) {
        this.animes = animes;
    }

    public List<InfoCharacter> getMangas() {
        return mangas;
    }

    public void setMangas(List<InfoCharacter> mangas) {
        this.mangas = mangas;
    }
}
