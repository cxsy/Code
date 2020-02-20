#import <Foundation/Foundation.h>

int main (int argc, const char *argv[])
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    const char *words[4] = {"aardvark", "abacus", "allude", "zygote"};
    int wordCount = 4;
    for (int i = 0; i < wordCount; i++) {
        NSLog (@"%s is %lu characters long", words[i], strlen(words[i]));
    }
    [pool drain];
    return (0);
}