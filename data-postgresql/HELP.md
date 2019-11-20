# RESTful project for accessing data to PostgreSQL databases

## If you get such an error:
```
org.postgresql.util.PSQLException: FATAL: Ident authentication failed for user...
```

### It is necessary to edit pg_hba.conf
```
# TYPE  DATABASE        USER            ADDRESS                 METHOD

# "local" is for Unix domain socket connections only
local   all             all                                     md5 
# IPv4 local connections:
host    all             all             127.0.0.1/32            md5
# IPv6 local connections:
host    all             all             ::1/128                 md5  

```

### and restart PostgreSQL server:
```
systemctl restart postgresql
```

## When everything will work, you can use curl command-line tool:
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
< Date: Wed, 20 Nov 2019 17:49:56 GMT
Date: Wed, 20 Nov 2019 17:49:56 GMT

< 
{
  "_links" : {
    "samples" : {
      "href" : "http://127.0.0.1:8080/samples{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://127.0.0.1:8080/profile"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
$ curl -v -i http://127.0.0.1:8080/samples
*   Trying 127.0.0.1:8080...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /samples HTTP/1.1
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
< Date: Wed, 20 Nov 2019 17:51:20 GMT
Date: Wed, 20 Nov 2019 17:51:20 GMT

< 
{
  "_embedded" : {
    "samples" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:8080/samples{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://127.0.0.1:8080/profile/samples"
    },
    "search" : {
      "href" : "http://127.0.0.1:8080/samples/search"
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
$ curl -i -X POST -H "Content-Type:application/json" -d '{"code": "SW3T56QM23ER"}' http://localhost:8080/samples
HTTP/1.1 201 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Location: http://localhost:8080/samples/1
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Wed, 20 Nov 2019 17:53:29 GMT

{
  "code" : "SW3T56QM23ER",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/samples/1"
    },
    "sample" : {
      "href" : "http://localhost:8080/samples/1"
    }
  }
}
$ curl -v -i http://127.0.0.1:8080/samples
*   Trying 127.0.0.1:8080...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /samples HTTP/1.1
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
< Date: Wed, 20 Nov 2019 17:53:56 GMT
Date: Wed, 20 Nov 2019 17:53:56 GMT

< 
{
  "_embedded" : {
    "samples" : [ {
      "code" : "SW3T56QM23ER",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/samples/1"
        },
        "sample" : {
          "href" : "http://127.0.0.1:8080/samples/1"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:8080/samples{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://127.0.0.1:8080/profile/samples"
    },
    "search" : {
      "href" : "http://127.0.0.1:8080/samples/search"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 1,
    "totalPages" : 1,
    "number" : 0
  }
* Connection #0 to host 127.0.0.1 left intact
}
```
