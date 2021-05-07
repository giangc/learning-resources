``` typescript
const container = render( < Component > )
const componentName = 'the-component-name';

container.querySelector < HTMLInputElement > (`[name="${componentName}"]`) !
container.querySelector<HTMLParagraphElement>('.points-selection')!;
expect(Array.from(container.querySelectorAll<HTMLButtonElement>('.list > *'))).toHaveLength(1);

```
