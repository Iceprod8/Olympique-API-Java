@echo off

:: Adding a user to the database
echo Registering a new user...
curl -X POST http://localhost:8080/auth/register ^
-H "Content-Type: application/json" ^
-d "{
  \"username\": \"testuser\",
  \"password\": \"password123\"
}" -w "\nHTTP Status Code: %{http_code}\n" -o register_response.txt

echo Waiting for response...
timeout /T 5

echo Response from registration:
type register_response.txt

:: Logging in to get a JWT token
echo Logging in to get a JWT token...
curl -X POST http://localhost:8080/auth/login ^
-H "Content-Type: application/json" ^
-d "{
  \"username\": \"testuser\",
  \"password\": \"password123\"
}" -w "\nHTTP Status Code: %{http_code}\n" -o login_response.txt

echo Waiting for response...
timeout /T 5

echo Response from login:
type login_response.txt

:: Extracting the JWT token from the response
for /F "tokens=2 delims=: " %%a in (login_response.txt) do (
  set "token=%%a"
)

:: Trimming the token (remove trailing and leading spaces)
set "token=%token:~1,-1%"

echo JWT token: %token%

:: Using the JWT token to access a protected endpoint
echo Accessing protected endpoint...
curl -X GET http://localhost:8080/api/protected-endpoint ^
-H "Authorization: Bearer %token%" -w "\nHTTP Status Code: %{http_code}\n" -o protected_response.txt

echo Waiting for response...
timeout /T 5

echo Response from protected endpoint:
type protected_response.txt

echo Done.
pause
