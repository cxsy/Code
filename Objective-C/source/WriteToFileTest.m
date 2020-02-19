#import <Foundation/Foundation.h>

int main (int argc, const char *argv[])
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    NSArray *phrase = [NSArray arrayWithObjects: @"I", @"seem", @"to", @"be", @"a", @"verb", nil];
    [phrase writeToFile: @"file.txt" atomically: YES];

    NSArray *phrase2 = [NSArray arrayWithContentsOfFile: @"file.txt"];
    NSLog (@"%@", phrase2);
    [pool drain];
    return (0);
}