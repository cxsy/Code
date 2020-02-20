#import "Car.h"
// #import "Tire.h"
#import "Engine.h"
// #import "Slant6.h"

int main (int argc, const char *argv[])
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    Car *car = [[[Car alloc] init] autorelease];

    NSLog (@"A car has %@ tires", [car valueForKeyPath: @"tires.@count"]);
    NSLog (@"A car has tire pressure of %@ in average", [car valueForKeyPath: @"tires.@avg.pressure"]);
    // NSArray *pressures = [car valueForKeyPath: @"tires.pressure"];
    // NSLog (@"pressures %@", pressures);
    NSLog (@"%@", car.engine);
    [car setValue: [NSNumber numberWithInt: 155] forKeyPath: @"engine.horsepower"];
    NSLog (@"%@", car.engine);

    car.name = @"Herbie";
    car.make = @"Honda";
    car.model = @"CRX";
    car.numberOfDoors = 2;
    car.modelYear = 1984;
    NSLog (@"%@", car);
    NSString *name = [car valueForKey: @"name"];
    NSLog (@"%@", name);
    NSString *make = [car valueForKey: @"make"];
    NSLog (@"%@", make);

    // 如果想设置一个标量值，在调用-setValue：forKey方法之前需要将它们包装起来
    [car setValue: [NSNumber  numberWithInt: 1988] forKey: @"modelYear"];
    // -valueForKey:    返回装箱后的对象
    // 仅KVC具有这种自动装箱功能，常规方法调用和属性语法不具备该功能
    NSString *modelYear = [car valueForKey: @"modelYear"];
    NSLog (@"%@", modelYear);

    // if ([car respondsToSelector: @selector(setEngine:)])
    // {
    //     NSLog (@"yowza!");
    // }
    [car print];
    // [car setEngine: [Engine new]];
    // [car print];
    Car *carCopy = [car copy];
    NSLog (@"%@", carCopy);
    // [carCopy print];
    [pool drain];
    return (0);
}

