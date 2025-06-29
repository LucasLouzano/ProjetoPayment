# Project Payment

Sistema de gerenciamento de valores de pagamento, utilizando **Spring Boot** 
com uma abordagem inspirada na **Arquitetura Hexagonal (Ports & Adapters)**.
A aplicação permite o controle dos valores atuais e anteriores com base em status e 
persistência em banco de dados relacional (MySQL).
---

## 🧱 Arquitetura
Mundo Externo ┌──────────────────────────────┐ │ REST API Banco de
Dados │ └──────────────┬───────────────┘ │ ┌────▼─────┐ │
Adapters │ ← Controllers, JPA └────┬─────┘ │ ┌──────▼────────┐ │
Application │ ← Casos de uso └──────┬────────┘ │ ┌──────▼────────┐ │
Domain │ ← Regra de negócio + contratos └───────────────┘


---

## 📁 Estrutura de Pacotes
ProjetoPayment.Payment ├── adapters │ ├── inbound.controller │ │ └──
PaymentValueController.java │ └── outbound │ ├── entity │ │ └──
JpaPaymentValue.java │ └── repository │ ├── JpaPaymentValueRepository.java │ └──
PaymentValueRepositoryImpl.java ├── application │ └── PaymentValueServiceImpl.java
├── domain │ ├── dto │ │ ├── PaymentValueDTO.java │ │ └── ValuePaymentDTO.java
│ ├── model │ │ ├── PaymentValue.java │ │ └── PaymentStatus.java │ └── userCase │
└── PaymentValueUserCase.java ├── mapper │ └── PaymentValueMapper.java └──
PaymentApplication.java

---

## ⚙️ Tecnologias

- Java 17
- Spring Boot 3.3.1
- Spring Web
- Spring Data JPA
- MapStruct 1.5.5.Final
- Lombok
- MySQL Driver

---

## 🚀 Como executar o projeto

1. Clone o repositório:

```bash
git clone https://github.com/LucasLouzano/ProjetoPayment
cd seu-repositorio

## Configure o arquivo src/main/resources/application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/payment_db
spring.datasource.username=root
spring.datasource.password=suasenha
spring.jpa.hibernate.ddl-auto=update

## Compile e execute a aplicação
./mvnw clean install
./mvnw spring-boot:run



