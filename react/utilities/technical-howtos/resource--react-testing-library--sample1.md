``` js
import React from 'react'
import {
    screen,
    fireEvent,
    getByText
} from '@testing-library/dom'
import {
    render
} from '@testing-library/react';
import Tooltip from '../Tooltip'

describe('<Tooltip /> ', () => {

    it('renders Tooltip', () => {
        const tree = render( < Tooltip / > )
        expect(tree).toMatchSnapshot()
    })

    it('renders Tooltip with message as Why do we need this', () => {
        renderComponent({
            inputName: "date",
            message: "Why do we need this?"
        })
        screen.queryByText(/Why do we need this?/i)
    })

    it('renders Tooltip' +
        'pass props message as Why do we need this and ' +
        'hover on Tooltip message ' +
        'Display message Why do we need this and ' +
        'After hover, display message' +
        'We need to know your workplace suburb to ensure you’re signing up to the correct SDA branch.', () => {
            const {
                container
            } = renderComponent({
                inputName: "suburbWork",
                message: "Why do we need this?",
                tooltip_message: "We need to know your workplace suburb to ensure you’re signing up to the correct SDA branch."
            })

            screen.getByText(/Why do we need this?/i)
            // hover
            fireEvent(getByText(container, /Why do we need this?/i),
                new MouseEvent('mouseover', {}))
            screen.getByText(/We need to know your workplace suburb to ensure you’re signing up to the correct SDA branch./i)

        })

    it('renders Tooltip' +
        'pass props message as Why do we need this and ' +
        'hover on Tooltip icon ' +
        'Display message Why do we need this and ' +
        'After hover, display message' +
        'We need to know your workplace suburb to ensure you’re signing up to the correct SDA branch.', () => {
            renderComponent({
                inputName: "suburbWork",
                message: "Why do we need this?",
                tooltip_message: "We need to know your workplace suburb to ensure you’re signing up to the correct SDA branch."
            })

            // hover
            fireEvent(screen.getByRole('tooltip'), new MouseEvent('mouseover', {}))
            screen.getByText(/We need to know your workplace suburb to ensure you’re signing up to the correct SDA branch./i)

        })
});
```
