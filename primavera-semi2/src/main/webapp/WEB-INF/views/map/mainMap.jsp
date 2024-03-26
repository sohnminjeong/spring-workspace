<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
				<!DOCTYPE html>
				<html>

				<head>
					<meta charset="UTF-8">
					<title>지도</title>
					<link rel="stylesheet" href="../../../resources/css/reset.css" />
					<link rel="stylesheet" href="../../../resources/css/header.css" />
					<link rel="stylesheet" href="../../../resources/css/map/mainMap.css" />
					<link rel="stylesheet"
						href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
					<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
					<script src="https://kit.fontawesome.com/cbb1359000.js" crossorigin="anonymous"></script>
				</head>

				<body>
					<div class="header-blackbox"></div>
					<header>
						<nav>
							<a href="/">Primavera</a>
						</nav>
						<nav>
							<a href="mainMap">Store</a> <a href="Guide">Guide</a> <a href="collectPage">PickUp</a> <a
								href="/notice/list">Board</a> <span>
								<a href="/review/list">Review</a> <a href="listQna">Store</a> <a
									href="/notice/list">Notice</a>
							</span> <a href="myPage"><i class="fa-regular fa-user" id="mypage"></i></a>
						</nav>
					</header>
					<section id="top">
						<div class="blackbox"></div>
						<div class="top-content">
							<h2 id="topH2">Q&A</h2>
						</div>
					</section>

					<div id=contents>
						<div class="main">
							<div class="container">
								<h2 class="title" id="bag">Bag</h2>
								<div class="card text">
									<div class="imgBx">
										<img src="../../../resources/images/bag1.png">
									</div>
									<div class="contentBx">
										<h2>Frame Shoulder Bag</h2>
										<div class="size">
											<h3>인조 가죽 소재를 활용하여 업사이클링한 가죽 숄더 백</h3>
										</div>
										<div class="color">
											<p>
												* 내부 섹션 2개와 내부 포켓 3개 보유 <br> <br>
												* 탈부착 가능한 체인 스트랩<br> <br> * 접이식 플랩, 자석 스냅 버튼
											</p>
										</div>
									</div>
								</div>
							</div>
							<div class="container">
								<div class="card text">
									<div class="imgBx">
										<img src="../../../resources/images/bag2.png">
									</div>
									<div class="contentBx">
										<h2>Air Messenger Bag</h2>
										<div class="size">
											<h3>비닐 소재를 활용하여 업사이클링한<br> 메신저백</h3>
										</div>
										<div class="color">
											<p>
												* 데일리로 가볍게 착용가능한 화이트 컬러<br> <br> * 노트북
												수납 가능한 안전 포켓 <br> <br> * 플랩 안쪽 넉넉한 수납
											</p>
										</div>
									</div>
								</div>
							</div>
							<div class="container">
								<div class="card text">
									<div class="imgBx">
										<img src="../../../resources/images/bag3.png">
									</div>
									<div class="contentBx">
										<h2>Urban Tote Bag</h2>
										<div class="size">
											<h3>가죽과 린넨 소재를 활용해 업사이클링한 토트백</h3>
										</div>
										<div class="color">
											<p>
												* A5 노트 크기까지 수납 가능 <br> <br> * 토트, 숄더, 크로스백으로 사용 가능 <br>
												<br> * 열쇠고리 등을 부착할 수 있는 D링
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="main">
							<div class="container">
								<h2 class="title" id="clothes">Clothes</h2>
								<div class="card text1">
									<div class="imgBx clothes">
										<img src="../../../resources/images/clothes1.png">
									</div>
									<div class="contentBx">
										<h2>Vintage Zip-up Hoodie</h2>
										<div class="size">
											<h3>면 소재를 활용하여 업사이클링한 <br> 워싱 집업 후드</h3>
										</div>
										<div class="color">
											<p>
												* 전면 투웨이 집업 형태로 편안함 추구 <br> <br> * 집업 상단의 시그니처 포인트 자수
												디자인 <br> <br> * 빈티지 느낌의 차콜 컬러
											</p>
										</div>
									</div>
								</div>
							</div>
							<div class="container">
								<div class="card text1">
									<div class="imgBx clothes">
										<img src="../../../resources/images/clothes2.png">
									</div>
									<div class="contentBx">
										<h2>Loose Long Denim Pants</h2>
										<div class="size">
											<h3>데님 소재를 활용하여 업사이클링한 <br> 루스 핏 롱 데님 팬츠</h3>
										</div>
										<div class="color">
											<p>
												* 넉넉한 밑위 기장과 스트레이트 루즈 핏 <br> <br> * 깔끔한 밑단 <br> <br>
												* 인디고 컬러
											</p>
										</div>
									</div>
								</div>
							</div>
							<div class="container">
								<div class="card text1">
									<div class="imgBx clothes" id="modern">
										<img src="../../../resources/images/clothes3.png">
									</div>
									<div class="contentBx">
										<h2>Modern Hoodie</h2>
										<div class="size">
											<h3>면 소재를 활용하여 업사이클링한 후드티</h3>
										</div>
										<div class="color">
											<p>
												* 남/녀 공용 오버사이즈 스웨트 셔츠 실루엣 <br> <br> * 깔끔한 디자인의 페이디드 블랙
												컬러
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="main">
							<div class="container">
								<h2 class="title" id="wallet">Wallet</h2>
								<div class="card text2">
									<div class="imgBx">
										<img src="../../../resources/images/wallet1.png">
									</div>
									<div class="contentBx">
										<h2>Quilting Card Wallet</h2>
										<div class="size">
											<h3>가죽 소재를 활용하여 업사이클링한 <br> 퀄팅 카드 지갑</h3>
										</div>
										<div class="color">
											<p>
												* 아코디언 4단 분리 지갑 <br> <br> * 카드, 지폐, 동전, 명함 등 분리 수납 가능
												<br> <br> * 모던 블랙 컬러
											</p>
										</div>
									</div>
								</div>
							</div>
							<div class="container">
								<div class="card text2">
									<div class="imgBx">
										<img src="../../../resources/images/wallet2.png">
									</div>
									<div class="contentBx">
										<h2>Accordion Card Holder</h2>
										<div class="size">
											<h3>가죽 소재를 활용하여 업사이클링한 <br> 아코디언 카드 홀더</h3>
										</div>
										<div class="color">
											<p>
												* 카드 이탈 방지 가드 적용 <br> <br> * 최대 8장 카드 수납 가능 <br>
												<br> * 세이지 그린 컬러
											</p>
										</div>
									</div>
								</div>
							</div>
							<div class="container">
								<div class="card text2">
									<div class="imgBx">
										<img src="../../../resources/images/wallet3.png">
									</div>
									<div class="contentBx">
										<h2>Pink Edge Half-Wallet</h2>
										<div class="size">
											<h3>가죽 소재를 활용하여 업사이클링한 <br>반지갑</h3>
										</div>
										<div class="color">
											<p>
												* 생활 방수 가능한 멀티 반지갑 <br> <br> * 지폐 수납칸 1개, 지퍼칸 1개, 카드칸
												8개 구성 <br> <br> * 블랙 컬러에 핑크 엣지 코드 마감 포인트
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="main">
							<div class="container">
								<div id="map" style="width: 800px; height: 600px;"></div>
							</div>
						</div>
					</div>

					<script type="text/javascript"
						src="//dapi.kakao.com/v2/maps/sdk.js?appkey=04b7f22e5edf17d8f2ce411e6eb1f006"></script>
					<script>
						var mapContainer = document.getElementById('map'),
							mapOption = {
								center: new kakao.maps.LatLng(37.5519, 126.9918),
								level: 9
							};
						var map = new kakao.maps.Map(mapContainer, mapOption);
						var markers = [
							{
								position: new kakao.maps.LatLng(37.49781, 127.13338), content: '<div class="wrap">'
									+ '    <div class="info">'
									+ '        <div class="title">'
									+ '            프리마베라 1호점'
									+ '            '
									+ '        </div>'
									+ '        <div class="body">'
									+ '            <div class="img">'
									+ '                <img src="../../../resources/images/wallet.jpg" width="75" height="70">'
									+ '           </div>'
									+ '            <div class="desc">'
									+ '                <div class="ellipsis">서울특별시 송파구 동남로 238</div>'
									+ '                <div class="ellipsis1"><a href="https://map.kakao.com/link/to/프리마베라 1호점,37.49781, 127.13338" target="_blank">1호점 가는길</a></div>'
									+ '                <div>070-1312-1454</div>'
									+ '            </div>' + '        </div>' + '    </div>'
									+ '</div>'
							},
							{
								position: new kakao.maps.LatLng(37.594792, 127.001803), content: '<div class="wrap">'
									+ '    <div class="info">'
									+ '        <div class="title">'
									+ '            프리마베라 2호점'
									+ '            '
									+ '        </div>'
									+ '        <div class="body">'
									+ '            <div class="img">'
									+ '                <img src="../../../resources/images/clothes.jpg" width="75" height="70">'
									+ '           </div>'
									+ '            <div class="desc">'
									+ '                <div class="ellipsis">서울특별시 성북구 성북동 성북로</div>'
									+ '                <div class="ellipsis1"><a href="https://map.kakao.com/link/to/프리마베라 2호점,37.574524, 127.03965" target="_blank">2호점 가는길</a></div>'
									+ '                <div>070-1712-3764</div>'
									+ '            </div>' + '        </div>' + '    </div>'
									+ '</div>'
							},
							{
								position: new kakao.maps.LatLng(37.495472, 126.887536), content: '<div class="wrap">'
									+ '    <div class="info">'
									+ '        <div class="title">'
									+ '            프리마베라 3호점'
									+ '            '
									+ '        </div>'
									+ '        <div class="body">'
									+ '            <div class="img">'
									+ '                <img src="../../../resources/images/bag.jpg" width="75" height="70">'
									+ '           </div>'
									+ '            <div class="desc">'
									+ '                <div class="ellipsis">서울특별시 구로구 가마산로 245</div>'
									+ '                <div class="ellipsis1"><a href="https://map.kakao.com/link/to/프리마베라 3호점,37.495472, 126.887536" target="_blank">3호점 가는길</a></div>'
									+ '                <div>070-4512-1214</div>'
									+ '            </div>' + '        </div>' + '    </div>'
									+ '</div>'
							}
						];
						markers.forEach(function (markerInfo, index) {
							var marker = new kakao.maps.Marker({
								map: map,
								position: markerInfo.position
							});

							var overlay = new kakao.maps.CustomOverlay({
								content: markerInfo.content,
								map: map,
								position: marker.getPosition()
							});
							overlay.setMap(null);
							daum.maps.event.addListener(marker, 'mouseover', function () {
								overlay.setMap(map);
								setTimeout(function () { overlay.setMap(null); }, 5000);
							});

						});
						function closeOverlay(overlay) {
							overlay.setMap(null);
						}
						var zoomControl = new kakao.maps.ZoomControl();
						map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

					</script>
					<script>
						document.addEventListener("DOMContentLoaded", function () {
							var observer = new IntersectionObserver(function (entries) {
								entries.forEach(entry => {
									if (entry.isIntersecting) {
										entry.target.classList.add('animate');
									}
								});
							});

							document.querySelectorAll('.image-text-wrapper').forEach(item => {
								observer.observe(item);
							});

							var mapElement = document.querySelector('#map');
							observer.observe(mapElement);
						});
					</script>
					<script>
						let slideIndex = 1;
						showSlides(slideIndex);
						function plusSlides(n) {
							showSlides(slideIndex += n);
						}
						function showSlides(n) {
							let i;
							let slides = document.querySelectorAll(".slide");
							if (n > slides.length) { slideIndex = 1 }
							if (n < 1) { slideIndex = slides.length }
							for (i = 0; i < slides.length; i++) {
								slides[i].style.display = "none";
							}
							slides[slideIndex - 1].style.display = "flex";
						}
						document.getElementById('prev').addEventListener('click', function () {
							plusSlides(-1);
						});
						document.getElementById('next').addEventListener('click', function () {
							plusSlides(1);
						});			
					</script>

					<script>
						$(function () {
							var bag = $("#bag");
							var clothes = $("#clothes");
							var wallet = $("#wallet");
							var lastScroll = 0;
							$(window).scroll(function (event) {
								var st = $(this).scrollTop();
								bag.removeClass("titleAni");
								clothes.removeClass("titleAni");
								wallet.removeClass("titleAni");
								if (st > lastScroll) {
									if (st > 750) {
										bag.addClass("titleAni");
									}
									if (st >= 1750) {
										clothes.addClass("titleAni");
									}
									if (st > 2650) {
										wallet.addClass("titleAni");
									}
								} else {
									if (st < 850) {
										bag.addClass("titleAni");
									}
									if (st < 1750) {
										clothes.addClass("titleAni");
									}
									if (st < 2620) {
										wallet.addClass("titleAni");
									}
								}
								lastScroll = st;
							});
						});
					</script>
				</body>

				</html>