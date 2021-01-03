

SRC_FILES= src/Control/*.java  src/Modele/*.java src/Vue/*.java


run: compil
	java -cp bin/ Control.Lanceur
compil:
	javac -d bin/ ${SRC_FILES}

clean:
	rm -Rf bin
 