#import <Foundation/Foundation.h>

int main (int argc, const char *argv[])
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    NSPredicate *predicate = [NSPredicate predicateWithFormat: @"%K == %d", @"intValue", 11];
    BOOL match = [predicate evaluateWithObject: [NSNumber numberWithInt: 11]];
    NSLog (@"%s", (match) ? "YES" : "NO");

    NSArray *array = [NSArray arrayWithObjects: @"aa", @"bbb", @"cccc", nil];
    NSPredicate *predicate1 = [NSPredicate predicateWithFormat: @"%K >= %d", @"length", 3];
    for (id e in [array filteredArrayUsingPredicate: predicate1])
    {
        NSLog (e);
    }

    NSPredicate *predicateTemplate = [NSPredicate predicateWithFormat: @"length >= $key"];
    NSDictionary *varDict = [NSDictionary dictionaryWithObjectsAndKeys: [NSNumber numberWithInt: 2], @"key", nil];
    NSPredicate *predicate2 = [predicateTemplate predicateWithSubstitutionVariables: varDict];
    NSArray *array2 = [NSArray arrayWithObjects: @"aa", @"bbb", @"cccc", nil];
    for (id e in [array2 filteredArrayUsingPredicate: predicate2])
    {
        NSLog (e);
    }
    [pool drain];
    return (0);
}