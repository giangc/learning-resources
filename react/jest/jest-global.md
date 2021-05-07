``` typescript
interface TestGlobal extends Global {
  fetch: jest.Mock;
}

globalLocal.fetch = mockFetch({[GET_BOOKS_URL]: books,});

globalLocal.fetch.mockClear();
MockDate.reset();

```
