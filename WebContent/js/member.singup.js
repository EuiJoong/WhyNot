
function chkBoxCheck(intChkNumber) {

	// 체크박스 갯수만큼 반복문을 돌면서
	for (j = 0; j < 3; j++) {
		// 체크박스가 선택되어 있으면
		if (eval("document.f.interestcheckbox[" + j + "].checked") == true) {
		// 우선 체크박스의 속성을 선택되지 않음으로 하고
		document.f.interestcheckbox[j].checked = false;
		// 사용자가 클릭한 체크박스와 프로그래밍적으로 돌고 있는
		// 체크박스의 번호가 같으면
		if (j == intChkNumber) {
			// 이런 경우만 체크박스가 선택되도록 한다...
			document.f.interestcheckbox[j].checked = true;
			}
		}
	}
}
function isID(Obj) {
	
	if (Obj.value == "") {
		alert("아이디를 입력해 주세요!!");
		document.f.id.focus();
		exit;
	}
	
	var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	if(exptext.test(document.f.id.value)==false){
	//이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우
	alert("아이디가 이상합니다!!");
	document.f.id.focus();
	exit;
	}
}
function isCHK(Obj) {
	num = 1234;//임이의값

	if (Obj.value == "") {
		alert("이메일을 확인해 주세요!!");
		document.f.EmailCHK.focus();
		exit;
	}
	if(document.f.EmailCHK.value!=num){
		alert("이메일을 확인해 주세요!!");
		document.f.EmailCHK.focus();
		return false;
	}
}
function isPW(Obj1,Obj2) {

	if (Obj1.value == "") {
		alert("비밀번호를 입력해 주세요!!");
		document.f.password.focus();
		exit;
	}
	
	var exptext = /([A-Za-z0-9]{6,20})+/g//특수문자 빼고 6자리 이상
	if(exptext.test(document.f.password.value)==false){
	alert("비밀번호가 이상합니다!!");
	document.f.password.focus();
	exit;
	}
	
	if (document.f.password.value != document.f.passwd2.value) {
		alert("비밀번호가 다릅니다!!");
		document.f.passwd2.focus();
		exit;
	}
}

function isNAME(Obj) {

	if (Obj.value == "") {
		alert("이름을 입력해 주세요!!");
		f.nickname.focus();
		exit;
	}
	var exptext = /([A-Za-z0-9]{2,20})+/g//여기 한글이 않되서 어케할지 모르갰음
	if(exptext.test(document.f.nickname.value)==false){
		alert("이름이 이상합니다!!");
		f.nickname.focus();
		exit;
	}
	
}
function isDAY() {
	
	if (document.f.birth.value == "") {
		alert("생일을 입력해 주세요!!");
		document.f.birth.focus();
		exit;
	}
	var exptext = /([0-9]{8})+/g//숫자 8자리
	if(exptext.test(document.f.birth.value)==false){
		alert("생일이 이상합니다!!");
		document.f.birth.focus();
		exit;
	}
}

function isBOX() {

	if (f.box.checked == false) {
		alert("약관을 읽어 주세요!!");
		exit;
	}
}

function chk() {
	
	if(isID(f.id)){
		return;
	}if(isCHK(f.EmailCHK)){
		return;
	}if(isPW(f.password,f.passwd2)){
		return;
	}if(isNAME(f.name)){
		return;
	}if(isDAY(f.birthday)){
		return;
	}if(isBOX(f.box)){
		return;
	}
	
	document.f.submit();
	
}

function idCHK() {
	
	var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	if(exptext.test(document.f.id.value)==false){
	//이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우
	alert("아이디 양식이 올바르지 않습니다.");
	document.f.id.focus();
	exit;
	return;
	}
	alert("해당 이메일로 인증번호가 전송되었습니다.");//이것이 이메일 쏴줘야 하는곳
}
