



function randomImage(){

    let randomNumber = Math.floor(Math.random()*100)+1;
    console.log('randomNumber >'+randomNumber);
}

let tripInfo = document.querySelectorAll(".trip-operation");

document.addEventListener('click',(e)=>{
    if(e.target.id == "roundTrip" || e.target.id==("oneWay")||e.target.id=="multipleSections"){
        e.target.classList.add('checked');
    }else if(e.target.classList.contains("checked")){
        e.target.classList.remove("checked");
    }
})