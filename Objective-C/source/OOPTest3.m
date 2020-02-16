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

@interface Shape : NSObject {
    ShapeColor fillColor;
    ShapeRect bounds;
}
- (void) setFillColor: (ShapeColor) fillColor;
- (void) setBounds: (ShapeRect) bounds;
- (void) draw;
@end

@interface Circle : Shape
@end

@interface Rectangle : Shape
@end

@interface Egg : Shape
@end

@implementation Shape
- (void) setFillColor: (ShapeColor) c
{
    fillColor = c;
}
- (void) setBounds: (ShapeRect) b 
{
    bounds = b;
}
-(void) draw
{
    
}
@end

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

@implementation Circle
- (void) setFillColor: (ShapeColor) c
{
    if (c == kRedColor) 
    {
        c = kGreenColor;
    }
    [super setFillColor: c];
}
- (void) draw
{
    NSLog (@"drawing a circle at (%d %d %d %d) in %@", 
    bounds.x, bounds.y,
    bounds.width, bounds.height,
    colorName(fillColor));
}
@end

@implementation Rectangle
- (void) draw
{
    NSLog (@"drawing a Rectangle at (%d %d %d %d) in %@", 
    bounds.x, bounds.y,
    bounds.width, bounds.height,
    colorName(fillColor));
}
@end

@implementation Egg
- (void) draw
{
    NSLog (@"drawing an Egg at (%d %d %d %d) in %@", 
    bounds.x, bounds.y,
    bounds.width, bounds.height,
    colorName(fillColor));
}
@end

void drawShapes (Shape *shapes[], int count) 
{
    for (int i = 0; i < count; i++) {
        Shape *shape = shapes[i];
        [shape draw];
    }
}

int main (int argc, const char *argv[])
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    Shape *shapes[3];

    ShapeRect rect0 = {0, 0, 10, 30};
    shapes[0] = [Circle new];
    [shapes[0] setBounds: rect0];
    [shapes[0] setFillColor: kRedColor];
    ShapeRect rect1 = {30, 40, 50, 60};
    shapes[1] = [Rectangle new];
    [shapes[1] setBounds: rect1];
    [shapes[1] setFillColor: kGreenColor];
    ShapeRect rect2 = {15, 18, 37, 29};
    shapes[2] = [Egg new];
    [shapes[2] setBounds: rect2];
    [shapes[2] setFillColor: kBlueColor];
    drawShapes (shapes, 3);
    [pool drain];
    return (0);
}