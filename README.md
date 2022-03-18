<h1 align="center">
  <a href="https://github.com/harrykriches@gmail.com/basic-car-api">
    <!-- Please provide path to your logo here -->
    <img src="docs/images/logo.svg" alt="Logo" width="100" height="100">
  </a>
</h1>

<div align="center">
  Basic Car Api
</div>

<div align="center">
<br />




</div>

## About




<details>
<summary>Screenshots</summary>
<br>

> **[?]**
> Please provide your screenshots here.

|                               Home Page                               |                               Login Page                               |
| :-------------------------------------------------------------------: | :--------------------------------------------------------------------: |
| <img src="docs/images/screenshot.png" title="Home Page" width="100%"> | <img src="docs/images/screenshot.png" title="Login Page" width="100%"> |

</details>

### Built With

> **[?]**
> Please provide the technologies that are used in the project.

## Getting Started

### Installation

I find it useful to have a docker network created for the compose stack. The docker-compose file uses `carApiNetwork` so run:

`docker network create carApiNetwork`

Go into the `car-api-docker` folder and build the docker images:

`docker-compose build --no-cache`

`docker-compose up`

## Why are we doing this?

The API was requested as a final project for the Software Development Bootcamp led by QA. This deliverable utilised technologies such as Java, Spring Boot, MySql, Docker and the testing suites Mockito and Junit.

## How I expected the challenge to go.

I expected to complete the minimum requirements for the project as well as complete some challenges that I set for myself. These extra challenges were to create a frontend for the API and create docker images for each service for easy deployment. I did this because I believe I would have time to complete these extra challenges, but I still accounted for unexpected problems by delegating most of the allocated project time to them.

## What went well? / What didn't go as planned?

I believed I was able to learn the javascript library React and apply this knowledge towards creating a frontend. Unfortunately I did not foresee how much content was needed to learn as well as implement to my project, which I was unable to do in a couple of days.

I resorted to using an apache web server hosted in a docker container and use a volume bind mount to point towards the root web directory. I used javascript to make fetch requests on the frontend to the exposed port of the database in localhost. I found it difficult to work around issues with CORS, especially trying to resolve docker hostnames as internal IP addresses. Using localhost as a url seemed to work, which is acceptable considering this project is not made to be exposed to the internet for public API access.

One particular issue I was unable to resolve was expecting exceptions when performing tests of the service class in the Java project. This may be a configuration error on my end, but I was able to find a work around by throwing an exception and then asserting it inside the catch of a try/catch statement. This worked fine, but was not a graceful implementation of asserting the exception in my opinion.

## Possible improvements for future revisions of the project.

I have not covered all possible exceptions when sending requests through the REST API. This means that the responses that I receive in the frontend are not handled equally. I would prefer to create more exceptions with greater detail added, so I am able to provide meaningful feedback when a user makes an error.

## Screenshots showing your postman requests and the output from the API.



## Screenshots of your database to prove that data is being persisted.
## Screenshot of your test results, including coverage report.
## Link to Jira Board - You must add your trainer(s) as collaborators also.

## Usage

> **[?]**
> How does one go about using it?
> Provide various use cases and code examples here.
