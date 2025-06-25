import React, { useState } from "react";

function Department() {

    const [name, setName] = useState("");
    const [description, setDescription] = useState("");
    const [message, setMessage] = useState("");

    const handleSubmit = async (e) => {
        e.preventDefault();

        const departmentData = { name, description };

        try {
            const response = await fetch("http://localhost:8080/department", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(departmentData),
            });

            if (response.ok) {
                setMessage("✅ Department added successfully!");
                setName("");
                setDescription("");
            } else {
                setMessage("❌ Failed to add department.");
            }
        } catch (error) {
            console.error("Error:", error);
            setMessage("❌ Server error.");
        }
    };

    return (
        <div className="max-w-md mx-auto p-6 bg-white rounded-2xl shadow-lg mt-10">
            <h2 className="text-2xl font-bold mb-4 text-center">Add Department</h2>
            {message && (
                <div className="text-center mb-4 text-sm font-medium text-green-600">
                    {message}
                </div>
            )}
            <form onSubmit={handleSubmit} className="space-y-4">
                <div>
                    <label className="block text-sm font-medium">Department Name</label>
                    <input
                        type="text"
                        className="w-full border border-gray-300 p-2 rounded-md mt-1 focus:outline-none focus:ring-2 focus:ring-blue-500"
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label className="block text-sm font-medium">Description</label>
                    <textarea
                        className="w-full border border-gray-300 p-2 rounded-md mt-1 focus:outline-none focus:ring-2 focus:ring-blue-500"
                        rows="4"
                        value={description}
                        onChange={(e) => setDescription(e.target.value)}
                        required
                    />
                </div>
                <button
                    type="submit"
                    className="w-full bg-blue-600 text-white py-2 px-4 rounded-md hover:bg-blue-700 transition-all"
                >
                    Add Department
                </button>
            </form>
        </div>
    );
};

export default Department;
