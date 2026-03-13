fs = require('fs');
path = require('path');

// 다른 디렉토리에서 실행하면 에러 발생
// fs.readFile('./example.txt', 'utf-8', (err, data) => {
//   if (err) {
//     console.error(err);
//   }
//   console.log(data);
// });

filepath = path.join(__dirname, 'example.txt');

fs.readFile(filepath, 'utf-8', (err, data) => {
  if (err) {
    console.error(err);
  }
  console.log(data);
});
