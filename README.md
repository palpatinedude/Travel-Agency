# 🧭 Tourism Management System

## 📌 Overview

The **Tourism Management System** is a software solution designed to streamline the operations of travel agencies and tour operators. It connects administrators, staff, tour guides, and customers through a structured backend database and an intuitive graphical user interface (GUI). The system simplifies the booking process, manages tour schedules, monitors reservations, and provides real-time interaction with the tourism database.

---

## 💼 Key Features

### 👤 User Management
- Admins can add, update, and remove users (staff or guides).
- Each user has specific roles and permissions (e.g., admin, tour guide, reservation clerk).

### 📅 Trip Management
- Schedule new trips with details such as destination, duration, guide, and cost.
- Modify existing trip details or cancel trips when necessary.

### 📝 Reservation System
- Book and manage customer reservations for available trips.
- Automatically updates seat availability and assigns guides.
- Generates reservation receipts and status updates.

### 🧭 Guide Information
- View, add, or update profiles of tour guides.
- Assign guides to specific trips and track their schedules.

### 🧾 Report Generation
- Generate reports on trips, reservations, earnings, and occupancy.
- Export reports in formats like CSV or PDF for record-keeping.

### 📈 Real-Time Trip Availability
- Displays live availability of slots for each trip.
- Automatically updates based on confirmed reservations.

### 🌟 Feedback Collection (New)
- Allows customers to rate trips and provide feedback.
- Helps administrators review service quality and guide performance.

---

## ⚙️ Technologies Used

### Backend (Database)
- **MySQL**: Relational database to store user data, trip details, reservations, and feedback.
- SQL scripts define tables for:
  - `users`
  - `guides`
  - `trips`
  - `reservations`
  - `feedback`
  - `payments` *(optional)*

### Frontend (GUI)
- **Python Tkinter** or **Java Swing / JavaFX** (depending on your implementation)
- Interactive screens for:
  - Admin Dashboard
  - Reservation Form
  - Trip Management Panel
  - Guide Assignment Module

---

## 🗃️ Database Schema Overview

| Table           | Description                                |
|----------------|--------------------------------------------|
| `users`         | Admins, staff, and guide login credentials |
| `guides`        | Tour guide information                     |
| `trips`         | Trip data including schedule and price     |
| `reservations`  | Customer bookings                          |
| `feedback`      | Ratings and comments from tourists         |
| `reports`       | Generated statistics for admin view        |



