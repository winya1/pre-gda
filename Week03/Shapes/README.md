https://coding-competitions-staging.appspot.com/codejam/round/0000000000a56555/0000000000a57741
<br>
<h2> Points </h2>
Define a class for a 2D point (as x and y coordinates), a segment (as two points), a triangle (as three points), a rectangle with sides parallel to the coordinate axes (as its diagonal segment: the segment going from the bottom left corner to the top right corner).

For the segment: implement a constructor from two points and a member function computing the length of the segment.

For the rectangle: implement member functions computing corner points of the rectangle (the bottom right and the top left, in addition to the ones contained in the segment).

For the triangle and the rectangle: implement member functions computing their area (Tip: use this formula for the triangle area) and their perimeters.

For the triangle: implement a member function to create a containing rectangle from a triangle (where containing rectangle is the minimal rectangle that fully contains the given triangle inside; its bottom left corner coordinates are the minimal coordinates of all triangle points coordinates, and its top right corner coordinates are the maximal coordinates of all triangle points coordinates).

Given coordinates of triangle points, output:

> The triangle area <br>
> The triangle perimeter <br>
> The containing rectangle area <br>
> The containing rectangle perimeter <br>
<h2> Input </h2>
The first line of the input contains T: the number of test cases. T test cases follow. <br>

Each test case is a line containing six integer numbers: x1, y1, x2, y2, x3, and y3, where (xi,yi) are the coordinates of the i-th point of the triangle.

<h2> Output </h2>
For each test case, output one line containing Case #t: Ta Tp Ra Rp, where t is the test case number (starting from 1), Ta is the triangle area, Tp is the triangle perimeter, Ra is the containing rectangle area, Ra is the containing rectangle perimeter. All numbers must be output rounded to 2 decimal digits after the comma (using "%.2f" format string in System.out.printf.)
