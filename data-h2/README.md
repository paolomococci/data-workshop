# data-service project

## accessing to database with REST
-----

### basic example of use:
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
< Date: Mon, 18 Nov 2019 19:45:52 GMT
Date: Mon, 18 Nov 2019 19:45:52 GMT

< 
{
  "_links" : {
    "profile" : {
      "href" : "http://127.0.0.1:8080/profile"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

### after have add entity and repository:
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
< Date: Mon, 18 Nov 2019 20:06:51 GMT
Date: Mon, 18 Nov 2019 20:06:51 GMT

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
```
### example of use:
```
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
< Date: Mon, 18 Nov 2019 20:09:54 GMT
Date: Mon, 18 Nov 2019 20:09:54 GMT

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

```
$ curl -i -X POST -H "Content-Type:application/json" -d '{"code": "ASDFG12345"}' http://localhost:8080/some
HTTP/1.1 201 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Location: http://localhost:8080/some/1
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Mon, 18 Nov 2019 20:12:52 GMT

{
  "code" : "ASDFG12345",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/some/1"
    },
    "someone" : {
      "href" : "http://localhost:8080/some/1"
    }
  }
}
$ curl -i -X POST -H "Content-Type:application/json" -d '{"code": "FDERT546789"}' http://localhost:8080/some
HTTP/1.1 201 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Location: http://localhost:8080/some/2
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Mon, 18 Nov 2019 20:14:34 GMT

{
  "code" : "FDERT546789",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/some/2"
    },
    "someone" : {
      "href" : "http://localhost:8080/some/2"
    }
  }
}
$ curl -i -X POST -H "Content-Type:application/json" -d '{"code": "IWEND76890"}' http://localhost:8080/some
 HTTP/1.1 201 
 Vary: Origin
 Vary: Access-Control-Request-Method
 Vary: Access-Control-Request-Headers
 Location: http://localhost:8080/some/3
 Content-Type: application/hal+json
 Transfer-Encoding: chunked
 Date: Mon, 18 Nov 2019 20:15:32 GMT
 
 {
   "code" : "IWEND76890",
   "_links" : {
     "self" : {
       "href" : "http://localhost:8080/some/3"
     },
     "someone" : {
       "href" : "http://localhost:8080/some/3"
     }
   }
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
< Date: Mon, 18 Nov 2019 20:16:07 GMT
Date: Mon, 18 Nov 2019 20:16:07 GMT

< 
{
  "_embedded" : {
    "some" : [ {
      "code" : "ASDFG12345",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/some/1"
        },
        "someone" : {
          "href" : "http://127.0.0.1:8080/some/1"
        }
      }
    }, {
      "code" : "FDERT546789",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/some/2"
        },
        "someone" : {
          "href" : "http://127.0.0.1:8080/some/2"
        }
      }
    }, {
      "code" : "IWEND76890",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/some/3"
        },
        "someone" : {
          "href" : "http://127.0.0.1:8080/some/3"
        }
      }
    } ]
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
    "totalElements" : 3,
    "totalPages" : 1,
    "number" : 0
  }
* Connection #0 to host 127.0.0.1 left intact
}
$ curl -v -i http://127.0.0.1:8080/some/search
*   Trying 127.0.0.1:8080...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /some/search HTTP/1.1
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
< Date: Mon, 18 Nov 2019 20:18:27 GMT
Date: Mon, 18 Nov 2019 20:18:27 GMT

< 
{
  "_links" : {
    "findByCode" : {
      "href" : "http://127.0.0.1:8080/some/search/findByCode{?code}",
      "templated" : true
    },
    "self" : {
      "href" : "http://127.0.0.1:8080/some/search"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
$ curl -v -i http://127.0.0.1:8080/some/search/findByCode?code=FDERT546789
*   Trying 127.0.0.1:8080...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /some/search/findByCode?code=FDERT546789 HTTP/1.1
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
< Date: Mon, 18 Nov 2019 20:20:37 GMT
Date: Mon, 18 Nov 2019 20:20:37 GMT

< 
{
  "_embedded" : {
    "some" : [ {
      "code" : "FDERT546789",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/some/2"
        },
        "someone" : {
          "href" : "http://127.0.0.1:8080/some/2"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:8080/some/search/findByCode?code=FDERT546789"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
$ curl -v -i http://127.0.0.1:8080/some?sort=code
*   Trying 127.0.0.1:8080...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /some?sort=code HTTP/1.1
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
< Date: Mon, 18 Nov 2019 20:23:43 GMT
Date: Mon, 18 Nov 2019 20:23:43 GMT

< 
{
  "_embedded" : {
    "some" : [ {
      "code" : "ASDFG12345",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/some/1"
        },
        "someone" : {
          "href" : "http://127.0.0.1:8080/some/1"
        }
      }
    }, {
      "code" : "FDERT546789",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/some/2"
        },
        "someone" : {
          "href" : "http://127.0.0.1:8080/some/2"
        }
      }
    }, {
      "code" : "IWEND76890",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/some/3"
        },
        "someone" : {
          "href" : "http://127.0.0.1:8080/some/3"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:8080/some"
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
    "totalElements" : 3,
    "totalPages" : 1,
    "number" : 0
  }
* Connection #0 to host 127.0.0.1 left intact
}
$ curl -i -X PATCH -H "Content-Type:application/json" -d '{"code": "SQGRT65127"}' http://localhost:8080/some/1
HTTP/1.1 200 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Mon, 18 Nov 2019 20:43:09 GMT

{
  "code" : "SQGRT65127",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/some/1"
    },
    "someone" : {
      "href" : "http://localhost:8080/some/1"
    }
  }
}
$ curl -X DELETE http://localhost:8080/some/1
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
< Date: Mon, 18 Nov 2019 20:45:40 GMT
Date: Mon, 18 Nov 2019 20:45:40 GMT

< 
{
  "_embedded" : {
    "some" : [ {
      "code" : "FDERT546789",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/some/2"
        },
        "someone" : {
          "href" : "http://127.0.0.1:8080/some/2"
        }
      }
    }, {
      "code" : "IWEND76890",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/some/3"
        },
        "someone" : {
          "href" : "http://127.0.0.1:8080/some/3"
        }
      }
    } ]
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
    "totalElements" : 2,
    "totalPages" : 1,
    "number" : 0
  }
* Connection #0 to host 127.0.0.1 left intact
}
```
