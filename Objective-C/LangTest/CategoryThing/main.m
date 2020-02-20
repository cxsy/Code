#import <Foundation/Foundation.h>
#import "CategoryThing.h"
int main (int argc, const char *argv[])
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    CategoryThing *thing = [[CategoryThing alloc] init];
    [thing setThing1: 5];
    [thing setThing2: 23];
    [thing setThing3: 42];
    NSLog (@"Things are %@", thing);
    [pool drain];
    return (0);
}