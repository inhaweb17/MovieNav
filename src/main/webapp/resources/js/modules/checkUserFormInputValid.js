import {NAME_EMPTY_ERROR, EMAIL_EMPTY_ERROR, TEL_EMPTY_ERROR,DATE_EMPTY_ERROR,  ERRORMSG} from "../constants/errorMsg.js";
import showAlert from "./showAlert.js";

export default function checkUserFormInputValid(){
	const userName = document.querySelector('.user_name').value;
	const userEmail = document.querySelector('.user_email').value;
	const userTel = document.querySelector('.user_tel').value;
	const userDate = document.querySelector('.user_date').value;
	
	let checkInputEmpty = true;
	
	if(userName.length === ''){
		showAlert(ERRORMSG[NAME_EMPTY_ERROR]);
		checkInputEmpty = false;
	}
	
	if(userEmail.length === ''){
		showAlert(ERRORMSG[EMAIL_EMPTY_ERROR]);
		checkInputEmpty = false;
	}
	
	if(userTel.length === ''){
		showAlert(ERRORMSG[TEL_EMPTY_ERROR]);
		checkInputEmpty = false;
	}
	
	if(userDate.length === ''){
		showAlert(ERRORMSG[DATE_EMPTY_ERROR]);
		checkInputEmpty = false;
	}
	
	return checkInputEmpty;
	
	
}