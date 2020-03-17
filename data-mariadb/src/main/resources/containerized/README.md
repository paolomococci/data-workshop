# At work!

## how to use:
```
$ podman build --tag mariadb_image .
$ podman run --rm -d --name mariadb_container -e MYSQL_ROOT_PASSWORD=yourpassword -p 3306:3306 mariadb_image
$ podman ps --all
```

## and now try:
```
$ curl -v -i http://127.0.0.1:8080
* Rebuilt URL to: http://127.0.0.1:8080/
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET / HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.61.1
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Tue, 17 Mar 2020 09:05:47 GMT
Date: Tue, 17 Mar 2020 09:05:47 GMT

< 
{
  "_links" : {
    "some" : {
      "href" : "http://127.0.0.1:8080/some{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://127.0.0.1:8080/profile"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}

$ curl -v -i http://127.0.0.1:8080/some
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /some HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.61.1
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Tue, 17 Mar 2020 09:06:50 GMT
Date: Tue, 17 Mar 2020 09:06:50 GMT

< 
{
  "_embedded" : {
    "some" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:8080/some{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://127.0.0.1:8080/profile/some"
    },
    "search" : {
      "href" : "http://127.0.0.1:8080/some/search"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

## finally:
```
$ podman stop yourcontainerid
```
