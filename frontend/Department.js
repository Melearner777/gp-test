document.addEventListener("DOMContentLoaded", () => {
    const tableBody = document.querySelector("#department-table tbody");

    // Fetch data from API
    fetch("https://example.com/api/department") // Replace with your API endpoint
        .then(response => response.json())
        .then(data => {
            data.forEach(department => {
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td>${department.name}</td>
                    <td>${department.budget}</td>
                `;
                tableBody.appendChild(row);
            });
        })
        .catch(error => {
            console.error("Error fetching data:", error);
            alert("Error fetching data from server.");
        });

    // Back button functionality
    document.getElementById("back-button").addEventListener("click", () => {
        // Simulate navigation to Reception page
        window.location.href = "reception.html"; // Replace with your Reception page
    });
});
