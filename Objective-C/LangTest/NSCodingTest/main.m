#import <Foundation/Foundation.h>
#import "Thingie.h"

int main (int argc, const char *argv[])
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    Thingie *thing1;
    thing1 = [[Thingie alloc] initWithName: @"thing1" magicNumber: 42 shoeSize: 10.5];
    // 循环嵌套下不可以使用NSLog
    // [thing1.subThingies addObject: thing1];
    Thingie *anotherThing = [[[Thingie alloc] initWithName: @"thing2" magicNumber: 23 shoeSize: 13.0] autorelease];
    [thing1.subThingies addObject: anotherThing];
    NSLog (@"some thing: %@", thing1);
    NSData *freezeDried = [NSKeyedArchiver archivedDataWithRootObject: thing1];
    [thing1 release];
    thing1 = [NSKeyedUnarchiver unarchiveObjectWithData: freezeDried];
    NSLog (@"reconstituted thing: %@", thing1);    
    [pool drain];
    return (0);
}