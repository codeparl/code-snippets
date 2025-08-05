<?php 
require  'db_manager.php';

createTables();
//addUsersFromJson('users.json');
$users  =  getUsers();
$tasks  =  getTasks();
if($_SERVER['REQUEST_METHOD'] == 'POST'){
    //store tasks  
    $time = strtotime($_POST['deadline']);
    $date = date('Y-m-d',$time);
    addTask($_POST['task_name'],$_POST['status'],$_POST['assigned_to'],$date );


}
