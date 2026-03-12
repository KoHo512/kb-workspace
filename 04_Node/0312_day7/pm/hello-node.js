// http 객체 생성
const http = require('http');

let count = 0;

// Node 서버 객체 생성
const server = http.createServer((request, response) => {
  console.log('my first node servier');
  console.log((count += 1));

  response.statusCode = 200;
  response.setHeader('ContentType', 'text/plain');
  response.write('hello\n');

  setTimeout(() => {
    response.end('Node.js');
  }, 2000);
});

server.listen(8000, () => console.log('Hello Node.js'));
