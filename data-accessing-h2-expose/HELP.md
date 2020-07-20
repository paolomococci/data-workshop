# Data accessing to H2 RDBMS RESTful web service

## example of use:

```
$ curl -v -i -H "Content-Type:application/json" -d '{"code":"12345678","description":"sample items into database","status":"AVAILABLE"}' http://127.0.0.1:8091/items
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8091 (#0)
> POST /items HTTP/1.1
> Host: 127.0.0.1:8091
> User-Agent: curl/7.61.1
> Accept: */*
> Content-Type:application/json
> Content-Length: 83
> 
* upload completely sent off: 83 out of 83 bytes
< HTTP/1.1 201 
HTTP/1.1 201 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Location: http://127.0.0.1:8091/items/1
Location: http://127.0.0.1:8091/items/1
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Mon, 20 Jul 2020 11:47:38 GMT
Date: Mon, 20 Jul 2020 11:47:38 GMT

< 
{
  "code" : "12345678",
  "description" : "sample items into database",
  "status" : "AVAILABLE",
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:8091/items/1"
    },
    "item" : {
      "href" : "http://127.0.0.1:8091/items/1"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}

$ curl -v -i http://127.0.0.1:8091/items
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8091 (#0)
> GET /items HTTP/1.1
> Host: 127.0.0.1:8091
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
< Date: Mon, 20 Jul 2020 11:51:33 GMT
Date: Mon, 20 Jul 2020 11:51:33 GMT

< 
{
  "_embedded" : {
    "items" : [ {
      "code" : "12345678",
      "description" : "sample items into database",
      "status" : "AVAILABLE",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8091/items/1"
        },
        "item" : {
          "href" : "http://127.0.0.1:8091/items/1"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:8091/items"
    },
    "profile" : {
      "href" : "http://127.0.0.1:8091/profile/items"
    },
    "search" : {
      "href" : "http://127.0.0.1:8091/items/search"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```
