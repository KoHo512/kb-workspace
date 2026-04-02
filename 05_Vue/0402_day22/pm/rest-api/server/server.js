// 1. 서버 구성
// Express 서버로 JSON 파일을 직접 읽고 쓰며 기능 구현
// data.json이 데이터베이스를 대신함

// express 모듈 가져오기
// expree: 웹서버 쉽게 만들 수 있게 하는 Node.js 프레임워크
const { error } = require('console');
const express = require('express');

// fs/promises 모듈 가져오기
// promise 기반으로 파일 읽기쓰기 기능을 사용할 수 있음
const fs = require('fs/promises');

// path 모듈 가져오기
// 운영체제에 맞는 안전한 파일 경로 만들 수 있음
const path = require('path');

// express 어플리케이션 생성
const app = express();

// 서버가 실행될 포트 번호
const port = 3000;

// 현재 파일이 있는 폴더(__dirname)를 기준으로 data.json의 절대 경로 생성
// 예) C:\...\05_Vue\0402_day22\pm\rest-api\server\data.json
const dataFilePath = path.join(__dirname, 'data.json');

app.use(express.json());

// CORS 설정 - 다른 주소의 서버에서도 이 서버(3000포트)에게 요청할 수 있게 허용
app.use((req, res, next) => {
  res.header('Access-Control-Allow-Origin', '*'); // 모든 출처(origin)에서의 접근 허용
  res.header('Access-Control-Allow-Methods', 'GET, POST, PUT, PATCH, DELETE'); // 작성된 메소드에 대해 허용

  next(); // 라우팅
});

// 2. 서버에서 제공하는 HTTP 메소드(GET, POST, DELETE, PUT) 기능 생성
// GET : /api/data - 전체 데이터 조회
// POST : /api/data - 새 데이터 추가
// PUT : /api/data/:id - 특정 데이터 전체 수정
// PATCH : /api/data/:id - 특정 데이터 일부 수정
// DELETE : /api/data/:id - 특정 데이터 삭제
// 해당 조작에 의한 결과(데이터)는 data.json에 저장

app.get('/api/data', async (req, res) => {
  try {
    const data = await readDataFile();

    res.json(data);
  } catch (error) {
    res.status(500).json({ error: 'Internal Server Error' });
  }
});

app.post('/api/data', async (req, res) => {
  try {
    const newData = req.body;

    const data = await readDataFile();

    const writeData = {
      id: data.length + 1,
      name: `${newData.name} ${data.length + 1}`,
      description: `${newData.description} ${data.length + 1}`,
    };

    data.push(writeData);

    await writeDataFile(data);

    res.json(newData);
  } catch (error) {
    res.status(500).json({ error: 'Internal Server Error' });
  }
});

app.put('/api/data/:id', async (req, res) => {
  try {
    const id = Number(req.params.id);
    const updatedData = req.body;

    const data = await readDataFile();

    const index = data.findIndex((item) => item.id === id);

    if (index !== -1) {
      data[index] = { ...data[index], ...updatedData };
      await writeDataFile(data);
      res.json(data[index]);
    } else {
      res.status(404).json({ error: 'Not Found' });
    }
  } catch (error) {
    res.status(500).json({ error: 'Internal Server Error' });
  }
});

app.patch('/api/data/:id', async (req, res) => {
  try {
    const id = Number(req.params.id);
    const partialData = req.body;

    const data = await readDataFile();

    const index = data.findIndex((item) => item.id === id);

    if (index !== -1) {
      data[index] = { ...data[index], ...partialData };
      await writeDataFile(data);
      res.json(data[index]);
    } else {
      res.status(404).json({ error: 'Not Found' });
    }
  } catch (error) {
    res.status(500).json({ error: 'Internal Server Error' });
  }
});

app.delete('/api/data/:id', async (req, res) => {
  try {
    const id = Number(req.params.id);

    const data = await readDataFile();

    const index = data.findIndex((item) => item.id === id);

    if (index !== -1) {
      const deletedItem = data.splice(index, 1)[0];
      await writeDataFile(data);
      res.json(deletedItem);
    } else {
      res.status(404).json({ error: 'Not Found' });
    }
  } catch (error) {
    res.status(500).json({ error: 'Internal Server Error' });
  }
});

// Helper 함수 : 데이터 파일 읽기
async function readDataFile() {
  const data = await fs.readFile(dataFilePath, 'utf-8');
  return data ? JSON.parse(data) : [];
}

// Helper 함수 : 데이터 파일 쓰기
async function writeDataFile(data) {
  await fs.writeFile(dataFilePath, JSON.stringify(data, null, 2), 'utf-8');
}

// 서버 실행
// localhost:3000에서 서버 시작
app.listen(port, () => {
  console.log(`Server is running at http://localhost:${port}`);
});
