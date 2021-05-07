``` js
import React from 'react'
import {
    CSSTransition
} from 'react-transition-group'
import {
    render,
    fireEvent
} from '@testing-library/react'
import {
    HiddenMessage
} from '../hidden-message'
// NOTE: you do NOT have to do this in every test.
// Learn more about Jest's __mocks__ directory:
// https://jestjs.io/docs/en/manual-mocks
jest.mock('react-transition-group', () => {
    return {
        CSSTransition: jest.fn(({
            children,
            in: show
        }) => (show ? children : null)),
    }
})

test('you can mock things with jest.mock', () => {
            const {
                getByText,
                queryByText
            } = render( < HiddenMessage initialShow = {
                    true
                }
                />)

                const toggleButton = getByText(/toggle/i)
                const context = expect.any(Object)
                const children = expect.any(Object)
                const defaultProps = {
                    children,
                    timeout: 1000,
                    className: 'fade'
                }

                expect(CSSTransition).toHaveBeenCalledWith({
                        in: true,
                        ...defaultProps
                    },
                    context,
                )

                expect(getByText(/hello world/i)).not.toBeNull()

                CSSTransition.mockClear()

                fireEvent.click(toggleButton)

                expect(queryByText(/hello world/i)).toBeNull()

                expect(CSSTransition).toHaveBeenCalledWith({
                        in: false,
                        ...defaultProps
                    },
                    context,
                )
            })
```
