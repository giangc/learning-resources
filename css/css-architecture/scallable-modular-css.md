**http://smacss.com/book/**
- 5 core categories: Base, Layout, Module, State, Theme. Additional: Font rules
- What is the default state?
- How the state changes?
- Attribute selector convention:
.btn[data-state=default] { color: #333; } 
.btn[data-state=pressed] { color: #000; } 
.btn[data-state=disabled] { opacity: .5; pointer-events: none; }

<!-- HTML -->
<button class="btn" data-state="disabled">Disabled</button>

... 
Changing code in jquery

// bind a click handler to each button
$(".btn").bind("click", function(){
    // change the state to pressed
    $(this).attr('data-state', 'pressed');
});

- Performance in css depends on how a browser render the website. E.g Firefox render from top to bottom, right to left. So that there are several rules to keep the website in good performance.
  - Rules with descendant selectors. E.g. #content h3
  - Rules with child or adjacent selectors. E.g. #content > h3
  - Rules with overly qualified selectors. E.g. div#content > h3
  - Rules that apply :hover to non-link elements. E.g. div#content:hover
- Simple guidelines to limit number of elements that need to be evaluated: 
  - Use child selectors
  - Avoid tag selectors for common elements
  - Use class names as the right-most selector

1. How do I structure my css file following SMACSS?
- Place all Base rules into their own file.
- Depending on the type of layouts you have, either place all of them into a single file or major layouts into separate files.
- Put each module into its own file.
- Depending on size of project, place sub-modules into their own file.
- Place global states into their own file.
- Place layout and module states, including media queries that affect those layouts and modules, into the module files.

2. How do those categories worked together in use cases?