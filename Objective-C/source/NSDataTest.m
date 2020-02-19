#import <Foundation/Foundation.h>

int main (int argc, const char *argv[])
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    const char *string = "Hi there, this is a C string!";
    NSData *data = [NSData dataWithBytes: string length: strlen(string) + 1];
    NSLog (@"data is %@", data);
    NSLog (@"%d byte string is '%s'", [data length], [data bytes]);
    [pool drain];
    return (0);
}