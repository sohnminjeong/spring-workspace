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
			<h3 id="viewTitle">상세 신청 정보</h3>

			<body>
				<!-- 내용 -->

				<div id="contents">
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

								<session id="user">
									<session class="session">
										<h2>아이디</h2>
										<p>${collect.id}</p>
										<h2 class="m_top">이름</h2>
										<p>${collect.name}</p>
									</session>
									<session>
										<h2>전화번호</h2>
										<p>${collect.phone}</p>
									</session>
								</session>
							</div>

							<div class="contents">
								<i class="fa-solid fa-location-dot"></i>

								<session id="user">
									<session>
										<h2>우편번호</h2>
										<p>${collect.postCode}</p>
									</session>
									<session class="session">
										<h2>주소</h2>
										<p>${collect.roadAddress}</p>
										<h2 class="m_top">상세주소</h2>
										<p>${collect.detailAddress}</p>
									</session>
								</session>

							</div>

							<div class="contents">
								<i class="fa-regular fa-clipboard"></i>
								<h2>수거일</h2>
								<p>${collect.collectionDate}</p>
								<h2 class="m_top">수거 신청 무게</h2>
								<p>${collect.kg} kg</p>

							</div>

							<div class="contents">
								<i class="fa fa-envelope"></i>
								<h2>공동 현관 비밀번호</h2>
								<c:choose>
									<c:when test="${collect.doorPwd == ''}">
										<p>*미기입</p>
									</c:when>
									<c:otherwise>
										<p>${collect.doorPwd}</p>
									</c:otherwise>
								</c:choose>
								<h2 class="m_top">요청사항</h2>
								<c:choose>
									<c:when test="${collect.request == ''}">
										<p>*미기입</p>
									</c:when>
									<c:otherwise>
										<p>${collect.request}</p>
									</c:otherwise>
								</c:choose>
							</div>

						</div>
					</div>
					<!-- 버튼 -->
					<c:choose>
						<c:when test="${collect.prog eq '신청완료'}">
							<div id="btn">
								<div class="button-list">
									<button id="updateBtn"
										onclick="location.href='/updatePage?orderNum=${collect.orderNum}';">신청 사항
										수정</button>
									<button class="reverse dark"
										onclick="location.href='/deleteCollect?orderNum=${collect.orderNum}';">
										신청 취소
									</button>
								</div>

								<!-- dribbble -->
								<a class="dribbble" href="https://dribbble.com/shots/7441241-Button-Hover-Effects"
									target="_blank">
									<img src="https://cdn.dribbble.com/assets/dribbble-ball-mark-2bd45f09c2fb58dbbfb44766d5d1d07c5a12972d602ef8b32204d28fa3dda554.svg"
										alt="">
								</a>
							</div>
						</c:when>
					</c:choose>
				</div>

				<!-- 내용 -->
				<script src="../../../resources/js/collect/viewCollect.js"></script>

			</body>

			</html>