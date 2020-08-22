# PostgreSQL containerized

```
sudo docker build --tag postgres_image .
sudo docker run -d --name postgres_container -e POSTGRES_USER=username -e POSTGRES_PASSWORD=password -e POSTGRES_DB=sampledb -p 5432:5432 postgres_image
```