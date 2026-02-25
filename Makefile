FILES = Cipher.java Block.java Stream.java Utility.java
all:
	javac -g $(FILES)
run:
	java Cipher
clean:
	rm *.class
package:
	zip -r Hendren_Scott-PA1.zip $(FILES) Makefile