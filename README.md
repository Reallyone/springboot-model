## git 拉取or本地上传
```java
   git init
   git add *
   git commit -m “baoli2”
   git remote add origin https://you_git_address
   提示出错信息：fatal: remote origin already exists.
   解决办法如下：
   1、先输入$ git remote rm origin
    2、再输入$
  git push -u origin master
  输入密码
```
  
 ##项目结构说明
    -SpringCloud_study
        -eureka_center 注册中心
        -oauth_rbac    基于oauth用户登录，使用缓存来处理登录凭证
 
  
  
  
 
 
 
