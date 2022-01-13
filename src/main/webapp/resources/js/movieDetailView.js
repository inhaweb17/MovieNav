import ratingMovieScore from './modules/ratingMovieScore.js';

export default function movieDetailView(){
	this.init = () => {
		ratingMovieScore();
	}
	const initEventListener = () => {
		const submitLikeBtn = document.querySelector('.submitLike');
		submitLikeBtn.addEventListener('click', () => {
			//추천하기 +1 정보 서버에 전송
		})
		
	}
	
}

const moview = new movieDetailView();
moview.init();