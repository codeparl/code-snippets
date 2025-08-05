<?php require  'app.php' ?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task Management System</title>
    <link rel="stylesheet" href="styles.css">
    <link href="assets/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<div class="main-content">
    <div class="sec">
        <form  method="post">
            <label for="task_name">Task Name:</label>
            <input type="text" id="task_name" name="task_name" required><br><br>

            <label for="deadline">Deadline:</label>
            <input type="date" id="deadline" name="deadline" required><br><br>

            <label for="status">Status:</label>
            <select id="status" name="status" required>
                <option value="pending">Pending</option>
                <option value="completed">Completed</option>
            </select><br><br>

            <label for="assigned_to">Assigned To:</label>
            <select id="assigned_to" name="assigned_to" required>
                <?php foreach ($users as $user): ?>
                    <option value="<?php echo $user['id']; ?>"><?php echo $user['name']; ?></option>
                <?php endforeach; ?>
            </select>

            <input id="submit" type="button" value="Submit">
        </form>
    </div>

    <div class="sec">
    <h2>Task List</h2>
        <table class="table-striped table">
            <thead>
                <tr>
                    <th>Task Name</th>
                    <th>Deadline</th>
                    <th>Status</th>
                    <th>Assigned To</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($tasks as $task): ?>
                    <tr>
                        <td><?php echo $task['task_name']; ?></td>
                        <td><?php echo $task['deadline']; ?></td>
                        <td><?php echo $task['status']; ?></td>
                        <td><?php echo $task['assigned_to']; ?></td>
                    </tr>
                <?php endforeach; ?>
            </tbody>
        </table>
    </div>

    <script src="/assets/js/jquery.js"></script>
    <script src="/assets/js/axios.js"></script>
    <script src="/assets/js/main.js"></script>
    </div>
</body>

</html>