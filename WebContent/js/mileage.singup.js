
function isMoney() {

	if (!$(':input:radio[name=money]:checked').val()) {
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


function isCom() {

	if (!$(':input:radio[name=tel_company]:checked').val()) {
		alert("통신사를 선택해 주세요");
		exit;
	}
}

function isNum() {
	
	if (document.f.tel_num.value == "") {
		alert("휴대전화번호를 적어주세요");
		document.f.tel_num.focus();
		exit;
	}
	
	var exptext = /([0-9])+/g//숫자만
	if(	exptext.test(document.f.tel_num.value)==false){
		alert("휴대전화번호가 이상합니다!!");
		document.f.tel_num.focus();
		exit;
	}
	
	
	if (document.f.tel_cnum1.value == ""||
		document.f.tel_cnum2.value == "") {
		alert("주민 번호를 적어주세요");
		document.f.card_num.card_num1.focus();
		exit;
	}
	var exptext = /([0-9])+/g//숫자만
	if(	exptext.test(document.f.tel_cnum1.value)==false||
		exptext.test(document.f.tel_cnum2.value)==false	){
		alert("주민 번호가 이상합니다!!");
		document.f.tel_cnum1.focus();
		exit;
	}
	
	
}

function chkBoxCheck(intChkNumber) {

		if (eval("document.f.box[" + 0 + "].checked") == true) {
		for (j = 1; j < 4; j++) {
		document.f.interestcheckbox[j].checked = true;
			}
		}
}

function isBox() {

	for (j = 1; j < 4; j++) {
	if (eval("document.f.box[" + j + "].checked") != true) {
		alert("약관에 동의해 주세요!");
		exit;
		}
	}

}

function tel_chk() {

	if(isCom()){
		return;
	}if(isNum()){
		return;
	}if(isBox()){
		return;
	}
	document.f.submit();
	
}

