#import <Foundation/Foundation.h>

@interface RetainTracker : NSObject
@end

@implementation RetainTracker
- (id) init
{
    if (self = [super init]) {
        NSLog (@"init: Retain count of %d.", [self retainCount]);
    }
    return (self);
}
- (void) dealloc
{
    NSLog (@"dealloc called. Bye Bye.");
    [super dealloc];
}
@end

int main (int argc, const char *argv[])
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    RetainTracker *tracker = [RetainTracker new];
    [tracker retain];
    NSLog (@"%d", [tracker retainCount]);
    [tracker retain];
    NSLog (@"%d", [tracker retainCount]);
    [tracker release];
    NSLog (@"%d", [tracker retainCount]);
    [tracker release];
    [tracker autorelease];
    NSLog (@"auto releasing pool");
    // NSLog (@"%d", [tracker retainCount]);
    // [tracker release];
    [pool release];
    return (0);
}