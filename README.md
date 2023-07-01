# Employee Management System
![](https://github.com/prameswaraandhika/Employee-Management-System-Terminal-Based/blob/master/employee-management.gif)

This is a Java program for an Employee Management System, a terminal-based application that allows users to manage a list of employees. The program provides various features such as adding, editing, searching, sorting, and removing employees.

## Features

The Employee Management System provides the following features:

1. **Add Employee**: Allows users to add new employees to the system by entering their name and position.

2. **Delete Employee**: Enables users to remove an employee from the system by providing the employee's ID.

3. **Edit Employee**: Allows users to edit the details of an existing employee, including their name and position.

4. **Search Employee**: Provides the ability to search for employees based on either their name or position.

5. **Sort Employees**: Sorts the list of employees in ascending order based on their IDs.

6. **Display Employees**: Displays the list of employees, including their IDs, names, and positions.

7. **Exit**: Terminates the program and exits the application.

## Usage

1. When the program starts, it displays the current list of employees in a tabular format.

2. Users can choose from the available options by entering the corresponding command number:

   - `1`: Add a new employee.
   - `2`: Delete an existing employee.
   - `3`: Edit the details of an employee.
   - `4`: Search for an employee.
   - `5`: Sort the list of employees.
   - `6`: Exit the program.

3. To add a new employee, select option `1` and provide the employee's name and position when prompted.

4. To delete an employee, select option `2` and enter the ID of the employee to be removed.

5. To edit an employee's details, select option `3`, enter the employee's ID, and provide the updated name and position.

6. To search for an employee, select option `4` and choose whether to search by name or position. Enter the corresponding search term, and the program displays the matching results.

7. To sort the list of employees, select option `5`. The program rearranges the employees based on their IDs in ascending order.

8. To exit the program, select option `6`.

## Implementation Details

The program is implemented in Java and uses the following concepts:

- **Object-Oriented Programming**: The program uses objects and classes to represent employees. The `Employee` class encapsulates the attributes of an employee, such as their ID, name, and position.

- **Collections**: The program utilizes the `ArrayList` class from the `java.util` package to store and manage the list of employees.

- **User Input**: The program uses the `Scanner` class from the `java.util` package to read user input from the terminal.

- **Control Flow**: The program uses conditional statements (`if`, `switch`) and loops (`for`, `while`) to implement different functionalities and handle user interactions.

- **Exception Handling**: The program handles exceptions using the `throws` keyword and catches them where necessary.

## Getting Started

To run the Employee Management System program, follow these steps:

1. Make sure you have Java Development Kit (JDK) installed on your system.

2. Copy the provided code into a Java source file (e.g., `Main.java`).

3. Compile the source file using the following command:
