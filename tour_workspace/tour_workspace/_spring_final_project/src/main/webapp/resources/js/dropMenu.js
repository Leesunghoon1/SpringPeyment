
let header = document.querySelector('header'), // 헤더
    mainMenu = document.querySelectorAll('.drop-menu > dd'), // 메인 메뉴
    subMenu = document.querySelectorAll('.sub-menu'), // 서브 메뉴
    headerHeight = header.offsetHeight, // 기본(초기) 헤더 높이값 변수
    subMenuHeight = 0; // 서브메뉴 높이값 변수

    console.log("headerHeight >> "+ headerHeight);
    console.log(mainMenu);
    console.log(subMenu);
    
    // 서브 메뉴 중 가장 높은 값의 height 값 구하기
    // for(let i = 0; i < subMenu.length; i++){
    //     if(subMenuHeight < subMenu[i].offsetHeight){
    //         subMenuHeight = subMenu[i].offsetHeight;
    //     }
    // }
            



    // 메인 메뉴 중 마우스 오버시 이벤트 발생
    for(let i = 0; i < mainMenu.length; i++){
        mainMenu[i].addEventListener('mouseover', function(){
            this.querySelector('dl').style.display = 'block';
            subMenuHeight = this.querySelector('dl').offsetHeight;
            header.style.height = subMenuHeight + headerHeight + 20 + 'px';
            setTimeout(() =>{
                this.querySelector('dl').style.visibility='visible';
                this.querySelector('dl').style.transition='0.5s ease-in';
            }, 300);
            
            // header.style.height = headerHeight + subMenuHeight + 20 +'px';
        })
        mainMenu[i].addEventListener('mouseout', function(){
            header.style.height = headerHeight + "px";
            this.querySelector('dl').style.display = 'none';
            this.querySelector('dl').style.visibility='hidden';
        })
        
    }

