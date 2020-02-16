CC=gcc
DEST=../bin
CFLAGS=`gnustep-config --objc-flags`
POSTFLAGS=-lgnustep-base -lobjc -std=c11 -Wno-parentheses
$(DEST)/$(file): $(file).m
	$(CC) $(CFLAGS) $(file).m -o $(DEST)/$(file) $(POSTFLAGS)
	rm $(DEST)/$(file).d

clean: $(DEST)/$(file)
	rm $(DEST)/$(file) 2> /dev/null

run: $(DEST)/$(file)
	./$(DEST)/$(file)
