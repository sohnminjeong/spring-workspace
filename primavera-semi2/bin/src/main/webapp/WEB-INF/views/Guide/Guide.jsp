<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/reset.css" />
<link rel="stylesheet" href="../../../resources/css/Guide/Guide.css" />
<script src="https://kit.fontawesome.com/cbb1359000.js"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
 <div class="header-blackbox"></div>
    <header>
      <nav>
        <a href="/">Primavera</a>
      </nav>
      <nav>
        <a href="/mainMap">Store</a> <a href="/Guide">Guide</a>
        <a href="collectPage">PickUp</a> <a href="/notice/list">Board</a>
        <span>
          <a href="/review/list">Review</a> <a href="listQna">Q & A</a>
          <a href="/notice/list">Notice</a>
        </span>
        <a href="myPage"><i class="fa-regular fa-user" id="mypage"></i></a>
      </nav>
    </header>
    <section class="section1">
      <img src="../resources/images/Main back.jpg" alt="" />
      <h1 class="h2">Guide</h1>
    </section>
    <div class="section">
      <ul class="case-study-wrapper">
        <li class="case-study-name">
          <a href="#" class="hover-target">Apply for collection</a>
        </li>
        <li class="case-study-name">
          <a href="#" class="hover-target">clothing pick-up</a>
        </li>
        <li class="case-study-name">
          <a href="#" class="hover-target">Calculation inspection amount</a>
        </li>
        <li class="case-study-name">
          <a href="#" class="hover-target">the last page</a>
        </li>
      </ul>
      <ul class="case-study-images">
        <li>
          <div class="img-hero-background"></div>
          <div class="dark-over-hero"></div>
          <div class="hero-number-back">01</div>
          <div class="case-study-title"></div>
          <div class="content" id="text1">
            <img src="../../../resources/images/Guide1_front.jpg" alt="" />
            <p>
              수거 신청하기 웹 사이트를 통해 간편하게 의류 수거 신청을 할 수
              있습니다.
              <br /><br /><br />
              사이트 내 [상단바 > PickUp] 또는 [메인 첫 페이지 > "Pick Up"]을
              통해 신청이 가능합니다!<br /><br /><br />
              수거 신청 주소가 회원 정보와 다른 경우 신청 폼에서 변경
              가능합니다.<br /><br /><br />
              "수거일"에 수거를 원하는 일정을 선택해 주세요.<br /><br /><br />
              다음으로 "수거 신청 무게" 항목에 수거 신청할 의류의 무게를 선택해
              주세요.<br /><br /><br />
              * 프리마베라의 수거 서비스는 5kg 이상부터 20kg 이하인 경우에만
              이용 가능합니다!<br /><br /><br />
              "수거 신청 하기" 버튼을 누르면 신청이 완료됩니다.<br /><br />
            </p>
          </div>
        </li>
        <li>
          <div class="img-hero-background"></div>
          <div class="hero-number-back">02</div>

          <div class="content" id="text2">
            <img src="../../../resources/images/Guide2_front.jpg" alt="" />
            <p>
              수거 신청한 날짜에 문 앞에 수거품을 내어주시면 프리마베라 픽업
              팀이 직접 비대면 수거합니다.<br /><br /><br /><br />
              당일 예약된 주소지들을 기반으로 이동하므로 픽업 시간은 상황에 따라
              다릅니다.<br /><br /><br /><br />
              약속된 수거일 오전 8시 이전까지 수거품을 문앞에 놓아주시길
              부탁드립니다! <br /><br /><br /><br />수거품 픽업 시 신청 폼에
              입력하신 번호로 수거 확인 메세지를 발송합니다. (수거 완료)
            </p>
          </div>
        </li>
        <li>
          <div class="img-hero-background"></div>
          <div class="hero-number-back">03</div>

          <div class="content" id="text3">
            <img src="../../../resources/images/Guide3_front.jpg" alt="" />
            <p>
              당일 예약된 수거가 완료되면 무게 측정이 진행됩니다.<br /><br /><br /><br />
              무게 측정과 검수가 완료되면 측정 무게와 입금 예정 금액을 회원
              번호로 송부해드립니다.<br /><br /><br /><br />
              검수 결과에 따라 입금 예정 금액은 [myPage>진행상황]에 입력되어있는
              금액과 상이할 수 있습니다.<br /><br /><br /><br />
              입금 진행 입금 예정 금액은 kg당 400원의 매입 단가를 기준으로
              책정됩니다.<br /><br /><br /><br />
              매입 금액 산정이 완료되면 회원가입 시 입력한 계좌로 산정 금액을
              입금해드립니다.<br /><br /><br /><br />
            </p>
          </div>
        </li>
        <li>
          <div class="img-hero-background"></div>
          <div class="hero-number-back">04</div>

          <div class="content" id="text4">
            <img src="../../../resources/images/Guide4_front.jpg" alt="" />
            <p>
              수거한 의류들을 업사이클하여 만든 제품들을 오프라인 스토어를 통해
              직접 만나볼 수 있습니다!<br />
              <a href="/mainMap">> Off line store</a>
            </p>
          </div>
        </li>
      </ul>
    </div>
    <div class="cursor" id="cursor"></div>
    <div class="cursor2" id="cursor2"></div>
    <div class="cursor3" id="cursor3"></div>

    <script src="../../../resources/js/Guide/Guide.js"></script>
</body>
</html>