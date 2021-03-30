#### defines repeated fragment(s) of the track list.
> repeat()

- repeat(auto-fill, 250px)
- repeat(4, 1fr)
- repeat(4, [col-start] minmax(100px, 1fr) [col-end])
More details, visit: https://developer.mozilla.org/en-US/docs/Web/CSS/repeat

#### defines minmax
> minmax(min, max): 

- minmax(100px, 1fr)

#### Reset margin and padding + everything is boarder-box
*, *:before, *:after {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

#### font setting shorthand
{
  font: 1em "Helvetica Neue", Helvetica, sans-serif;
}

#### dictionary background
https://www.w3schools.com/css/css_background_shorthand.asp

* background: 	Sets all the background properties in one declaration
* background: 	Sets all the background properties in one declaration
* background-attachment:  	Sets whether a background image is fixed or scrolls with the rest of the page
* background-clip 	Specifies the painting area of the background
* background-color 	Sets the background color of an element
* background-image 	Sets the background image for an element
* background-origin 	Specifies where the background image(s) is/are positioned
* background-position 	Sets the starting position of a background image
* background-repeat 	Sets how a background image will be repeated
* background-size 	Specifies the size of the background image(s)

#### vertical align on span
```
<!DOCTYPE html>
<html>
<head>
<style>
span.middle {
  vertical-align: middle;
  font-size: 100px;
}
</style>
</head>
<body>

<p>An <span class="middle">"W3Schools" </span> image with a middle alignment.</p><br>

</body>
</html>
```
