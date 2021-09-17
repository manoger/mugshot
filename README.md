# mugshot
---
:suspect:
**The profile image API**
(Germano's version/see my branch)

### First steps
(Configuring the environment):

1. git clone https://github.com/hex-g/mugshot.git
    1. cd mugshot
2. git checkout [branch]
3. git submodule init
4. git submodule update 
5. Run the project in your IDE
    1. required JDK 11+
    2. required Gradle compatible
---
### Usage

> :smiley: URL: `http://localhost:9500/` - Profile image

> :bridge_at_night: URL: `http://localhost:9500/banner` - Banner image

#### 🔵 `POST`
* `header`
    * *key*: `authenticated-user-id`
    * *value*: [identification for the folder where the image will be stored]
* `body`
    * *key*: `image`
    * *value*: [file in form-data]
#### 🟢 `GET`
* `header`
    * *key*: `authenticated-user-id`
    * *value*: [identification for the folder where the image will be retrieved]
#### 🔴 `DELETE`
* `header`
    * *key*: `authenticated-user-id`
    * *value*: [identification for the folder where the image will be deleted]
---
:game_die: Random
>  URL: `http://localhost:9500/generateImage/random` - Profile image

#### 🔵 `POST`
* `header`
    * *key*: `authenticated-user-id`
    * *value*: [identification for the folder where the generated image will be stored]
---
:page_facing_up: Base64
> URL: `http://localhost:9500/base64` - Profile image

> URL: `http://localhost:9500/base64/banner` - Banner image

alternative form for getting image
#### 🟢 `GET`
* `header`
    * *key*: `authenticated-user-id`
    * *value*: [identification for the folder where the image will be retrieved encoded in base64]
