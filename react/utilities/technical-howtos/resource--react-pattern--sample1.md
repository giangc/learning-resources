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
