#import <Foundation/Foundation.h>

int main (int argc, const char *argv[])
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    
    NSArray *array = [NSArray arrayWithObjects: @"a", @"b", nil];
    NSEnumerator *enumerator = [array objectEnumerator];

    NSString *thingie;
    while (thingie = [enumerator nextObject]) {
        NSLog (@"I found %@", thingie);
    }

    for (NSString *string in array) {
        NSLog (@"I found %@", string);
    }

    // [array enumerateObjectsUsingBlock: ^(NSString *string, NSUInteger index, BOOL *stop) {
    //     NSLog (@"I found %@", string);
    // }];

    [pool drain];
    return (0);
}