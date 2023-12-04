# librarian_service_api

**librarian_service_api** - this microservice is used for book management in a library.


**API documentation** [http://localhost:8080/demo/swagger-ui/index.html](http://localhost:8080/demo/swagger-ui/index.html)

## Usage

You can generate a bearer token for authorization by following the link [http://localhost:8080/demo/auth](http://localhost:8080/demo/auth) and sending authorization data for corresponding role.

```
{
    "username": "admin/user",
    "password": "100"
}
```

I'm using Postgres database, and service pre-generates some tables for you in database **librariandb** so make sure it's created.

To connect microservices "LIBRARIAN-SERVICE" and "LIBRARY-SERVICE" I use eureka server at Library-service-registry.
 
