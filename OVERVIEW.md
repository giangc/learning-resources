Zoom out level to view what subjects that I think I am working on. 

Context: This is what I have been working on over the past 2 months after I completed Certified K8s Admin(CKA)

--- 

* [Front-end](#front-end)
* [JS:](#js)
  + [Nextjs solve problems in React](#nextjs-solve-problems-in-react)
* [React](#react)
* [Redux](#redux)
* [CSS](#css)
* [React Native](#react-native)
* [Backend](#backend)
* [Programming](#programming)
* [Programming agnostic](#programming-agnostic)
* [Algorithm learning](#algorithm-learning)
* [Container](#container)
* [Android](#android-stack)
* [Build tools(inactive)](#build-toolsinactive)
* [Learning models](#learning-models)
* [IDE](#ide)
* [Software development tasks](#software-development-tasks)
* [Software development experience](#software-development-experience)

## Front-end

* Refactoring the existing pugjs/scss project

### JS

  + glossary: 
    - transpiler, bundler, task runner.
    - headless cms: backend only cms system.
    - jam stack
    - code spliting
    - dynamic server rendering
    - pre-rendering
    - static type checking.
  + library: 

    - lodash: 
      + _.get(object, path, default) used for nullsafe check.
      + _.uniq()
      + _.map()
      + -.memoize()
      + _.chain()
    - semantic UI

### Nextjs solve problems in React

  + code splitting
  + pre-rendering
  + pre-installed webpack and babel

### React:

  + Webpack, babel
  + Props, state, ReactRef, callback, life cycle
  + Thinking in React: state-based rendering UI, break down into components(1); Identify State(2): Not state: it can be passed via parent props. It never change. It can be computed from other props. 
  + Lifting the state(callback function in JSX)
  + Structuring with CSS code
  + links: <should be vetted on day 04-16-2020_buildnote|dailywork|>
  + React router: <Link to> 3 types of Router: BrowserRouter, HashRouter, MemoryRouter, which will be considered when deploying. HashRouter is considered to be the easiest. Deploy on React Server, otherwise it's screwed. Don't use the <a> because it cause reload the whole website, and losing all js states. 
    - dispatch rules: contains and ===. By default is contains. `exact` keyword
  + Hook: useState, useEffect, useRef ~ very similar to reducer(previousState, action)
  + Context: Global varible, could be as redux alternative. 

### Redux

  + createStore, Reducers(basic usage: pure Reducers), dispatch, combineReducers
  + React-redux: connect, Provider
  + use cases: basic, scalable. 
  + read the docs: about the motivation, design decision. 
  + redux middleware: redux-thunk, Redux-saga: library that handles redux, react side effect. 
  + links: 
    - https://medium.com/@dan_abramov/you-might-not-need-redux-be46360cf367
    - https://overreacted.io/
  + redux-thunk on calling duplicated requests, approached by: lodash. memoize out the request calls, or fetchPostsAndUser(): await fetching post -> dispatch, request with lodash. uniq(userIds) -> dispatch: Key points here is not changing fetchPosts and fetchUser method. 
* Saga pattern: definition. 

### Gatsby
philosophy: https://www.gatsbyjs.org/docs/gatsby-core-philosophy/

glossary: gatsby theme: UI functionality, pre-configured functions, data sourcing, added via gatsby-config.js

glossary: gatsby plugin: 3rd party libraries such as google analytics, responsive image, SEO, etc.  added via npm registry.

glossary: hydration: it is a process which, after build, gatsby turns the sites into full React web application.

question: how gatsby build website with React Component?
- Based on: page component, template component, customized component, html component, non component.

glossary: reach/router: client side router render in Gatsby.

tools: Redux dev tool: https://github.com/reduxjs/redux-devtools

composition: gatsby API files: gatsby-ssr.js; gatsby-browser.js

question: why graphql?
 * eliminates the need for multiple endpoints
 * push complexity on query logic
 * therefore very flexible

link: graphql concept: https://www.gatsbyjs.org/docs/graphql-concepts/
 * GraphQL schema: where queries, mutations, deletion, updates, subscription of GraphQL happens.

### CSS

* Responsive system
* Size unit: absolute or relative unit
* Some basic works on header, logo. 2 important properties: justifyContent and alignItem. 
* Codepen
* Learning structure: cheatsheet, summary, concept notes, plan, glossary. List of design: fonts and pattern.
* changing in knowledge system.
* Books: 
  + HTML and CSS ..by Jon
  + CSS Mastery
  + Scalable CSS: read object oriented css, SMACSS(scalable modular architecture css)
* Tools in the box:
  + Display: grid module, container(template, template col and row) and item. 
  + repeat()
  + minmax(min, max)
  + css cheatsheet from hostinger. 
  + No class css. 
  + links: from css-trick, etc. 
  + CSS Links
  + - Explained for dinasour series
  + Callback experiment.
  + Customizing bootstrap(after so much time of trying): Override scss requires to have re-import the library for updates(needs experiment).

### CSS Framework: Bootstrap

* 

### React Native

  + Everything is View. 
  + StyleSheet: css object
  + flex based layout. Defines main axis - justifyContent(col/row/col rerverse/row reverse) and cross axis - alignItem(flext-start, flex-end) for child alignment . Proportionally display, e. g child1 { flex: 1} child2 {flex: 2} // 1/3 and 2/3. 
    - flex-start | flex-end | stretch | center
  + Testing: UT and integration: Jest; e2e detox, appium; component testing(UT and integration); snapshot testing(redux snapshot)
  + Security: . . 
  + react-navigator, yoga playground: defines your layout then copy code(could be a designer job). 
  + Native modules: module that wrap around native code to communicate with js. 

## Backend

* APIs: 
  + unsplash
  + goodreads
* ORM: 
  + read: people hate ORM
  + basic: sequelize
* nodejs
* sailjs(working experience)
* PostgreSQL
  + pgAdmin4: query tool, SQL, navigation menu, create table(UI)
  + type: character varying, date and time
  + on cascade
  + CREATE FUNCTION(a. k. a store procedure)

## Programming

* JS
  + Array: immutable functions, map, [... , new item], filter. Mutable functions, include: push, pop
  + Promise
  + async/await basic
  + for ... of 
  + function* : generator, yeild

#### Programming agnostic

  + Concurrency: book `Java Concurrency in Practice` : Concurrency in definition is based on 2 factors: invariant and post condition. Aspects: Atomicity, ThreadSafe, types of operators ... , locking: locking could be a disater for performance, composed locking, reentrant, 

#### Algorithm learning

  + General approach: definition, representation, approach, algorithm and proof
  + Subarray problem: find maximum subarray using kaden algorithm: This can be solved with bruteforce or kaden. Kaden, find maximum subarray of the ending index start with 0. Visualization is something like a table(variable records result, or some part required for calculation that can be cached). Just continuously cache the result so that you don't have to do the calculation again, which save one iteration. 
  + Find min and max index of N in sorted array
  + memoize, kadaen

## Container

* Docker

Orchestration: K8s ecosystem

* CKA
* Deployment with https://github.com/google/ko

## Android stack

* Dependency injection pattern: application graph, appflow, 
* Dagger 2:
  + @Inject, @Provides, @Binds, @Modules, @Subcomponent, @Component, @Subcomponent. Factory, inject(), @Scope, @Singleton, @CustomScope
  + Injector and injectee; Injector request
  + Advance: Dagger in multi modular in gradle, dynamic feature

## Build tools(inactive)

* gradle

## Learning models

* Building process 
* Reading based learning
* video based learning
* cheatsheet: where storing stuff like tldr. 

## IDE

Visual studio code: 

* open in new tab. 

## Software development tasks

* ETA task in React, with set of questions:
  + Does xd has extracting text tool to aid eta process(I think it does)?
  + What would I do if they don't have generic page? I actually just view the whole page, and extract by eyes.

* ETA task on static webpage: refactor, update changes, test.

* Working technique(google sheets):
  + When 'expected workload' value is matched with workload per component, 'expected duration' take 'workload per component' value?
  + delete all white row: Create filter view, by condition, row is not empty

## Software development experience
