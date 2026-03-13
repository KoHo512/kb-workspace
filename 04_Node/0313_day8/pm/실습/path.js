const path = require('path');

console.log(path.join('some', 'work', 'ex.txt'));

console.log(`파일 절대 경로 : ${__filename}`);
console.log(`경로만 : ${__dirname}`);

console.log(`파일 이름 : ${path.basename(__filename)}`);
console.log(`파일 이름(확장자 제외) : ${path.basename(__filename, '.js')}`);

console.log(`파일 확장자 : ${path.extname(__filename)}`);

console.log(path.parse(__filename));
