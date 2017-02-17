redwood - purely functional transformable free hierarchy
======

A scalaz free implementation of a generic hierarchy of elements

Adding to your application
------

```
resolvers ++= Seq(
    Resolver.sonatypeRepo("releases"),
    Resolver.sonatypeRepo("snapshots")
)

libraryDependencies ++= Seq(
    "io.nary" %% "redwood" % "0.0.1"
)
```

redwood makes extensive use of scalaz as well as the kind-projector
compiler plugin.

Plan
------
* Implementation of three free algebras
  - single-node manipulation
  - multi-node manipulation
  - tree evaluation

* Build some interpreters
  - single-node + multi-node
    1. Local File System
    2. In Memory Buffer

  - tree evaluation
    1. pretty printer
    2. File Text processing
    3. File Math Computation

* Free Applicatives!  Optimization of operations
* Add another interpreter:  CoFree in-memory buffer

[Future Project]  Free Monad performance optimization
"de-free" using Scala.meta
