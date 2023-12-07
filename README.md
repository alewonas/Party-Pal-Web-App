# Party Pal - Full Stack Application

## Overview

Party Pal is a full stack application that facilitates event management and music collaboration. The application is built using Vue.js for the front end, Java with the Spring Boot framework for the back end, and utilizes npm for managing dependencies. It integrates with Spotify's API for music functionality and employs PostgreSQL as its database.

## Features

- **Event Management:**
  - Users can view a list of events.
  - DJs can create and manage events.

- **Music Collaboration:**
  - Users can request songs at events.
  - DJs have control over the playlist, including play and pause functionality.

- **Spotify Integration:**
  - The app consumes Spotify's API to provide seamless music functionality.

## Tech Stack

- **Front End:**
  - Vue.js
  - HTML
  - CSS
  - JavaScript

- **Back End:**
  - Java
  - Spring Boot
  - Maven

- **Database:**
  - PostgreSQL

## Installation

- Clone the repository:

   ```bash
   git clone https://github.com/your-username/party-pal.git
   ```

### Front End

- Install front-end dependencies using npm:
  ```bash
  npx install
  ```
- Run the development server:
  ```bash
  npx run serve
  ```
  This will start the Vue.js development server, and you can access the application at http://localhost:8080 in your web browser.

### Back End

- Install Maven dependencies:
  ```bash
  mvn install
  ```
- Run the Spring Boot server:
  ```bash
  mvn spring-boot:run
  ```
  The Spring Boot server will start, and you can access the back-end services at http://localhost:9000.

Now, both the front-end and back-end servers are up and running, allowing you to explore and interact with Party Pal.