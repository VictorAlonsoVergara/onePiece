package com.anime.onepiece.service;

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
public class MovieService {
    //El primer enlace representa el endpoint para el listado de las películas
    private String urlMovies = "https://api.jikan.moe/v4/anime?q=one%20piece&type=Movie";

    public List<Movie> findAllMovies(){
        List<Movie> listMovie = new ArrayList<>();
        try
        { //Se realiza la conexion con la api externa
            URL url = new URL(urlMovies);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //Se llama al metodo para realizar la conexion
            JSONObject o = connection(conn);
            JSONArray movies = o.getJSONArray("data");
            int lengthMovies = movies.length();
            for(int i=0; i<lengthMovies; i++){
                //Object posee el json recibido, ahora solo se necesita llenar uno por uno los datos al objeto movie
                JSONObject object = movies.getJSONObject(i);
                Movie movie = new Movie();
                fillMovie(object, movie);
                listMovie.add(movie);
            }
            conn.disconnect();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return listMovie;
    }

    private void fillMovie(JSONObject object, Movie movie) throws JSONException {
        movie.setIdMovie(object.getInt("mal_id"));
        movie.setUrl(object.getString("url"));
        movie.setImageUrl(object.getJSONObject("images").getJSONObject("jpg").getString("image_url"));
        movie.setTitle(object.getString("title"));
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
