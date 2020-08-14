# Redis containerized

```
$ sudo docker build --tag redis_image .
$ sudo docker run -d --name redis_container -p 6379:6379 redis_image
```
