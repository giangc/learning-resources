# Introduction code with React

* depdendencies:
  * react: core library for react
  * react-dom: react library that renders on DOM
 
* Simple project code on react:

**Javascript**
* class MyApp extends App.Component{}: 
  * logic function: onMouseMove(event) => transform mouse position to the opposite event.mouseX and event.mouseY 
  * logic function: 
  * render(){} => return the render HTML code 
* ReactDom.render => return the MyApp component as HTML Tag: <MyApp />

**CSS**
* Intialise the overall layout sketch for the whole page.
  * div {width: 100wh; height: 100wh}
  * load background: url("www.abccxyz.asdasd")

**HTML**
* Declaration of the layout

**Javascript in Details**  
In MyApp extends React.Component 
 - state
 - this.setState
 - render()

In ReactDOM.render:
ReactDOM.render(
<MyApp />,
document.querySelector('#root')
);

