#import "Car.h"
#import "Tire.h"
#import "Engine.h"
#import "Slant6.h" 

@implementation Car
@synthesize engine;
- (id) init
{
    if (self = [super init]) {
        self.engine = [[Slant6 alloc] init];
        [self setTire: [Tire new] atIndex: 0];
        [self setTire: [Tire new] atIndex: 1];
        [self setTire: [Tire new] atIndex: 2];
        [self setTire: [Tire new] atIndex: 3];
    }
    return (self);
}
-(void) setTire: (Tire *) tire atIndex: (int) index {
    if (index < 0 || index > 3) {
        NSLog (@"bad index (%d) in setTire:atIndex", index);
        exit(1);
    }
    tires[index] = tire;
}
-(Tire *) tireAtIndex: (int) index {
    if (index < 0 || index > 3) {
        NSLog (@"bad index (%d) in setTire:atIndex", index);
        exit(1);
    }
    return (tires[index]);
}
- (void) print
{
    NSLog (@"%@", engine);
    NSLog (@"%@", tires[0]);
    NSLog (@"%@", tires[1]);
    NSLog (@"%@", tires[2]);
    NSLog (@"%@", tires[3]);
}
@end