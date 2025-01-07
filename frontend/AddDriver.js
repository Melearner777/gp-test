document.getElementById("addDriverForm").addEventListener("submit", function (e) {
    e.preventDefault();

    // Capture form data
    const name = document.getElementById("name").value.trim();
    const age = document.getElementById("age").value.trim();
    const gender = document.getElementById("gender").value;
    const company = document.getElementById("company").value.trim();
    const model = document.getElementById("model").value.trim();
    const available = document.getElementById("available").value;
    const location = document.getElementById("location").value.trim();

   
    if (!name || !age || !gender || !company || !model || !available || !location) {
        alert("Please fill all fields!");
        return;
    }

   
    const driverData = { name, age, gender, company, model, available, location };

    fetch("http://localhost:5000/api/drivers", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(driverData),
    })
        .then((response) => {
            if (response.ok) {
                alert("Driver added successfully!");
                document.getElementById("addDriverForm").reset();
            } else {
                throw new Error("Failed to add driver.");
            }
        })
        .catch((error) => {
            console.error("Error:", error);
            alert("Error adding driver. Please try again.");
        });
});
