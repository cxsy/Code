CC=gcc
CFLAGS=`gnustep-config --objc-flags`
POSTFLAGS=-lgnustep-base -lobjc -std=c11

$(file): $(file).m
	$(CC) $(CFLAGS) $(file).m -o $(file) $(POSTFLAGS) -Wno-parentheses

%.o: %.m
	CC $(CFLAGS) -c $< $(POSTFLAGS)

clean: $(file)
	rm $(file) 2> /dev/null

run: $(file)
	./$(file)
