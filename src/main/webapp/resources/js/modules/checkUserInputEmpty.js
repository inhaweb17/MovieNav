import showAlert from "./showAlert.js";
import {ERRORMSG, EMPTY_ERROR} from "../constants/errorMsg.js";
export default function checkUserInputEmpty(userInput){
	if(userInput === ''){
		showAlert(ERRORMSG[EMPTY_ERROR]);
		return false;
	}
	return true;
}