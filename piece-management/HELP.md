# piece-management example

## To start:
```
$ mkdir -p $HOME/postgres/test/data
$ podman build --tag postgres_image .
$ podman images 
$ podman run --rm -t -i --name postgres_container -e POSTGRES_PASSWORD=password -p 5432:5432 postgres_image postgres
```

## after that, it will be accessible through the RESTful application:
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
< Date: Mon, 16 Mar 2020 10:17:45 GMT
Date: Mon, 16 Mar 2020 10:17:45 GMT

< 
{
  "_links" : {
    "playwrights" : {
      "href" : "http://127.0.0.1:8080/playwrights{?page,size,sort}",
      "templated" : true
    },
    "producers" : {
      "href" : "http://127.0.0.1:8080/producers{?page,size,sort}",
      "templated" : true
    },
    "players" : {
      "href" : "http://127.0.0.1:8080/players{?page,size,sort}",
      "templated" : true
    },
    "designers" : {
      "href" : "http://127.0.0.1:8080/designers{?page,size,sort}",
      "templated" : true
    },
    "directors" : {
      "href" : "http://127.0.0.1:8080/directors{?page,size,sort}",
      "templated" : true
    },
    "scenographers" : {
      "href" : "http://127.0.0.1:8080/scenographers{?page,size,sort}",
      "templated" : true
    },
    "pieces" : {
      "href" : "http://127.0.0.1:8080/pieces{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://127.0.0.1:8080/profile"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}

$ curl -v -i http://127.0.0.1:8080/pieces
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /pieces HTTP/1.1
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
< Date: Mon, 16 Mar 2020 10:21:19 GMT
Date: Mon, 16 Mar 2020 10:21:19 GMT

< 
{
  "_embedded" : {
    "pieces" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:8080/pieces{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://127.0.0.1:8080/profile/pieces"
    },
    "search" : {
      "href" : "http://127.0.0.1:8080/pieces/search"
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

$ curl -v -i -H "Content-Type:application/json" -d '{"nickname":"pinocchio"}' http://127.0.0.1:8080/players
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> POST /players HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.61.1
> Accept: */*
> Content-Type:application/json
> Content-Length: 24
> 
* upload completely sent off: 24 out of 24 bytes
< HTTP/1.1 201 
HTTP/1.1 201 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Location: http://127.0.0.1:8080/players/1
Location: http://127.0.0.1:8080/players/1
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Mon, 16 Mar 2020 10:30:57 GMT
Date: Mon, 16 Mar 2020 10:30:57 GMT

< 
{
  "nickname" : "pinocchio",
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:8080/players/1"
    },
    "player" : {
      "href" : "http://127.0.0.1:8080/players/1"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}

$ curl -v -i http://127.0.0.1:8080/api/players
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /api/players HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.61.1
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Mon, 16 Mar 2020 10:31:40 GMT
Date: Mon, 16 Mar 2020 10:31:40 GMT

< 
{
  "_embedded" : {
    "players" : [ {
      "nickname" : "pinocchio",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/api/players/1"
        },
        "players" : {
          "href" : "http://127.0.0.1:8080/api/players"
        }
      }
    } ]
  }
* Connection #0 to host 127.0.0.1 left intact
}
```
