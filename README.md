# HAL
[HAL](http://en.wikipedia.org/wiki/HAL_9000) is the codename for the release coordination of a EAP 6.x web management console that can be used across products. An essential part of HAL is to provide a way to build the final master console [add-on](https://community.jboss.org/wiki/LayeredDistributionsAndModulePathOrganization). Therefore HAL consists of several maven modules. 

# Maven Modules
- __pom.xml__: The parent POM of HAL. It acts as an umbrella and does not contain any specific dependencies or plugins. It declares profiles (but does not specify details). It holds global variables and the maven coordinates like groupId, artifactId, version, name and description.

- __master/pom.xml__: This POM actually builds the HAL master console add-on. Therefore it inherits from `org.jboss.as:jboss-as-console-build`. Furthermore this POM contains an assembly configuration to build a zip which can be extracted into an existing product installation. When building the assembly specific variables for the layer, module and slot are used.   

- __extensions/pom.xml__: The parent POM for all extensions. It solely contains a `<modules>` section which lists all extensions.
- __extension/&lt;name&gt;/pom.xml__: The POM for one specific extension must contain _all_ necessary dependencies for this extension inside a `<dependencyManagement>` section. In particular the extension must define both a dependency to the extension jar itself and a dependency containing the sources with classifier `sources`.

- __samples/pom.xml__: HAL ships with two sample extensions which can be used as blueprints for new extensions. There's a simple sample which just contains the basic building blocks and a more advanced sampe with a more sophisticated UI and external dependencies. The structure for both samples is the same. The following section describes the simple sample.
- __samples/simple/pom.xml__: The parent POM for the simple sample. 
- __samples/simple/ext/pom.xml__: This POM holds the actual extension. It extends from `org.jboss.as:jboss-as-console-extension` and declares its dependencies inside a `<dependencyManagement>` section. 
- __samples/simple/app/pom.xml__: This POM is just for starting the console with this sample. It's not part of the maven reactor build. 

# Profiles
The HAL build can be controlled by using one or several profiles:

- __&lt;no profile&gt;__: Whithout specifying a profile the console for the community version is built.
- __eap__: Builds the console with EAP specific settings (module.xml, L&F).
- __extensions__: Use this profile to include the extensions (can be combined with other profiles).
- __samples__: Use this profile to include the samples (can be combined with other profiles).
- __dev__: Reduces the GWT compile time drastically. Restricts the languages to english and the browser permutations to firefox: (can be combined with other profiles). 

# Build
To build HAL use `mvn clean install` from the root directory and choose any combination of profiles from above. If you just want to create the zip and you're sure that the compiled GWT artifacts are already present use the flag `-Dgwt.compiler.skip` to speed things up. In any case the final ZIP will be created as `master/target/hal-master-<skin>-<version>-console.zip` where skin is either `jboss` or `eap`.

# Run
To run the HAL master console in hosted mode

1. Make sure JBoss 7 is started
2. Make sure you build the top level module first using one of the profiles (you should at least use -Pdev).
3. cd 'master'
4. start the GWT shell with `mvn gwt:<run|debug>`

Once the hosted browser is started, it's enough to hit the 'refresh' button to recompile and verify changes. You can get the OOPHM Plugin, required for attaching your browser to the hosted mode execution here: http://gwt.google.com/samples/MissingPlugin/MissingPlugin.html

In some cases you may want to bind both the AS and the hosted mode to a specific address. A typical scenario is running a different OS (i.e windows) in a virtual machine. To make such a setup work you need to bind the hosted mode environment and the application server to a specific inet address that can be access from the virtual machine:

1. Start the AS on a specific address:

        ./bin/standalone.sh -Djboss.bind.address=192.168.2.126 -Djboss.bind.address.management=192.168.2.126`

2. Launch hosted mode on a specific address:

        mvn -Dgwt.bindAddress=192.168.2.126 gwt:<run|debug>

# Install
Unzip `master/target/hal-master-<skin>-<version>-console.zip` into an existing JBoss / EAP installation and restart the server. 