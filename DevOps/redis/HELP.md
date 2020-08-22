# Redis containerized

## from within the directory where the Dockerfile is, you can run the following commands:

```
sudo docker build --tag redis_image .
sudo docker run -d --name redis_container -p 6379:6379 redis_image
sudo docker ps --all
sudo docker stop container_id
sudo docker start container_id
```
