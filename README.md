# jparelation
## jpa매핑연습


부모 <br>
자식 <br>
손자 <br>
다중키<br>
간의 연관 관계에 따라 입력, 수정, 삭제시 어떤 차이점이 있는지 실제 눈으로 DB와 쿼리 결과를 보며 이해하기 위한 테스트 앱

테스트 편의상 모두 get 방식 요청을 받고 시큐리티 설정 없음.

패키지별로  /test1, /test2, /test3, .... <br>
(부모당 자식 3개) 세트 입력 /insert <br>
조회 /list


예 
http://localhost:8090/test1/insert <br>
http://localhost:8090/test3/list
