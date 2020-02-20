CC=clang
DEST=../bin
FLAGS=-I `gnustep-config --variable=GNUSTEP_SYSTEM_HEADERS`\
-L `gnustep-config --variable=GNUSTEP_SYSTEM_LIBRARIES`\
-lgnustep-base -fconstant-string-class=NSConstantString\
-D_NATIVE_OBJC_EXCEPTIONS -lobjc -Wno-parentheses

$(DEST)/$(file): $(file).m
	$(CC) $(file).m -o $(DEST)/$(file) $(FLAGS)

clean: $(DEST)/$(file)
	rm $(DEST)/$(file) 2> /dev/null

run: $(DEST)/$(file)
	./$(DEST)/$(file)

