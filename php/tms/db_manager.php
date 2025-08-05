<?php
require 'config.php';

$db = null;

function  createDB()
{
    global $db;
    // Create connection
    $db = new mysqli(SERVER_NAME, DB_USER, DB_PASSWORD);
    // Check connection
    if ($db->connect_error) {
        die("Connection failed: " . $db->connect_error);
    }

    // Create database
    $sql = "CREATE DATABASE    " . DB_NAME;
    if ($db->query($sql) === TRUE) {
        echo "Database created successfully";
    } else {
        echo "Error creating database: " . $db->error;
    }
}

function connectToDB()
{
    global $db;
    $db = new mysqli(SERVER_NAME, DB_USER, DB_PASSWORD, DB_NAME,);
    if ($db->connect_error) {
        die("Connection failed: " . $db->connect_error);
    }

    return $db;
}

function  createTables()
{
    global $db;
    $db =  connectToDB();

    $usersSql = <<<SQL
    CREATE TABLE IF NOT EXISTS users (
        id INT AUTO_INCREMENT PRIMARY KEY,
        `name` VARCHAR(255) NOT NULL,
        email VARCHAR(255) NOT NULL,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    )
    SQL;

    $taskSql  =  <<<SQL
    CREATE TABLE IF NOT EXISTS tasks (
        id INT AUTO_INCREMENT PRIMARY KEY,
        task_name VARCHAR(255) NOT NULL,
        deadline DATETIME NOT NULL,
        status ENUM('pending', 'completed') NOT NULL,
        assigned_to INT  NULL,
        FOREIGN KEY (assigned_to) REFERENCES users(id),
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    )

    SQL;

    if ($db->query($usersSql) === TRUE) {
    } else {
        echo "Error creating table: " . $db->error;
    }

    if ($db->query($taskSql) === TRUE) {
    } else {
        echo "Error creating table: " . $db->error;
    }

    $db->close();
}



function addUsersFromJson($jsonFilePath)
{
    $db = connectToDB();
    $db->query("DELETE FROM users");

    $jsonData = file_get_contents($jsonFilePath);
    $users = json_decode($jsonData, true);

    if (is_array($users)) {
        foreach ($users as $user) {
            if (isset($user['name']) && isset($user['email'])) {
                addUser($user['name'], $user['email']);
            }
        }
    } else {
        echo "Invalid JSON data.";
    }
}

function getUsers()
{
    $db = connectToDB();
    $result = $db->query("SELECT id, name FROM users");
    $users = [];
    if ($result->num_rows > 0) {
        while ($row = $result->fetch_assoc()) {
            $users[] = $row;
        }
    }
    $db->close();

    return $users;
}


function getTasks(){
    $db = connectToDB();
    $result = $db->query("SELECT tasks.id, task_name, deadline, status, users.name AS assigned_to FROM tasks LEFT JOIN users ON tasks.assigned_to = users.id");
    $tasks = [];
    if ($result->num_rows > 0) {
        while ($row = $result->fetch_assoc()) {
            $tasks[] = $row;
        }
    }
    $db->close();

    return $tasks;
}
function addTask($name, $status, $assignedTo,$deadline)
{
    global $db;
    $db = connectToDB();

    $stmt = $db->prepare("INSERT INTO tasks (task_name, status, assigned_to, deadline) VALUES (?, ?,?,?)");
    $stmt->bind_param("ssss", $name, $status, $assignedTo,$deadline);

    if ($stmt->execute() === TRUE) {
    } else {
        echo "Error: " . $stmt->error;
    }

    $stmt->close();
    $db->close();
}

function addUser($name, $email)
{
    global $db;
    $db = connectToDB();

    $stmt = $db->prepare("INSERT INTO users (name, email) VALUES (?, ?)");
    $stmt->bind_param("ss", $name, $email);

    if ($stmt->execute() === TRUE) {
    } else {
        echo "Error: " . $stmt->error;
    }

    $stmt->close();
    $db->close();
}
