# Jest each breakdown

``` JS
// JavaScript
it.each < [keyof FilteringWork, string, Attendees[]] > ([
        ['name', 'John', attendees.slice(0, 1)],
        ['product', product.name, attendees.filter((n) => n.productName === product.name)],
        ['status', status, attendees.slice(0, 1)],
    ])(
        'User with user status is %s and name %s, buy product %s',

        async (filterType, filterValue, testAttendees) => {

        }
```

key: FilterState  | string | Attendee
data:
 [
  { FilterState > 'name', string > 'John', Attendees[] > [{name, age}]}, 
  { FilterState > 'product', string > 'Toothbrush', Attendees[] > attendees.slice(0, 1)}, 
  { FilterState > 'status', string > 'married' , Attendees[] > attendees.slice(0, 1)}, 
  ]

 
