# data-redis

## create an item
```

```

## fetching record from id
```
$ curl -v -i http://127.0.0.1:8080/api/reactive/items/dca9a1da-22c6-4087-ba15-93ef7c543a25
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /api/reactive/items/dca9a1da-22c6-4087-ba15-93ef7c543a25 HTTP/1.1
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
< Date: Sat, 15 Aug 2020 06:03:12 GMT
Date: Sat, 15 Aug 2020 06:03:12 GMT

< 
{
  "code" : "74c4fc82-0ee5-4937-8853-604ee7ba6b68",
  "name" : "one",
  "description" : "some description",
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:8080/api/reactive/items/dca9a1da-22c6-4087-ba15-93ef7c543a25"
    },
    "items" : {
      "href" : "http://127.0.0.1:8080/api/reactive/items"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

## fetching all records:
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
< Date: Sat, 15 Aug 2020 05:51:29 GMT
Date: Sat, 15 Aug 2020 05:51:29 GMT

< 
{
  "_embedded" : {
    "items" : [ {
      "code" : "74c4fc82-0ee5-4937-8853-604ee7ba6b68",
      "name" : "one",
      "description" : "some description",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/api/reactive/items/dca9a1da-22c6-4087-ba15-93ef7c543a25"
        },
        "items" : {
          "href" : "http://127.0.0.1:8080/api/reactive/items"
        }
      }
    }, {
      "code" : "5e8efaa3-2257-4214-ab34-d84519973edf",
      "name" : "five",
      "description" : "some description",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/api/reactive/items/943a6a13-ea75-49fa-b28e-e4a197980a27"
        },
        "items" : {
          "href" : "http://127.0.0.1:8080/api/reactive/items"
        }
      }
    }, {
      "code" : "17655afe-9739-4313-9f18-5a3cff0f644e",
      "name" : "three",
      "description" : "some description",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/api/reactive/items/49cfea64-d04c-418f-aa27-91eaf4c8d848"
        },
        "items" : {
          "href" : "http://127.0.0.1:8080/api/reactive/items"
        }
      }
    }, {
      "code" : "e43c869e-7419-414b-8468-2e60fe87810c",
      "name" : "two",
      "description" : "some description",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/api/reactive/items/acc57499-02bc-4004-bee6-e09310c2de0c"
        },
        "items" : {
          "href" : "http://127.0.0.1:8080/api/reactive/items"
        }
      }
    }, {
      "code" : "a3e62bb4-c8e1-4b04-87b8-ded3bce5c9ed",
      "name" : "four",
      "description" : "some description",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/api/reactive/items/df1a62a5-9590-4d2e-b79d-2d825a1b23ef"
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

## delete record from id
```

```
