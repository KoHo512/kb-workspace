let isPizza = true;

const pizza = new Promise((res, rej) => {
  if (isPizza) {
    res('피자를 주문했습니다');
  } else {
    rej('피자를 주문하지 않았습니다');
  }
});

pizza.then((result) => console.log(result)).catch((err) => console.log(err));
