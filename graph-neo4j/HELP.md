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

## if I substitute "PagingAndSortingRepository" with "Neo4jRepository" in the repository interfaces
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
< Date: Sun, 24 Nov 2019 16:59:45 GMT
Date: Sun, 24 Nov 2019 16:59:45 GMT

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
< Date: Sun, 24 Nov 2019 17:02:26 GMT
Date: Sun, 24 Nov 2019 17:02:26 GMT

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
< Date: Sun, 24 Nov 2019 17:03:08 GMT
Date: Sun, 24 Nov 2019 17:03:08 GMT

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
$ curl -i -X POST -H "Content-Type:application/json" -d '{"code": "DE7VRT73NTPD"}' http://localhost:8080/some
HTTP/1.1 201 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Location: http://localhost:8080/some/0
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Sun, 24 Nov 2019 17:07:14 GMT

{
  "code" : "DE7VRT73NTPD",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/some/0"
    },
    "someone" : {
      "href" : "http://localhost:8080/some/0"
    },
    "everything" : {
      "href" : "http://localhost:8080/some/0/everything"
    }
  }
}
$ curl -i -X POST -H "Content-Type:application/json" -d '{"code": "SD09IJ23VF7H"}' http://localhost:8080/some
HTTP/1.1 201 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Location: http://localhost:8080/some/20
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Sun, 24 Nov 2019 17:08:26 GMT

{
  "code" : "SD09IJ23VF7H",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/some/20"
    },
    "someone" : {
      "href" : "http://localhost:8080/some/20"
    },
    "everything" : {
      "href" : "http://localhost:8080/some/20/everything"
    }
  }
}
$ curl -i -X POST -H "Content-Type:application/json" -d '{"code": "GR8RWI2M6CHU"}' http://localhost:8080/some
HTTP/1.1 201 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Location: http://localhost:8080/some/21
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Sun, 24 Nov 2019 17:09:52 GMT

{
  "code" : "GR8RWI2M6CHU",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/some/21"
    },
    "someone" : {
      "href" : "http://localhost:8080/some/21"
    },
    "everything" : {
      "href" : "http://localhost:8080/some/21/everything"
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
< Date: Sun, 24 Nov 2019 17:10:16 GMT
Date: Sun, 24 Nov 2019 17:10:16 GMT

< 
{
  "_embedded" : {
    "some" : [ {
      "code" : "DE7VRT73NTPD",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/some/0"
        },
        "someone" : {
          "href" : "http://127.0.0.1:8080/some/0"
        },
        "everything" : {
          "href" : "http://127.0.0.1:8080/some/0/everything"
        }
      }
    }, {
      "code" : "SD09IJ23VF7H",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/some/20"
        },
        "someone" : {
          "href" : "http://127.0.0.1:8080/some/20"
        },
        "everything" : {
          "href" : "http://127.0.0.1:8080/some/20/everything"
        }
      }
    }, {
      "code" : "GR8RWI2M6CHU",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/some/21"
        },
        "someone" : {
          "href" : "http://127.0.0.1:8080/some/21"
        },
        "everything" : {
          "href" : "http://127.0.0.1:8080/some/21/everything"
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
```

## after the "some" interface I go to use the "everything" interface to continue entering data
```
$ curl -i -X POST -H "Content-Type:application/json" -d '{"code": "D3N8UHB24F39"}' http://localhost:8080/everything
HTTP/1.1 201 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Location: http://localhost:8080/everything/22
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Sun, 24 Nov 2019 17:13:00 GMT

{
  "thinks" : null,
  "code" : "D3N8UHB24F39",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/everything/22"
    },
    "something" : {
      "href" : "http://localhost:8080/everything/22"
    }
  }
}
$ curl -i -X POST -H "Content-Type:application/json" -d '{"code": "FR40OS245NUQ"}' http://localhost:8080/everything
HTTP/1.1 201 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Location: http://localhost:8080/everything/1
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Sun, 24 Nov 2019 17:15:44 GMT

{
  "thinks" : null,
  "code" : "FR40OS245NUQ",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/everything/1"
    },
    "something" : {
      "href" : "http://localhost:8080/everything/1"
    }
  }
}
$ curl -i -X POST -H "Content-Type:application/json" -d '{"code": "GRN2PO567SN4"}' http://localhost:8080/everything
HTTP/1.1 201 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Location: http://localhost:8080/everything/2
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Sun, 24 Nov 2019 17:17:01 GMT

{
  "thinks" : null,
  "code" : "GRN2PO567SN4",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/everything/2"
    },
    "something" : {
      "href" : "http://localhost:8080/everything/2"
    }
  }
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
< Date: Sun, 24 Nov 2019 17:17:28 GMT
Date: Sun, 24 Nov 2019 17:17:28 GMT

< 
{
  "_embedded" : {
    "everything" : [ {
      "thinks" : null,
      "code" : "FR40OS245NUQ",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/everything/1"
        },
        "something" : {
          "href" : "http://127.0.0.1:8080/everything/1"
        }
      }
    }, {
      "thinks" : null,
      "code" : "GRN2PO567SN4",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/everything/2"
        },
        "something" : {
          "href" : "http://127.0.0.1:8080/everything/2"
        }
      }
    }, {
      "thinks" : null,
      "code" : "D3N8UHB24F39",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/everything/22"
        },
        "something" : {
          "href" : "http://127.0.0.1:8080/everything/22"
        }
      }
    } ]
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
    "totalElements" : 3,
    "totalPages" : 1,
    "number" : 0
  }
* Connection #0 to host 127.0.0.1 left intact
}
$ curl -i -X PATCH -H "Content-Type:application/json" -d '{"code": "FE8NXS34M1W9"}' http://localhost:8080/everything/22
HTTP/1.1 200 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Sun, 24 Nov 2019 17:22:58 GMT

{
  "thinks" : null,
  "code" : "FE8NXS34M1W9",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/everything/22"
    },
    "something" : {
      "href" : "http://localhost:8080/everything/22"
    }
  }
}
```
