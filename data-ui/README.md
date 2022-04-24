# Data UI example

### create:

```
$ curl -v -i -H "Content-Type:application/json" -d '{"nickname":"jumper","abcClassification":"A"}' http://127.0.0.1:8090/rest/customers
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8090 (#0)
> POST /rest/customers HTTP/1.1
> Host: 127.0.0.1:8090
> User-Agent: curl/7.61.1
> Accept: */*
> Content-Type:application/json
> Content-Length: 45
> 
* upload completely sent off: 45 out of 45 bytes
< HTTP/1.1 201 
HTTP/1.1 201 
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Wed, 20 May 2020 06:09:18 GMT
Date: Wed, 20 May 2020 06:09:18 GMT

< 
{
  "nickname" : "jumper",
  "abcClassification" : "A",
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:8090/rest/customers/1"
    },
    "customers" : {
      "href" : "http://127.0.0.1:8090/rest/customers"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

### read:

```
$ curl -v -i http://127.0.0.1:8090/rest/customers
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8090 (#0)
> GET /rest/customers HTTP/1.1
> Host: 127.0.0.1:8090
> User-Agent: curl/7.61.1
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Wed, 20 May 2020 06:10:30 GMT
Date: Wed, 20 May 2020 06:10:30 GMT

< 
{
  "_embedded" : {
    "customers" : [ {
      "nickname" : "jumper",
      "abcClassification" : "A",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8090/rest/customers/1"
        },
        "customers" : {
          "href" : "http://127.0.0.1:8090/rest/customers"
        }
      }
    } ]
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

### TODO response from ```http://127.0.0.1:8090/rest/reactive/customers:```

```
$ curl -v -i http://127.0.0.1:8090/rest/reactive/customers
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8090 (#0)
> GET /rest/reactive/customers HTTP/1.1
> Host: 127.0.0.1:8090
> User-Agent: curl/7.61.1
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/json
Content-Type: application/json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Wed, 20 May 2020 06:11:46 GMT
Date: Wed, 20 May 2020 06:11:46 GMT

< 
{
  "scanAvailable" : true,
  "prefetch" : -1
* Connection #0 to host 127.0.0.1 left intact
}
```
