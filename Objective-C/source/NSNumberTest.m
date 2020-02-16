#import <Foundation/Foundation.h>

int main (int argc, const char *argv[])
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    
    NSNumber *number = [NSNumber numberWithFloat: 12345.12];
    NSLog (@"%d", [number intValue]);

    [pool drain];
    return (0);
}