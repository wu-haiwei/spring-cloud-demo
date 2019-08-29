1. com.spring-cloud-first-provider 第一个springCloud提供者项目创建
    统一指定工程 com.spring 依赖版本
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>com.spring-cloud-dependencies</artifactId>
                <version>Greenwich.SR1</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>com.spring-boot-dependencies</artifactId>
                <version>2.1.7.RELEASE</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
    </dependencyManagement>
 
 
