
// 메인 슬라이더
// <!-- ex) html 구조 -->
// <div class="slider-wraper">
    
//     <div id="slider" class="slider">
//         <div class="items slider-item1"></div>
//         <div class="items slider-item2"></div>
//         <div class="items slider-item3"></div>
//     </div>
    
//     <div class="left-arrow">
//         Prev
//         <i class="fa-solid fa-chevron-left"></i>
//     </div>
//     <div class="right-arrow">
//         Next
//         <i class="fa-solid fa-chevron-right"></i>
//     </div>
// </div>

function slider(divName){ // 
    
    // 변수 설정
    let slider = document.querySelector('.'+divName); // slider wraper
    let leftBtn = document.querySelector('.left-arrow'); // prev버튼
    let rightBtn = document.querySelector('.right-arrow'); // next버튼
    let items = document.querySelectorAll('.items'); // 슬라이드 리스트
    makeClone(); // 클론 생성 함수 호출
    let index = 1; // 슬라이드 인덱스
    let itemsQty = document.querySelectorAll('.items').length; // 슬라이드 개수
    
    console.log(document.querySelectorAll('.items'));
    
    // slider.style.width = `${itemsQty * 설정할값}설정단위`;
    slider.style.width = `${itemsQty * 100}vw`; // 전체 슬라이더 width
    // 개별 슬라이더 width
    let itemWidth = document.querySelector('.items').clientWidth; 
    
    
    // 클론 슬라이드 앞,뒤 생성 함수
    function makeClone(){
        let firstClone = items[0].cloneNode(true);
        let lastClone = items[items.length-1].cloneNode(true);
        slider.prepend(lastClone); // 앞에 추가(마지막 복사본)
        slider.append(firstClone); // 뒤에 추가(첫번째 복사본)
    }
    
    // prev, next 이벤트 설치
    leftBtn.addEventListener('click', prevSlider);
    rightBtn.addEventListener('click', nextSlider);
    initTransform();
    // 초기 슬라이드위치 설정 함수
    function initTransform(){
        slider.style.transform = `translateX(-${itemWidth}px)`;
    }
    // 슬라이드 이동함수
    function moveSlider(index){
        console.log("tranlateX >> " + index * itemWidth);
        slider.style.transform = `translateX(-${itemWidth*index}px)`;
    }
    // 트렌지션 효과 함수
    function addTransition(time){
        slider.style.transition = `${time}s`;
    }
    
    // 자동 슬라이드
    const setInterval = (() => {
        nextSlider();
    }, 2000);
    
    
    
    // prev버튼 함수
    function prevSlider(){
        index--;
        moveSlider(index);
        addTransition(0.3);
        if(index == 0){ // 처음 클론슬라이드로 이동시 위치바꿔줌
            setTimeout(()=>{
                index = itemsQty-2;
                moveSlider(index);
                addTransition(0);
            }, 300);
        }
    }
    
    // next버튼 함수
    function nextSlider(){
        index++;
        moveSlider(index);
        addTransition(0.3);
        if(index == itemsQty-1){ // 마지막 클론슬라이드로 이동시 위치바꿔줌
            setTimeout(()=>{
                index = 1;
                moveSlider(index);
                addTransition(0);
            }, 300);
        }
    }
}



