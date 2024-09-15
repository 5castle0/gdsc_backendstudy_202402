## <초급 백엔드 스터디 1주차 WIL>

### <keyword>
web, 프로토콜과 HTTP, 프론트엔드와 백엔드, API

### 배운 내용
- 클라이언트는 데이터의 crud 요청을 전송한다.
- 서버는 그 요청을 받아 동작을 수행하고 응답을 전송한다.
- 컴퓨터는 정해진 동작만 수행할 수 있기에 규칙이 필요한데, 웹에서는 HTTP라는 프로토콜을 이용한다.
- HTTP 프로토콜은 HTTP Method와 URL을 필요로 한다.
- 요청에 대한 처리 결과는 HTTP가 정의한 상태코드로 표현된다.
- 프론트엔드는 백엔드에게 요청하고, 백엔드는 DB에서 데이터를 프론트에게 응답한다.
- 백엔드가 주고받는 데이터는 JSON 형태이다.
- API는 어플리케이션과 소통하는 구체적인 방법을 정의한 것이다.

### API
- 회원가입 : POST/register
- 로그인 : POST/login
- 할 일 조회 : GET/todo/list
- 할 일 생성 : POST/todo
- 할 일 수정 : PATCH/todo/{todo_id}
- 할 일 삭제 : DELETE/todo/{todo_id}
- 할 일 체크 및 체크 해제 : POST/todo/{todo_id}/check
- 친구 추가 : POST/friend
- 친구 조회 : GET/friend/list
- 친구 삭제 : DELETE/friend/{friend_id}
- 특정 친구의 할 일 조회 : GET/friend/{friend_id}/list

![image](2024-09-16 01;51;46)