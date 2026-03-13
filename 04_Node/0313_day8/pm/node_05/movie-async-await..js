const axios = require('axios');

async function getTop20Movies() {
  const url =
    'https://raw.githubusercontent.com/wapj/musthavenodejs/main/movieinfo.json';

  // http 네트워크에서 데이터 받아오는 동안 await로 대기
  try {
    const result = await axios.get(url);
    const { data } = await result;

    if (!data.articleList || data.articleList == 0) {
      throw new Error('데이터가 없습니다.');
    }

    // data에서 필요한 영화 제목과 순위 정보를 뽑아내기
    const movieInfos = data.articleList.map((article, idx) => {
      return { title: article.title, rank: idx + 1 };
    });

    // 영화 정보 출력
    for (let movieInfo of movieInfos) {
      console.log(`#${movieInfo.rank} : ${movieInfo.title}`);
    }
  } catch (error) {
    throw new Error(error);
  }
}

getTop20Movies();
