function validate() {
	let f = document.pickUp;
	
	if (f.name.value == '') {
	  	f.name.focus();
        return false;
	} else if(f.phone.value == ''){
	    f.phone.focus();
	    return false;
	} else if(f.postCode.value == ''){
	    f.postCode.focus();
	    return false;
	}else if(f.roadAddress.value == ''){
	    f.roadAddress.focus();
	    return false;
	}else if(f.detailAddress.value == ''){
	    f.detailAddress.focus();
	    return false;
	}else if(f.collectionDate.value==''){
	    f.collectionDate.focus();
	    return false;
	}else if(f.kg.value==''){
	    f.kg.focus();
	    return false;
	}else if(!f.agree.checked){
		alert("약관 내용에 동의해주세요.");
	    return false;
	}
	    alert("수거 신청에 성공하였습니다.\n\n[알림] 진행 상황이 '신청 확인'이 된 이후에는 신청 수정 및 신청 취소가 불가합니다.\n(신청별 진행상황은 '마이페이지 > 진행 상황'에서 확인해주세요.)");
	    return true; 
}
	      

var target = document.querySelectorAll('.btn_open');
var btnPopClose = document.querySelectorAll('.pop_wrap .btn_close');
var targetID;

for (var i = 0; i < target.length; i++) {
	target[i].addEventListener('click', function() {
			targetID = this.getAttribute('href');
			document.querySelector(targetID).style.visibility = 'visible';
	});
}

for (var j = 0; j < target.length; j++) {
	btnPopClose[j].addEventListener('click', function() {
		this.parentNode.parentNode.style.visibility = 'hidden';
	});
}

$(function(){
		
		$("#collectionDate").datepicker({
			 dateFormat: 'yy-mm-dd',
			 minDate: 0 + "2D",
			 maxDate: new Date('2025-12-31'),
			 changeMonth:true,
			 changeYear:true,
			 nextText : '다음 달',
			 prevText : '이전 달'
		});	
		
	});
