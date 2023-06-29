# 주절주접
## 📒1. 프로젝트 소개
**`주절주접`은 스프링을 이용한 웹 다이어리입니다!**
- 메인화면은 `회원가입`, `로그인`으로 구성
- 로그인 후 자신의 캘린더에 날짜별로 일기를 작성
- 캘린더에는 그 날의 기분을 나타내는 `이모지`로 일기를 표시
- 일기에는 제목, 내용, 기분, 지도, 주접(칭찬 comment) 표시
- 기분은 `HAPPY😍` `SMILE😊` `CRY😢` `ANGRY😡` `CYNICAL😐` 로 구성

<br>

## 👋 2. 팀원 소개
<table>
  <tr>
    <td align="center"><a href="https://github.com/bbbbooo"><img src="https://avatars.githubusercontent.com/bbbbooo" width="150px;" alt="">
    <td align="center"><a href="https://github.com/Dylan-SonJungin"><img src="https://avatars.githubusercontent.com/Dylan-SonJungin" width="150px;" alt="">
    <td align="center"><a href="https://github.com/raxchaz"><img src="https://avatars.githubusercontent.com/raxchaz" width="150px;" alt="">
    <td align="center"><a href="https://github.com/numerical43"><img src="https://avatars.githubusercontent.com/numerical43" width="150px;" alt="">
    <td align="center"><a href="https://github.com/hodin030"><img src="https://avatars.githubusercontent.com/hodin030" width="150px;" alt="">
    <td align="center"><a href="https://github.com/myrhymetree"><img src="https://avatars.githubusercontent.com/myrhymetree" width="150px;" alt="">
    </td>
  </tr>
  <tr>
    <td align="center"><a href="https://github.com/bbbbooo"><b>이현석</b></td>
    <td align="center"><a href="https://github.com/Dylan-SonJungin"><b>손정인</b></td>
    <td align="center"><a href="https://github.com/raxchaz"><b>라현지</b></td>
    <td align="center"><a href="https://github.com/numerical43"><b>강수의</b></td>
    <td align="center"><a href="https://github.com/hodin030"><b>이효진</b></td>
    <td align="center"><a href="https://github.com/hodin030"><b>박성준</b></td>
  </tr>

  <tr>
    <td align="center"><strong>Lee Hyun Seok</strong></td>
    <td align="center"><strong>Son Jung In</strong></td>
    <td align="center"><strong>Ra Hyeon Ji</strong></td>
    <td align="center"><strong>SUI</strong></td>
    <td align="center"><strong>Lee Hyo Jin</strong></td>
    <td align="center"><strong>Park Seoun Jun</strong></td>
  </tr>
</table>

<br>

## ⚒️ 3. 기술 스택
<img width="1259" alt="KakaoTalk_20230628_164423310" src="https://github.com/mtvs-server2/spring-web-diary/assets/61495627/f1feb1aa-1d9f-4a8e-a7c1-bbce62702c9c">

<br>


## 🧱 4. 프로젝트 아키텍처
###  4-1. 흐름도
![spring-diary-흐름도(배경투명) drawio](https://github.com/mtvs-server2/spring-web-diary/assets/61495627/d96f58dd-8c80-4eb9-bf8b-5ebcbc0c1fc9)

### 4-2. ERD 다이어그램
<img width="809" alt="KakaoTalk_20230628_155928918" src="https://github.com/mtvs-server2/spring-web-diary/assets/61495627/9b88395d-976b-4b04-9860-5306a11031e4">

###  4-3. File Settings 🗄️

```
📦main
 ┣ 📂
 ┃ ┗ 📂com
 ┃ ┃ ┗ 📂diary
 ┃ ┃ ┃ ┗ 📂diaryproject
 ┃ ┃ ┃ ┃ ┣ 📂config
 ┃ ┃ ┃ ┃ ┃ ┣ 📜BeanConfiguration
 ┃ ┃ ┃ ┃ ┃ ┣ 📜JasyptConfiguration
 ┃ ┃ ┃ ┃ ┃ ┗ 📜JpaConfiguration
 ┃ ┃ ┃ ┃ ┣ 📂domain
 ┃ ┃ ┃ ┃ ┃ ┣ 📂aggregate
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Address
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Board
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Phrases
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜User
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂enumtype
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜EmojiEnum
 ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EmojiPostController
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoginController
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LogoutController
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MapController
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhraseController
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PopUpController
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜RegistMemberController
 ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AddressDTO
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardDTO
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EventDTO
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NoDTO
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhraseDTO
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhraseReqDTO
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReqDataDTO
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ResBoardDTO
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ResUserDTO
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserDTO
 ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BoardRepository
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MapRepository
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhrasesRepository
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserRepository
 ┃ ┃ ┃ ┃ ┃ ┣ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CheckBody
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CheckTitle
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EmojiPostService
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoginService
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LogoutService
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MapService
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PhraseService
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PopUpService
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜RegistMemberService
 ┃ ┃ ┃ ┃ ┃ ┗ 📂view
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜RegisterView
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜View
 ┃ ┃ ┃ ┃ ┗ 📜DiaryProjectApplication
 ┗ 📂resources
 ┃ ┣ 📂META-INF
 ┃ ┃ ┗ 📜MANIFEST.MF
 ┃ ┣ 📂static
 ┃ ┃ ┣ 📂images
 ┃ ┃ ┃ ┣ 📜angry
 ┃ ┃ ┃ ┣ 📜cry
 ┃ ┃ ┃ ┣ 📜cynical
 ┃ ┃ ┃ ┣ 📜happy
 ┃ ┃ ┃ ┗ 📜smile
 ┃ ┃ ┣ 📂js
 ┃ ┃ ┃ ┣ 📜map
 ┃ ┃ ┃ ┗ 📜requestOpenAi
 ┃ ┃ ┗ 📜index
 ┃ ┣ 📂templates
 ┃ ┃ ┣ 📂test
 ┃ ┃ ┃ ┗ 📜test
 ┃ ┃ ┣ 📜calendar
 ┃ ┃ ┣ 📜login
 ┃ ┃ ┣ 📜register
 ┃ ┃ ┗ 📜saveAddr
 ┃ ┣ 📜application-dev
 ┃ ┣ 📜application-prod
 ┃ ┗ 📜application
```

<br>

## 🗒️ 5. 요구 사항
- 기능별로 각각의 상황을 테스트하는 코드를 구현한다.
- 새로운 기능, 버그 fix 등의 코드 수정이 있다면 이슈를 작성한다.

<br>

## 📌 6. 기능 소개

### 6-1. 로그인
    - 아이디, 비밀번호 입력받아 로그인하도록 한다.
    - db에 저장된 데이터와 비교하여 아이디랑 비밀번호가 맞는지 아닌지 확인한다.
        - 일치하지 않는다면 로그인이 되지않도록 한다. 

### 6-2. 회원가입
    - 아이디, 비밀번호, 닉네임을 입력받는다. 
    - 아이디는 길이(5~20자), 한글 미포함, 영문과 숫자가 포함되어야한다.
    - 이미 존재하는 다른 회원과 아이디가 중복되지않는지 확인한다. 
    - 비밀번호 확인을 입력받아 비밀번호가 맞는지 다시 한 번 확인한다. 
    - 제약 사항을 통과했다면 db에 회원 정보를 저장한다.

### 6-3. 캘린더
    - 로그인하면 해당 회원의 캘린더를 불러와서 표시한다. 
		- 작성된 일기들은 함께 저장된 기분 이모지로 캘린더에 표시된다.
				- 기분 이모지 : HAPPY, SMILE, CRY, ANGRY, CYNICAL
		- 기분 이모지를 클릭하면 해당 일기를 조회한다.
		- 빈 날짜칸을 클릭하면 해당 날짜의 일기를 작성할 수 있는 창이 뜬다.

### 6-4 일기
    - 새로운 일기를 작성할 때, 주접 멘트, 해당 날짜와 지도를 표시한다. 
		- 제목, 내용, 기분을 입력받아 일기를 저장한다. 
    - 저장된 일기를 조회할 때 해당 일기와 함께 저장된 주접 멘트와 위치 정보를 가져와서 표시한다.
		    - 제목, 내용, 기분을 수정할 수 있다. 
    - placeholder 설정
        - 제목 : 제목을 입력하세요
        - 내용 : 오늘의 기분을 표현해주세요!
    - 제목은 30자, 내용은 500자 내로 제한한다.

### 6-4. 지도 : Kakao Map
    - 일기를 쓸 때 카카오맵의 지도 api를 이용하여 위치 정보를 표시하고 저장할 수 있다. 
        - 지도에서 특정 위치를 더블 클릭하면 지도가 사라지고, 해당 위치가 텍스트로 표시된다. 
        - 해당 위치는 일기가 저장될 때 db에 저장된다.
		- 일기를 조회할 때 저장된 위치 정보가 텍스트로 표시된다.

### 6-5. 주접 (칭찬 COMMENT) : Open AI
    - 주접떠는 멘트들을 Open AI의 API를 이용하여 생성하고 가져온다.
				- 일기를 작성할 때 랜덤으로 주접 멘트가 생성되고, 일기 입력창에 표시된다. 
		- 주접 멘트는 생성되고나서 바로 db에 저장된다.
				- 일기를 저장할 때 해당 주접 멘트 데이터를 받아 일기와 함께 저장한다.

<br>

---

### 제약사항
#### 📝 브랜치 규칙
- 신규 기능 추가
  - features/기능명(소문자)
- 개발 테스트
  - develop
- 최종본
  - master

#### 🏷️ Git Convention
| **Convention**  | **내용**                                                         |
|-----------------|----------------------------------------------------------------|
| **Feat**        | 새로운 기능 추가                                                      |
| **Fix**         | 버그 수정                                                          |
| **Test**        | 테스트 코드, 리펙토링 테스트 코드 추가, Production Code(실제로 사용하는 코드) 변경 없음     |
| **Refactor**    | 프로덕션 코드 리팩토링                                                   |
