# API 명세서

## 1. 유저 API

| 기능           | 메서드 | 엔드포인트               | 요청 예시                            | 상태 코드       |
|----------------|--------|------------------------|---------------------------------------|------------------|
| 유저 생성      | POST   | /api/user              | ```json { "username": "user01", "email": "user01@example.com" } ``` | 201 Created       |
| 전체 유저 조회 | GET    | /api/user              | N/A                                   | 200 OK           |
| 단일 유저 조회 | GET    | /api/user/{id}         | N/A                                   | 200 OK           |
| 유저 수정      | PUT    | /api/user/{id}         | ```json { "username": "user01_updated", "email": "user01_updated@example.com" } ``` | 200 OK           |
| 유저 삭제      | DELETE | /api/user/{id}         | N/A                                   | 204 No Content    |

---

## 2. 일정 API

| 기능           | 메서드 | 엔드포인트               | 요청 예시                            | 상태 코드       |
|----------------|--------|------------------------|---------------------------------------|------------------|
| 일정 생성      | POST   | /api/todo              | ```json { "title": "테스트 제목 01", "content": "테스트 내용 01", "creatorId": 1 } ``` | 201 Created       |
| 전체 일정 조회 | GET    | /api/todo              | N/A                                   | 200 OK           |
| 단일 일정 조회 | GET    | /api/todo/{id}         | N/A                                   | 200 OK           |
| 일정 수정      | PUT    | /api/todo/{id}         | ```json { "title": "수정된 제목", "content": "수정된 내용" } ``` | 200 OK           |
| 일정 삭제      | DELETE | /api/todo/{id}         | N/A                                   | 204 No Content    |

---

## 3. 댓글 API

| 기능           | 메서드 | 엔드포인트               | 요청 예시                            | 상태 코드       |
|----------------|--------|------------------------|---------------------------------------|------------------|
| 댓글 생성      | POST   | /api/comment           | ```json { "todoId": 1, "content": "댓글 내용" } ``` | 201 Created       |
| 전체 댓글 조회 | GET    | /api/comment           | N/A                                   | 200 OK           |
| 단일 댓글 조회 | GET    | /api/comment/{id}      | N/A                                   | 200 OK           |
| 댓글 수정      | PUT    | /api/comment/{id}      | ```json { "content": "수정된 댓글 내용" } ``` | 200 OK           |
| 댓글 삭제      | DELETE | /api/comment/{id}      | N/A                                   | 204 No Content    |
