# Wishlist

---

### Project Description
1. CRUD application that accepts user input via REST endpoints;
2. User inputs are saved in Postgres database, which can be easily started using Docker;
3. Additionally, there is additional endpoint which accepts JSON formatted list of users, and returns value as string to user. 
---
### Configuration
1. Get this project from Git:
   * clone project <br>
   `git@github.com:yapijs/Wishlist.git`
2. Get Postgres image by running this command: <br>
   `docker run --name postgres-db -e POSTGRES_PASSWORD=docker -p 5432:5432 -d postgres`
3. Run the project !

---
### Endpoints
Swagger-UI can be accessed [here](http://localhost:8080/swagger-ui/index.html#/)

![Alt text](/endpoints.png)

---
### Tests
There are also unit tests to verify correctness of the app.
