const matches = pkVo.match(/payNum=(\d+), id=([a-zA-Z0-9]+), orderNum=(\d+), payMethod=([a-zA-Z]+), productName=([가-힣]+), payDate=([a-zA-Z0-9]+), payAmount=(\d+), pkNo=(\d+)/);

// matches 배열에서 필요한 정보 추출
const payNum = matches[1];
const id = matches[2];
const orderNum = matches[3];
const payMethod = matches[4];
const productName = matches[5];
const payDate = matches[6];
const payAmount = matches[7];
const pkNo = matches[8];

console.log("payNum:", payNum);
console.log("id:", id);
console.log("orderNum:", orderNum);
console.log("payMethod:", payMethod);
console.log("productName:", productName);
console.log("payDate:", payDate);
console.log("payAmount:", payAmount);

document.addEventListener("DOMContentLoaded", function () {
  // payMentCancel 클래스를 가진 모든 요소를 찾아 payMentCancelButtons에 할당합니다.
  const payMentCancelButtons = document.querySelectorAll('.payMentCancel');

  // payMentCancelButtons에 대한 forEach 루프를 사용하여 각각에 이벤트 리스너를 추가합니다.
  payMentCancelButtons.forEach(function(button) {
      button.addEventListener("click", function () {
          console.log(orderNum);

          const userConfirmed = confirm("주문을 취소하시겠습니까?\n취소하면 되돌릴 수 없습니다.!");

          if (userConfirmed) {
              alert("주문을 취소하였습니다!");
              const xhttp = new XMLHttpRequest();

              xhttp.open("POST", "/peyment/orderCancle");

              xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

          xhttp.send("orderNum=" + orderNum);

              xhttp.onreadystatechange = function () {
                  if (this.readyState == 4 && this.status == 200) {
                      let result1 = xhttp.responseText.trim();
                      console.log(result1);

                      if (result1 == 1) {
                          location.replace('/package/list');
                      } else {
                          alert("이미 취소된 주문이거나 없는 주문번호입니다.");
                      }
                  }
              }
          } else {
              alert("보류하였습니다!");
          }
      });
  });
});


function cancelPay(){
		
		
        const xhttp = new XMLHttpRequest;

        xhttp.open("POST","../admin/orderCancle")

        
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");


        xhttp.send("orderNum="+orderNum);

        xhttp.onreadystatechange=function(){
            if(this.readyState==4 && this.status==200){
               let result1 = xhttp.responseText.trim();
               console.log(result1);
                   if(result1==1){
                       console.log("삭제성공")
               
                   } else{
                       console.log("삭제실패");
                   }
            } 
        }
 }