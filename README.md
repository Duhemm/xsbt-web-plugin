# Usage
Setup [SBT](http://github.com/harrah/xsbt/).

Add plugin to project in `project/plugins.sbt`:

    resolvers += "Web plugin repo" at "http://siasia.github.com/maven2"    
		
    addSbtPlugin("com.github.siasia" %% "xsbt-web-plugin" % "0.1.2")

Artifacts are available for 0.10.1 and 0.11.0 SBT versions.

Inject plugin settings into project in `build.sbt`:

    seq(webSettings :_*)
		
or in case if you're using full configuration `webSettings` are `com.github.siasia.WebPlugin.webSettings`.
		
Add other required stuff like `web.xml`, properties and source code.
		
This will add commands required to run web application. Invoke `jetty-run`(as in sbt 0.7) to run web application:

    > jetty-run
    [info] jetty-7.3.0.v20110203
    [info] NO JSP Support for /, did not find org.apache.jasper.servlet.JspServlet
    [info] started o.e.j.w.WebAppContext{/,file:/home/siasia/work/sample-copy/target/webapp/},/home/siasia/work/sample-copy/target/webapp
    [info] Started SelectChannelConnector@0.0.0.0:8080
		
Web application is now accesible on [http://localhost:8080](http://localhost:8080)

Use `jetty-stop` to stop Jetty and `prepare-webapp` to build webapp after you've done some changes:

    > prepare-webapp
    [success] Total time: 1 s, completed 02.05.2011 17:08:43
    > [info] Reloading web application...
    17:08:44.595 [Scanner-0] DEBUG net.liftweb.http.LiftServlet - Destroyed Lift handler.
    [info] stopped o.e.j.w.WebAppContext{/,file:/home/siasia/work/sample-copy/target/webapp/},/home/siasia/work/sample-copy/target/webapp
    [info] NO JSP Support for /, did not find org.apache.jasper.servlet.JspServlet
    [info] started o.e.j.w.WebAppContext{/,file:/home/siasia/work/sample-copy/target/webapp/},/home/siasia/work/sample-copy/target/webapp
    [info] Reload complete.
		
    > jetty-stop
    17:09:21.739 [main] DEBUG net.liftweb.http.LiftServlet - Destroyed Lift handler.
    [info] stopped o.e.j.w.WebAppContext{/,file:/home/siasia/work/sample-copy/target/webapp/},/home/siasia/work/sample-copy/target/webapp
		
## Running Lift

**Please note that Jetty dependencies should go to `jetty` configuration instead of `test` as it was in 0.7.x version.**

Add Lift and Jetty to project dependencies:

    libraryDependencies ++= Seq(
      "net.liftweb" %% "lift-webkit" % "2.3" % "compile",
      "org.mortbay.jetty" % "jetty" % "6.1.22" % "jetty",
      "ch.qos.logback" % "logback-classic" % "0.9.26"
    )
		
or in case if you want to use Jetty 7:

    libraryDependencies ++= Seq(
      "net.liftweb" %% "lift-webkit" % "2.3" % "compile",
      "org.eclipse.jetty" % "jetty-webapp" % "7.3.0.v20110203" % "jetty",
      "ch.qos.logback" % "logback-classic" % "0.9.26"
    )
		
Check [Lift Basic Sample](http://github.com/downloads/siasia/xsbt-web-plugin/lift-basic-xsbt.zip) for further examples.

# License
This software is distributed under modified 3-clause BSD license. See [LICENSE](https://github.com/siasia/xsbt-web-plugin/blob/master/LICENSE) for more information.
