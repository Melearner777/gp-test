CREATE DATABASE hotel_management;

-- Use the newly created database
USE hotel_management;

-- Step 2: Create Room Table
CREATE TABLE room (
    room_number VARCHAR(10) PRIMARY KEY,
    availability ENUM('Available', 'Occupied') NOT NULL,
    cleaning_status ENUM('Cleaned', 'Dirty') NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    bed_type ENUM('Single Bed', 'Double Bed') NOT NULL
);

-- Sample Insert (Optional)
-- This is just to test the table with an example entry.
INSERT INTO room (room_number, availability, cleaning_status, price, bed_type)
VALUES ('101', 'Available', 'Cleaned', 100.00, 'Single Bed');