let loginBack = document.querySelector('.loginFail-background'), // 전체 백그라운드 배경색 설정용
    loginModal = document.querySelector('.loginFail-modal'), // 모달창 div
    loginConfirm = document.querySelectorAll('#confirm-btn'), // 확인, x 버튼
    modalText = document.querySelector('.modal-text'); // 모달창 안의 text 영역

// 모달창 오픈 함수
function modalOpen(text){
    modalText.innerText = text;
    loginBack.style.display = 'block';
    setTimeout(function(){
        loginModal.style.display = 'flex';
        loginModal.style.transform = 'translate(-50%, -35%)';
        setTimeout(function(){
            // loginModal.style.top = '35%';
            loginModal.style.transform = 'translate(-50%, -38%)';
            loginModal.style.transition = '0.3s';
            setTimeout(function(){
                // loginModal.style.top = '35%';
                loginModal.style.transform = 'translate(-50%, -35%)';
                loginModal.style.transition = '0.3s';
            },150);
        },100);
    }, 150);
}

// 회원 로그인 실패시 서버에서 전달받은 에러 결과값 loginFail = 2
if(loginFail == 2){
    modalOpen("회원정보가 존재하지 않습니다.");
}

// x버튼, 확인버튼 클릭시 모달창 닫기
loginConfirm.forEach(e =>{
    e.addEventListener('click', ()=>{
        loginModal.style.display = 'none';
        loginBack.style.display = 'none';
    })
})

let idVal = document.getElementById('id');
let pwdVal = document.getElementById('pwd');
function validation(){
    if(idVal.value == '' || idVal.value == null){
        modalOpen('아이디를 입력해 주세요.');
        return false;
    }else if(pwdVal.value == '' || pwdVal.value == null){
        modalOpen('비밀번호를 입력해 주세요.');
        return false;
    }else{
        return true;
    }
}