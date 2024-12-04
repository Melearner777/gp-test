document.getElementById('addRoomForm').addEventListener('submit', function (event) {
    event.preventDefault(); // Prevent form submission

    // Get form data
    const roomNumber = document.getElementById('roomNumber').value;
    const availability = document.getElementById('availability').value;
    const cleanStatus = document.getElementById('cleanStatus').value;
    const price = document.getElementById('price').value;
    const bedType = document.getElementById('bedType').value;

    // Mock database operation
    console.log("Room Added:", {
        roomNumber,
        availability,
        cleanStatus,
        price,
        bedType,
    });

    // Show success message
    alert('New Room Added Successfully');

    // Reset the form
    document.getElementById('addRoomForm').reset();
});

function cancelForm() {
    if (confirm("Are you sure you want to cancel?")) {
        document.getElementById('addRoomForm').reset();
    }
}
