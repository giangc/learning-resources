# React

## Start the project: ReactDOM.render
**Description**: ReactDOM.render as entry point of project.
```
ReactDOM.render(
<MyApp />,
document.querySelector('#root')
);
```

## State management start: react-redux

## Route page: BrowserRouter


# lodash
## Check null safe lodash: _.get(object, path, [defaultValue])
**Description**: Gets the value at path of object. Path is content inside object

```
var object = { 'a': [{ 'b': { 'c': 3 } }] };
_.get(object, 'object.a[0].b.c'); // => DOES NOT WORK

var object = { 'a': [{ 'b': { 'c': 3 } }] };
_.get(object, 'a[0].b.c'); // => 3

_.get(object, ['a', '0', 'b', 'c']); // => 3

_.get(object, 'a.b.c', 'default'); // => 'default'

- Null safe: check undefined
 if(typeof props.images !== 'undefined') // undefined 

```