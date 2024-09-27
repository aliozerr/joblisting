# Simple Spring Boot MongoDB Job Listing Project

This project is a RESTful API for a job listing application built with Spring Boot and MongoDB. It allows users to create, retrieve, update, and delete job posts, as well as search for posts based on specific criteria.

## Features

- Create new job posts
- Retrieve all job posts
- Retrieve a single job post by ID
- Update existing job posts
- Delete job posts
- Search for job posts by text (searches across technologies, description, and profile fields)

## Technologies Used

- Spring Boot
- MongoDB
- Java

## Project Structure

The project consists of the following main components:

1. `PostController`: Handles HTTP requests and defines API endpoints.
2. `PostService`: Contains business logic and interacts with repositories.
3. `PostRepository`: Standard MongoDB repository for basic CRUD operations.
4. `SearchRepository` and `SearchRepositoryImpl`: Custom repository for text-based search functionality.

## API Endpoints

- `GET /posts`: Retrieve all job posts
- `GET /posts/id/{postId}`: Retrieve a single job post by ID
- `GET /posts/{text}`: Search for job posts containing the specified text
- `POST /post`: Create a new job post
- `PUT /posts/{postId}`: Update an existing job post
- `DELETE /posts/{postId}`: Delete a job post

## Setup and Running

1. Ensure you have Java and MongoDB installed on your system.
2. Clone the repository to your local machine.
3. Configure MongoDB connection in `application.properties` file.
4. Run the Spring Boot application.


## Search Functionality

The search feature uses MongoDB's aggregation pipeline to perform text searches across multiple fields (technologies, description, and profile). Results are sorted by experience level and limited to 5 entries.
Send a GET request to `/posts/{searchText}`, replacing `{searchText}` with your search query.

## Update Functionality

The update feature uses MongoDB's `MongoTemplate` to perform partial updates on job posts. It only updates the fields that are provided in the update request, leaving other fields unchanged.

