import {MAX_STAR_SCORE} from '../constants/constants.js';

function renderEmptyStateArray(stars){
	let starArray = Array(MAX_STAR_SCORE).fill();
	starArray.forEach(() => {
		const star = document.createElement('div');
		star.className = 'star empty';
		stars.appendChild(star);
	})
}

function fillStar(stars, star_index){
	const starList = [...stars.children];
	starList.forEach((star,index) => {
		if(star_index >index){
			if(star_index - index === 0.5){
				star.className = 'star half';
			}else{
				star.className = 'star full';
			}
		}else{
			star.className = 'star empty';
		}
	});
}

function calculateScore(e){
	const {width, left} = e.currentTarget.getBoundingClientRect();
	const x = e.clientX - left;
	const half_score = width / MAX_STAR_SCORE / 2;
	return Math.floor(x / half_score + 1) / 2;
} 


function renderStarRating(state){
	const pointShowElement = document.querySelector('.point');
	if (state > 5){
		pointShowElement.innerText = 5;
	}else if (state < 0){
		pointShowElement.innerText = 0;
	}else{
		pointShowElement.innerText = state;
	}
}

export default function ratingMovieScore(){
	let state = {
			score : 0
	};
	const stars = document.querySelector('.stars');
	renderEmptyStateArray(stars);
	stars.addEventListener('click', (e) => {
		state.score = calculateScore(e);
		fillStar(stars, state.score);
		renderStarRating(state.score);
	})
	stars.addEventListener('mousemove', (e) => {
		state.score = calculateScore(e);
		fillStar(stars, state.score);
		renderStarRating(state.score);
	})
	stars.addEventListener('mouseleave', (e) => {
		state.score = calculateScore(e);
		fillStar(stars, state.score);
		renderStarRating(state.score);
	})
	document.querySelector('.submitGrade').addEventListener('click', () => {
		if(state.score > 5){
			state.score = 5;
		}else if(state.score < 0){
			state.score = 0;
		}
		console.log(state.score);
	})
}