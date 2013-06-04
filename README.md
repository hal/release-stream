# HAL
[HAL](http://en.wikipedia.org/wiki/HAL_9000) is the codename for the release coordination of a EAP 6.x web management
console that can be used across products. An essential part of HAL is to provide a way to build the final master
console [add-on](https://community.jboss.org/wiki/LayeredDistributionsAndModulePathOrganization).

Therefore HAL includes the following extensions:

- Teiid: `org.switchyard.console:switchyard-console-extension:1.0.0-SNAPSHOT`
- Switchyard: `org.jboss.teiid.web-console:console-extensions:1.1.0-SNAPSHOT`

The core console and the extensions are compiled together into one final master console. This master console is
assembled into the zip file `hal-master-<skin>-<version>-console.zip` where skin is either `wildfly` or `eap`.
The zip contains a layer which can be safley unzipped into an existing WildFly / EAP installation.

# Profiles
The HAL build can be controlled by using one or several profiles:

- __&lt;no profile&gt;__: Whithout specifying a profile the console for the community (WildFly) version is built.
- __eap__: Builds the console with EAP specific settings (module.xml, L&F).
- __dev__: Reduces the GWT compile time drastically. Restricts the languages to english and the browser permutations to
firefox (can be combined with other profiles).

# Build
To build HAL use `mvn clean install` from the root directory and choose any combination of profiles from above.
If you just want to create the zip and you're sure that the compiled GWT artifacts are already present use the flag
`-Dgwt.compiler.skip` to speed things up.

# Install
Unzip `target/hal-master-<skin>-<version>-console.zip` into an existing WildFly / EAP installation and restart the
server.
