package com.zmints.photoalbum.repository

import com.zmints.photoalbum.model.Album
import org.junit.Before
import org.junit.Test


class PhotoAlbumRepositoryTest {
    PhotoAlbumRepository repository

    @Before
    void setUp() {
        repository = new PhotoAlbumRepository()
    }

    @Test
    void findAll() {
        List<Album> albums = repository.findAll()
        assert albums.size() > 0
        assert albums.first().getId() == 1
        assert albums.first().getTitle().equals("accusamus beatae ad facilis cum similique qui sunt")
        assert albums.first().getAlbumId() == 1
        assert albums.first().getThumbnailUrl().equals("https://via.placeholder.com/150/92c952")
    }

    @Test
    void findById() {
        List<Album> albums = repository.findById(1)
        assert albums.size() > 0
        assert albums.first().albumId == 1
        assert albums.last().albumId == 1

    }

    @Test
    void no_albums_found(){
        List<Album> photoAlbumList = repository.findById(999)
        assert photoAlbumList.size() == 0
    }
}

