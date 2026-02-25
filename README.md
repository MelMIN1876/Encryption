# Java Encryption Program
A simple Java-based encryption and decryption program supporting both Block Cipher and Stream Cipher modes. This project demonstrates fundamental cryptographic techniques including XOR operations, key-based swapping, and block padding.
# Overview
This program allows users to:
* Encrypt or Decrypt files
* Choose between:
  - Block Cipher (B)
  - Stream Cipher (s)
* Use a key file
* Output results to a specified file
The program operates entirely using file input and output
# Project Structure
* Cipher.java -> Main driver program
* Block.java -> Block Cipher implementaion
* Stream.java -> Stream Cipher implementaion
* Utility.java -> Helper functions (file I/O, padding, XOR, swapping)
# How to Compile
javac *.java
# How to Run
java Cipher <cipherType> <inputFile> <outputFile> <keyFile> <mode>
# Command Line Arguments
* cipherType - "B" for Block Cipher / "S" for Stream Cipher
* inputFile - Path to the input file
* outputFile - Path to write the output file
* keyFile - Path to the key file
* mode - "E" for Encrypt ot "D" for Decrypt
