
# Nail-studio

This project is for nail service masters, for dialogue and comfortable management of their work.
## database structure

![Nais_studio](https://user-images.githubusercontent.com/66059644/208201545-3d3c08d5-2a67-4e87-9a97-af1891535c4a.PNG)


##Registration diagram

![registration PNG](https://user-images.githubusercontent.com/66059644/208255676-67a7a511-215a-4bd0-b506-1fcdbdacfc02.jpg)


## API Reference

#### Get Specialist

```http
  GET api/v1/specialist/{id}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `string` | **Required**. id of specialist
|           |           |Representing a response with a model that accepts a Specialist.class |

#### Get all Specialists

```http
  GET api/v1/specialists
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `-`      | `string` | **Required**. Response view with Model that accepts a List<Specialist> |



## Authors

- [@reuven9632](https://github.com/reuven9632)


## Features

- Light/dark mode toggle
- Live previews
- Fullscreen mode
- Cross platform


## Feedback

If you have any feedback, please reach out to us at reuven1856@gmail.com


## 🚀 About Me
I'm a Java developer...


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/reuven9632/Nail_studio)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/reuven-s/)


## 🛠 Skills
<p align="left"> <a href="https://www.w3schools.com/css/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/css3/css3-original-wordmark.svg" alt="css3" width="40" height="40"/> </a> <a href="https://www.figma.com/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/figma/figma-icon.svg" alt="figma" width="40" height="40"/> </a> <a href="https://git-scm.com/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/git-scm/git-scm-icon.svg" alt="git" width="40" height="40"/> </a> <a href="https://gulpjs.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/gulp/gulp-plain.svg" alt="gulp" width="40" height="40"/> </a> <a href="https://www.w3.org/html/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/html5/html5-original-wordmark.svg" alt="html5" width="40" height="40"/> </a> <a href="https://www.postgresql.org" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original-wordmark.svg" alt="postgresql" width="40" height="40"/> </a> <a href="https://postman.com" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/getpostman/getpostman-icon.svg" alt="postman" width="40" height="40"/> </a> <a href="https://sass-lang.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/sass/sass-original.svg" alt="sass" width="40" height="40"/> </a> <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> </p>


<h3 align="left">Connect with me:</h3>
<p align="left">
<a href="https://www.linkedin.com/in/reuven-s/" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/linked-in-alt.svg" alt="https://www.linkedin.com/in/reuven-s/" height="30" width="40" /></a>
</p>



## Logo

![Logo](https://github.com/reuven9632/Nail_studio/blob/main/src/main/resources/static/images/readme/logo.png)


## Support

For support, email reuven1856@gmail.com or join our Slack channel.


## Tech Stack

**Client:** thymeleaf, css, sass, html, gulp

**Server:** Java Spring boot, PostgresQL, data jpa, lombok, guava


## Used By

This project is used by the following companies:

- Alona-Nails



### CURL
```
curl --location --request POST 'localhost:8080/api/v1/registration' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "ReuvenS",
    "lastName": "Nail-studio",
    "email": "reuven1856@gmail.com",
    "password": "password"
}'
```
