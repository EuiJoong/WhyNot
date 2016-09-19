
function isBOX() {

	if (f.box.checked == false) {
		alert("약관을 읽어 주세요!!");
		exit;
	}
}

function chk() {
	
	if(isBOX(f.box)){
		return;
	}if(isBOX(f.box)){
		return;
	}
	
	document.f.submit();
	
}
