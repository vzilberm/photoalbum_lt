# Photo Album Assignment

List the id and the title of the photo albums
The albums json provided at https://jsonplaceholder.typicode.com/photos.

## Installation

Clone from github:

    git clone https://github.com/vzilberm/photoalbum_lt

After downloading project from github, run a Maven build:

    mvn clean install


When build is successful, a target/ folder will be created.
It will contain the built photoalbum-0.0.1-SNAPSHOT.jar file. 

## to run application:
Change dir to /target.
Run the Java JAR file with arguments ("photoalbum {albumId}").
It will output the results in the console environment.

    java -jar photoalbum-0.0.1-SNAPSHOT.jar photoalbum 1

