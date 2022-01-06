import checkIdInputValid from "./modules/checkIdInputValid.js";
import showAlert from "./modules/showAlert.js";
import {DUPLICATE_ID_ERROR, ERRORMSG} from "./constants/errorMsg.js";
import checkUserFormInputValid from "./modules/checkUserFormInputValid";

export default function registerMember(){
	this.idValid = false;
	this.init = () => {
		initEventListener();
	}
	const initEventListener = () => {
		document.querySelector('.checkIdValidBtn').addEventListener('click', () =>{
			this.isValid = checkIdInputValid();
		})
		document.querySelector('.submit_btn').addEventListener('click', () => {
			if(this.isValid){
				this.isValid = checkUserFormInputValid();
				
			}else{
				showAlert(ERRORMSG[DUPLICATE_ID_ERROR]);
			}
		})
	}
	
}
const member = new registerMember();
member.init();