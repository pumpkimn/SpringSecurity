# SpringSecurity全注释版
* 访问路径:127.0.0.1:6666

## SpringBoot 集成 SpringSecurity 开发流程

## SpringBoot集成SpringSecurity
1.创建用户类 User （关联用户和角色）、角色类
2.创建UserMapper（注解: @Repository ), 实现方法 findByUsername()
3.创建用户安全类JwtUser（关联安全用户和权限），实现由 User 向 JwtUser 安全用户对象的转换
4.创建JwtUserFactory工具类(关联角色和权限)，实现由User向JwtUser类对象的转换
5.创建JwtUserService(注解：@Service)，实现UserDetailsService接口，重写loadByUsername()方法
6.创建安全配置类WebSecurityConfig(注解：@Configuration、@EnableWebSecurity、@EnableGlobalMethodSecurity)，继承WebSecurityConfigurerAdapter
	①配置认证管理器
	②设置http拦截规则
7.配置application.yml和编写控制器


## 集成SpringSecurity和JWT
1.创建JwtTokenUtil工具类，实现生成、解密、验证、刷新令牌的方法——(★)
2.创建JwtAuthenticationTokenFilter过滤器类，并集成到配置类WebSecurityConfig——(★★)
3.创建JwtAuthenticationException异常类以及异常处理类JwtAuthenticationExceptionHandler用于处理授权异常
4.创建JwtAuthenticationRequest授权请求类以及授权响应类JwtAuthenticationResponse用于前后端数据的传输
5.创建AuthenticationController授权控制器类，生成登录、刷新的方法
6.创建UserController用户模型控制器，生成获得用户信息的方法
7.创建jwt.js用于存取token


## Spring Security 的核心:

* Authentication：代表了Spring Security中的当事人。
* SecurityContext：拥有了Authentication、请求相关的信息。
* SecurityContextHolder：用于获取SecurityContext。
* GrantedAuthority：代表在应用程序中给当事人授予的权限。
* UserDetails：用户详细信息。其实就是一个JavaBean。
* UserDetailsService：UserDetails相关的业务处理。

这几个是Spring Security的核心，其它的API都是围绕这些API展开的，都是为它们服务的。

## Spring Security doc
> mysql.sql
> 认证笔记.