``` typescript
test('toggle toggles the state of show', () => {
            const wrapper = shallow( < HiddenMessage initialShow = {
                    true
                }
                />)
                expect(wrapper.state().show).toBe(true) // initialized properly
                
                wrapper.instance().toggle()

                wrapper.update() 
                 
                expect(wrapper.state().show).toBe(false) // toggled
            })
```
