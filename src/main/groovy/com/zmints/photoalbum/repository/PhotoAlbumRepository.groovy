package com.zmints.photoalbum.repository

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.zmints.photoalbum.model.Album
import groovy.util.logging.Slf4j
import kong.unirest.HttpResponse
import kong.unirest.JsonNode
import kong.unirest.Unirest
import org.springframework.stereotype.Component

@Slf4j
@Component
class PhotoAlbumRepository {

    List<Album> findAll() {
        try {

            HttpResponse<JsonNode> jsonResponse =
                    Unirest.get("https://jsonplaceholder.typicode.com/photos")
                            .header("accept", "application/json")
                            .asJson()

            JsonNode result = jsonResponse.body
            ObjectMapper objectMapper = new ObjectMapper()
            return objectMapper.readValue(result.toString(), new TypeReference<List<Album>>() {})

        } catch (Exception e) {
            log.info("Something went wrong", e)
        }

        return null
    }

    List<Album> findById(Integer id) {
        try {
            HttpResponse<JsonNode> jsonResponse =
                    Unirest.get("https://jsonplaceholder.typicode.com/photos")
                            .queryString("albumId", id)
                            .header("accept", "application/json")
                            .asJson()
            JsonNode result = jsonResponse.body
            ObjectMapper objectMapper = new ObjectMapper()
            return objectMapper.readValue(result.toString(), new TypeReference<List<Album>>() {})
        } catch (Exception e) {
            System.out.println("Some Error Has Occured");
            e.printStackTrace();
        }

        return null;
    }
}
