import {GENRELIST} from './constants/genreConstants.js';

export default function genreView(){
	this.init = () => {
		tabClickEventListener();
	}
	const tabClickEventListener = () => {
		document.querySelectorAll('#genre-btn').forEach((item) => {
			item.addEventListener('click', (e) => {
				console.log(checkGenre(e));
			})
		})
	}
	const checkGenre = (e) => {
		let genreNumber = 0;
		GENRELIST.forEach((item, index) => {
			if(item === e.target.className){
				genreNumber = index;
			}
		})
		return String(genreNumber);
	}
}
const view = new genreView();
view.init();