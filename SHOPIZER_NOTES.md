# Shopizer Notes

This is the only way I have been able to run Shopizer. I have also experimented with Maven, Eclipse, and IntelliJ.

## Dependencies

 - Git
 - Java 8+
 - Tomcat 9

## Clone Repository

```
git clone https://github.com/shopizer-ecommerce/shopizer
git checkout origin/2.8.0
```

## Modify

Add the following XML snippet to the dependencies section of the root pom.xml.

```
<dependency>
    <groupId>javax.xml.bind</groupId>
    <artifactId>jaxb-api</artifactId>
    <version>2.3.0</version>
</dependency>
```

## Build

```
cd <shopizer root>
mvnw clean install
```

## Run

1. Copy the `ROOT` directory in `sm-shop/target` to the `webapps` directory in your Tomcat installation.

2. Run startup.bat (or startup.sh on *nix) in the `bin` directory of your Tomcat installation.

3. Visit `localhost:8080` to view the storefront.

4. Visit `localhost:8080\admin` with username `admin@shopizer.com` and password `password` to view the admin panel.