# Genjavadoc and Scala 2.13.4 problem

Genjavadoc 0.16 generates invalid Java code when using Scala 2.13.4 (it works with Scala 2.13.3). To reproduce, clone this repo and run:

```bash
sbt Genjavadoc/doc
```

It should fail with a message similar to:

```
[info] javadoc: Standard Doclet version 11.0.9.1
[info] javadoc: Building tree for all the packages and classes...
[error] /tmp/scala-2.13.4-genjavadoc-failure/target/java/com/acme/Foo$.java:3:1: invalid use of @return
[error] /tmp/scala-2.13.4-genjavadoc-failure/target/java/com/acme/Foo.java:3:1: invalid use of @return
[info] javadoc: Generating /tmp/scala-2.13.4-genjavadoc-failure/target/scala-2.13/genjavadoc-api/com/acme/Foo.html...
[info] javadoc: Generating /tmp/scala-2.13.4-genjavadoc-failure/target/scala-2.13/genjavadoc-api/com/acme/Foo$.html...
[info] javadoc: Generating /tmp/scala-2.13.4-genjavadoc-failure/target/scala-2.13/genjavadoc-api/com/acme/package-summary.html...
[info] javadoc: Generating /tmp/scala-2.13.4-genjavadoc-failure/target/scala-2.13/genjavadoc-api/com/acme/package-tree.html...
[info] javadoc: Generating /tmp/scala-2.13.4-genjavadoc-failure/target/scala-2.13/genjavadoc-api/constant-values.html...
[info] javadoc: Building index for all the packages and classes...
[info] javadoc: Generating /tmp/scala-2.13.4-genjavadoc-failure/target/scala-2.13/genjavadoc-api/overview-tree.html...
[info] javadoc: Generating /tmp/scala-2.13.4-genjavadoc-failure/target/scala-2.13/genjavadoc-api/index-all.html...
[info] javadoc: Building index for all classes...
[info] javadoc: Generating /tmp/scala-2.13.4-genjavadoc-failure/target/scala-2.13/genjavadoc-api/allclasses-index.html...
[info] javadoc: Generating /tmp/scala-2.13.4-genjavadoc-failure/target/scala-2.13/genjavadoc-api/allpackages-index.html...
[info] javadoc: Generating /tmp/scala-2.13.4-genjavadoc-failure/target/scala-2.13/genjavadoc-api/deprecated-list.html...
[info] javadoc: Building index for all classes...
[info] javadoc: Generating /tmp/scala-2.13.4-genjavadoc-failure/target/scala-2.13/genjavadoc-api/allclasses.html...
[info] javadoc: Generating /tmp/scala-2.13.4-genjavadoc-failure/target/scala-2.13/genjavadoc-api/allclasses.html...
[info] javadoc: Generating /tmp/scala-2.13.4-genjavadoc-failure/target/scala-2.13/genjavadoc-api/index.html...
[info] javadoc: Generating /tmp/scala-2.13.4-genjavadoc-failure/target/scala-2.13/genjavadoc-api/help-doc.html...
[info] javadoc: 2 errors
[error] sbt.inc.Doc$JavadocGenerationFailed
[error] 	at sbt.inc.Doc$.sbt$inc$Doc$$$anonfun$cachedJavadoc$1(Doc.scala:51)
[error] 	at sbt.inc.Doc$$anonfun$cachedJavadoc$2.run(Doc.scala:41)
[error] 	at sbt.inc.Doc$.sbt$inc$Doc$$$anonfun$prepare$1(Doc.scala:62)
[error] 	at sbt.inc.Doc$$anonfun$prepare$5.run(Doc.scala:57)
[error] 	at sbt.inc.Doc$.go$1(Doc.scala:73)
[error] 	at sbt.inc.Doc$.$anonfun$cached$5(Doc.scala:82)
[error] 	at sbt.inc.Doc$.$anonfun$cached$5$adapted(Doc.scala:81)
[error] 	at sbt.util.Tracked$.$anonfun$inputChangedW$1(Tracked.scala:219)
[error] 	at sbt.inc.Doc$.sbt$inc$Doc$$$anonfun$cached$1(Doc.scala:85)
[error] 	at sbt.inc.Doc$$anonfun$cached$7.run(Doc.scala:68)
[error] 	at sbt.Defaults$.$anonfun$docTaskSettings$3(Defaults.scala:1994)
[error] 	at scala.Function1.$anonfun$compose$1(Function1.scala:49)
[error] 	at sbt.internal.util.$tilde$greater.$anonfun$$u2219$1(TypeFunctions.scala:62)
[error] 	at sbt.std.Transform$$anon$4.work(Transform.scala:68)
[error] 	at sbt.Execute.$anonfun$submit$2(Execute.scala:282)
[error] 	at sbt.internal.util.ErrorHandling$.wideConvert(ErrorHandling.scala:23)
[error] 	at sbt.Execute.work(Execute.scala:291)
[error] 	at sbt.Execute.$anonfun$submit$1(Execute.scala:282)
[error] 	at sbt.ConcurrentRestrictions$$anon$4.$anonfun$submitValid$1(ConcurrentRestrictions.scala:265)
[error] 	at sbt.CompletionService$$anon$2.call(CompletionService.scala:64)
[error] 	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
[error] 	at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:515)
[error] 	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
[error] 	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
[error] 	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
[error] 	at java.base/java.lang.Thread.run(Thread.java:834)
[error] (Genjavadoc / doc) sbt.inc.Doc$JavadocGenerationFailed
[error] Total time: 4 s, completed Feb. 5, 2021, 2:57:17 p.m.
```

The Java version used:

```
openjdk version "11.0.9.1" 2020-11-04
OpenJDK Runtime Environment AdoptOpenJDK (build 11.0.9.1+1)
OpenJDK 64-Bit Server VM AdoptOpenJDK (build 11.0.9.1+1, mixed mode)
```
