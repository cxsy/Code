#import <Foundation/Foundation.h>

int main (int argc, const char *argv[])
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    
    NSArray *array1 = [NSArray arrayWithObjects: @"one", @"two", @"three", nil];
    NSArray *array2 = @[@"one", [NSNull null], @"three"];
    NSLog (@"%@", array2);

    NSString *string = @"oop:ack:bork:greeble:ponies";
    NSArray *chunks = [string componentsSeparatedByString: @":"];
    NSLog (@"%@", chunks);

    NSMutableArray *array3 = [NSMutableArray arrayWithCapacity: 10];
    for (NSInteger i = 0; i < 4; i++) {
        [array3 addObject: @"a"];
    }
    NSMutableArray *mutable = [@[@1, @2, @3] mutableCopy];
    NSLog (@"%@", mutable);

    // array3[1] = @"b";
    NSString *ele = [array3 objectAtIndex: 1];
    // NSString *ele = array3[1];
    NSLog (@"%@", ele);
    [array3 removeObjectAtIndex: 1];
    NSLog (@"%@", array3);

    [pool drain];
    return (0);
}