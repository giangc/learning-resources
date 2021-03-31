Animation note:
[problem] issue, which render jumpy at the end of animation. Solved by adding additional render frame on end position

```
0% {
    transform: scale(1, 1);
    }
  25% {
    transform: scale(1, 1);
    }
  50% {
    transform: scale(1.1, 1.1);
    }
  75% {
    transform: scale(1, 1);
    }
  100% {
    transform: scale(1, 1);
    }
```
