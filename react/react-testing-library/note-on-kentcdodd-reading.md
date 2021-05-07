* Testing tech sum:

  **what do I know/don't know?**

    - Unit testing for javascript logic.
    - Use jest-styled-component to test CSS-in-JS, but not really know how, and why.
    - Able to extract CSS from styled-component using react-testing-library, however having issue with useState.
    - React-testing-library: Verify DOM, what it has on screen
    - Don't know how to test behavior, hover, click(should be fired Event)
    - When does snapshot testing happen?
    - I used mixed Enzyme with react-testing-library, which is shit. I don't think it's good.
    - Jest is used for unit testing, DOM testing in Unit level. Enzyme and React-testing-library provide utilities to make it into behavior testing. Enzyme and react-testing-library ???? I think there is something missing.
    - APIs: describe(), it(), expect().toBe toHave(), etc.

  **what kind of problem do I have?**

    - Struggle to find out if I should snapshot now or later(the process)
    - Struggle in apis to access on DOM, UT on CSS level, with styled-component feature, and some weird issue with react hook.
    - Little knowledge in testing strat.

  **what thing should I look into?**

    - [.] strat(2:20)

      APIs

    - stuff: what uses what.

testingjavascript.com: 

  + app
  + customhook
  + mock component
  + http jest mock
  + jest dom
  + prop updates
  + react dom
  + react redux router

Strat: React testing library - DOM
  Problem: maintainable tests for Web UI, care only about UI without implementation details.
  Solution: querying DOM node

https://kentcdodds.com/blog/write-tests

* Write not too many unit test, more integration test.
* Coverage 100% is not really effective: **you get diminishing returns on your tests as the coverage increases much beyond 70%**. But it depends

https://kentcdodds.com/blog/the-merits-of-mocking

* Cost of mocking is mostly high. It's not 100% confident of working with mock would work with real scenario.
* Reason???
* ?? 

https://kentcdodds.com/blog/why-i-never-use-shallow-rendering

``` 

test('toggle toggles the state of show', () => {
  const wrapper = shallow(<HiddenMessage initialShow={true} />)
  expect(wrapper.state().show).toBe(true) // initialized properly
  wrapper.instance().toggle()
  wrapper.update()
  expect(wrapper.state().show).toBe(false) // toggled
})
```

1. Will this test break when there's a mistake that would break the component in production?

2. Will this test continue to work when there's a fully backward compatible refactor of the component?

What does r-t-l can't do: 

``` 

* shallow rendering
* Static rendering (like enzyme's render function).
* Pretty much most of enzyme's methods to query elements (like find) which include the ability to find by a component class or even its displayName (again, the user does not care what your component is called and neither should your test). Note: React Testing Library supports querying for elements in ways that encourage accessibility in your components and more maintainable tests.
* Getting a component instance (like enzyme's instance)
* Getting and setting a component's props (props())
* Getting and setting a component's state (state())

All of these things are things which users of your component cannot do, so your tests shouldn't do them either

```

``` 

import React from 'react'
import {CSSTransition} from 'react-transition-group'
import {render, fireEvent} from '@testing-library/react'
import {HiddenMessage} from '../hidden-message'
// NOTE: you do NOT have to do this in every test.
// Learn more about Jest's __mocks__ directory:
// https://jestjs.io/docs/en/manual-mocks
jest.mock('react-transition-group', () => {
  return {
    CSSTransition: jest.fn(({children, in: show}) => (show ? children : null)),
  }
})
test('you can mock things with jest.mock', () => {
  const {getByText, queryByText} = render(<HiddenMessage initialShow={true} />)
  const toggleButton = getByText(/toggle/i)
  const context = expect.any(Object)
  const children = expect.any(Object)
  const defaultProps = {children, timeout: 1000, className: 'fade'}
  expect(CSSTransition).toHaveBeenCalledWith(
    {in: true, ...defaultProps},
    context,
  )
  expect(getByText(/hello world/i)).not.toBeNull()
  CSSTransition.mockClear()
  fireEvent.click(toggleButton)
  expect(queryByText(/hello world/i)).toBeNull()
  expect(CSSTransition).toHaveBeenCalledWith(
    {in: false, ...defaultProps},
    context,
  )
})
```

https://kentcdodds.com/blog/how-to-know-what-to-test

> For all of these, rather than thinking about the code, think about the observable effect that code has for the end user and developer user, that's your use case, test that

* User interactions (using fireEvent from React Testing Library): Is the end user able to interact with the elements that the component renders?
* Changing props (using rerender from React Testing Library): What happens when the developer user re-renders your component with new props?
* Context changes (using rerender from React Testing Library): What happens when the developer user changes context resulting in your component re-rendering?
* Subscription changes: What happens when an event emitter the component subscribes to changes? (Like firebase, a redux store, a router, a media query, or DOM-based subscriptions like online status)

* What part of this app would make me most upset if it were broken?

* What would be the worst thing to break in this app?

I see this pattern alot when working with React -> this could solve problem without inset html content.

``` 

function Fade({children, ...props}) {
  return (
    <CSSTransition {...props} timeout={1000} className="fade">
      {children}
    </CSSTransition>
  )
}

 <Fade in={this.state.show}>
          <div>Hello world</div>
  </Fade>
```

https://kentcdodds.com/blog/testing-implementation-details

``` 

* Can break when you refactor application code. False negatives
* May not fail when you break application code. False positives

```

> Implementation details: are things which users of your code will not typically use, see, or even know about.

https://kentcdodds.com/blog/unit-vs-integration-vs-e2e-tests

> I love that metaphor in how it applies to testing because it's basically saying that choosing the right testing strategy is the same kind of choice you'd make when choosing a brush for painting a wall. Would you use a fine-point brush for the entire wall? Of course not. That would take too long and the end result would probably not look very even. Would you use a roller to paint everything, including around the mounted furnishings your great-great-grandmother brought over the ocean two hundred years ago? No way. There are different brushes for different use cases and the same thing applies to tests.

https://kentcdodds.com/blog/confidently-shipping-code
