organization := "io.nary"

name := "redwood"

version := "0.0.1"

scalaVersion := "2.11.8"

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

addCompilerPlugin("com.milessabin" % "si2712fix-plugin" % "1.2.0" cross CrossVersion.full)
addCompilerPlugin("org.spire-math" % "kind-projector" % "0.8.0" cross CrossVersion.binary)

publishArtifact in Test := false

publishMavenStyle := true

homepage := Some(url("https://github.com/scommon/"))

pomExtra := (
  <scm>
    <url>git@github.com:ryanonsrc/redwood.git</url>
    <connection>scm:git:git@github.com:ryanonsrc/redwood.git</connection>
  </scm>
    <licenses>
      <license>
        <name>Apache 2</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <developers>
      <developer>
        <id>Ryan Delucchi</id>
        <name>Ryan Delucchi</name>
        <email>q@onsrc.com</email>
        <url>http://nary.io</url>
        <organization>nary.io</organization>
        <organizationUrl>http://nary.io</organizationUrl>
        <roles>
          <role>Architect</role>
        </roles>
      </developer>
    </developers>
  )

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

releasePublishArtifactsAction := PgpKeys.publishSigned.value

libraryDependencies ++= Seq(
  "com.chuusai" %% "shapeless" % "2.2.5",
  "org.scalaz" %% "scalaz-core" % "7.2.8",
  "org.scalaz" %% "scalaz-effect" % "7.2.8",
  "org.scalaz" %% "scalaz-concurrent" % "7.2.8"
)

mainClass in Test := Some("io.nary.redwood.sample.Main")
