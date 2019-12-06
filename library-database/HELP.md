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

## Books with titles invented for example purposes:
```
$ curl --verbose --include http://localhost:8080/books --header "Content-Type:application/json" --data-ascii '{"title":"John the smith"}'
*   Trying ::1:8080...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> POST /books HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.66.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 31
> 
* upload completely sent off: 31 out of 31 bytes
* Mark bundle as not supporting multiuse
< HTTP/1.1 201 
HTTP/1.1 201 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Location: http://localhost:8080/books/2
Location: http://localhost:8080/books/2
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Thu, 05 Dec 2019 21:52:43 GMT
Date: Thu, 05 Dec 2019 21:52:43 GMT

< 
{
  "title" : "John the smith",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/books/2"
    },
    "book" : {
      "href" : "http://localhost:8080/books/2"
    }
  }
* Connection #0 to host localhost left intact
}
$ curl --verbose --include http://localhost:8080/books --header "Content-Type:application/json" --data-ascii '{"title":"Secret march of caterpillars"}'
*   Trying ::1:8080...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> POST /books HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.66.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 42
> 
* upload completely sent off: 42 out of 42 bytes
* Mark bundle as not supporting multiuse
< HTTP/1.1 201 
HTTP/1.1 201 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Location: http://localhost:8080/books/3
Location: http://localhost:8080/books/3
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Thu, 05 Dec 2019 21:54:25 GMT
Date: Thu, 05 Dec 2019 21:54:25 GMT

< 
{
  "title" : "Secret march of caterpillars",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/books/3"
    },
    "book" : {
      "href" : "http://localhost:8080/books/3"
    }
  }
* Connection #0 to host localhost left intact
}
$ curl --verbose --include http://localhost:8080/books --header "Content-Type:application/json" --data-ascii '{"title":"Sheila walk over water"}'
*   Trying ::1:8080...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> POST /books HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.66.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 33
> 
* upload completely sent off: 33 out of 33 bytes
* Mark bundle as not supporting multiuse
< HTTP/1.1 201 
HTTP/1.1 201 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Location: http://localhost:8080/books/4
Location: http://localhost:8080/books/4
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Thu, 05 Dec 2019 21:55:11 GMT
Date: Thu, 05 Dec 2019 21:55:11 GMT

< 
{
  "title" : "Sheila walk over water",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/books/4"
    },
    "book" : {
      "href" : "http://localhost:8080/books/4"
    }
  }
* Connection #0 to host localhost left intact
}
$ curl --verbose --include http://localhost:8080/books --header "Content-Type:application/json" --data-ascii '{"title":"The math of monkeys"}'
*   Trying ::1:8080...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> POST /books HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.66.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 28
> 
* upload completely sent off: 28 out of 28 bytes
* Mark bundle as not supporting multiuse
< HTTP/1.1 201 
HTTP/1.1 201 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Location: http://localhost:8080/books/5
Location: http://localhost:8080/books/5
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Thu, 05 Dec 2019 21:55:48 GMT
Date: Thu, 05 Dec 2019 21:55:48 GMT

< 
{
  "title" : "The math of monkeys",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/books/5"
    },
    "book" : {
      "href" : "http://localhost:8080/books/5"
    }
  }
* Connection #0 to host localhost left intact
}
```

## Books sorted by title
```
$ curl --verbose --include http://localhost:8080/books?sort=title
*   Trying ::1:8080...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> GET /books?sort=title HTTP/1.1
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
< Date: Fri, 06 Dec 2019 07:41:02 GMT
Date: Fri, 06 Dec 2019 07:41:02 GMT

< 
{
  "_embedded" : {
    "books" : [ {
      "title" : "The math of monkeys",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/books/5"
        },
        "book" : {
          "href" : "http://localhost:8080/books/5"
        }
      }
    }, {
      "title" : "John the smith",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/books/2"
        },
        "book" : {
          "href" : "http://localhost:8080/books/2"
        }
      }
    }, {
      "title" : "Sheila walk over water",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/books/4"
        },
        "book" : {
          "href" : "http://localhost:8080/books/4"
        }
      }
    }, {
      "title" : "Secret march of caterpillars",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/books/3"
        },
        "book" : {
          "href" : "http://localhost:8080/books/3"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/books"
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
    "totalElements" : 4,
    "totalPages" : 1,
    "number" : 0
  }
* Connection #0 to host localhost left intact
}
```

## Responses from custom api of Book:
```
$ curl --verbose --include http://localhost:8080/api/books
*   Trying ::1:8080...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> GET /api/books HTTP/1.1
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
< Date: Fri, 06 Dec 2019 07:44:05 GMT
Date: Fri, 06 Dec 2019 07:44:05 GMT

< 
[ {
  "id" : 2,
  "title" : "John the smith"
}, {
  "id" : 3,
  "title" : "Secret march of caterpillars"
}, {
  "id" : 4,
  "title" : "Sheila walk over water"
}, {
  "id" : 5,
  "title" : "The math of monkeys"
* Connection #0 to host localhost left intact
} ]
$ curl --verbose --include http://localhost:8080/api/books/2
*   Trying ::1:8080...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> GET /api/books/2 HTTP/1.1
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
< Date: Fri, 06 Dec 2019 08:02:25 GMT
Date: Fri, 06 Dec 2019 08:02:25 GMT

< 
{
  "id" : 2,
  "title" : "John the smith"
* Connection #0 to host localhost left intact
}

$ curl --verbose --include http://localhost:8080/api/books/where?title="Secret%20march%20of%20caterpillars"
*   Trying ::1:8080...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> GET /api/books/where?title=Secret%20march%20of%20caterpillars HTTP/1.1
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
< Date: Fri, 06 Dec 2019 08:24:19 GMT
Date: Fri, 06 Dec 2019 08:24:19 GMT

< 
[ {
  "id" : 3,
  "title" : "Secret march of caterpillars"
* Connection #0 to host localhost left intact
} ]
$ curl --verbose --include http://localhost:8080/api/books/like?title="Secret%20march%20of%20caterpillars"
*   Trying ::1:8080...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> GET /api/books/like?title=Secret%20march%20of%20caterpillars HTTP/1.1
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
< Date: Fri, 06 Dec 2019 08:32:08 GMT
Date: Fri, 06 Dec 2019 08:32:08 GMT

< 
[ {
  "id" : 3,
  "title" : "Secret march of caterpillars"
* Connection #0 to host localhost left intact
} ]
$ curl --verbose --include http://localhost:8080/api/books/like?title="caterpillars"
*   Trying ::1:8080...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> GET /api/books/like?title=caterpillars HTTP/1.1
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
< Date: Fri, 06 Dec 2019 08:50:10 GMT
Date: Fri, 06 Dec 2019 08:50:10 GMT

< 
[ {
  "id" : 3,
  "title" : "Secret march of caterpillars"
* Connection #0 to host localhost left intact
} ]
$ curl --verbose --include http://localhost:8080/api/books/like?title="Secret%20march"
*   Trying ::1:8080...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> GET /api/books/like?title=Secret%20march HTTP/1.1
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
< Date: Fri, 06 Dec 2019 08:51:31 GMT
Date: Fri, 06 Dec 2019 08:51:31 GMT

< 
[ {
  "id" : 3,
  "title" : "Secret march of caterpillars"
* Connection #0 to host localhost left intact
} ]
```
