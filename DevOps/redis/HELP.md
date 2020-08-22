# Redis containerized

## from within the directory where the Dockerfile is, you can run the following commands:

```
$ sudo docker build --tag redis_image .
$ sudo docker run -d --name redis_container -p 6379:6379 redis_image
```
