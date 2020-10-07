package com.zmints.photoalbum.model

import com.fasterxml.jackson.annotation.JsonProperty

class Album {

    @JsonProperty("albumId")
    int albumId
    @JsonProperty("id")
    int id
    @JsonProperty("title")
    String title
    @JsonProperty("url")
    String url
    @JsonProperty("thumbnailUrl")
    String thumbnailUrl
}
