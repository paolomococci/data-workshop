# This demo uses Neo4j community edition

## to start the server, in the bin directory, type:
```
./neo4j start
```

## to stop the server, type:
```
./neo4j stop
```

# Examples of use:
```
$ curl -v -i http://127.0.0.1:8080
*   Trying 127.0.0.1:8080...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET / HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.66.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
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
< Date: Sun, 24 Nov 2019 07:14:16 GMT
Date: Sun, 24 Nov 2019 07:14:16 GMT

< 
{
  "_links" : {
    "some" : {
      "href" : "http://127.0.0.1:8080/some{?page,size,sort}",
      "templated" : true
    },
    "everything" : {
      "href" : "http://127.0.0.1:8080/everything{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://127.0.0.1:8080/profile"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
$ curl -v -i http://127.0.0.1:8080/some
*   Trying 127.0.0.1:8080...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /some HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.66.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
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
< Date: Sun, 24 Nov 2019 07:15:30 GMT
Date: Sun, 24 Nov 2019 07:15:30 GMT

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
$ curl -v -i http://127.0.0.1:8080/everything
*   Trying 127.0.0.1:8080...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /everything HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.66.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
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
< Date: Sun, 24 Nov 2019 07:16:37 GMT
Date: Sun, 24 Nov 2019 07:16:37 GMT

< 
{
  "_embedded" : {
    "everything" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:8080/everything{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://127.0.0.1:8080/profile/everything"
    },
    "search" : {
      "href" : "http://127.0.0.1:8080/everything/search"
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
