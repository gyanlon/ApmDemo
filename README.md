
### 1, Agent打包
把所有相关的lib打到一个大包里

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
---
Change zuul-agent/target/zuul-agent-1.0-SNAPSHOT-jar-with-dependencies.jar to zuul-agent/target/zuul-agent-1.0-SNAPSHOT.jar

### 2, Agent使用
--
 -javaagent:/Users/oyo/Develop/workspace/ApmDemo/zuul-agent/target/zuul-agent-1.0-SNAPSHOT.jar


### 3, Test

http://localhost:8080/zuul/xxx