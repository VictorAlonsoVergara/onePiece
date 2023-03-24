package com.anime.onepiece.service;

import com.anime.onepiece.model.Character;
import com.anime.onepiece.model.FullCharacter;
import com.anime.onepiece.model.InfoCharacter;
import com.anime.onepiece.model.Movie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterService {
    //El segundo enlace representa el endpoint para el listado de los personajes para una pelicula
    private String urlCharacter = "https://api.jikan.moe/v4/anime/id/characters";
    //El tercer enlace representa el endpoint para la informacion completa del personaje
    private String urlFullCharacter = "https://api.jikan.moe/v4/characters/id/full";

    public List<Character> findAllCharacters(Integer id){
        List<Character> listCharacter = new ArrayList<>();
        String newUrl = urlCharacter.replace("id",id.toString());
        try
        { //Se realiza la conexion con la api externa
            URL url = new URL(newUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //Se llama al metodo para realizar la conexion
            JSONObject o = connection(conn);
            JSONArray characters = o.getJSONArray("data");
            int lengthCharacters = characters.length();
            for(int i=0; i<lengthCharacters; i++){
                //Object posee el json recibido, ahora solo se necesita llenar uno por uno los datos al objeto character
                JSONObject object = characters.getJSONObject(i);
                Character character = new Character();
                fillCharacter(object, character);
                listCharacter.add(character);
            }
            conn.disconnect();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return listCharacter;
    }

    public FullCharacter findFullCharacter(Integer id){
        FullCharacter fullCharacter = new FullCharacter();
        String newUrl = urlFullCharacter.replace("id",id.toString());
        try
        { //Se realiza la conexion con la api externa
            URL url = new URL(newUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //Se llama al metodo para realizar la conexion
            JSONObject o = connection(conn);
            //Object posee el json recibido, ahora solo se necesita llenar los datos del objeto full character
            JSONObject object = o.getJSONObject("data");
            fillFullCharacter(object, fullCharacter);
            conn.disconnect();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return fullCharacter;
    }

    private void fillCharacter(JSONObject object, Character character){
        character.setIdCharacter(object.getJSONObject("character").getInt("mal_id"));
        character.setUrl(object.getJSONObject("character").getString("url"));
        character.setImageUrl(object.getJSONObject("character").getJSONObject("images").getJSONObject("jpg").getString("image_url"));
        character.setName(object.getJSONObject("character").getString("name"));
        character.setRole(object.getString("role"));
    }

    private void fillFullCharacter(JSONObject object, FullCharacter fullCharacter){
        fullCharacter.setIdCharacter(object.getInt("mal_id"));
        fullCharacter.setUrl(object.getString("url"));
        fullCharacter.setImageUrl(object.getJSONObject("images").getJSONObject("jpg").getString("image_url"));
        fullCharacter.setName(object.getString("name"));

        fullCharacter.setAbout(object.getString("about"));
        List<String> nicknames = new ArrayList<>();
        JSONArray arrayNicknames = object.getJSONArray("nicknames");
        int lengthNicknames = arrayNicknames.length();
        for(int i=0; i<lengthNicknames; i++){
            nicknames.add(arrayNicknames.getString(i));
        }
        fullCharacter.setNicknames(nicknames);
        List<InfoCharacter> infoCharacters = new ArrayList<>();
        JSONArray arrayAnimes = object.getJSONArray("anime");
        int lengthAnimes = arrayAnimes.length();
        for(int i=0; i<lengthAnimes; i++){
            InfoCharacter infoCharacter = new InfoCharacter();
            infoCharacter.setRole(arrayAnimes.getJSONObject(i).getString("role"));
            Movie movie = new Movie();
            movie.setIdMovie(arrayAnimes.getJSONObject(i).getJSONObject("anime").getInt("mal_id"));
            movie.setUrl(arrayAnimes.getJSONObject(i).getJSONObject("anime").getString("url"));
            movie.setImageUrl(arrayAnimes.getJSONObject(i).getJSONObject("anime").getJSONObject("images").getJSONObject("jpg").getString("image_url"));
            movie.setTitle(arrayAnimes.getJSONObject(i).getJSONObject("anime").getString("title"));
            infoCharacter.setMovie(movie);
            infoCharacters.add(infoCharacter);
        }
        fullCharacter.setAnimes(infoCharacters);
        infoCharacters = new ArrayList<>();
        JSONArray arrayMangas = object.getJSONArray("manga");
        int lengthMangas = arrayMangas.length();
        for(int i=0; i<lengthMangas; i++){
            InfoCharacter infoCharacter = new InfoCharacter();
            infoCharacter.setRole(arrayMangas.getJSONObject(i).getString("role"));
            Movie movie = new Movie();
            movie.setIdMovie(arrayMangas.getJSONObject(i).getJSONObject("manga").getInt("mal_id"));
            movie.setUrl(arrayMangas.getJSONObject(i).getJSONObject("manga").getString("url"));
            movie.setImageUrl(arrayMangas.getJSONObject(i).getJSONObject("manga").getJSONObject("images").getJSONObject("jpg").getString("image_url"));
            movie.setTitle(arrayMangas.getJSONObject(i).getJSONObject("manga").getString("title"));
            infoCharacter.setMovie(movie);
            infoCharacters.add(infoCharacter);
        }
        fullCharacter.setMangas(infoCharacters);
    }

    private JSONObject connection(HttpURLConnection conn) throws IOException, JSONException {
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        if (conn.getResponseCode() != 200)
        {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = br.read()) != -1)
        {
            sb.append((char) cp);
        }
        String output = sb.toString();
        return new JSONObject(output);
    }

}
