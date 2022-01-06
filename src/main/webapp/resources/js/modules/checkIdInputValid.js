import checkUserInputEmpty from "./checkUserInputEmpty.js";
import checkIdDuplicate from "./checkIdDuplicate.js";

export default function checkIdInputValid(){
	const userInput = document.querySelector('.user_id').value;
	if(checkUserInputEmpty(userInput)){
		checkIdDuplicate(userInput);
	}
}