## 1) 소개
GET /_hello 로 hello를 출력해주는 플러그인

- elasticsearch : 8.13.0
- java : 19.0.2
- maven : 3.8.4

### plugin 구조
- GET /_hello
- GET /_hello{name}

## 2) Build 및 설치
### 1. buil하고 zip 파일 생성하기
1.1 build 진행
```
mvn clean package
```

1.2 파일 생성 확인  
```
\hello_world_plugin\target\releases\hello-world-8.13.0.zip
```

- zip 파일 구조  
![화면 캡처 2025-06-12 092334](https://github.com/user-attachments/assets/66b9fa80-ab31-4a1d-81e8-3bec3562f786)  

### 2. elasticsearch에 plugin 설치하기  
2.1 서버에 zip파일 넣고 install 하기  
```
$elasticsearch-8.13.0/bin/elasticsearch-plugin install file:경로/hello-world-8.13.0.zip  
```

2.2 elasticsearch 재기동

## 3) 플러그인 실행 확인하기
3.1 GET /_hello  
- 쿼리  
![화면 캡처 2025-06-12 090644](https://github.com/user-attachments/assets/13cc8b61-2a6c-46eb-9a72-452c227060b4)  
- 결과  
![화면 캡처 2025-06-12 090704](https://github.com/user-attachments/assets/26ae4fe8-73e2-4279-944f-b3004d7a4600)  

3.2 GET /_hello{name}  
- 쿼리  
![화면 캡처 2025-06-12 090803](https://github.com/user-attachments/assets/977c522a-39a1-486f-8d01-9e82ebafd480)
- 결과  
![화면 캡처 2025-06-12 090813](https://github.com/user-attachments/assets/2c275996-b38e-4d01-8797-e2f604b4dcee)

