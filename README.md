# mugshot
---
:suspect:
**The profile image API**
(Germano's version)

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

#### ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) `POST`
* `header`
    * *key*: `authenticated-user-id`
    * *value*: [identification for the folder where the image will be stored]
* `body`
    * *key*: `image`
    * *value*: [file in form-data]
#### ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) `GET`
* `header`
    * *key*: `authenticated-user-id`
    * *value*: [identification for the folder where the image will be retrieved]
#### ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) `DELETE`
* `header`
    * *key*: `authenticated-user-id`
    * *value*: [identification for the folder where the image will be deleted]
---
<details>
<summary>:game_die: Random</summary>

>  URL: `http://localhost:9500/generateImage/random` - Profile image

#### ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) `POST`
* `header`
    * *key*: `authenticated-user-id`
    * *value*: [identification for the folder where the generated image will be stored]
</details>

---
<details>
<summary>:page_facing_up: Base64</summary>

alternative form for getting image
> URL: `http://localhost:9500/base64` - Profile image

> URL: `http://localhost:9500/base64/banner` - Banner image

#### ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) `GET`
* `header`
    * *key*: `authenticated-user-id`
    * *value*: [identification for the folder where the image will be retrieved encoded in base64]
</details>

---
<details>
<summary>:art: General Usage (comming soon :construction_worker:)</summary> 
(just put the link in a img tag and it works)

> URL: `http://localhost:9500/images/{image_name}` - Any image

#### ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) `POST`
* `path variable`
    * *image_name*: `a valid image name`
#### ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) `GET`
* `path variable`
    * *image_name*: `a valid image name`
#### ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) `DELETE`
* `path variable`
    * *image_name*: `a valid image name`
</details>

---
<details>
<summary>:file_folder: User images (comming soon :construction_worker:)</summary>
</details>
_"This fork made from a specific api of a hive product, was made especially to make free use in any application.
Make yourself at home."_:yellow_heart:
