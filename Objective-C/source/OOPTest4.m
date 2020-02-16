#import <Foundation/Foundation.h>

@interface Tire : NSObject
@end
@implementation Tire
- (NSString *) description {
    return (@"I am a tire. I last a while.");
}
@end

@interface AllWeatherRadial : Tire
@end
@implementation AllWeatherRadial
- (NSString *) description
{
    return (@"I am a tire for rain or shine.");
}
@end

@interface Engine : NSObject
@end
@implementation Engine
- (NSString *) description {
    return (@"I am an engine. Vrooom!");
}
@end

@interface Slant6 : Engine
@end
@implementation Slant6
- (NSString *) description
{
    return (@"I am a slant- 6. VROOOM!");
}
@end

@interface Car : NSObject
{
    Engine *engine;
    Tire *tires[4];
}
- (Engine *) engine;
- (void) setEngine: (Engine *) newEngine;
- (Tire *) tireAtIndex: (int) index;
- (void) setTire: (Tire *) tire atIndex: (int) index;
- (void) print;
@end
@implementation Car
- (id) init
{
    if (self = [super init]) {
        [self setEngine: [Slant6 new]];
        [self setTire: [Tire new] atIndex: 0];
        [self setTire: [AllWeatherRadial new] atIndex: 1];
        [self setTire: [Tire new] atIndex: 2];
        [self setTire: [Tire new] atIndex: 3];
    }
    return (self);
}
- (Engine *) engine {
    return (engine);
}
- (void) setEngine: (Engine *) newEngine {
    engine = newEngine;
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

int main (int argc, const char *argv[])
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    Car *car = [Car new];
    [car print];
    [pool drain];
    return (0);
}