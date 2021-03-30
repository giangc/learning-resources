#### Customizing bootstrap doesn't work
- Solved with: https://bootstrap.themes.guide/how-to-customize-bootstrap.html
- Public gits: https://gist.github.com/giangc/fddbb9e7041b5f98b819b452ca315ff2

```
First, when the custom.scss file is processed using SASS, the !default values defined in the Bootstrap variables.scss.

Next, our custom values are set, which will override any of the variables that had !default values set in Bootstrap variables.scss.

Finally, Bootstrap is imported (@import "bootstrap") which enables the SASS processor (A.K.A. compiler) to generate all the appropriate CSS using both the Bootstrap defaults and the custom overrides.
```