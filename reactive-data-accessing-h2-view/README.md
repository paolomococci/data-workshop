# Reactive data accessing to H2 RDBMS view

## Here's how to consume a RESTful web service using Spring Boot and Vaadin

This web application reads the following response produced by the RESTful data-accessing-h2-expose web service, transforming it into something graphically pleasing and usable.

```
{
  "_embedded" : {
    "items" : [ {
      "code" : "12001212",
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
    }, {
      "code" : "12001214",
      "description" : "sample items into database",
      "status" : "AVAILABLE",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8091/items/2"
        },
        "item" : {
          "href" : "http://127.0.0.1:8091/items/2"
        }
      }
    }, {
      "code" : "12001216",
      "description" : "sample items into database",
      "status" : "AVAILABLE",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8091/items/3"
        },
        "item" : {
          "href" : "http://127.0.0.1:8091/items/3"
        }
      }
    }, {
      "code" : "12001218",
      "description" : "sample items into database",
      "status" : "AVAILABLE",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8091/items/4"
        },
        "item" : {
          "href" : "http://127.0.0.1:8091/items/4"
        }
      }
    }, {
      "code" : "12001220",
      "description" : "sample items into database",
      "status" : "AVAILABLE",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8091/items/5"
        },
        "item" : {
          "href" : "http://127.0.0.1:8091/items/5"
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
}
```
