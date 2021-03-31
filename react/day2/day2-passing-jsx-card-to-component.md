# Explanation
Passing a jsx card to down to child component(nested component).

In the child component, the jsx card is inside `props`, and act as a javascript object. Because inside the child component, the jsx card is now a javascript cobject, therefore to access it, requires using `{props.children}`

Question is: what if I pass multiple jsx cards down to child compoent? How the `{props.children}` works? 

