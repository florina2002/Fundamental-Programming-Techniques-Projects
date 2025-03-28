
⸻

☕ Fundamental Programming Techniques Projects

This repository contains three Java-based projects developed as part of the Fundamental Programming Techniques course. Each project explores core concepts such as object-oriented design, GUI development, multithreading, data structures, and more.

⸻

📌 Project 1: Polynomial Calculator

Overview
A graphical calculator for performing mathematical operations on polynomials. Users can input polynomials and execute operations like addition, subtraction, multiplication, integration, and derivation.

Features
	•	Built using Java Swing
	•	Uses Map for polynomial representation
	•	Operations: +, -, *, derivative, integral
	•	Follows MVC architecture
	•	Includes JUnit tests for logic verification

Technologies: Java, Swing, JUnit

📂 Packages:
	•	model – Polynomial data structures
	•	logic – Operation and Controller classes
	•	gui – Graphical user interface (View)

⸻

📌 Project 2: Queue Management System

Overview
A simulation of multiple queues, using multithreading and synchronization, where clients are generated randomly and assigned to queues in real-time based on wait time.

Features
	•	Multithreaded simulation with synchronized queues
	•	Real-time event logging and GUI
	•	Strategy pattern for queue assignment
	•	Performance metrics: average wait time, service time, peak hour
	•	Uses Java Swing for the UI

Technologies: Java, Threads, Synchronization, Swing

📂 Key Components:
	•	model – Server and Task classes
	•	business – SimulationManager, Scheduler, Strategy logic
	•	gui – SimulationFrame for user interaction

⸻

📌 Project 3: Orders Management System

Overview
An application for managing clients, products, and orders, with full CRUD operations and persistent storage using an embedded relational database (SQLite).

Features
	•	Layered architecture: model, dataAccessLayer, businessLayer, presentation
	•	GUI with separate panels for managing clients, products, and orders
	•	Reflection used to dynamically populate tables (JTable)
	•	Immutable Bill class using Java Records
	•	Generic DAO with reflection-based query generation
	•	Input validation and error handling

Technologies: Java, Swing, SQLite, Reflection

📂 Architecture:
	•	model – Client, Product, Order, Bill
	•	dataAccessLayer – Generic and specific DAOs
	•	businessLayer – Core logic (validations, processing)
	•	presentation – GUI interfaces

⸻

📚 Skills & Concepts Practiced
	•	Java OOP & design principles
	•	GUI development with Swing
	•	Threads & concurrency
	•	Strategy & DAO patterns
	•	Reflection & dynamic table generation
	•	Unit testing with JUnit
	•	Data persistence with SQLite

⸻
