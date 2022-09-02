# 포인트 시스템 과제 제출

<br>

## 📔 사용 기술 및 문제 선택

#### *SpringBoot, Spring Data JPA, H2*
#### 선택 1번과 선택 2번을 합쳐서 만들었습니다.

<br>



## 👨‍💻 API 명세서



| 분류           | 기능   | URL   | Request         | Response                |
| ---------------- | -------- | ------| ------------------------ | -------------------------------- |
| 유저생성 | 유저 생성용 API  | POST : /api/users/create | {"userName":"테스트유저", "userCash":100000, "userPoint":0} | {"status": "Success", "message": "유저가 생성 되었습니다.", "errorMessage": "", "errorCode": "" }
| 제품생성 | 제품 생성용 API  | POST : /api/product/create | {"productName":"테스트제품1", "productPrice":5000, "productCount":20, "pointRate":20,"productOwner":"테스트오너" } | {"status": "Success", "message": "제품이 생성 되었습니다.", "errorMessage": "", "errorCode": "" }
| 현금제품주문 | 현금으로 제품을 주문하는 API  | POST : /api/order/cash | {"userName":"테스트유저", "products":[ { "productName":"테스트제품1", "productCount":2 } ] } | {"status": "Success", "message": "제품을 구매 했습니다.", "errorMessage": "", "errorCode": "" }
| 포인트제품주문 | 포인트로 제품을 주문하는 API  | POST : /api/order/point | {"userName":"테스트유저", "products":[ { "productName":"테스트제품1", "productCount":2 } ] } | {"status": "Success", "message": "제품을 구매 했습니다.", "errorMessage": "", "errorCode": "" }
| 장바구니담기 | 장바구니에 제품을 담는 API | POST : /api/shopBasket/add | {"userName":"테스트유저", "products":[ { "productName":"테스트제품1", "productCount":2 } ] } | {"status": "Success", "message": "장바구니 담기 완료", "errorMessage": "", "errorCode": "" }
| 장바구니제거 | 장바구니의 제품을 제거하는 API | DELETE : /api/shopBasket/remove | {"userId":1, "productId":1} | {"status": "Success", "message": "장바구니 제거 완료", "errorMessage": "", "errorCode": "" }


<br>

## 💻 ERD 설계서
![pointSystem](https://user-images.githubusercontent.com/59018674/188051632-134596b6-b164-44b8-8dc8-67fd30f0c1dd.png)
