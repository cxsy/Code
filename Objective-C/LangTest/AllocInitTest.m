#import <Foundation/Foundation.h>

int main (int argc, const char *argv[])
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];

    NSString *string = [[NSString alloc] initWithFormat: @"%d or %d", 25, 64];
    NSLog (string);

    NSError * error = nil;
    NSStringEncoding encoding = NSUTF8StringEncoding;
    NSString *string1 = [[NSString alloc] initWithContentsOfFile: @"words.txt" usedEncoding: &encoding error: &error];
    if (nil != error) {
        NSLog (@"Unable to read data from file, %@", [error localizedDescription]);
    } else {
        NSLog (string1);
    }

    [pool drain];
    return (0);
}