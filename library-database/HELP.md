# Case of study
To begin with, a database that associates some authors with their own books.

## Examples of use:
```
$ curl --verbose --include http://localhost:8080
*   Trying ::1:8080...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> GET / HTTP/1.1
> Host: localhost:8080
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
< Date: Thu, 05 Dec 2019 16:41:46 GMT
Date: Thu, 05 Dec 2019 16:41:46 GMT

< 
{
  "_links" : {
    "authors" : {
      "href" : "http://localhost:8080/authors{?page,size,sort}",
      "templated" : true
    },
    "books" : {
      "href" : "http://localhost:8080/books{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://localhost:8080/profile"
    }
  }
* Connection #0 to host localhost left intact
}
$ curl --verbose --include http://localhost:8080/authors
*   Trying ::1:8080...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> GET /authors HTTP/1.1
> Host: localhost:8080
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
< Date: Thu, 05 Dec 2019 17:10:20 GMT
Date: Thu, 05 Dec 2019 17:10:20 GMT

< 
{
  "_embedded" : {
    "authors" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/authors{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://localhost:8080/profile/authors"
    },
    "search" : {
      "href" : "http://localhost:8080/authors/search"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
* Connection #0 to host localhost left intact
}
$ curl --verbose --include http://localhost:8080/books
*   Trying ::1:8080...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> GET /books HTTP/1.1
> Host: localhost:8080
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
< Date: Thu, 05 Dec 2019 17:12:07 GMT
Date: Thu, 05 Dec 2019 17:12:07 GMT

< 
{
  "_embedded" : {
    "books" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/books{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://localhost:8080/profile/books"
    },
    "search" : {
      "href" : "http://localhost:8080/books/search"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
* Connection #0 to host localhost left intact
}
$ curl --verbose --include http://localhost:8080/authors --header "Content-Type:application/json" --data '{"lastName":"Do"}'
*   Trying ::1:8080...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> POST /authors HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.66.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 35
> 
* upload completely sent off: 35 out of 35 bytes
* Mark bundle as not supporting multiuse
< HTTP/1.1 201 
HTTP/1.1 201 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Location: http://localhost:8080/authors/1
Location: http://localhost:8080/authors/1
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Thu, 05 Dec 2019 17:13:16 GMT
Date: Thu, 05 Dec 2019 17:13:16 GMT

< 
{
  "firstName" : null,
  "lastName" : "Do",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/authors/1"
    },
    "author" : {
      "href" : "http://localhost:8080/authors/1"
    }
  }
* Connection #0 to host localhost left intact
}
$ curl --verbose --include --request PATCH http://localhost:8080/authors/1 --header "Content-Type:application/json" --data '{"firstName":"Paul"}'
*   Trying ::1:8080...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> PATCH /authors/1 HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.66.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 20
> 
* upload completely sent off: 20 out of 20 bytes
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
< Date: Thu, 05 Dec 2019 17:16:45 GMT
Date: Thu, 05 Dec 2019 17:16:45 GMT

< 
{
  "firstName" : "Paul",
  "lastName" : "Do",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/authors/1"
    },
    "author" : {
      "href" : "http://localhost:8080/authors/1"
    }
  }
* Connection #0 to host localhost left intact
}
$ curl --verbose --include http://localhost:8080/authors
*   Trying ::1:8080...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> GET /authors HTTP/1.1
> Host: localhost:8080
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
< Date: Thu, 05 Dec 2019 17:21:23 GMT
Date: Thu, 05 Dec 2019 17:21:23 GMT

< 
{
  "_embedded" : {
    "authors" : [ {
      "firstName" : "Paul",
      "lastName" : "Do",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/authors/1"
        },
        "author" : {
          "href" : "http://localhost:8080/authors/1"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/authors{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://localhost:8080/profile/authors"
    },
    "search" : {
      "href" : "http://localhost:8080/authors/search"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 1,
    "totalPages" : 1,
    "number" : 0
  }
* Connection #0 to host localhost left intact
}
```

## Now I try query to custom api
```
$ curl --verbose --include http://localhost:8080/api/authors
*   Trying ::1:8080...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> GET /api/authors HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.66.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/json
Content-Type: application/json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Thu, 05 Dec 2019 17:22:18 GMT
Date: Thu, 05 Dec 2019 17:22:18 GMT

< 
[ {
  "id" : 1,
  "firstName" : "Paul",
  "lastName" : "Do"
* Connection #0 to host localhost left intact
} ]
$ curl --verbose --include http://localhost:8080/api/authors/identification/1
*   Trying ::1:8080...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> GET /api/authors/identification/1 HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.66.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/json
Content-Type: application/json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Thu, 05 Dec 2019 21:18:46 GMT
Date: Thu, 05 Dec 2019 21:18:46 GMT

< 
{
  "id" : 1,
  "firstName" : "Paul",
  "lastName" : "Do"
* Connection #0 to host localhost left intact
}
$ curl --verbose --include http://localhost:8080/api/authors/surname?lastName="Do"
*   Trying ::1:8080...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> GET /api/authors/surname?lastName=Do HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.66.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/json
Content-Type: application/json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Thu, 05 Dec 2019 21:20:16 GMT
Date: Thu, 05 Dec 2019 21:20:16 GMT

< 
[ {
  "id" : 1,
  "firstName" : "Paul",
  "lastName" : "Do"
* Connection #0 to host localhost left intact
} ]
$ curl --verbose --include http://localhost:8080/api/authors/name?firstName="Paul"
*   Trying ::1:8080...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> GET /api/authors/name?firstName=Paul HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.66.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/json
Content-Type: application/json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Thu, 05 Dec 2019 21:21:37 GMT
Date: Thu, 05 Dec 2019 21:21:37 GMT

< 
[ {
  "id" : 1,
  "firstName" : "Paul",
  "lastName" : "Do"
* Connection #0 to host localhost left intact
} ]
```
