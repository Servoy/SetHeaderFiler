# SetHeaderFiler
A Servlet filter that can set any header on a request based on the init parameters

Drop the latest release jar (https://github.com/Servoy/SetHeaderFiler/releases) on your WAR/WEB-INF/lib folder and then adjust the WEB-INF/web.xml to include this filter:

```xml
    <filter>
        <filter-name>AddHeaderFilter</filter-name>
        <filter-class>com.servoy.filter.AddHeaderFilter</filter-class>
        <async-supported>true</async-supported>
        <init-param>
            <param-name>Content-Security-Policy</param-name>
            <param-value>frame-ancestors 'none';</param-value>
        </init-param>
        <init-param>
            <param-name>anotherheader</param-name>
            <param-value>1</param-value>
        </init-param>
    </filter>

The above example is adding a CSP header and some other header, you can add as many as you want.

After that you need to say what mapping you want to have, so just for all files on the root:

```xml
  <filter-mapping>
    <filter-name>AddHeaderFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
```
 
