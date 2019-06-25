applicationContext.xml 为Spring的配置文件 ,这个里边也放了springmvc的配置文件，正常springmvc的配置文件是需要单独拿出来的。

jdbc.properties是数据库相关信息

log4j.properties是日志配置文件

sqlmap文件夹里面放实体与数据库的映射文件

generatorConfig.xml和generator.properties(已经合入jdbc.properties配置文件内 二合一)是mybatis的配置文件


web.xml web.xml主要用来配置Filter、Listener、Servlet等