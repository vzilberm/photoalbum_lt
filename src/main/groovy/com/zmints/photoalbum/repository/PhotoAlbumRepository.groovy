package com.zmints.photoalbum.repository

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest
import com.zmints.photoalbum.model.Album;
import org.springframework.stereotype.Component;

import java.net.http.HttpResponse

class PhotoAlbumRepository {
    List<Album> findAll() {
        try {

            HttpResponse<JsonNode> jsonResponse = Unirest.get("https://jsonplaceholder.typicode.com/photos").header("accept", "application/json").asJson();
            JsonNode result = jsonResponse.getBody();
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(result.toString(), new TypeReference<List<Album>>() {});

        } catch (Exception e) {
            System.out.println("Some Error Has Occured");
            e.printStackTrace();
        }

        return null;
    }
}
