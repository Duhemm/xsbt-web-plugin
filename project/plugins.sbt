resolvers += Resolver.url("Typesafe repository", new java.net.URL("http://typesafe.artifactoryonline.com/typesafe/ivy-snapshots/"))(Resolver.defaultIvyPatterns)

libraryDependencies <+= sbtVersion("org.scala-tools.sbt" %% "scripted-plugin" % _)
