const fs = require('fs');

// 프로세스가 실행 중인 디렉토리
fs.readdir('./', (err, files) => {
  if (err) {
    console.error(err);
    return;
  }
  console.log(files);
});

// 파일이 존재하고 있는 디렉토리
fs.readdir(__dirname, (err, files) => {
  if (err) {
    console.error(err);
    return;
  }
  console.log(files);
});
