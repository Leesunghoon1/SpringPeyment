/**
 * 
 */

console.log("product list in!");


async function imageFromServer(){
    try {
        
        const resp = await fetch("/product/image");
        const result = await resp.json();
        return result;
        
    } catch (error) {
        console.log(error);
    }
}

function getImageList(){
    imageFromServer().then(result=>{
        console.log(result);
        for(let i=0; i<result.length; i++){
            

            let forImg = `imgZone${result[i].pdNo}`;               
            let imgZone = document.getElementById(forImg);
            let imgDiv = `<img class="listImg" src="/product_upload/${result[i].pfSaveDir.replace(/[\\]/g,'/')+'/'+result[i].pfUuid+'_'+result[i].pfName}" alt="그림없음">`;
            imgZone.innerHTML += imgDiv;
        }


    })

}

function arrowUpDown(){
    document.getElementById('arrow').innerHTML = "expand_more";
}

// document.getElementById('placeAll').addEventListener('click',()=>{
//     document.getElementById('placeDiv').style.display = "block";
//     document.getElementById('arrow').innerHTML= "expand_less";
// });


document.addEventListener('click',(e)=>{
    
    if(e.target.id == "placeAll" || e.target.id == "placeDiv" || e.target.id == "checkBox"){
        document.getElementById('placeDiv').style.display = "block";
        document.getElementById('arrow').innerHTML= "expand_less";
    }else{
        console.log(e.target);
        document.getElementById('placeDiv').style.display = "none";
        document.getElementById('arrow').innerHTML= "expand_more";
    }

    if(e.target.id == "testText"){
        document.getElementById('placeAll').innerHTML = "";

        let text = document.getElementById('testText').innerHTML;
        document.getElementById('placeAll').innerHTML = text;
    }
})
