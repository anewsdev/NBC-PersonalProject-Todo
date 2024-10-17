# 개발 전 공통 조건

- 모든 테이블은 고유 식별자(ID)를 가집니다.
- `3 Layer Architecture`에 따라 각 Layer의 목적에 맞게 개발합니다.
- CRUD 필수 기능은 데이터베이스 연결 및 `JPA`를 사용하여 개발합니다.
- `JDBC`와 `Spring Security`는 사용하지 않습니다.
- 인증/인가 절차는 `JWT`를 활용하여 개발합니다.
- JPA의 연관관계는 **`양방향`**으로 구현합니다.

## Lv 0. API 명세 및 ERD 작성

-  **API 명세서 작성하기**
    

-  **ERD 작성하기**
    

-  **SQL 작성하기**
    

## Lv 1. 일정 CRUD

-  일정을 저장, 조회, 수정, 삭제할 수 있습니다.
- 일정 필드: `작성 유저명`, `할일 제목`, `할일 내용`, `작성일`, `수정일`
- 삭제 시 댓글도 함께 삭제 (JPA 영속성 전이 기능 활용)

## Lv 2. 댓글 CRUD

-  일정에 댓글을 남길 수 있습니다.
- 댓글 필드: `댓글 내용`, `작성일`, `수정일`, `작성 유저명`

## Lv 3. 일정 페이징 조회

-  `Pageable` 및 `Page` 인터페이스 활용하여 페이지네이션 구현
- 기본 페이지 크기: 10, 수정일 기준 내림차순 정렬

## Lv 4. 유저 CRUD

-  유저를 저장, 조회, 삭제할 수 있습니다.
- 유저 필드: `유저명`, `이메일`, `작성일`, `수정일`
- 일정은 `유저 고유 식별자` 필드를 가집니다. (N:M 관계, 지연 로딩 활용)

## Lv 5. 다양한 예외처리 적용하기

-  `@Valid`를 활용한 예외처리
- 다양한 제약 조건 검증: 
    - `@NotNull`, `@NotEmpty`, `@Size`, `@Email` 등

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


# ERD

![image](https://github.com/user-attachments/assets/1548cc72-1282-4cf9-a85b-34e63737f22a)

# 트러블 슈팅

https://a-new-s.tistory.com/36

