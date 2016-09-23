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

function btnChk() {

	if(isMoney()){
		return;
	}if(isTool()){
		return;
	}
	document.f.submit();
}



