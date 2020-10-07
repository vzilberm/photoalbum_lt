package com.zmints.photoalbum.service

import com.zmints.photoalbum.model.Album
import com.zmints.photoalbum.repository.PhotoAlbumRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import static org.mockito.Mockito.mock
import static org.mockito.Mockito.when

class PhotoAlbumServiceTest {
    PhotoAlbumRepository repository
    PhotoAlbumService service

    @BeforeEach
    void setUp() {
        repository = mock(PhotoAlbumRepository)
        service = new PhotoAlbumService()
        service.repository = repository
    }

    @Test
    void listByAlbumId() {
        Album album1 = new Album(albumId: 1, id: 1, title: "some title",
                url: "/some/url", thumbnailUrl: "/thumbnail/url")

        when(repository.findById(1)).thenReturn([album1])

        List<String> result = service.listByAlbumId(1)

        assert result[0].equals("[1] some title")
    }

}