package com.zmints.photoalbum.service

import com.zmints.photoalbum.model.Album
import com.zmints.photoalbum.repository.PhotoAlbumRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PathVariable

@Component
class PhotoAlbumService {
    @Autowired PhotoAlbumRepository repository

    List<String> listByAlbumId(@PathVariable Integer id)  {
        List<Album> albums = repository.findById(id)
        List<String> stringResult = []
        albums.each {Album album ->
            stringResult.add("[" + album.id + "] " + album.title)
        }
        stringResult
    }

}
