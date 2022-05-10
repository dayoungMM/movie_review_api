# 영화 리뷰 서비스 (BE)
## Table

- 리뷰 테이블
    - seq (id로 하기 위해)
    - 평점
    - 감상일
    - 영화 제목
    - 감독
    - 배우
    - 감상
        - 리뷰 내용
    - 평가자
        - 평가자 테이블과 연동 (리뷰 테이블과 update, delete CASCADE 조건)
- 평가자 테이블
    - 평가자 이름
    - 평가자 Id

![image](https://user-images.githubusercontent.com/56625356/167633377-7e89aadb-eaf8-43c4-b358-660693c79399.png)

## API Document

[https://documenter.getpostman.com/view/15580972/Uyxepovw](https://documenter.getpostman.com/view/15580972/Uyxepovw)

## Function

- 평가자 조회/등록/삭제/수정
    - 조회
        - 모든 평가자
        - 하나의 평가자(ID 기준)
    - 등록
        - ID validation → 영어 소문자+숫자만 가능
        - ID, Name 필수 인자 (Not Blank)
        - ID 중복 불가
- 리뷰 조회/기록/삭제/수정
    - 조회
        - 모든 리뷰 (평가자 이름까지)
        - 모든 리뷰 (평가자 이름 빼고)
        - 영화 제목을 기준으로 조회 (검색어 포함)
    - 수정
        - seq, 등록일자, 평가자 아이디 수정 불가 (validation 기능 있음)
        - seq, score 필수값
        - score → 0~ 5 사이의 값 (validation 기능 있음)
        - 필수조건이 아닌 인자들이 requestBody에 없을 경우 기존 값 유지

## Future Work

- 추후 시간 남으면 추가할 예정
    - CommonResponse로 Response 형식 동일하게 맞출것
    - try -catch 반복되는 부분 Wrapper로 처리
