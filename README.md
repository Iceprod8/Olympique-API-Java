### README.md

# Olympic Games API

Bienvenue dans l'API de billetterie des Jeux Olympiques ! Cette API vous permet de gérer les événements, les stades, les utilisateurs et les commandes de billets. Vous pouvez également utiliser cette API pour acheter des billets pour des événements spécifiques, visualiser l'historique des commandes, gérer les utilisateurs et administrer les événements.

## Prérequis

- Java
- Maven
- Postman pour tester les routes de l'API
- Postgres SQL v16 [download](https://www.postgresql.org/download/windows/)

## Installation

1. Clonez le repository:

   ```bash
   git clone https://github.com/your-username/olympic-games-api.git
   cd olympic-games-api
   ```

2. Compilez et lancez l'application:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

L'API sera disponible à `http://localhost:8080`.

## Endpoints

### Authentification

#### Register

- **URL**: `/api/auth/register`
- **Method**: `POST`
- **Description**: Enregistre un nouvel utilisateur.

#### Login

- **URL**: `/api/auth/login`
- **Method**: `POST`
- **Description**: Authentifie un utilisateur et renvoie un token JWT.

### Utilisateurs

#### Get All Users

- **URL**: `/api/users`
- **Method**: `GET`
- **Description**: Récupère tous les utilisateurs.

#### Get User by ID

- **URL**: `/api/users/{id}`
- **Method**: `GET`
- **Description**: Récupère un utilisateur par ID.

#### Create User

- **URL**: `/api/users`
- **Method**: `POST`
- **Description**: Crée un nouvel utilisateur.

#### Update User

- **URL**: `/api/users/{id}`
- **Method**: `PUT`
- **Description**: Met à jour un utilisateur existant.

#### Delete User

- **URL**: `/api/users/{id}`
- **Method**: `DELETE`
- **Description**: Supprime un utilisateur par ID.

### Stades

#### Get All Stadiums

- **URL**: `/api/stadiums`
- **Method**: `GET`
- **Description**: Récupère tous les stades.

#### Get Stadium by ID

- **URL**: `/api/stadiums/{id}`
- **Method**: `GET`
- **Description**: Récupère un stade par ID.

#### Create Stadium

- **URL**: `/api/stadiums`
- **Method**: `POST`
- **Description**: Crée un nouveau stade.

#### Update Stadium

- **URL**: `/api/stadiums/{id}`
- **Method**: `PUT`
- **Description**: Met à jour un stade existant.

#### Delete Stadium

- **URL**: `/api/stadiums/{id}`
- **Method**: `DELETE`
- **Description**: Supprime un stade par ID.

### Événements

#### Get All Events

- **URL**: `/api/events`
- **Method**: `GET`
- **Description**: Récupère tous les événements.

#### Get Event by ID

- **URL**: `/api/events/{id}`
- **Method**: `GET`
- **Description**: Récupère un événement par ID.

#### Create Event

- **URL**: `/api/events`
- **Method**: `POST`
- **Description**: Crée un nouvel événement.

#### Update Event

- **URL**: `/api/events/{id}`
- **Method**: `PUT`
- **Description**: Met à jour un événement existant.

#### Delete Event

- **URL**: `/api/events/{id}`
- **Method**: `DELETE`
- **Description**: Supprime un événement par ID.

### Commandes

#### Purchase Tickets

- **URL**: `/api/orders`
- **Method**: `POST`
- **Description**: Achète des billets pour un événement.

#### Get Orders by User

- **URL**: `/api/orders/user/{id}`
- **Method**: `GET`
- **Description**: Récupère les commandes d'un utilisateur par ID.

#### Delete Order

- **URL**: `/api/orders/{id}`
- **Method**: `DELETE`
- **Description**: Supprime une commande par ID.

## Utilisation de Postman

1. **Importez la collection Postman**:
   - Ouvrez Postman.
   - Cliquez sur "Import" en haut à gauche.
   - Sélectionnez "Raw text".
   - Collez le JSON de la collection fourni dans le fichier `postman.json`.
   - Cliquez sur "Continue" puis sur "Import".

2. **Variables d'environnement**:
   - Créez un nouvel environnement dans Postman.
   - Ajoutez les variables suivantes :
     - `baseUrl` avec la valeur `http://localhost:8080`
     - `jwt` avec la valeur du token JWT que vous obtiendrez après avoir utilisé l'endpoint de login.

3. **Effectuez les requêtes**:
   - Utilisez les endpoints décrits ci-dessus pour tester l'API.
   - N'oubliez pas de mettre à jour la variable `jwt` dans Postman avec le token reçu après la connexion.

## Fichier Postman

Le fichier JSON pour Postman se trouve dans ce repository sous le nom `postman.json`. Importez-le dans Postman pour tester facilement toutes les routes de l'API.

#Nathan Samochval
