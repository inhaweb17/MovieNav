const url = 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json';
const key = '08fe9327eb466a04a4592345c7c94ee0';

let time = (function() {
   let now = new Date();
   let yesterday = now.getTime() - (1 * 24 * 60 * 60 * 1000);
   now.setTime(yesterday);
   
   let y = now.getFullYear();
   let m = now.getMonth() + 1;
   let d = now.getDate();
   
   if (m < 10){m = '0' + m;}
   if (d < 10){d = '0' + d;}
   
   return String(y) + String(m) + String(d);
})();

const reqRank =
   fetch(`${url}?key=${key}&targetDt=${time}`);
   reqRank.then(res => {
       if(res.status >= 200 && res.status < 300){
           return res.json();
       }else{
           return Promise.reject(new Error('rank api error'));
       }
   })
   .then(res=> {
       let rankList = res.boxOfficeResult.dailyBoxOfficeList;
       let posterList = poster.split(',');
       showRanking(rankList, posterList);
   })



const leftBtn = document.querySelector('.left_btn');
const rightBtn = document.querySelector('.right_btn');
const p0 = document.querySelector('.p0');
const p1 = document.querySelector('.p1');
const p2 = document.querySelector('.p2');
const p3 = document.querySelector('.p3');


const posterContainers = [p0, p1, p2, p3];
let p_index = [0,1,2,3];
let p_length = 4;

const showRanking = (rankList, posterlist) => {
   for(let i =0; i<p_length; i++){
      posterContainers[i].innerHTML = `
      <img src='${posterlist[i]}'
      alt = '${rankList[i].movieNm}${rankList[p_index[i]].rank}st'
      class = 'poster poster${rankList[i].rank}'/>
      <p id="rankInfo" class="rankInfo">#${rankList[p_index[i]].rank}</p>
      <p class="ranktitle">${rankList[p_index[i]].movieNm}</p>
      `
   };
   
   leftBtn.onclick = () => {
        for(let i = 0; i< 4; i++){
            p_index[i] = minus(p_index[i]);
        }
        for(let i = 0; i< 4; i++){
            posterContainers[i].innerHTML = `
            <img src='${posterlist[p_index[i]]}'
            alt = '${rankList[p_index[i]].movieNm}${rankList[p_index[i]].rank}st'
            class = 'poster poster${rankList[p_index[i]].rank}' />
            <p id="rankInfo" class="rankInfo">#${rankList[p_index[i]].rank}</p>
            <p class="ranktitle">${rankList[p_index[i]].movieNm}</p>
            `
        }
    }

    rightBtn.onclick = () => {
        for(let i =0; i<4; i++) {
            p_index[i] = plus(p_index[i]);
        }
        for(let i =0; i< 4; i++){
            posterContainers[i].innerHTML = `
            <img src= '${posterlist[p_index[i]]}'
            alt = '${rankList[p_index[i]].movieNm}${rankList[p_index[i]].rank}st'
            class = 'poster poster${rankList[p_index[i]].rank}' />
            <p id="rankInfo" class="rankInfo">#${rankList[p_index[i]].rank}</p>
            <p class="ranktitle">${rankList[p_index[i]].movieNm}</p>
            `
        }
    }

    function plus(e) {
        if (e == 9) {
            e = 0;
        }else {
            e += 1;
        }
        return e;
    }

    function minus(e) {
        if (e == 0){
            e = 9;
        }else {
            e -= 1;
        }
        return e;
    }
   
}
