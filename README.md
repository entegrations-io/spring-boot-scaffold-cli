## Introduction
Scaffolding CLI for rapid code development of Spring based web and RESTful service, consisting of CRUD operations, for use with any quick prototyping.

It has 4 maven sub-projects.
1. core - core of the generator logic
2. generator - depends on core above
3. templates - depends on core above
4. cli - depends on all above


## Install this project as CLI

1. From root of this project, do
```
mvn install
```

2. Then, to install the CLI, do 
```
spring install open.source.tools.spring.scaffold:cli:1.0.0-SNAPSHOT
```

Note, to uninstall, use
```
spring uninstall open.source.tools.spring.scaffold:cli:1.0.0-SNAPSHOT

#or cautiously 

spring uninstall --all
```

## Use the installed CLI
1. Initialize the project to start with...

```
spring init --dependencies=web,data-jpa,thymeleaf,h2,validation --package-name=open.source.tools.spring.sample demo-app

cd demo-app
```

2. Scaffold it
```
spring setup:scaffold -n "open.source.tools.spring.sample"

spring scaffold -n "Customer" -p "name:String email:String city:String"
```

3. Add this to pom.xml, for styling to work (sorry, this is annoying TODO / wishlist item of this work):
```
    <dependency>
       <groupId>nz.net.ultraq.thymeleaf</groupId>
       <artifactId>thymeleaf-layout-dialect</artifactId>
    </dependency>
```
may use something like this
```
sed -i 's/<dependencies>/<dependencies><dependency><groupId>nz.net.ultraq.thymeleaf<\/groupId><artifactId>thymeleaf-layout-dialect<\/artifactId><\/dependency>/g' pom.xml
```

4. Then, run it
```
mvn clean install

mvn spring-boot:run
```

5. Launch the app, by following the console log to ensure that the DemoApplicaiton is up and noting down it's port, to access the link like [http://localhost:8080/customers](http://localhost:8080/customers). "customers" in the url is based on the above example entity name chosen for scaffolding. Note that the scaffolded app would use in-memory mode of H2 DB.



## TODOs

## Misc.

### Credits

[https://github.com/netodevel/cli-spring-boot-scaffold](https://github.com/netodevel/cli-spring-boot-scaffold)