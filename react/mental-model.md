## mental-model: how to add semantic-ui in the project 
- step 1: search on cloudfare, css tab, .min file(can be wrong with js file).
- step 2: in index.html add in link

## mental-model:react: how to check context of state 
- console.log(this)
- step 2: check for the info, if it's matched the somethign similar to the App
- what is the value of the this, inside a callback function? check the left hand side of the dot

## mental-model: how to setup css grid system and use it to store equally sized iamge 
- step 1: define each grid size: e.g: 30/30 per w/h
- step 2: get image size
- step 3: use image size to calculate each grid could be: e.g: img_h = 65 -> total_grids = Math.floor(img_h/grid_h) = 3summary: 
- display: grid to Image Card
- Image Card: react component styling for a single image card instead of basic <img>
- Image Card: passing info using props
- apply css style into React

## mental-model: how to setup css display grid 
- usefulness? this is used for styling content display size based on grid weight.
- step 1:

## mental-model: use css in React
- step 1: css file
- step 2: import css file into React component(handle by webpack.) `import from 'file.css'`
- step 3: `className="cssClassName"`

## mental-model: use styled-component css in React
