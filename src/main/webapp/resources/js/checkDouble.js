const confirmbtn = document.querySelector('.confirm');
const user_id = document.querySelector('.user_id');

function checkDobule(e){
	const userId = user_id.value;
	location.href=`user/idCheck?userId=${userId}`;
}

confirmbtn.addEventListener("click",checkDouble);


