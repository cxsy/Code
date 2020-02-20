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
        [self addTire: [[Tire alloc] initWithPressure: 10 treadDepth: 23]];
        [self addTire: [[Tire alloc] initWithPressure: 10 treadDepth: 23]];
        [self addTire: [[Tire alloc] initWithPressure: 10 treadDepth: 23]];
        [self addTire: [[Tire alloc] initWithPressure: 10 treadDepth: 23]];
    }
    return (self);
}

-(id) copyWithZone: (NSZone *) zone
{
    Car *carCopy = [[[self class] allocWithZone: zone] init];
    carCopy.engine = [[engine copy] autorelease];
    for (id tire in tires) 
    {
        [carCopy addTire: [[tire copy] autorelease]];
    }
    carCopy.name = name;
    carCopy.make = make;
    carCopy.model = model;
    carCopy.modelYear = modelYear;
    carCopy.numberOfDoors = numberOfDoors;
    return (carCopy);
}
- (void) addTire: (Tire *) tire {
    if (tires == nil) 
    {
        tires = [[NSMutableArray alloc] init];
    }
    [tires addObject: tire];
}
// -(void) setTire: (Tire *) tire atIndex: (int) index {
//     if (index < 0 || index > 3) {
//         NSLog (@"bad index (%d) in setTire:atIndex", index);
//         exit(1);
//     }
//     tires[index] = tire;
// }
// -(Tire *) tireAtIndex: (int) index {
//     if (index < 0 || index > 3) {
//         NSLog (@"bad index (%d) in setTire:atIndex", index);
//         exit(1);
//     }
//     return (tires[index]);
// }
- (NSString *) description
{
    NSString *desc = [NSString stringWithFormat: @"%@, a %d %@ %@, has %d doors", name, modelYear, make, model, numberOfDoors];
    return (desc);
}
- (void) print
{
    NSLog (@"%@", engine);
    for (id tire in tires)
    {
        NSLog (@"%@", tire);
    }
}
@end