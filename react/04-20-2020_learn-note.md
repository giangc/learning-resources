## summary

* Redux middleware: plays as an adapter from Action to Reducers. It recives Action or function and return Action. Redux-thunk params are dispatch() and setState().
* The example of Redux-thunk is, 
  + return async function()
  + await for requests
  + do something with request.
  + dispatch Action: dispatch({type, payload: response})
* Redux-thunk: a redux middleware, which handles async action to redux Reducers.
* Scaling up implementation in redux thunk
* Requirement: Request a list of post + with author requires to use 2 API: GET posts/ and get/users/:id. Process overview includes:
  + Understand what redux thunk does: handles async action(redux side effect) -> ? thunk(state, dispatch) : thunk(dispatch, setState), this return a function.
  + memoize helps to reduce the elimated function.
  + overall logic: get posts -> eachPost -> render post + render getUser(userId).name

--- 
* Recall basic use case of react-redux: 
  + Redux term: ActionCreator, Action, createStore, Reducers, dispatch
  + React-redux term: Provider, connect, combineReducers, mapStateToProps.
  + Do not mutate state.
  + Return plain object in Action
* What is the general workflow on redux?
  + Action, ActionCreator and Reducers: Action is input for update, Reducer is where the computing logic at and deliver output as state via dispatch. ActionCreator is the plain object which create Action.
* What does combineReducers and createStore mean?
  + All Reducer will be combined into one for centralizing the Reducers. Create store centralize the action.
* Describe react-redux?
  + Provider: wrap redux store
  + connect: ... 

--- 
**revision**:
* Needs to look again how react-redux work.

## screenshots 

## glossary

* redux middleware
* redux side effect
* pure reducers:
* string, number in js are immutable
* array, object in js are mutable
* lodash memoize: utility which eliminate repeated request.

## mental model

Requirement: render info from 2 different APIs, with the use of: redux, redux-thunk

**What if without redux-thunk when trying to create async request action?**

> Action is required to return plain object. Error.

**Why is this an error of requiring plain object, when I do return a plain object?**

> Because async code from TypeScript is transpiled via Babel, in which the transpiled code generates return 2 things on switch cases. If we fix this, this also will not work, because the Reducer is not designed to receive async result.

**If reducer check if state has not been changed, it will not notify the apps the state has been changed.**

**Thinking in React: How to identify states?**

**Thinking in React: How to identify which component should own which state?**

## links

* jsonplaceholder.com
