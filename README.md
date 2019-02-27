
### 1, Agent打包

pom.xml
````
<plugin>
                <artifactId>maven-jar-plugin</artifactId>
                <version>2.6</version>
                <configuration>
                    <archive>
                        <manifest>
                            <mainClass>Main</mainClass>
                        </manifest>
                        <manifestEntries>
                            <Premain-Class>com.oyo.apm.javaagent.ZuulAgent</Premain-Class>
                        </manifestEntries>
                    </archive>
                </configuration>
            </plugin>
            <plugin>
                <artifactId>maven-assembly-plugin</artifactId>
                <configuration>
                    <archive>
                        <manifest>
                            <mainClass>Main</mainClass>
                        </manifest>
                        <manifestEntries>
                            <Premain-Class>com.oyo.apm.javaagent.ZuulAgent</Premain-Class>
                        </manifestEntries>
                    </archive>
                    <descriptorRefs>
                        <descriptorRef>jar-with-dependencies</descriptorRef>
                    </descriptorRefs>
                </configuration>
            </plugin>

````
---
````
mvn clean compile assembly:single
````

### 2, Agent使用
-
 -javaagent:/Users/oyo/Develop/workspace/ApmDemo/zuul-agent/target/zuul-agent-1.0-SNAPSHOT.jar
