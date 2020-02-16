#import <Foundation/Foundation.h>

int main (int argc, const char *argv[])
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    NSString *height;
    height = [NSString stringWithFormat: @"Your height is %d feet, %d inches.", 5, 11];
    NSLog (height);
    if ([height length] > 30) {
        NSLog (@"wow, you're really tall!");
    }

    NSString *thing1 = @"hello 5";
    NSString *thing2 = [NSString stringWithFormat: @"hello %d", 5];
    if ([thing1 isEqualToString: thing2]) {
        NSLog (@"They are the same in text!");
    }
    if (thing1 == thing2) {
        NSLog (@"They are same!");
    } else {
        NSLog (@"They are different!");
    }

    NSLog (@"%d", [@"aoinks" compare: @"jinkies"]);

    if ([@"3" compare: @"22" options: NSNumericSearch] == NSOrderedAscending) {
        NSLog (@"They match!");
    }

    NSString *fileName = @"draft-chapter.pages.mov";

    if ([fileName hasPrefix: @"draft"]) {
        NSLog (@"this is a draft");
    }
    if ([fileName hasSuffix: @".mov"]) {
        NSLog (@"this is a movie");
    }

    NSMutableString *string = [NSMutableString stringWithCapacity: 50];
    [string appendString: @"Hello there "];
    [string appendFormat: @"human %d!", 39];
    NSLog (string);

    NSMutableString *friends = [NSMutableString stringWithCapacity: 50];
    [friends appendString: @"James BethLynn Jack Evan"];
    NSRange jackRange = [friends rangeOfString: @"Jack"];
    jackRange.length++;
    [friends deleteCharactersInRange: jackRange];
    NSLog (friends);

    NSMutableString *string1 = [NSMutableString stringWithFormat: @"jo%dy", 2];
    NSLog (string1);
    
    [pool drain];
    return (0);
}