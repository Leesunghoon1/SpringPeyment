/**
 * 
 */
let checkbox = document.querySelectorAll(".all-check");
let icon = document.getElementById("icon-check");
let select = document.querySelectorAll(".select-check");


icon.addEventListener('click',()=>{
    if(icon.classList.contains('checked')){
        for(let i=0; i<checkbox.length; i++){
            checkbox[i].classList.remove('checked');
        }
    }else{
        for(let i=0; i<checkbox.length; i++){
            checkbox[i].classList.add('checked');
        }
    }
})

for(let i=0; i<select.length; i++){
    select[i].addEventListener('click', ()=>{
        if(select[i].classList.contains('checked')){
            select[i].classList.remove('checked');
        }else{
            select[i].classList.add('checked');
        }
    })
}


document.getElementById('reservation-btn').addEventListener('click',()=>{
    
    let aBtn = document.getElementById('reservation-btn-a');

    let checkBtn1 = document.getElementById('check-btn1');
    let checkBtn2 = document.getElementById('check-btn2');
    let checkBtn3 = document.getElementById('check-btn3');
    let checkBtn4 = document.getElementById('check-btn4');
    let checkBtn5 = document.getElementById('check-btn5');

    if(!checkBtn1.classList.contains('checked')|| !checkBtn2.classList.contains('checked')
    || !checkBtn3.classList.contains('checked')|| !checkBtn4.classList.contains('checked')|| !checkBtn5.classList.contains('checked')){
        alert("약관을 동의해주세요");
    }else{
        aBtn.href = "/";
    }
})


let peplecount = document.getElementById("peple-input"); // 인원수
let reservationPrice = document.getElementById("reservation-price"); // 변동수
let packagePrice = document.getElementById("package-price"); //패키지 가격
document.addEventListener('click',(e)=>{

    if(e.target.id == "minus-btn"){
        if(peplecount.value == 0){
            let minus = document.getElementById("minus-btn").style.disabled='disabled'
        }else{
            peplecount.value = parseInt(peplecount.value)-1;
            reservationPrice.value = parseInt(peplecount.value)*parseInt(packagePrice.value);
        }
    }else if(e.target.id == "plus-btn"){
        peplecount.value = parseInt(peplecount.value)+1;
        reservationPrice.value = parseInt(peplecount.value)*parseInt(packagePrice.value);
    }
})