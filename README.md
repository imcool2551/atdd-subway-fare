# 지하철 노선도 미션

[ATDD 강의](https://edu.nextstep.camp/c/R89PYi5H) 실습을 위한 지하철 노선도 애플리케이션

## 기능 요구 사항

---

- 회원 기능

  - 사용자는 회원 가입, 로그인, 회원 탈퇴를 할 수 있다.
  - 회원은 일반 회원과 관리자로 구분된다. 관리자는 역, 노선, 구간과 같은 중요한 정보를 관리한다.
  - 회원은 내 정보(이름, 나이)를 수정할 수 있다.
  - 회원은 자주 검색하는 경로를 즐겨찾기를 통해 더욱 편하게 검색할 수 있다.
  - 회원은 게스트 사용자와 달리 나이에 따라 요금 할인과 같은 혜택을 받을 수 있다.

- 역 관리

  - 관리자는 지하철역을 추가, 수정, 삭제 등 관리할 수 있다. ex) 교대역
  - 구간에 추가된 역은 속한 구간들을 먼저 삭제한 다음에 삭제할 수 있다.

- 노선 관리

  - 관리자는 노선을 추가, 수정, 삭제 등 관리할 수 있다. ex) 2호선
  - 노선은 추가 요금을 가질 수 있다.

- 구간 관리

  - 관리자는 노선에 구간을 추가하거나 제거할 수 있다. ex) 2호선에 강남역 추가
  - 구간은 거리(km)와 소요 시간(분) 정보를 가진다.

- 경로 검색

  - 사용자는 출발역, 도착역을 입력하여 경로를 검색할 수 있다.
  - 경로는 최단 거리, 최소 소요 시간을 기준으로 검색할 수 있다.

- 요금 정책
  - 기본 요금은 1250원이다.
  - 실제 이동한 경로가 아닌 출발역과 도착역의 거리를 기준으로 요금을 추가한다.
    - 10km 부터 50km 까지는 5km마다 100원이 추가된다.
    - 50km 부터는 8km마다 100원이 추가된다.
    - 추가 요금이 있는 노선들을 여러개 이용한 경우 가장 높은 추가 요금만 추가한다.
  - 회원은 나이에 따라 할인 혜택을 받을 수 있다.
    - 아기(6세미만)은 무료로 이용할 수 있다.
    - 어린이(6~12세)는 50% 할인을 적용한다.
    - 청소년(13세~18세)은 20% 할인을 적용한다.

## 패키지 구조

---

```bash
├── src
│  ├── main.java.nextstep
│  │   ├── auth: 인증/인가 기능
│  │   ├── common: 공통 기능 (예외 처리 등)
│  │   ├── line: 노선 관리 기능
│  │   ├── member: 회원 관련 기능(회원 가입, 내 정보 수정, 회원 탈퇴), 즐겨 찾기 관리 기능
│  │   ├── path: 경로 검색, 요금 계산 기능
│  │   └── station: 역 관리 기능
│  ├── test.java.nextstep
│  │   ├── acceptance
│  │   │   ├──  documentation: API 문서화 테스트
│  │   │   ├──  steps: 인수 테스트 픽스쳐 생성 편의 기능
│  │   │   ├──  test: 인수 테스트(시나리오 테스트)
│  │   ├── auth: 인증 기능 단위 테스트
│  │   ├── line: 노선 기능 단위 테스트
│  │   ├── member: 회원 기능, 즐겨 찾기 기능 단위 테스트
│  │   ├── path: 경로 검색 기능, 요금 계산 기능 단위 테스트
│  │   └── utils: 테스트를 위한 유틸 기능 (테스트 DB 초기화)
└──
```

## 화면 예시 (일부)

---

- 회원 가입

  ![](https://velog.velcdn.com/images/imcool2551/post/a43bdb1f-3f87-46cf-8ced-df03cabcba82/image.png)

- 로그인

  ![](https://velog.velcdn.com/images/imcool2551/post/ca4ca292-dc61-4bad-9c15-db7cbff1d05e/image.png)

- 역 관리

  ![](https://velog.velcdn.com/images/imcool2551/post/fb578a34-39b1-489c-b142-c77a10f930e4/image.png)

- 노선 관리

  ![](https://velog.velcdn.com/images/imcool2551/post/25e5a2bf-9743-4a4c-8a99-b84ea245dfe5/image.png)

  ![](https://velog.velcdn.com/images/imcool2551/post/14e9bb96-7f35-48c1-98c9-9eac98e0f0fc/image.png)

- 구간 관리

  ![](https://velog.velcdn.com/images/imcool2551/post/c165cfc0-51d8-4baf-a2dd-ebe5957d75a2/image.png)

- 경로 검색

  ![](https://velog.velcdn.com/images/imcool2551/post/37998ec1-e9ac-4d1a-ae8d-16fb65288c72/image.png)
