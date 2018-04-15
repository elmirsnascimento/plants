#gradle build --refresh-dependencies
docker build . -t plants
docker rm /plants
docker images
docker run --name="plants" --publish 8080:8080 plants
