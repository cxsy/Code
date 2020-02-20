#import "Tire.h"

@implementation Tire
@synthesize pressure;
@synthesize treadDepth;
- (id) initWithPressure: (int) p treadDepth: (int) td
{
    if (self = [super init]) {
        pressure = p;
        treadDepth = td;
    }
    return (self);
}
- (NSString *) description
{
    return (@"I am a tire. I last a while");
}

- (id) copyWithZone: (NSZone *) zone
{
    Tire *tireCopy = [[[self class] allocWithZone: zone] initWithPressure: pressure treadDepth: treadDepth];
    return (tireCopy);
}
@end
