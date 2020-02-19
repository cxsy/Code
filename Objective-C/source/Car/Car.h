#import <Cocoa/Cocoa.h>

@class Tire;
@class Engine;

@interface Car : NSObject <NSCopying>
{
    NSString *name;
    NSString *make;
    NSString *model;
    int modelYear;
    int numberOfDoors;
    Engine *engine;
    Tire *tires[4];
}
@property (readwrite, copy) NSString *name;
@property (readwrite, retain) Engine *engine; 
@property (readwrite, copy) NSString *make;
@property (readwrite, copy) NSString *model;
@property (readwrite) int modelYear;
@property (readwrite) int numberOfDoors;
- (Tire *) tireAtIndex: (int) index;
- (void) setTire: (Tire *) tire atIndex: (int) index;
- (void) print;
@end