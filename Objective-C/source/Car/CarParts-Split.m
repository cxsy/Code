#import "Car.h"
// #import "Tire.h"
#import "Engine.h"
// #import "Slant6.h"

int main (int argc, const char *argv[])
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    Car *car = [[Car alloc] init];
    [car print];
    [car setEngine: [Engine new]];
    [car print];
    [pool drain];
    return (0);
}

