# HAL
[HAL](http://en.wikipedia.org/wiki/HAL_9000) is the codename for the release coordination of a EAP 6.x web management console that can be used across products. 

# Maven Modules
HAL consists of several maven modules:

- __pom.xml__: The parent POM of HAL. It acts as an umbrella and does not contain any specific dependencies or plugins. It declares profiles (but does not specify details). It holds global variables and the maven coordinates like groupId, artifactId, version, name and description.

- __master/pom.xml__: This POM actually builds the HAL master console. Therefore it inherits from `org.jboss.as:jboss-as-console-build`. Furthermore this POM contains an assembly configuration to build the final zip. In this process specific variables for the layer, module and slot are used. Finally this POM defines details about the profiles (see below).  

- __extensions/pom.xml__: The parent POM for all extensions. It solely contains only a `<modules>` section which lists all extensions.
- __extension/&lt;name&gt;/pom.xml__: The POM for one specific extension must contain _all_ necessary dependencies for this extension inside a `<dependencyManagement>` block. In particular the extension must define both a dependency to the extension jar itself and a dependency with classifier `sources`.

- __samples/pom.xml__: HAL ships with two sample extensions which can be used as blueprints for new extensions. There's a simple sample which just contains the basic building blocks and a more advanced sampe with a more sophisticated UI and external dependencies. The structure for both samples is the same. The following section describes the simple sample.
- __samples/simple/pom.xml__: The parent POM for the simple sample. 
- __samples/simple/ext/pom.xml__: This POM holds the actual extension. Therefore it has to extend from `org.jboss.as:jboss-as-console-extension`. 
- __samples/simple/app/pom.xml__: This POM is just for starting the console with this sample. It's not part of the maven reactor build. 

# Profiles
The HAL build can be controlled by using a one or several profiles:

- __&lt;no profile&gt;__: Whithout specifying a profile the console for the community version is built.
- __eap__: Builds the console with EAP specific settings (module.xml, L&F).
- __extensions__: Use this profile to include the extensions (can be combined with the other profiles).
- __samples__: Use this profile to include the samples (can be combined with the other profiles).
- __dev__: Reduces the GWT compile time drastically (can be combined with the other profiles). 

# Building
TBD

# Extensions
TBD