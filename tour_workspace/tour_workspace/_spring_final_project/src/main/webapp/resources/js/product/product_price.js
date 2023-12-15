/**
 * 
 */
let reservation = document.querySelector('.option-submit-button');
let peple = document.getElementById('pepleCnt');
let btn = document.querySelectorAll('.option-button');

    btn.forEach(e=>{
        e.addEventListener('click',()=>{
            console.log('peple-count >'+ peple.value);
        })
    })
