##Getting Token
1. POST http://localhost:8080/api/auth/login
2. Remove cookies
3. Add User
in body as raw
`
{
    "username": "admin",
    "password": "password"
}
`
![image](https://github.com/ascaryaaa/springboot-jwt-security/assets/73589875/a6697d51-3935-450a-9f62-190716aff6b1)
4. Send
![image](https://github.com/ascaryaaa/springboot-jwt-security/assets/73589875/2ccd105b-5e4e-40fc-9891-cbc0d398fa26)
5. Copy the Token
6. GET http://localhost:8080/api/hello
7. Go to header and add
`
Key = Authorization
Value = Beaver <Token>
`
![image](https://github.com/ascaryaaa/springboot-jwt-security/assets/73589875/71d2d145-b8af-4b5c-86a4-48f135007dff)
8. Send
![image](https://github.com/ascaryaaa/springboot-jwt-security/assets/73589875/6760a150-c45f-4212-aa38-fa62d69927b8)


