# Mini Database with AVL Tree Index

A lightweight database system implemented in Java from scratch. The project supports record insertion, deletion, lookup, and persistent storage through a custom AVL tree index instead of Java's built-in collections.

## Features

* Custom AVL Tree implementation

  * Self-balancing binary search tree
  * O(log n) insertion, deletion, and search
  * Automatic tree rebalancing using rotations

* Persistent Storage

  * Records are saved to a local file
  * Database state is restored automatically on startup

* Command Line Interface

  * INSERT <id> <name>
  * SELECT <id>
  * DELETE <id>
  * EXIT

* Object-Oriented Design

  * Record abstraction
  * AVLNode and AVLTree data structures
  * Database layer separated from storage and indexing logic

## Technologies

* Java
* Data Structures
* AVL Trees
* File I/O
* Object-Oriented Programming

## Learning Goals

This project was built to gain hands-on experience with:

* Self-balancing search trees
* Recursive algorithms
* Database indexing concepts
* Persistent data storage
* Software design in Java
