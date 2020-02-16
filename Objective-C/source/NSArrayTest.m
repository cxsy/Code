#import <Foundation/Foundation.h>

void printArray(NSArray *array) {
    for (NSInteger i = 0; i < [array count]; i++) {
        NSLog (@"index %d has %@.", i, [array objectAtIndex: i]);
    }
}

int main (int argc, const char *argv[])
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    
    NSArray *array1 = [NSArray arrayWithObjects: @"one", @"two", @"three", nil];
    // NSArray *array2 = @[@"one", @"two", @"three"];
    printArray(array1);

    NSString *string = @"oop:ack:bork:greeble:ponies";
    NSArray *chunks = [string componentsSeparatedByString: @":"];
    printArray(chunks);

    NSMutableArray *array3 = [NSMutableArray arrayWithCapacity: 10];
    for (NSInteger i = 0; i < 4; i++) {
        [array3 addObject: @"a"];
    }
    [array3 removeObjectAtIndex: 1];
    printArray(array3);

    [pool drain];
    return (0);
}