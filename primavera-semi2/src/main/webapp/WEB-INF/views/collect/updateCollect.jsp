<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="UTF-8">

				<link rel="stylesheet" href="/resources/css/reset.css" />
				<link href="../../resources/css/header.css" rel="stylesheet" type="text/css">

				<link href="../../resources/css/collect/viewCollect.css" rel="stylesheet" type="text/css">
				<script src="https://kit.fontawesome.com/cbb1359000.js" crossorigin="anonymous"></script>
				<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js" defer>
				</script>
				<script src="../../../resources/js/registerCollectDaum.js"></script>
				<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
					type="text/css" />
				<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
				<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
				<style>
					.contents>span {
						color: red;
						font-size: 0.7rem;
						position: absolute;
						left: 305px;
						top: 0px;
						font-weight: bold;
					}

					input {
						margin-top: 8px;
						font-family: "Cafe24Oneprettynight";
						font-weight: bold;
						height: 23px;
					}

					input#roadAddress,
					input#detailAddress {
						width: 70%;
					}

					.session {
						display: flex;
						flex-direction: column;
						align-items: center;
					}

					textarea {
						font-family: "Cafe24Oneprettynight";
						font-weight: bold;
						margin-top: 8px;
						width: 85%;
						resize: none;
					}

					textarea#doorPwd {
						height: 25px;
					}

					textarea#request {
						height: 55px;
					}

					.tabs .tab-header>div:hover,
					.tabs .tab-header>div.active {
						color: #00acee;
					}

					#viewTitle {
						position: absolute;
						top: 256px;
						left: 630px;
						font-size: 1.7rem;
						font-weight: bold;
					}

					button#updateBtn {
						--background: #00acee;
					}
				</style>
				<title>Insert title here</title>
			</head>
			<div class="header-blackbox"></div>
			<header>
				<nav>
					<a href="/">Primavera</a>
				</nav>
				<nav>
					<a href="mainMap">Store</a>
					<a href="Guide">Guide</a>
					<a href="collectPage">PickUp</a>
					<a href="/notice/list">Board</a>
					<span>
						<a href="/review/list">Review</a>
						<a href="listQna">Q & A</a>
						<a href="/notice/list">Notice</a>
					</span>
					<a href="myPage"><i class="fa-regular fa-user" id="mypage"></i></a>
				</nav>
			</header>
			<!-- -----------------------------------main----------------------------- -->
			<h3 id="viewTitle">신청 정보 수정</h3>

			<body>
				<!-- 내용 -->
				<div id="contents">
					<form action="updateCollect" method="post" id="update" name="update" onsubmit="return validate()">
						<div class="tabs">
							<div class="tab-header">
								<div class="active">
									<i class="fa-solid fa-user"></i> 아이디, 이름, 전화번호
								</div>
								<div>
									<i class="fa-solid fa-location-dot"></i> 주소
								</div>
								<div>
									<i class="fa-regular fa-clipboard"></i> 수거일, 수거 신청 무게
								</div>
								<div>
									<i class="fa fa-envelope"></i> 공동 현관 비밀번호, 요청사항
								</div>
							</div>
							<div class="tab-indicator"></div> <!-- header click bar -->
							<div class="tab-content">

								<div class="active contents">
									<i class="fa-solid fa-user"></i>
									<span>* 수정 불가 항목입니다.</span>
									<session id="user">
										<session class="session">
											<input type="hidden" name="orderNum" id="orderNum"
												value="${collect.orderNum}" readonly />
											<h2>아이디</h2>
											<input type="hidden" name="id" id="id" value="${collect.id}" readonly />
											<p>${collect.id}</p>
											<h2 class="m_top">이름</h2>
											<input type="hidden" name="name" id="name" value="${collect.name}"
												readonly />
											<p>${collect.name}</p>
										</session>
										<session>
											<h2>전화번호</h2>
											<input type="hidden" name="phone" id="phone" value="${collect.phone}"
												readonly />
											<p>${collect.phone}</p>
										</session>

									</session>
								</div>

								<div class="contents">
									<i class="fa-solid fa-location-dot"></i>
									<session id="user" style="flex-direction:column">
										<session>
											<h2>우편번호</h2>
											<input type="text" name="postCode" id="postCode" placeholder="우편번호"
												size="15" value="${collect.postCode}" />
											<input type="button" onclick="daumPostCode()" value="우편번호 찾기" />
										</session>
										<session class="session">

											<h2 style="margin-top : 15px">주소</h2>
											<input type="text" name="roadAddress" id="roadAddress" placeholder="주소"
												size="40" value="${collect.roadAddress}" />
											<h2 style="margin-top : 19px">상세주소</h2>
											<input type="text" name="detailAddress" id="detailAddress"
												placeholder="상세 주소" size="40" value="${collect.detailAddress}" />
										</session>
									</session>

								</div>

								<div class="contents">
									<i class="fa-regular fa-clipboard"></i>
									<h2>수거일</h2>
									<input type="text" name="collectionDate" id="collectionDate"
										value="${collect.collectionDate}" />
									<h2 class="m_top">수거 신청 무게</h2>
									<input type="number" name="kg" id="kg" placeholder="5~20kg 신청 가능" min="5" max="20"
										value="${collect.kg}" />

								</div>

								<div class="contents">
									<i class="fa fa-envelope"></i>
									<h2>공동 현관 비밀번호</h2>
									<c:choose>
										<c:when test="${collect.doorPwd == ''}">
											<textarea name="doorPwd" id="doorPwd" cols="50" rows="2"
												placeholder="미기입"></textarea>
										</c:when>
										<c:otherwise>
											<textarea name="doorPwd" id="doorPwd" cols="50" rows="2"
												placeholder="${collect.doorPwd}"></textarea>
										</c:otherwise>
									</c:choose>
									<h2 style="margin-top:20px;">요청사항</h2>
									<c:choose>
										<c:when test="${collect.request == ''}">
											<textarea name="request" id="request" cols="40" rows="10"
												placeholder="미기입"></textarea>
										</c:when>
										<c:otherwise>
											<textarea name="request" id="request" cols="40" rows="10"
												placeholder="${collect.request}"></textarea>
										</c:otherwise>
									</c:choose>
								</div>

							</div>
						</div>
						<!-- 버튼 -->
						<div id="btn">
							<div class="button-list">
								<button type="submit" id="updateBtn">수정 완료</button>
								<button type="button" class="reverse dark"
									onclick="location.href='/viewCollect?orderNum=${collect.orderNum}';">
									수정 취소
								</button>
							</div>

							<!-- dribbble -->
							<a class="dribbble" href="https://dribbble.com/shots/7441241-Button-Hover-Effects"
								target="_blank">
								<img src="https://cdn.dribbble.com/assets/dribbble-ball-mark-2bd45f09c2fb58dbbfb44766d5d1d07c5a12972d602ef8b32204d28fa3dda554.svg"
									alt="">
							</a>
						</div>
					</form>
				</div>
				<!-- 내용 -->
				<script src="../../../resources/js/collect/viewCollect.js"></script>
				<script>
					function validate() {
						let f = document.update;

						if (f.postCode.value == '') {
							f.postCode.focus();
							alert("우편 번호를 입력해주세요");
							return false;
						} else if (f.roadAddress.value == '') {
							f.roadAddress.focus();
							alert("주소를 입력해주세요");
							return false;
						} else if (f.detailAddress.value == '') {
							f.detailAddress.focus();
							alert("상세 주소를 입력해주세요");
							return false;
						} else if (f.collectionDate.value == '') {
							alert("수거일을 입력해주세요");
							return false;
						} else if (f.kg.value == '') {
							f.kg.focus();
							alert("수거 신청 무게를 입력해주세요");
							return false;
						} alert("신청 정보 수정 성공하였습니다.");
						return true;
					}




					$(function () {

						$("#collectionDate").datepicker({
							dateFormat: 'yy-mm-dd',
							minDate: 0 + "2D",
							maxDate: new Date('2025-12-31'),
							changeMonth: true,
							changeYear: true,
							nextText: '다음 달',
							prevText: '이전 달'
						});

					});
				</script>
			</body>

			</html>