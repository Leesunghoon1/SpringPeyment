console.log('js 연결됨');

//댓글 추가
let cmtPostBtn=document.getElementById('cmtPostBtn');

async function postCommentToServer(cmtData)
{
    try {
        const url='/reviewcmt/post';
        const config={
            method:'post',
            headers:{
                'content-type':'application/json; charset=utf-8'
            },
            body:JSON.stringify(cmtData)
        };
        const resp=await fetch(url,config);
        const result=await resp.json();
        return result;
    } catch (error) {
        console.log(error);
    }
}

cmtPostBtn.addEventListener('click', (e)=>{
    let cmtTextVal=document.getElementById('cmtText').value;
    let cmtWriterVal=document.getElementById('cmtWriter').innerText;

    let cmtData={
        rvNo:rnoVal,
        rcContent:cmtTextVal,
        rcWriter:cmtWriterVal
    };
    cmtTextVal.innerText='';
    postCommentToServer(cmtData).then(result=>{
        if(result==1){
            alert('댓글 등록 성공');
            getCommentList(rnoVal);
        }
    })
})

// 댓글 리스트 뿌려주는 영역

async function spreadCommentListFromServer(rvNo)
{
    try {
        const resp=await fetch('/reviewcmt/'+rvNo);
        const result=await resp.json();
        return result;
    } catch (error) {
        console.log(error);
    }
}
function getCommentList(rvNo)
{
    spreadCommentListFromServer(rvNo).then(result=>{
        console.log(result);
        let ReviewCmtArea=document.getElementById('ReviewCmtArea');
        ReviewCmtArea.innerHTML='';
        if(result.length>0)
        {
            for(let i=0;i<result.length;i++)
            {
                let str=`<ul>`;
                str+=`<li><input type="text" value="${result[i].rcNo}" id="cmtModNo" readonly="readonly"></li>`;
                str+=`<li><input type="text" value="${result[i].rcWriter}" id="cmtModWriter" readonly="readonly"></li>`;
                str+=`<li><input type="text" value="${result[i].rcContent}" id="cmtModText"></li>`;
                str+=`<li>${result[i].rcRegAt}</li>`;
                str+=`<li><button type="button" class="cmtModBtn" data-rcno="${result[i].rcNo}">수정</button></li>`;
                str+=`<li><button type="button" class="cmtDelBtn" data-rcno="${result[i].rcNo}">삭제</button></li>`;
                str+=`</ul>`;
                ReviewCmtArea.innerHTML+=str;
            }
        }
        else
        {
            let str=`<ul><li>Comment List Empty</li></ul>`;
            ReviewCmtArea.innerHTML=str;
        }
    })
}

async function DeleteComment(rcNo)
{
    try {
        const url="/reviewcmt/"+rcNo;
        const config={
            method:'delete'
        };
        const resp=await fetch(url,config);
        const result=await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}

async function ModifyComment(cmtData)
{
    try {
        const url="/reviewcmt/"+cmtData.rcNo;
        const config={
            method:'put',
            headers:{
                'content-type':'application/json; charset=utf-8'
            },
            body:JSON.stringify(cmtData)
        };
        const resp=await fetch(url,config);
        const result=await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}

document.addEventListener('click',(e)=>{
    console.log(e.target);
    if(e.target.classList.contains('cmtDelBtn'))
    {
        let li=e.target.closest('button');
        console.log(li);
        let rcno=li.dataset.rcno;
        console.log(rcno);
        DeleteComment(rcno).then(result=>{
            if(result==1){
                alert('삭제성공');
                getCommentList(rnoVal);
            }
                
        })
    }
    else if(e.target.classList.contains('cmtModBtn'))
    {
        let cmtModNo=document.getElementById('cmtModNo').value;
        let cmtModText=document.getElementById('cmtModText').value;

        let cmtData={
            rcNo:cmtModNo,
            rcContent:cmtModText
        };
        ModifyComment(cmtData).then(result=>{
            if(result==1)
                alert('수정 성공');
        })

    }
})