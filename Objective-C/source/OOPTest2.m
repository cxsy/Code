#import <Foundation/Foundation.h>

typedef enum {
    kCircle,
    kRectanle,
    kEgg
} ShapeType;

typedef enum {
    kRedColor,
    kGreenColor,
    kBlueColor
} ShapeColor;

typedef struct {
    int x, y, width, height;
} ShapeRect;

typedef struct {
    ShapeType type;
    ShapeColor fillColor;
    ShapeRect bounds;
} Shape;

NSString *colorName (ShapeColor colorName) 
{
    switch (colorName) {
        case kRedColor:
            return @"red";
            break;
        case kGreenColor:
            return @"green";
            break;
        case kBlueColor:
            return @"blue";
            break;
    }
    return @"no clue";
}

@interface Circle : NSObject
{
@private
    ShapeColor fillColor;
    ShapeRect bounds;
}
- (void) setFillColor: (ShapeColor) fillColor;  
- (void) setBounds: (ShapeRect) bounds;  
- (void) draw;
@end  

@implementation Circle
- (void) setFillColor: (ShapeColor) c
{
    fillColor = c;
}
- (void) setBounds: (ShapeRect) b
{
    bounds = b;
}
- (void) draw
{
    NSLog (@"drawing a circle at (%d %d %d %d) in %@",
    bounds.x, bounds.y,
    bounds.width, bounds.height,
    colorName(fillColor));
}
@end

@interface Rectangle : NSObject
{
@private
    ShapeColor fillColor;
    ShapeRect bounds;
}
- (void) setFillColor: (ShapeColor) fillColor;  
- (void) setBounds: (ShapeRect) bounds;  
- (void) draw;
@end  

@implementation Rectangle
- (void) setFillColor: (ShapeColor) c
{
    fillColor = c;
}
- (void) setBounds: (ShapeRect) b
{
    bounds = b;
}
- (void) draw
{
    NSLog (@"drawing a rectangle at (%d %d %d %d) in %@",
    bounds.x, bounds.y,
    bounds.width, bounds.height,
    colorName(fillColor));
}
@end

@interface Egg : NSObject
{
@private
    ShapeColor fillColor;
    ShapeRect bounds;
}
- (void) setFillColor: (ShapeColor) fillColor;  
- (void) setBounds: (ShapeRect) bounds;  
- (void) draw;
@end  

@implementation Egg
- (void) setFillColor: (ShapeColor) c
{
    fillColor = c;
}
- (void) setBounds: (ShapeRect) b
{
    bounds = b;
}
- (void) draw
{
    NSLog (@"drawing a egg at (%d %d %d %d) in %@",
    bounds.x, bounds.y,
    bounds.width, bounds.height,
    colorName(fillColor));
}
@end  

void drawShapes (id shapes[], int count) 
{
    for (int i = 0; i < count; i++) {
        id shape = shapes[i];
        [shape draw];
    }
}


int main (int argc, const char *argv[])
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    id shapes[3];

    ShapeRect rect0 = {0, 0, 10, 30};
    shapes[0] = [Circle new];
    [shapes[0] setBounds: rect0];
    [shapes[0] setFillColor: kRedColor];
    ShapeRect rect1 = {30, 40, 50, 60};
    shapes[1] = [Rectangle new];
    [shapes[0] setBounds: rect1];
    [shapes[0] setFillColor: kGreenColor];
    ShapeRect rect2 = {15, 18, 37, 29};
    shapes[2] = [Egg new];
    [shapes[0] setBounds: rect2];
    [shapes[0] setFillColor: kBlueColor];
    drawShapes (shapes, 3);
    [pool drain];
    return (0);
}