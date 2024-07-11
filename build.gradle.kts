subprojects {
    group = "cn.pbx.cs2"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenLocal()
        maven("https://maven.aliyun.com/repository/public/")
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

}
