https://css-tricks.com/snippets/css/complete-guide-grid/
**IN PROGRESS**: stop @ grid-column, grid-row

**glossary**
- line: line(start from 1) divide into row or cel
- grid track: columns or row of the grid
- fr: unit fraction of free space. If 1 item exists, there are total 1 fr. If 4 items exist, there are total 4 fr can be used. So fraction of free space is average free space that is needed for a single item.
- grid container: container div
- area: total space surrounded by number of grid lines.
- cell: space between 2 row lines and 2 cols lines(it's a cell)
- gap: container properties, declare gap between row and col.
- grid-template: container properties, defines template for row and colum.

**Q/A**
1. What is this?
Grid based system divides page into grid, and layout components based on grid settings/properties.

2. What is grid-based consists of?
- Container: a layout that contains other items. Container setting should define template of rows and columns, such as: how many col/row, sizes of col/row; how the whole container is aligned in the page: `content-justify: start | end | center | stretch`. There are shorthand for pro as well.
- Child: items that defined the grid. Child setting should be how items are aligned in the cell, e.g: `start | end center stretch`; auto-placement-column, auto-placement-row for auto placing stuff on col | row.

3. Why is this useful?
- This is quite useful in case of layouting list of items on the webpage, without using any kind of hacking approach, like float-based. Where it needs to have some absolute margin to fix some edge cases.

4. Identify some use cases?

