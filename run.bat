@echo off
start cmd /k "cd backend && mvn spring-boot:run"
start cmd /k "cd frontend && npm start"
