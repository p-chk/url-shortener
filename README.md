
# CHK - URL Shortener Service

A simple url shortener back-end service

Last Updated: 2022-05-07


## Authors

- [@p-chk](https://www.github.com/p-chk) - Chayakorn K.


## API Endpoint

#### Get redirect full url from shortened url

```http
  GET /{shortened_url}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `shortened_url` | `string` | **Required**. Short URL hash Code |

#### Add Full Url, and make shortened_url

```http
  POST /add/
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `fullUrl`      | `string` | **Required**. Full URL |






## Tech Stack

**Server:**
```
- Java 11
- Springboot 2.6.6
- Gradle 7.4.1
```


## Current Business Logic

### Feature 1 - Add Full URL and Create Shortened URL

Add full Url to the databse along with processing full url to shortened url using number of rows in the database as a shortened url

#### Method Name: **addUrl**

Call Parameter
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `fullUrl`      | `string` | Full URL |

Return
| Type     | Description                       |
| :------- | :-------------------------------- |
| `ResponseBody` | ShortenedUrl |

Method Dependencies: urlProcessingService.processUrl

#### Method Name: **processFullUrl**

Call Parameter
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `fullUrl`      | `string` | Full URL |

Return
| Type     | Description                       |
| :------- | :-------------------------------- |
| `string` | Shortened url |

Method Dependencies: urlProcessingService.getShortenedUrl, urlProcessingService.saveUrl

#### Method Name: **getShortenedUrl**

Return
| Type     | Description                       |
| :------- | :-------------------------------- |
| `string` | ShortenedUrl |

Method Dependencies: urlMainService.countRows

#### Method Name: **saveUrl**

Call Parameter
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `urlMainEntity`      | `UrlMainEntity` | URLMainEntity that created to connect with JPA Repository|

Method Dependencies: urlMainService.save

#### Method Name: **countRows**

Return
| Type     | Description                       |
| :------- | :-------------------------------- |
| `Long` | count number of rows |

### Feature 2 - Get Redirect to Full URL from Shrotened URL

Get ModelAndView Redirect to Full URL from getting the shortenedURL from database

#### Method Name: **getLongUrl**

Call Parameter
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `shortenedUrl`      | `string` | Shortened URL |

Return
| Type     | Description                       |
| :------- | :-------------------------------- |
| `ModelAndView` | Redirect to Full URL |

Method Dependencies: urlProcessingService.getFullUrl

#### Method Name: **getFullUrl**

Call Parameter
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `shortenedUrl`      | `string` | Shortened URL |

Return
| Type     | Description                       |
| :------- | :-------------------------------- |
| `String` | full url |

Method Dependencies: urlMainService.findByShortenedUrl

#### Method Name: **findByShortenedUrl**

Call Parameter
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `shortenedUrl`      | `string` | Shortened URL |

Return
| Type     | Description                       |
| :------- | :-------------------------------- |
| `UrlMainEntity` | UrlMainEntity found from database with the shortened url |

Method Dependencies: urlMainRepository.findByShortUrl






## Run Locally
Req. docker

Clone the project

```bash
  git clone https://github.com/p-chk/url-shortener.git
```

Go to the project directory

```bash
  cd url-shortener
```

Create docker image and run the container

```bash
  docker-compose up
```



## Roadmap

- Add processing logic to include shorten the link to avoid user random number

- Integrate Spring Security

- Deploy to Platform



