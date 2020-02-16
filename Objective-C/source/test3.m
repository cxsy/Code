#import <Foundation/Foundation.h>

int main (int argc, const char *argv[]) 
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    NSLog (@"The numbers from 1 to 5:");
    for (int i = 1; i <= 5; i++) {
        NSLog (@"%d\n", i);
    }
    [pool drain];
    return (0);
}