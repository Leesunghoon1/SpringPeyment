console.log(pldto);
console.log(userA);
console.log(userC);
console.log(pppp);

const userS = userA.match(/id=([a-zA-Z0-9]+),\s*pwd=([^,]+),\s*name=([^,]+),\s*age=(\d+),\s*address=([^,]+),\s*email=([^,]+),\s*phoneNumber=([^,]+),\s*authList=([^,]+)+/);

const packageA = pldto.match(/pkNo=(\d+), pkName=([^,]+), pkPrice=(\d+), pkContinent=([^,]+), pkContent=([^)]+)/);

const regex = pppp.match(/point=(\d+), grade=([^}]+)/);

const point = parseInt(regex[1]);
const grade = regex[2];

const pkNo = parseInt(packageA[1]);
const pkName = packageA[2];
const pkPrice = parseInt(packageA[3]);
const pkContinent = packageA[4];
const pkContent = packageA[5];
let pkPriceValue;

const discountedPriceElement = document.querySelectorAll('.discounted-price-value');

const discountedPointElement = document.querySelector('.discounted-point-value');

const discountedPoint2Element = document.querySelector('.discounted-point2-value');

const userCount = userC;

//포인트 쓰는 값
var enteredPoints = 0;

console.log("aaa" + enteredPoints);

let totalPrice = 0;

let discountedPrice = 0; // 초기값을 0으로 할당


    // matches 배열에서 필요한 정보 추출
    const id = userS[1];
    const pwd = userS[2];
    const Username = userS[3];
    const age = parseInt(userS[4]);
    const address = userS[5];
    const email = userS[6];
    const phoneNumber = userS[7];

var selectedValue;
// matches 배열에서 필요한 정보 추출

console.log(id);



function applyCount() {
    pkPriceValue = pkPrice * userCount;
  discountedPriceElement.forEach(e =>{
    e.innerHTML = `${pkPriceValue}`;
  })
  
  console.log(pkPriceValue)
}


function applyCoupon() {
  const couponInput = document.getElementById('coupon-input');
  const pkPriceElement = pkPriceValue; // pkPriceElement 정의
  const discountedPriceElement2 = document.getElementById('discounted-price-value2'); 
  
    // pkPriceElement이 null이면 함수 종료
    if (!pkPriceElement) {
        console.error('쿠폰 입력해주세요');
        return;
    }

  const couponCode = couponInput.value.trim().toLowerCase();


    let discount = 0;

    switch (couponCode) {
        case 'coupon10':
            discount = 10;
            break;
        case 'coupon20':
            discount = 20;
            break;
        // 여기에 필요한 쿠폰을 추가하세요.
        default:
            alert('Invalid Coupon Code');
            return; // 함수 종료
    }
	
    const discountedPrice = pkPriceValue - (pkPriceValue * (discount / 100));
	  pkPriceValue = discountedPrice;
    // discountedPrice를 pkPriceElement의 innerText로 설정
    
    pkPriceElement.innerText = discountedPrice.toFixed(2);
    discountedPriceElement.innerText = discountedPrice;


    discountedPriceElement2.innerText = discountedPrice;
    
}





 document.addEventListener("DOMContentLoaded", function() {
    var optionList = document.getElementById("paymentMethod");
    
    optionList.addEventListener("click", function(event) {
      selectedValue = event.target.getAttribute("value");
      console.log("Selected Value:", selectedValue);

    });
  });



  function requestPay() {
    // IMP.request_pay(param, callback) 결제창 호출
    var uid = '';
    IMP.init("imp76450478");

    if(pkPriceValue == null) {
      pkPriceValue = totalPrice;
    }

    IMP.request_pay({ // param

        pg: selectedValue,
        pay_method: "089",
        merchant_uid: paymentUuid(), //가맹점 주문번호 (아임포트를 사용하는 가맹점에서 중복되지 않은 임의의 문자열을 입력)
        name: pkName,
      	amount: pkPriceValue,
	    	buyer_email : email,
    		buyer_name : Username,
	    	buyer_tel : phoneNumber,
    		buyer_postcode : '상세주소',
        user_count : userCount
    }, function (rsp) { // callback
        if (rsp.success) { // 결제 성공 시: 결제 승인 또는 가상계좌 발급에 성공한 경우
            uid = rsp.imp_uid;
            // 결제검증
            $.ajax({
                url: '/peyment/peverifyIamport/' + rsp.imp_uid,
                type: 'post',
                dataType: 'json',
                contentType: 'application/json'
            }).done(function(data) {
                // 결제를 요청했던 금액과 실제 결제된 금액이 같으면 해당 주문건의 결제가 정상적으로 완료된 것으로 간주한다.
                console.log(data);
                if (pkPriceValue == data.response.amount) {
                    // jQuery로 HTTP 요청
                    // 주문정보 생성 및 테이블에 저장 
                    // @@ 주문정보는 상품 개수만큼 생성되어야 해서 상품 개수만큼 반복문을 돌린다
                    // 이때 order code는 모두 같아야 한다.          
		        	
                        // 데이터를 json으로 보내기 위해 바꿔준다.
                        data = JSON.stringify({
                            "orderNum" : rsp.merchant_uid,
                            "pkNo" : pkNo, //상품번호
                            "id" : id, // 회원번호
                            "productName" : rsp.name,
                            "orderDate" : new Date().getTime(),
                            "totalPrice" : rsp.paid_amount,
                            "impUid" : rsp.imp_uid,
                            "userCount" : userCount,
                        });
                        console.log(data);
					
                        $.ajax({
                            url: "/peyment/complete",
                            type: "POST",
                            dataType: 'json',
                            contentType: 'application/json',
                            data : data
                        })
                        .done(function(res) {
                            if (res > 0) {
                                console.log(res);
                                alert('주문정보 저장 성공')
                                createPayInfo(uid);
                            }
                            else {
                                console.log(data);
                                alert('주문정보 저장 실패');
                            }
                        })
                }
                else {
                    alert('결제 실패');
                }
            })
            } else {
                alert("결제에 실패하였습니다.","에러 내용: " +  rsp.error_msg,"error");
            }
        });
}



// uuid만들기
function paymentUuid(){
	const date = new Date();
	const year = date.getFullYear();
	const month = String(date.getMonth() + 1).padStart(2, "0");
	const day = String(date.getDate()).padStart(2, "0");
	
	let orderNum = year + month + day;
	for(let i=0;i<10;i++) {
		orderNum += Math.floor(Math.random() * 8);	
	}
	return orderNum;
}

function createPayInfo(uid) {
    // 결제정보 생성 및 테이블 저장 후 결제완료 페이지로 이동 
    console.log("시작");
    console.log(uid);
    $.ajax({
        type: 'get',
        url: '/peyment/pay_info',
        dataType: 'json',
        contentType: 'application/json',
        data: {
            'imp_uid': uid,
            'pkNo':pkNo,
            'enteredPoints' : enteredPoints
        },

        success: function(data) {
            
            var message = '결제 성공!\n결제완료 페이지로 이동합니다.';

        // 사용자에게 간단한 경고창 표시
            alert(message);


        window.location.replace('/peyment/complete?payNum=' + data);
            
        },
        error: function() {
            alert('결제정보 저장 통신 실패');
        }
    });
}



//셀렉트
const label = document.querySelector('.label');
const options = document.querySelectorAll('.optionItem');
const handleSelect = function(item) {
  label.innerHTML = item.textContent;
  label.parentNode.classList.remove('active');
}
options.forEach(function(option){
  option.addEventListener('click', function(){handleSelect(option)})
})

label.addEventListener('click', function(){
  if(label.parentNode.classList.contains('active')) {
    label.parentNode.classList.remove('active');
  } else {
    label.parentNode.classList.add('active');
  }
});

function applyPoint() {
    // 입력된 포인트 가져오기
    var couponInput = document.getElementById('point-input');
     enteredPoints = parseInt(couponInput.value);

    // 최종 가격 가져오기 (예시로 100,000으로 설정)
    var PointPrice = pkPriceValue; // 실제 로직에 맞게 수정하세요

    // 포인트 할인 로직 적용
    if (!isNaN(enteredPoints) && enteredPoints > 0 && enteredPoints < point) {
        // 최종 가격에서 포인트 할인 적용
        discountedPrice = Math.max(0, PointPrice - enteredPoints);

        // 결과 출력 (예시로 콘솔에 출력)
        console.log("포인트 할인 적용 전 가격: " + PointPrice);
        console.log("포인트 할인 후 가격: " + discountedPrice);

        discountedPointElement.innerText = discountedPrice;

        discountedPoint2Element.innerText = enteredPoints;


        // 여기에서 할인된 가격을 사용하거나, 화면에 표시하거나, 서버로 전송하는 등의 로직을 추가할 수 있습니다.
    } else {
        alert("올바른 포인트를 입력하세요.");
    }
}

// 함수 밖에서 discountedPrice 사용 가능
console.log("함수 밖에서 discountedPrice 사용: " + discountedPrice);