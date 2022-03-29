# QIMAone Interview

## Description

The goal is to create one endpoint that will __insert__ a book:

```json
{
  "name": "the name of the book",
  "description": "a short description",
  "authorId": 123
}
```

### Behavior

1. if the book name is present in the collection, the result is `BAD_REQUEST`
2. if the authorId is not present in the authors' collection, the result is `BAD_REQUEST`
3. Else the book is added in the book collection, and you return the http status `CREATED` with the body:

```json
{
  "id": 2345,
  "name": "the name of the book",
  "description": "a short description",
  "author": {
    "id": 123,
    "firstname": "John"
  }
}
```
