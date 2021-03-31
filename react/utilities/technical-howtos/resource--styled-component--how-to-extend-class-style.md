First: 
```TypeScript
export type Props = {
  className: string
}

//... 

const StyledSpinner = styled.div`
  width: 17px;
  height: 17px;
  background: rgba(255, 104, 32, 1);
  border-radius: 50%;
`

export const Spinner: React.FC<Props> = ({ className }) => (
  <SpinnerWrapper className={className} role='progressbar'>
    <StyledSpinner />
  </SpinnerWrapper>
)
```

Second:
```
const ButtonSpinner = styled(Spinner) <ButtonSpinner>`
  position: absolute;
  display: ${props => props.isShow === true ? 'flex' : 'none'} ;
  left: 185px;
`

```

