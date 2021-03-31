```Typescript
switch (buttonState) {
    case ButtonStates.enabled:
    default:
      return "background: #FF6820;";
    case ButtonStates.progressing:
      return "background: #FF6820;\n"
        + "cursor: not-allowed;\n"
        + "pointer-events: none;"
    case ButtonStates.disabled:
      return "background: #C9C9C9;\n"
        + "cursor: not-allowed;\n"
        + "pointer-events: none;"
  }
```
