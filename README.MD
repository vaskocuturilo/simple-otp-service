## Spring Boot OTP (One time password service)

The Spring Boot project with the demonstration of OTP technique. Also added API automation scripts for testing.

## Requirements:
- Use any *object-oriented language*.
- Create a One time password service.
- Use automation patterns like *PageObject*, *data-driven* tests, etc.
- Use any testing frameworks.
- Add Report.
- provide code and clear instructions how to run it.

**Note**: please put your code in public repository.

**Note**: Please send link to this repo when you are done.

You will need the following technologies available to try it out:
* Git
* Mysql 
* Spring Boot  
* Gradle 7+
* JDK 11
* IDE of your choice
* Web browser Chrome


### How to work 

![](https://a.radikal.ru/a27/2202/2c/f4bb9d38cf65.png)

open http://localhost:8080/api/v1/otp/create/

Example response:
``` {"id":10,"oneTimePasswordCode":827836,"expires":"2022-02-06T18:03:58.267+00:00"} ```

### Ho w to run

```./gradlew bootStop```

### Ho w to stop

```gradle -stop```





