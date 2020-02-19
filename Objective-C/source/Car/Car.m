#import "Car.h"
#import "Tire.h"
#import "Engine.h"
#import "Slant6.h" 

@implementation Car
@synthesize engine;
@synthesize name;
@synthesize make;
@synthesize model;
@synthesize modelYear;
@synthesize numberOfDoors;
- (id) init
{
    if (self = [super init]) {
        self.engine = [[Slant6 alloc] init];
        [self setTire: [[Tire alloc] initWithPressure: 10 treadDepth: 23] atIndex: 0];
        [self setTire: [[Tire alloc] initWithPressure: 10 treadDepth: 23] atIndex: 1];
        [self setTire: [[Tire alloc] initWithPressure: 10 treadDepth: 23] atIndex: 2];
        [self setTire: [[Tire alloc] initWithPressure: 10 treadDepth: 23] atIndex: 3];
    }
    return (self);
}

-(id) copyWithZone: (NSZone *) zone
{
    Car *carCopy = [[[self class] allocWithZone: zone] init];
    carCopy.engine = [[engine copy] autorelease];
    for (int i = 0; i < 4; i++) 
    {
        [carCopy setTire: [[[self tireAtIndex: i] copy] autorelease] atIndex: i];
    }
    carCopy.name = name;
    carCopy.make = make;
    carCopy.model = model;
    carCopy.modelYear = modelYear;
    carCopy.numberOfDoors = numberOfDoors;
    return (carCopy);
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
- (NSString *) description
{
    NSString *desc = [NSString stringWithFormat: @"%@, a %d %@ %@, has %d doors", name, modelYear, make, model, numberOfDoors];
    return (desc);
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