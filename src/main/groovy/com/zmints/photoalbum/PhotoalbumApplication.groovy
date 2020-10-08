package com.zmints.photoalbum

import com.zmints.photoalbum.service.PhotoAlbumService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class PhotoalbumApplication  implements CommandLineRunner {
	@Autowired
	PhotoAlbumService photoAlbumService
	static void main(String[] args) {
		SpringApplication.run(PhotoalbumApplication, args)
	}

	@Override
	void run(String... args) {
		if (args.length == 0) return
		Integer albumId = null

		try {
			albumId = Integer.parseInt(args[1]);
		}  catch(Exception e) {
			System.out.println("Invalid Argument, please try again.")

		}

		List<String> result = photoAlbumService.listByAlbumId(albumId)
		result.each {
			System.out.println(it)
		}

		System.exit(0)
	}
}
