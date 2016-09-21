/*
function isMoney() {

	if (!$(':input:radio[name=amount]:checked').val()) {
		alert("돈을 선택해 주세요");
		exit;
	}
}
function isTool() {

	if (!$(':input:radio[name=tool]:checked').val()) {
		alert("충전 방식을 선택해 주세요");
		exit;
	}
}

function chk() {

	if(isMoney()){
		return;
	}if(isTool()){
		return;
	}
	
	document.f.submit();

}


function isCard_num() {

	if (document.f.card_num.card_num1.value == ""||
		document.f.card_num.card_num2.value == ""||
		document.f.card_num.card_num3.value == ""||
		document.f.card_num.card_num4.value == ""||
		document.f.card_day.card_day1.value == ""||
		document.f.card_day.card_day2.value == ""||
		document.f.card_day.card_cvc.value == "") {
		alert("카드번호를 적어주세요");
		document.f.card_num.card_num1.focus();
		exit;
	}
	
	var exptext = /([0-9])+/g//숫자만
	if(	exptext.test(document.f.card_num.card_num1.value)==false||
		exptext.test(document.f.card_num.card_num2.value)==false||
		exptext.test(document.f.card_num.card_num3.value)==false||
		exptext.test(document.f.card_num.card_num4.value)==false||
		exptext.test(document.f.card_day.card_day1.value)==false||
		exptext.test(document.f.card_day.card_day2.value)==false||
		exptext.test(document.f.card_day.card_cvc.value)==false){
		alert("카드번호가 이상합니다!!");
		document.f.card_num.card_num1.focus();
		exit;
	}
	
}
function card_chk() {

	if(isCard_num()){
		return;
	}
	document.f.submit();
	
}


*/