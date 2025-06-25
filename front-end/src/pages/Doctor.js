import React, { useState } from 'react';
import axios from 'axios';

function Doctor() {

    const [doctor, setDoctor] = useState({
        name: '',
        specialization: '',
        contactNumber: '',
        department: {
            departmentId: ''
        }
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        if (name === 'departmentId') {
            setDoctor({
                ...doctor,
                department: {
                    ...doctor.department,
                    departmentId: value
                }
            });
        } else {
            setDoctor({ ...doctor, [name]: value });
        }
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/doctor', doctor);
            alert('Doctor saved successfully!');
            setDoctor({ name: '', specialization: '', contactNumber: '', department: { departmentId: '' } });
        } catch (error) {
            console.error('Error saving doctor:', error);
            alert('Failed to save doctor.');
        }
    };

    return (
        <div className="max-w-md mx-auto p-6 bg-white rounded-2xl shadow-lg mt-10">
            <h2 className="text-2xl font-bold mb-4 text-center">Add New Doctor</h2>
            <form onSubmit={handleSubmit} className="space-y-4">
                <div>
                    <label className="block text-sm font-medium">Name</label>
                    <input type="text" name="name" value={doctor.name} onChange={handleChange} required
                        className="mt-1 block w-full p-2 border rounded-xl shadow-sm" />
                </div>
                <div>
                    <label className="block text-sm font-medium">Specialization</label>
                    <input type="text" name="specialization" value={doctor.specialization} onChange={handleChange} required
                        className="mt-1 block w-full p-2 border rounded-xl shadow-sm" />
                </div>
                <div>
                    <label className="block text-sm font-medium">Contact Number</label>
                    <input type="text" name="contactNumber" value={doctor.contactNumber} onChange={handleChange} required
                        className="mt-1 block w-full p-2 border rounded-xl shadow-sm" />
                </div>
                <div>
                    <label className="block text-sm font-medium">Department ID</label>
                    <input type="number" name="departmentId" value={doctor.department.departmentId} onChange={handleChange} required
                        className="mt-1 block w-full p-2 border rounded-xl shadow-sm" />
                </div>
                <button type="submit" className="w-full bg-blue-600 text-white py-2 rounded-xl hover:bg-blue-700 transition">Save Doctor</button>
            </form>
        </div>
    );
};

export default Doctor;
