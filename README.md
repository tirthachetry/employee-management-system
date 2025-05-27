# Employee Management System

This project is a Spring Boot application for managing employees and their dependents. It provides RESTful APIs for creating, updating, retrieving, and querying employees and their dependents.

## Features

- **CRUD Operations**: Create, Read, Update, and Delete employees.
- **Dependent Management**: Manage dependents associated with employees.
- **Query by Dependent**: Query employees based on dependent details.
- **Validation**: Ensures data integrity and proper error handling.

## Technologies Used

- **Java**: Programming language.
- **Spring Boot**: Framework for building the application.
- **Gradle**: Build tool.
- **JPA (Hibernate)**: For database interaction.
- **H2 Database**: In-memory database for development and testing.

## Endpoints

### Employee Endpoints

#### Create Employee
**POST** `/employees`

Request Body:
```json
{
  "name": "Employee Name",
  "dependents": [
    {
      "name": "Dependent Name",
      "relationship": "Relationship"
    }
  ]
}
```
Response:
```json
{
  "id": 1,
  "name": "Employee Name",
  "dependents": [
    {
      "id": 1,
      "name": "Dependent Name",
      "relationship": "Relationship"
    }
  ]
}
```
#### Get Employee by ID
**GET** `/employees/{id}`
Response:
```json
{
  "id": 1,
  "name": "Employee Name",
  "dependents": [
    {
      "id": 1,
      "name": "Dependent Name",
      "relationship": "Relationship"
    }
  ]
}
```
#### Update Employee
**PUT** `/employees/{id}`
Request Body:
```json
{
  "name": "Updated Employee Name",
  "dependents": [
    {
      "id": 1,
      "name": "Updated Dependent Name",
      "relationship": "Updated Relationship"
    }
  ]
}
```
Response:
```json
{
  "id": 1,
  "name": "Updated Employee Name",
  "dependents": [
    {
      "id": 1,
      "name": "Updated Dependent Name",
      "relationship": "Updated Relationship"
    }
  ]
}
```
#### Partial Update Employee
**PATCH** `/employees/{id}`
Request Body:
```json
{
  "name": "Partially Updated Employee Name"
}
```
Response:
```json
{
  "id": 1,
  "name": "Partially Updated Employee Name",
  "dependents": [
    {
      "id": 1,
      "name": "Dependent Name",
      "relationship": "Relationship"
    }
  ]
}
```
#### Delete Employee
**DELETE** `/employees/{id}`
Response: `Delete Successfully for ID: {id}`

### Error Handling
#### Error Response Format
```json
{
  "status": "error",
  "message": "Error message here",
  "timestamp": "2023-10-01T12:00:00Z"
}
```
### Database Schema
#### Employee Table
- id (Primary Key)
- name
- dependents (One-to-Many relationship with Dependent)
#### Dependent Table
- id (Primary Key)
- name
- relationship
- employee_id (Foreign Key)

## Running the Application
To run the application, follow these steps:
- Clone the repository.
- Navigate to the project directory.
- Build the project using Gradle:
  - ./gradlew build
- Run the application:
  - ./gradlew bootRun
- Access the application at http://localhost:8080.

### Example curl commands
#### Create Employee
```curl
curl -X POST "http://localhost:8080/employees" \
-H "Content-Type: application/json" \
-d '{
  "name": "John Doe",
  "dependents": [
    {
      "name": "Jane Doe",
      "relationship": "Spouse"
    }
  ]
}'
```
#### Get Employee by ID
```curl
curl -X GET "http://localhost:8080/employees/1"
```
#### Update Employee
```curl
curl -X PUT "http://localhost:8080/employees/1" \
-H "Content-Type: application/json" \
-d '{
  "name": "Updated Name",
  "dependents": [
    {
      "name": "Updated Dependent",
      "relationship": "Updated Relationship"
    }
  ]
}'
```
#### Partial Update Employee
```curl
curl -X PATCH "http://localhost:8080/employees/1" \
-H "Content-Type: application/json" \
-d '{
  "name": "Partially Updated Name"
}'
```
#### Delete Employee
```curl
curl -X DELETE "http://localhost:8080/employees/1"
```
#### Query Employees by Dependent
```curl
curl -X GET "http://localhost:8080/employees?dependentName=Jane Doe&relationship=Spouse"
```
## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
## Contributing
Contributions are welcome! Please follow these steps:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Make your changes and commit them (`git commit -m 'Add your feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Create a pull request.
6. Discuss and review the changes.
7. Merge the pull request once approved.
8. Celebrate your contribution!
9. Update the documentation as needed.
10. Ensure all tests pass before merging.
11. Follow the project's coding standards and conventions.
12. Keep the commit history clean and meaningful.
13. Document any new features or changes in the code.
14. Respect the project's issue and pull request templates.
15. Engage with the community by responding to comments and feedback.
16. Stay updated with the project's progress and discussions.
17. Be respectful and collaborative in all interactions.


## Future Tasks @subhamkp

- **Authentication and Authorization**: Implement user authentication and role-based access control.
- **Pagination and Sorting**: Add support for paginated and sorted responses for large datasets.
- **Search Functionality**: Enable advanced search capabilities for employees and dependents.
- **API Documentation**: Integrate Swagger or OpenAPI for better API documentation.
- **Unit and Integration Tests**: Increase test coverage for all services and controllers.
- **Database Migration Tool**: Use Flyway or Liquibase for managing database schema changes.
- **Deployment**: Set up CI/CD pipelines and deploy the application to a cloud platform.
- **Internationalization (i18n)**: Add support for multiple languages.
- **Frontend Integration**: Develop a frontend application to interact with the backend APIs.
- **Performance Optimization**: Optimize database queries and application performance for scalability.