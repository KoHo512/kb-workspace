async function myName() {
  return 'KoHo';
}

async function showName() {
  const name = await myName();
  console.log(name);
}

console.log(showName());

```
Promise { <pending> }
KoHo
```;
