# T06 - Monopoly Game

This project uses gradle to build and test distributions.
To build a runnable jar of the Monopoly game, run the follow command in the root directory:

`gradlew dist`

Afterwards, you can combine the outputted jar at desktop/build/libs/desktop-1.0.jar in a new folder with the contents of the
core/assets folder.

The file structure should look like:

```
<your folder>
-desktop-1.0.jar
-assets/*
```

Our project also comes with an in app debug console that can be launched by running the jar with an additional parameter debug

Design documents are located in the design_documents folder.

---
### Resources
#### libgdx
* https://github.com/libgdx/libgdx/wiki libgdx wiki
* https://libgdx.badlogicgames.com/nightlies/docs/api/ libgdx javadoc
* http://www.gamefromscratch.com/ Older tutorial that explains some basic concepts
* http://www.pixnbgames.com/blog/libgdx/how-to-manage-screens-in-libgdx/ Working with screens

<a href="https://zenhub.com"><img src="https://raw.githubusercontent.com/ZenHubIO/support/master/zenhub-badge.png"></a>
