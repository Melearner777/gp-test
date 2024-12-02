<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<h1>Online HOTEL Booking System </h1>

<p><strong>GUVI Project for Sem-III B.Tech</strong><br>
A web-based Hotel Management System designed to streamline hotel operations, allowing admins to manage customer bookings, room availability, staff details, and other hotel-related services efficiently.</p>

<h2>Table of Contents</h2>
<ul>
  <li><a href="#overview">Overview</a></li>
  <li><a href="#features">Features</a></li>
  <li><a href="#technologies-used">Technologies Used</a></li>
  <li><a href="#setup">Setup</a></li>
  <li><a href="#database-configuration">Database Configuration</a></li>
  <li><a href="#usage">Usage</a></li>
  <li><a href="#future-scope">Future Scope</a></li>
  <li><a href="#contributing">Contributing</a></li>
  <li><a href="#license">License</a></li>
</ul>

<h2 id="overview">Overview</h2>
<p>The Hotel Management System automates various hotel operations, including room bookings, check-ins, check-outs, and employee management. It provides a user-friendly interface for administrators to manage guests, rooms, and staff members effectively, making daily hotel operations seamless and error-free.</p>

<h2 id="features">Features</h2>
<ul>
  <li>Room bookings and reservations</li>
  <li>Front desk operations (check-ins/check-outs)</li>
  <li>Guest profile management</li>
  <li>Role-based access control for security</li>
  <li>Real-time room availability and status updates</li>
  <li>Employee and department management</li>
  <li>Room maintenance and housekeeping tracking</li>
</ul>

<h2 id="technologies-used">Technologies Used</h2>
<ul>
  <li><strong>Frontend</strong>: HTML, CSS, JavaScript</li>
  <li><strong>Backend</strong>: Java, Servlet APIs</li>
  <li><strong>Database</strong>: MySQL</li>
</ul>

<h2 id="setup">Setup</h2>
<ol>
  <li><strong>Clone the Repository</strong>:
    <pre><code>git clone &lt;repository_url&gt;
cd hotel-management-system
</code></pre>
  </li>

  <li><strong>Install Dependencies</strong>:<br>
    Install MySQL and Java Development Kit (JDK) if not already installed.
  </li>

  <li><strong>Database Configuration</strong>:
    <ul>
      <li>Open MySQL and create a database named <code>hotel_management</code>.</li>
      <li>Import the database tables by running the provided SQL scripts in the <code>/db</code> folder.</li>
    </ul>
  </li>

  <li><strong>Run the Application</strong>:
    <ul>
      <li>Configure your servlet container (e.g., Tomcat) and place the application files in the appropriate directory.</li>
      <li>Start the server and access the application at <code>http://localhost:&lt;port&gt;/hotel-management-system</code>.</li>
    </ul>
  </li>
</ol>

<h2 id="database-configuration">Database Configuration</h2>
<ol>
  <li><strong>Database Connection</strong>:<br>
    Update the database connection string in <code>conn.java</code>:
    <pre><code>String connectionurl = "jdbc:mysql://localhost:3306/hotel_management?user=root&password=&lt;802301&gt;";
</code></pre>
  </li>

  <li><strong>Tables</strong>:<br>
    The system utilizes tables for rooms, customers, employees, and booking details. Ensure all necessary tables are created in MySQL using the SQL file provided.
  </li>
</ol>

<h2 id="usage">Usage</h2>
<ol>
  <li><strong>Admin Login</strong>: Start by logging in with admin credentials to access all features.</li>
  
  <li><strong>Managing Rooms</strong>:
    <ul>
      <li>Add new rooms, mark them as available or occupied.</li>
      <li>Update room details and housekeeping status.</li>
    </ul>
  </li>

  <li><strong>Handling Bookings</strong>:
    <ul>
      <li>Register new customer bookings.</li>
      <li>Check customers in and out, automatically updating room availability.</li>
    </ul>
  </li>

  <li><strong>Employee Management</strong>:
    <ul>
      <li>Add, update, and view employee details.</li>
      <li>Assign roles and manage access permissions.</li>
    </ul>
  </li>
</ol>

<h2 id="future-scope">Future Scope</h2>
<p>Potential improvements for the system include:</p>
<ul>
  <li>Adding payment processing integration.</li>
  <li>Providing customer-facing features, such as online booking.</li>
  <li>Expanding to support multiple hotel branches.</li>
</ul>

<h2 id="contributing">Contributing</h2>
<p>Contributions are welcome! Please fork the repository and submit a pull request.</p>

<h2 id="license">License</h2>
<p>This project is licensed under the MIT License.</p>

</body>
</html>
