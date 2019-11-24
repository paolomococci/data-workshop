# RESTful project for accessing data to MongoDB NoSQL databases

## example of use:
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
< Date: Thu, 21 Nov 2019 18:53:52 GMT
Date: Thu, 21 Nov 2019 18:53:52 GMT

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
< Date: Thu, 21 Nov 2019 18:54:36 GMT
Date: Thu, 21 Nov 2019 18:54:36 GMT

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
$ curl -i -X POST -H "Content-Type:application/json" -d '{"code": "SW3T56QM23ER"}' http://localhost:8080/some
HTTP/1.1 201 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Location: http://localhost:8080/some/5dd6ddb7caa31604ce316342
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Thu, 21 Nov 2019 18:55:52 GMT

{
  "code" : "SW3T56QM23ER",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/some/5dd6ddb7caa31604ce316342"
    },
    "someone" : {
      "href" : "http://localhost:8080/some/5dd6ddb7caa31604ce316342"
    }
  }
}
$ curl -i -X POST -H "Content-Type:application/json" -d '{"code": "JY67DW9GTX9W"}' http://localhost:8080/some
HTTP/1.1 201 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Location: http://localhost:8080/some/5dd6de42caa31604ce316343
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Thu, 21 Nov 2019 18:58:10 GMT

{
  "code" : "JY67DW9GTX9W",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/some/5dd6de42caa31604ce316343"
    },
    "someone" : {
      "href" : "http://localhost:8080/some/5dd6de42caa31604ce316343"
    }
  }
}
$ curl -i -X POST -H "Content-Type:application/json" -d '{"code": "DE7VRT73NTPD"}' http://localhost:8080/some
HTTP/1.1 201 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Location: http://localhost:8080/some/5dd6de85caa31604ce316344
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Thu, 21 Nov 2019 18:59:17 GMT

{
  "code" : "DE7VRT73NTPD",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/some/5dd6de85caa31604ce316344"
    },
    "someone" : {
      "href" : "http://localhost:8080/some/5dd6de85caa31604ce316344"
    }
  }
}
$ curl -i -X POST -H "Content-Type:application/json" -d '{"code": "DE7VRT73NTPD"}' http://localhost:8080/some
HTTP/1.1 201 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Location: http://localhost:8080/some/5dd6de85caa31604ce316344
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Thu, 21 Nov 2019 18:59:17 GMT

{
  "code" : "DE7VRT73NTPD",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/some/5dd6de85caa31604ce316344"
    },
    "someone" : {
      "href" : "http://localhost:8080/some/5dd6de85caa31604ce316344"
    }
  }
}
$ curl -i -X PATCH -H "Content-Type:application/json" -d '{"code": "SQGRT65127FR"}' http://localhost:8080/some/5dd6de42caa31604ce316343
HTTP/1.1 200 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Thu, 21 Nov 2019 19:26:35 GMT

{
  "code" : "SQGRT65127FR",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/some/5dd6de42caa31604ce316343"
    },
    "someone" : {
      "href" : "http://localhost:8080/some/5dd6de42caa31604ce316343"
    }
  }
}
$ curl -v -i -X DELETE http://127.0.0.1:8080/some/5dd6de42caa31604ce316343
*   Trying 127.0.0.1:8080...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> DELETE /some/5dd6de42caa31604ce316343 HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.66.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 204 
HTTP/1.1 204 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Date: Thu, 21 Nov 2019 19:40:55 GMT
Date: Thu, 21 Nov 2019 19:40:55 GMT

< 
* Connection #0 to host 127.0.0.1 left intact
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
< Date: Thu, 21 Nov 2019 19:41:37 GMT
Date: Thu, 21 Nov 2019 19:41:37 GMT

< 
{
  "_embedded" : {
    "some" : [ {
      "code" : "SW3T56QM23ER",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/some/5dd6ddb7caa31604ce316342"
        },
        "someone" : {
          "href" : "http://127.0.0.1:8080/some/5dd6ddb7caa31604ce316342"
        }
      }
    }, {
      "code" : "DE7VRT73NTPD",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/some/5dd6de85caa31604ce316344"
        },
        "someone" : {
          "href" : "http://127.0.0.1:8080/some/5dd6de85caa31604ce316344"
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
