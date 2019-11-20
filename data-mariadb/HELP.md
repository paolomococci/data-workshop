# RESTful project for accessing data to MariaDB databases

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
< Date: Tue, 19 Nov 2019 16:19:30 GMT
Date: Tue, 19 Nov 2019 16:19:30 GMT

< 
{
  "_links" : {
    "someones" : {
      "href" : "http://127.0.0.1:8080/someones{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://127.0.0.1:8080/profile"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
$ curl -v -i http://127.0.0.1:8080/someones
*   Trying 127.0.0.1:8080...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /someones HTTP/1.1
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
< Date: Tue, 19 Nov 2019 16:21:03 GMT
Date: Tue, 19 Nov 2019 16:21:03 GMT

< 
{
  "_embedded" : {
    "someones" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:8080/someones{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://127.0.0.1:8080/profile/someones"
    },
    "search" : {
      "href" : "http://127.0.0.1:8080/someones/search"
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
$ curl -i -X POST -H "Content-Type:application/json" -d '{"code": "R3SF78QWCTU"}' http://localhost:8080/someones
HTTP/1.1 201 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Location: http://localhost:8080/someones/1
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Tue, 19 Nov 2019 16:26:08 GMT

{
  "code" : "R3SF78QWCTU",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/someones/1"
    },
    "someone" : {
      "href" : "http://localhost:8080/someones/1"
    }
  }
}
$ curl -i -X POST -H "Content-Type:application/json" -d '{"code": "F4J9EF623ME"}' http://localhost:8080/someones
HTTP/1.1 201 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Location: http://localhost:8080/someones/2
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Tue, 19 Nov 2019 16:28:50 GMT

{
  "code" : "F4J9EF623ME",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/someones/2"
    },
    "someone" : {
      "href" : "http://localhost:8080/someones/2"
    }
  }
}
$ curl -i -X POST -H "Content-Type:application/json" -d '{"code": "TR9MI34XW4FE"}' http://localhost:8080/someones
HTTP/1.1 201 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Location: http://localhost:8080/someones/3
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Tue, 19 Nov 2019 16:30:14 GMT

{
  "code" : "TR9MI34XW4FE",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/someones/3"
    },
    "someone" : {
      "href" : "http://localhost:8080/someones/3"
    }
  }
}
$ curl -i -X POST -H "Content-Type:application/json" -d '{"code": "VE75QM8WDN98Z"}' http://localhost:8080/someones
HTTP/1.1 201 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Location: http://localhost:8080/someones/4
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Tue, 19 Nov 2019 16:31:44 GMT

{
  "code" : "VE75QM8WDN98Z",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/someones/4"
    },
    "someone" : {
      "href" : "http://localhost:8080/someones/4"
    }
  }
}
$ curl -i -X POST -H "Content-Type:application/json" -d '{"code": "HT71OS2BRT23J"}' http://localhost:8080/someones
HTTP/1.1 201 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Location: http://localhost:8080/someones/5
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Tue, 19 Nov 2019 16:33:24 GMT

{
  "code" : "HT71OS2BRT23J",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/someones/5"
    },
    "someone" : {
      "href" : "http://localhost:8080/someones/5"
    }
  }
}
$ curl -v -i http://127.0.0.1:8080/someones?sort=code
*   Trying 127.0.0.1:8080...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /someones?sort=code HTTP/1.1
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
< Date: Tue, 19 Nov 2019 16:35:41 GMT
Date: Tue, 19 Nov 2019 16:35:41 GMT

< 
{
  "_embedded" : {
    "someones" : [ {
      "code" : "F4J9EF623ME",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/someones/2"
        },
        "someone" : {
          "href" : "http://127.0.0.1:8080/someones/2"
        }
      }
    }, {
      "code" : "HT71OS2BRT23J",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/someones/5"
        },
        "someone" : {
          "href" : "http://127.0.0.1:8080/someones/5"
        }
      }
    }, {
      "code" : "R3SF78QWCTU",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/someones/1"
        },
        "someone" : {
          "href" : "http://127.0.0.1:8080/someones/1"
        }
      }
    }, {
      "code" : "TR9MI34XW4FE",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/someones/3"
        },
        "someone" : {
          "href" : "http://127.0.0.1:8080/someones/3"
        }
      }
    }, {
      "code" : "VE75QM8WDN98Z",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/someones/4"
        },
        "someone" : {
          "href" : "http://127.0.0.1:8080/someones/4"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:8080/someones"
    },
    "profile" : {
      "href" : "http://127.0.0.1:8080/profile/someones"
    },
    "search" : {
      "href" : "http://127.0.0.1:8080/someones/search"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 5,
    "totalPages" : 1,
    "number" : 0
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

## and now from database server perspective:
```
MariaDB [(none)]> use someone;

Database changed
MariaDB [someone]> show tables;
+--------------------+
| Tables_in_someone  |
+--------------------+
| hibernate_sequence |
| someone            |
+--------------------+
2 rows in set (0.000 sec)

MariaDB [someone]> describe someone;
+-------+--------------+------+-----+---------+-------+
| Field | Type         | Null | Key | Default | Extra |
+-------+--------------+------+-----+---------+-------+
| id    | bigint(20)   | NO   | PRI | NULL    |       |
| code  | varchar(255) | YES  |     | NULL    |       |
+-------+--------------+------+-----+---------+-------+
2 rows in set (0.001 sec)

MariaDB [someone]> select * from someone;
+----+---------------+
| id | code          |
+----+---------------+
|  1 | R3SF78QWCTU   |
|  2 | F4J9EF623ME   |
|  3 | TR9MI34XW4FE  |
|  4 | VE75QM8WDN98Z |
|  5 | HT71OS2BRT23J |
+----+---------------+
5 rows in set (0.000 sec)

MariaDB [someone]> select code from someone;
+---------------+
| code          |
+---------------+
| R3SF78QWCTU   |
| F4J9EF623ME   |
| TR9MI34XW4FE  |
| VE75QM8WDN98Z |
| HT71OS2BRT23J |
+---------------+
5 rows in set (0.000 sec)

MariaDB [someone]> select * from someone order by code;
+----+---------------+
| id | code          |
+----+---------------+
|  2 | F4J9EF623ME   |
|  5 | HT71OS2BRT23J |
|  1 | R3SF78QWCTU   |
|  3 | TR9MI34XW4FE  |
|  4 | VE75QM8WDN98Z |
+----+---------------+
5 rows in set (0.000 sec)
```

## again from RESTful web service perspective:
```
$ curl -v -i http://127.0.0.1:8080/someones
*   Trying 127.0.0.1:8080...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /someones HTTP/1.1
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
< Date: Tue, 19 Nov 2019 17:15:24 GMT
Date: Tue, 19 Nov 2019 17:15:24 GMT

< 
{
  "_embedded" : {
    "someones" : [ {
      "code" : "R3SF78QWCTU",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/someones/1"
        },
        "someone" : {
          "href" : "http://127.0.0.1:8080/someones/1"
        }
      }
    }, {
      "code" : "F4J9EF623ME",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/someones/2"
        },
        "someone" : {
          "href" : "http://127.0.0.1:8080/someones/2"
        }
      }
    }, {
      "code" : "TR9MI34XW4FE",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/someones/3"
        },
        "someone" : {
          "href" : "http://127.0.0.1:8080/someones/3"
        }
      }
    }, {
      "code" : "VE75QM8WDN98Z",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/someones/4"
        },
        "someone" : {
          "href" : "http://127.0.0.1:8080/someones/4"
        }
      }
    }, {
      "code" : "HT71OS2BRT23J",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/someones/5"
        },
        "someone" : {
          "href" : "http://127.0.0.1:8080/someones/5"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:8080/someones{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://127.0.0.1:8080/profile/someones"
    },
    "search" : {
      "href" : "http://127.0.0.1:8080/someones/search"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 5,
    "totalPages" : 1,
    "number" : 0
  }
* Connection #0 to host 127.0.0.1 left intact
}
```
