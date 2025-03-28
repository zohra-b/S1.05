
<p align="center"><h1 align="center">S1.05. Java Utils </h1></p>

<br>

---

## 📍 Objectives

Learn how Java annotations work.
---
The exercises in the 3 levels must be executed from the command line and not only from the editor. Create a file called "readme.txt" to explain the commands to execute for each exercise. These commands must allow you to compile Java source files (.java) into Java bytecode files (.class) on the one hand, and execute them on the other.

## 👾 Exercises
### 📌 Level 1

### 📌 Level 1 - ex 1
Create a class that lists alphabetically the contents of a directory received as a parameter.
### 📌 Level 1 - ex 2
Add to the class from the previous exercise the functionality of listing a directory tree with the contents of all its levels (recursively) so that they are printed on the screen in alphabetical order within each level, also indicating whether it is a directory (D) or a file (F), and its last modification date.
### 📌 Level 1 - ex 3
Modify the previous exercise. Now, instead of showing the result on the screen, save the result in a TXT file.
### 📌 Level 1 - ex 4
Add the functionality of reading any TXT file and displaying its contents on the console.
### 📌 Level 1 - ex 5
Now the program must serialize a Java Object to a .ser file and then deserialize it.

### 📌 Level 2 
Run exercise 3 from the previous level, parameterizing all methods in a configuration file.
You can use a Java Properties file, or the Apache Commons Configuration library if you prefer.
From the previous exercise, parameterize the following:

Directory to read.
Name and directory of the resulting TXT file.

### 📌 Level 3 
Create a utility that encrypts and decrypts the resulting files from the previous levels.
Use the AES algorithm in ECB or CBC mode with PKCS5Padding padding. You can use javax.crypto or org.apache.commons.crypto.

---
## 🚀 Getting Started

### ☑️ Prerequisites

Before getting started with S1.05, ensure your runtime environment meets the following requirements:

- **Programming Language:** Java 23SE
- IntelliJ or Eclipse IDE (with Maven)

A Readme file had been added in directories N1, N2 and N3 explaining hot to compile and execute our programs.

### ⚙️ Installation

Clone the S1.05 repository:
```sh
❯ git clone https://github.com/zohra-b/S1.05
```
