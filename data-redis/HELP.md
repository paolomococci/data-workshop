# data-redis

## I try to retrieve the records before inserting the entity
```
$ curl -v -i http://127.0.0.1:8080/api/reactive/items
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /api/reactive/items HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 16 Aug 2020 16:23:48 GMT
Date: Sun, 16 Aug 2020 16:23:48 GMT

< 
* Connection #0 to host 127.0.0.1 left intact
{ }
```

## I insert some records
```
$ curl -v -i -H "Content-Type:application/json" -d '{"code":"15000012","name":"one","description":"some description"}' http://127.0.0.1:8080/api/reactive/items
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> POST /api/reactive/items HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.58.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 65
> 
* upload completely sent off: 65 out of 65 bytes
< HTTP/1.1 201 
HTTP/1.1 201 
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 16 Aug 2020 16:26:48 GMT
Date: Sun, 16 Aug 2020 16:26:48 GMT

< 
{
  "id" : "985af903-8e86-4255-b40d-a7353ef2b232",
  "code" : "15000012",
  "name" : "one",
  "description" : "some description",
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:8080/api/reactive/items/985af903-8e86-4255-b40d-a7353ef2b232"
    },
    "items" : {
      "href" : "http://127.0.0.1:8080/api/reactive/items"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
$ curl -v -i -H "Content-Type:application/json" -d '{"code":"15000024","name":"two","description":"some description"}' http://127.0.0.1:8080/api/reactive/items
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> POST /api/reactive/items HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.58.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 65
> 
* upload completely sent off: 65 out of 65 bytes
< HTTP/1.1 201 
HTTP/1.1 201 
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 16 Aug 2020 16:27:59 GMT
Date: Sun, 16 Aug 2020 16:27:59 GMT

< 
{
  "id" : "d7d87426-5be8-47cd-aa05-472e17484ff7",
  "code" : "15000024",
  "name" : "two",
  "description" : "some description",
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:8080/api/reactive/items/d7d87426-5be8-47cd-aa05-472e17484ff7"
    },
    "items" : {
      "href" : "http://127.0.0.1:8080/api/reactive/items"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
$ curl -v -i -H "Content-Type:application/json" -d '{"code":"15000036","name":"three","description":"some description"}' http://127.0.0.1:8080/api/reactive/items
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> POST /api/reactive/items HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.58.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 67
> 
* upload completely sent off: 67 out of 67 bytes
< HTTP/1.1 201 
HTTP/1.1 201 
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 16 Aug 2020 16:28:51 GMT
Date: Sun, 16 Aug 2020 16:28:51 GMT

< 
{
  "id" : "6339a2f0-006d-4448-90b0-49c63ebc5d9e",
  "code" : "15000036",
  "name" : "three",
  "description" : "some description",
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:8080/api/reactive/items/6339a2f0-006d-4448-90b0-49c63ebc5d9e"
    },
    "items" : {
      "href" : "http://127.0.0.1:8080/api/reactive/items"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
...
```

## I fetch all records
```
$ curl -v -i http://127.0.0.1:8080/api/reactive/items
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /api/reactive/items HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 16 Aug 2020 16:35:46 GMT
Date: Sun, 16 Aug 2020 16:35:46 GMT

< 
{
  "_embedded" : {
    "items" : [ {
      "id" : "6339a2f0-006d-4448-90b0-49c63ebc5d9e",
      "code" : "15000036",
      "name" : "three",
      "description" : "some description",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/api/reactive/items/6339a2f0-006d-4448-90b0-49c63ebc5d9e"
        },
        "items" : {
          "href" : "http://127.0.0.1:8080/api/reactive/items"
        }
      }
    }, {
      "id" : "d7d87426-5be8-47cd-aa05-472e17484ff7",
      "code" : "15000024",
      "name" : "two",
      "description" : "some description",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/api/reactive/items/d7d87426-5be8-47cd-aa05-472e17484ff7"
        },
        "items" : {
          "href" : "http://127.0.0.1:8080/api/reactive/items"
        }
      }
    }, {
      "id" : "985af903-8e86-4255-b40d-a7353ef2b232",
      "code" : "15000012",
      "name" : "one",
      "description" : "some description",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/api/reactive/items/985af903-8e86-4255-b40d-a7353ef2b232"
        },
        "items" : {
          "href" : "http://127.0.0.1:8080/api/reactive/items"
        }
      }
    }, {
      "id" : "e98a1596-5822-47b8-97d6-d8ef83d2d15f",
      "code" : "15000072",
      "name" : "six",
      "description" : "some description",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/api/reactive/items/e98a1596-5822-47b8-97d6-d8ef83d2d15f"
        },
        "items" : {
          "href" : "http://127.0.0.1:8080/api/reactive/items"
        }
      }
    }, {
      "id" : "667745b8-6c46-4db6-b5f4-1b2a28734949",
      "code" : "15000060",
      "name" : "five",
      "description" : "some description",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/api/reactive/items/667745b8-6c46-4db6-b5f4-1b2a28734949"
        },
        "items" : {
          "href" : "http://127.0.0.1:8080/api/reactive/items"
        }
      }
    }, {
      "id" : "a8835098-d00a-4915-a035-36e9b88d2e66",
      "code" : "15000048",
      "name" : "four",
      "description" : "some description",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/api/reactive/items/a8835098-d00a-4915-a035-36e9b88d2e66"
        },
        "items" : {
          "href" : "http://127.0.0.1:8080/api/reactive/items"
        }
      }
    } ]
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

## I fetch last record using the id
```
$ curl -v -i http://127.0.0.1:8080/api/reactive/items/e98a1596-5822-47b8-97d6-d8ef83d2d15f
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /api/reactive/items/e98a1596-5822-47b8-97d6-d8ef83d2d15f HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sun, 16 Aug 2020 16:36:43 GMT
Date: Sun, 16 Aug 2020 16:36:43 GMT

< 
{
  "id" : "e98a1596-5822-47b8-97d6-d8ef83d2d15f",
  "code" : "15000072",
  "name" : "six",
  "description" : "some description",
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:8080/api/reactive/items/e98a1596-5822-47b8-97d6-d8ef83d2d15f"
    },
    "items" : {
      "href" : "http://127.0.0.1:8080/api/reactive/items"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

## now I delete a record using the ID 667745b8-6c46-4db6-b5f4-1b2a28734949
```
$ curl -v -i -X DELETE http://127.0.0.1:8080/api/reactive/items/667745b8-6c46-4db6-b5f4-1b2a28734949
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> DELETE /api/reactive/items/667745b8-6c46-4db6-b5f4-1b2a28734949 HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 204 
HTTP/1.1 204 
< Date: Sun, 16 Aug 2020 16:41:51 GMT
Date: Sun, 16 Aug 2020 16:41:51 GMT

< 
* Connection #0 to host 127.0.0.1 left intact
```

## I try fetch the id 667745b8-6c46-4db6-b5f4-1b2a28734949
```
$ curl -v -i http://127.0.0.1:8080/api/reactive/items/667745b8-6c46-4db6-b5f4-1b2a28734949
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /api/reactive/items/667745b8-6c46-4db6-b5f4-1b2a28734949 HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 404 
HTTP/1.1 404 
< Content-Length: 0
Content-Length: 0
< Date: Sun, 16 Aug 2020 16:45:33 GMT
Date: Sun, 16 Aug 2020 16:45:33 GMT

< 
* Connection #0 to host 127.0.0.1 left intact
```
