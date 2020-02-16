#import <Foundation/Foundation.h>

int main (int argc, const char *argv[])
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    NSArray *array = [NSArray arrayWithObjects: [NSNull null],  nil];
    if ([array objectAtIndex: 0] == [NSNull null]) {
        NSLog (@"is null!");
    }
    [pool drain];
    return (0);
}