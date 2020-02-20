#import "Engine.h"

@implementation Engine
@synthesize horsepower;
// - (NSString *) description
// {
//     return (@"I am an engine. Vrooom!");
// }
- (id) init
{
    if (self = [super init])
    {
        horsepower = 145;
    }
    return (self);
}
- (id) copyWithZone: (NSZone *) zone
{
    Engine *engineCopy = [[[self class] allocWithZone: zone] init];
    engineCopy.horsepower = horsepower;
    return (engineCopy);
}
- (NSString *) description
{
    NSString *desc = [NSString stringWithFormat: @"horsepower is %d", horsepower];
    return (desc);
}
@end