
# Basic Car API
## Getting Started

This project contains all the files needed to deploy a local instance which I recommend using the provided docker-compose file for.
### Installation

I find it useful to have a docker network created for the compose stack. The docker-compose file uses `carApiNetwork` so run:

`docker network create carApiNetwork`

Go into the `car-api-docker` folder and build the docker images:

`docker-compose build --no-cache`

Run the stack:

`docker-compose up`

You can access the frontend at

`http://localhost:3241`

You can make API calls to

 `http://localhost:8080`

### Things to Know

I have successfully deployed this project on multiple machines and accessed the frontend through the provided IP address and Port.

### docker-compose (recommended)
<br>

```yaml
---

version: '3'
services:
  db:
    build: ./mysql
    container_name: api-database
    restart: on-failure
    environment:
      MYSQL_ROOT_PASSWORD: 'password'
    ports:
      - '3310:3306'
    networks:
      - carApiNetwork
    volumes:
      - ./mysql/data:/var/lib/mysql
  api:
    container_name: car-api
    restart: on-failure
    build: ./car-api
    environment:
      - SPRINGPROFILES=prod
    depends_on:
      - db
    ports:
      - 8080:8080
    networks:
      - carApiNetwork
  frontend:
    container_name: api-frontend
    image: joseluisq/static-web-server:2
    environment:
      - SERVER_CORS_ALLOW_ORIGINS=*
      - SERVER_LOG_LEVEL=debug
      - SERVER_ROOT=/public
    volumes:
      -  ./frontend/files:/public
    ports:
      - 3124:80
    networks:
      - carApiNetwork
networks:
   carApiNetwork:
    external: true
    name: carApiNetwork
```
## Environment Variables

Container images are configured using parameters passed at runtime (such as those above). These parameters are separated by a colon and indicate `<external>:<internal>` respectively. For example, `-p 8080:80` would expose port `80` from inside the container to be accessible from the host's IP on port `8080` outside the container.

## api

| Environment Variable | Function |
| :----: | --- |
| `SPRINGPROFILES=prod` | Connects the jar file to the mysql database for persistent connection.|
| `SPRINGPROFILES=test` | Connects the jar file to a temporary H2 database which will reset every time the container is restarted.|

## frontend

| Environment Variable | Function |
| :----: | --- |
| ` SERVER_CORS_ALLOW_ORIGINS=* ` |This is enabled for development purposes, you can refer to the original <a href="https://github.com/joseluisq/static-web-server"> image </a> for further information.|
| `SERVER_LOG_LEVEL=debug` | This is enabled for development purposes, you can refer to the original <a href="https://github.com/joseluisq/static-web-server"> image </a> for further information. |
|  `SERVER_ROOT=/public` | The default webroot directory. This is mapped in the volume bindings in the provided compose file. Make sure the mappings all correlate if you change this value.|

## db

| Environment Variable | Function |
| :----: | --- |
|  `MYSQL_ROOT_PASSWORD: 'password'` | sets up the root password for the mysql container.

## Why are we doing this?

The API was requested as a final project for the Software Development Bootcamp led by QA. This deliverable utilised technologies such as Java, Spring Boot, MySql, Docker and the testing suites Mockito and Junit.

## How I expected the challenge to go.

I expected to complete the minimum requirements for the project as well as complete some challenges that I set for myself. These extra challenges were to create a frontend for the API and create docker images for each service for easy deployment. I did this because I believe I would have time to complete these extra challenges, but I still accounted for unexpected problems by delegating most of the allocated project time to them.

## What went well? / What didn't go as planned?

I believed I was able to learn the javascript library React and apply this knowledge towards creating a frontend. Unfortunately I did not foresee how much content was needed to learn as well as implement to my project, which I was unable to do in a couple of days.

I resorted to using an apache web server hosted in a docker container and use a volume bind mount to point towards the root web directory. I used javascript to make fetch requests on the frontend to the exposed port of the database in localhost. I found it difficult to work around issues with CORS, especially trying to resolve docker hostnames as internal IP addresses. Using localhost as a url seemed to work, which is acceptable considering this project is not made to be exposed to the internet for public API access.

One particular issue I was unable to resolve was expecting exceptions when performing tests of the service class in the Java project. This may be a configuration error on my end, but I was able to find a work around by throwing an exception and then asserting it inside the catch of a try/catch statement. This worked fine, but was not a graceful implementation of asserting the exception in my opinion.

I managed to successfully implement everything I planned to do in the end. The final deliverables regarding the extra tasks could have a lot of improvements made. This was not a mistake on my end as I was aware that creating a production ready frontend from scratch was not feasible in the time frame we were provided.

## Possible improvements for future revisions of the project.

I have not covered all possible exceptions when sending requests through the REST API. This means that the responses that I receive in the frontend are not handled equally. I would prefer to create more exceptions with greater detail added, so I am able to provide meaningful feedback when a user makes an error.

## Frontend Screenshots

### Create Item
<br>
<img src="docs/images/frontend_create.png" title="Home Page" width="100%">

---
### Read Item
<br>
<img src="docs/images/frontend_read.png" title="Home Page" width="100%">

---
### Update Item
<br>
<img src="docs/images/frontend_update.png" title="Home Page" width="100%">

---
### Delete Item
<br>
<img src="docs/images/frontend_delete.png" title="Home Page" width="100%">

---
### Find Items By Year
<br>
<img src="docs/images/frontend_findItemsByYear.png" title="Home Page" width="100%">

---
### Find Items By Make
<br>
<img src="docs/images/frontend_findItemsByMake.png" title="Home Page" width="100%">

---
### Find Items By Model
<br>
<img src="docs/images/frontend_findItemsByModel.png" title="Home Page" width="100%">

---


## Postman Screenshots

Link to Postman Collection is located in the [documentation]("docs/DFESW12_FP_Cars_API.postman_collection") folder

---
### Create Item
<br>
<img src="docs/images/createItem.png" title="Home Page" width="100%">

---

### Read Item
<br>
<img src="docs/images/readItem.png" title="Home Page" width="100%">

---

### Update Item
<br>
<img src="docs/images/updateItem.png" title="Home Page" width="100%">

---

### Delete Item
<br>
<img src="docs/images/deleteItem.png" title="Home Page" width="100%">

---

### Read Items By Year
<br>
<img src="docs/images/findItemsByYear.png" title="Home Page" width="100%">

---

### Read Items By Make
<br>
<img src="docs/images/findItemsByMake.png" title="Home Page" width="100%">

---

### Read Items By Model
<br>
<img src="docs/images/findItemsByModel.png" title="Home Page" width="100%">

---

## Database Persistance Evidence

I attached a shell to the mysql docker container and checked executed some commands on the `cars_db` database to see if the postman commands had persisted.

---

### Check to See if Item is Deleted
<br>
<img src="docs/images/checkIfDeleted.png" title="Home Page" width="100%">

---
### Check to See if Item is Updated
<br>
<img src="docs/images/checkIfUpdated.png" title="Home Page" width="100%">

---
### Check to See if Item is Created
<br>
<img src="docs/images/checkIfCreated.png" title="Home Page" width="100%">

---
### ERD
<br>
<img src="docs/images/erd.png" title="Home Page" width="100%">

---

## Screenshot of your test results, including coverage report.

### Coverage of Tests
<br>
<img src="docs/images/coverage.png" title="Home Page" width="100%">

---

### Tests Passed
<br>
<img src="docs/images/tests_passed.png" title="Home Page" width="100%">

---

## Risk Assessment

### High Risk, High Impact
 - My Hardware is not new, this means that components such as my Hard Drive are more likely to fail causing data loss.
> This can be prevented by replicating data to other physical locations.
### High Risk, Low Impact
 - Due to terrible ergonomics of my desk station, I frequently suffer from pains in my wrists. This could become more frequent, causing me to take more breaks and delaying the delivery of the final product.
 > This could be mitigated by budgeting for equipment that can help improve posture and reduce physical strain. This request has been escalated to management for consideration.
### Low Risk, High Impact
 - A terrorist organisation could blow up a small nuclear device close to the center of London. As I live close to the center, I might be exposed to the blast or radiation from the fallout. Power outages may occur and potential destruction of property.
 > There really is not a way to prevent this. As the most successful terrorist plots are not known until they are executed and by then it is too late to act.
### Low Risk, Low Impact
 - Mismanagement of files and git repos could lead to confusion of in the development process. This means that data loss could occur or untraceable errors.
 > Proper checks made when branching out and frequent merges to the dev branch may help in mitigating confusion of the codebase.

<a href="https://wessexhurst.atlassian.net/jira/software/projects/DFPA/boards/2/roadmap?shared=&atlOrigin=eyJpIjoiMDk2ODIzMmMwMjI4NDVmZWIyOTMzZmVmZDVkYjJjMGMiLCJwIjoiaiJ9">  	Link to Jira Board </a>