#Employee Management System
This is a simple web application for managing employee details in an organization. It provides basic CRUD (Create, Read, Update, Delete) operations for employees, as well as several complex queries.

#Technologies Used
Frontend: ReactJS, HTML/CSS
Backend: Spring Boot, Java
Database: MongoDB

#Collections
Employee: id, name, age, gender, phone, department_id
Salary: employee_id, basic_pay, meal_allowance, commute_allowance, phone_allowance, internet_allowance, tax_percentage
Dependent: id, employee_id, age, gender, relationship
Department: id, name, size
Insurance: insured_id, amount_covered, premium_per_month

#Basic Queries
Get all employees
Get employee by Id
Add employee
Update employee by Id
Delete employee by Id

#Complex Queries
Get employee and dependents’ insurance coverage details for an employee (Collections used - Employee, Dependent, and Insurance)
Get the net salary of an employee (Collections used - Employee, Dependent, Insurance, and Salary)
Get the net expenditure of a department (Collections used - Employee, Department, Dependent, Insurance, and Salary)

#Running the Application
#Prerequisites
Node.js
Java
MongoDB

#Backend
Clone the repository
Navigate to the backend folder
Run ./mvnw spring-boot:run to start the server

#Frontend
Navigate to the frontend folder
Run npm install to install dependencies
Run npm start to start the development server
Open http://localhost:3000 in your browser to view the application

#Contributors
Vignesh Somasundaram
Sri Harish Jayaram
