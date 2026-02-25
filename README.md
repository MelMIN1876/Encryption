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
`java Cipher <cipherType> <inputFile> <outputFile> <keyFile> <mode>`
# Command Line Arguments
* cipherType - "B" for Block Cipher / "S" for Stream Cipher
* inputFile - Path to the input file (*.txt)
* outputFile - Path to write the output file (*.txt)
* keyFile - Path to the key file (*.txt)
* mode - "E" for Encrypt ot "D" for Decrypt
# Cipher Modes
1. Block Cipher (B)
  * Key must be exactly 16 characters long

  Encryption Steps
  - Split input into 16-character blocks
  - Pad final block with 0x81 if needed
  - XOR each block with the key
  - Swap characters within each block based on key parity

  Decryption Steps
  - Apply swap operation
  - XOR with key
  - Remove padding (0x81)

  Block Details
  * Block size: 16 characters
  * Padding character: (char) 0x81
  * Swapping is controlled by odd/even values of key characters

2. Stream Cipher (S)
  * The Stream Cipher XORs each input character with the key
  `output[i] = (char) (input[i] ^ key[i % key.length]);`
  Features
   * No padding required
   * Key length can be any length
   * Same function handles encryption and decryption (XOR symmetry)
# File Handling
This program: 
* Reads files using FileReader
* Writes files using FileWriter
* Validates:
  - Correct argument count
  - Valid cipher type
  - Valid mode
  - Input file exists
  - Key file exists
If valdation fails, the program exits with status code `1`

# Limitations
* Not cryptographically secure
* Character-based (not binary-safe for all file types)
* Block Cipher requires exactly 16-character key
* Intended for educational purposes only
# DISCLAIMER
This software is for educational purposes ONLY and should not be used for real-world security applications
